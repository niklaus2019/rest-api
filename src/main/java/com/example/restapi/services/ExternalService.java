package com.example.restapi.services;

import com.example.restapi.dto.GenderDTO;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;



@Service
public class ExternalService {

    @Value("${external.url.link}")
    private String externalUrlLink;


    public GenderDTO getInfoAboutGender(String name) {

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<GenderDTO> forEntity =
                restTemplate.exchange(externalUrlLink + name,
                        HttpMethod.GET, null, new ParameterizedTypeReference<GenderDTO>() {

                        });
        System.out.println(forEntity.getStatusCode());
        return forEntity.getBody();
    }




}
