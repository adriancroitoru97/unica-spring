package com.myunica.first.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.myunica.first.dto.event.eventRequest.EventRequestDTO;
import com.myunica.first.dto.event.eventRequest.ParameterDTO;
import com.myunica.first.dto.standardResponse.StandardResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class EventService {
    @Autowired
    RestTemplate restTemplate;
    @Value("${server-base-url}")
    private String baseURL;

    public ResponseEntity<?> postEvent(final Integer sessionID, final List<String> treatmentCodes) {
        try {
            URI urlTemplate = UriComponentsBuilder.fromHttpUrl(baseURL)
                    .path("/events/" + sessionID + "/accept")
                    .encode()
                    .build().toUri();


            List<ParameterDTO> parameters = new ArrayList<>();
            for (String tc : treatmentCodes) {
                ParameterDTO parameter = ParameterDTO.builder()
                        .n("UACIOfferTrackingCode")
                        .t("string")
                        .v(tc)
                        .build();

                parameters.add(parameter);
            }
            EventRequestDTO dtos = EventRequestDTO.builder()
                    .parameters(parameters)
                    .build();


            ObjectMapper objectMapper = new ObjectMapper();
            String body = objectMapper.writeValueAsString(dtos);

            HttpEntity<String> entity = new HttpEntity<>(body);

            ResponseEntity<StandardResponseDTO> result =
                    restTemplate.exchange(urlTemplate, HttpMethod.POST, entity, StandardResponseDTO.class);

            return new ResponseEntity<>(Objects.requireNonNull(result.getBody()).getStatusCode() == 0 ?
                    "Event " + sessionID + " posted successfully!\n" + result.getBody():
                    "Event posting failed!\n" + result.getBody(), HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>("Error! Please try again.", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
