package me.chirp.service;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import me.chirp.configuration.RoleConfig;
import me.chirp.mapper.UserMapper;
import me.chirp.model.UserDTO;
import me.chirp.repository.UserRepository;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleConfig roleConfig;

    @Value("${client.id}")
    private String clientId;

    @Value("${client.pass}")
    private String clientSecret;

    @Value("${api.tokenEndpoint}")
    private String tokenEndpoint;

    @Value("${api.roleEndpoint.prefix}")
    private String roleEndpointPrefix;

    @Value("${api.roleEndpoint.suffix}")
    private String roleEndpointSuffix;


    public void addUser(UserDTO userDTO){
        userRepository.save(UserMapper.dtoToUser(userDTO));
    }

    public ResponseEntity addRole(UUID id, String role){

        HttpHeaders header = parseHeaders();

        List<Map<String, String>> list = new ArrayList<>();

        Map<String, String> map = new JSONObject();
        map.put("id", roleConfig.getRole(role).getId());
        map.put("name", role);

        list.add(map);

        HttpEntity<List<Map<String, String>>> entity = new HttpEntity<>(list, header);

        return makeRestCall(roleEndpointPrefix + "/" + id + "/" + roleEndpointSuffix,entity, HttpMethod.POST);

    }

    public ResponseEntity removeRole(UUID id, String role){
        HttpHeaders header = parseHeaders();

        List<Map<String, String>> list = new ArrayList<>();

        Map<String, String> map = new JSONObject();
        map.put("id", roleConfig.getRole(role).getId());
        map.put("name", role);

        list.add(map);

        HttpEntity<List<Map<String, String>>> entity = new HttpEntity<>(list, header);

        return makeRestCall(roleEndpointPrefix + id + roleEndpointSuffix,entity, HttpMethod.DELETE);
    }

    public String authenticate() {
        HttpHeaders header = new HttpHeaders();
        header.setContentType(MediaType.APPLICATION_FORM_URLENCODED);

        MultiValueMap<String, String> map = new LinkedMultiValueMap<>();
        map.add("grant_type", "client_credentials");
        map.add("client_id", clientId);
        map.add("client_secret", clientSecret);

        HttpEntity<MultiValueMap<String, String>> entity = new HttpEntity<>(map, header);

        ResponseEntity response = makeRestCall(tokenEndpoint,entity, HttpMethod.POST);
        return extractTokenFromResponse("access_token", response);

    }

    private HttpHeaders parseHeaders(){
        String jwt = authenticate();

        HttpHeaders header = new HttpHeaders();
        header.setContentType(MediaType.APPLICATION_JSON);
        header.add("Authorization", "bearer " + jwt);
        return header;
    }

    private ResponseEntity<String> makeRestCall(String url, HttpEntity entity, HttpMethod method){
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> responseEntity = restTemplate.
                exchange(url, method, entity, String.class);

        return responseEntity;
    }

    private String extractTokenFromResponse(String key, ResponseEntity response){

        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode root = null;
        String value = "";
        try {
            root = objectMapper.readTree(response.getBody().toString());
            value = root.get(key).toString();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return value.replace("\"", "");
    }

}