package com.myunica.first.service;

import com.myunica.first.dto.standardResponse.StandardResponseDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class SessionService {
    private final RestTemplate restTemplate;
    @Value("${server-base-url}")
    private String baseURL;

    public ResponseEntity<?> startSession(final Integer sessionID) {
        try {
            URI urlTemplate = UriComponentsBuilder.fromHttpUrl(baseURL)
                    .path("/sessions/" + sessionID)
                    .queryParam("ic", "A_AdrianCroitoru_July2022")
                    .queryParam("audienceLevel", "individual")
                    .queryParam("audienceIDField", "indiv_id|3|numeric")
                    .encode()
                    .build().toUri();

            ResponseEntity<StandardResponseDTO> result =
                    restTemplate.postForEntity(urlTemplate, null, StandardResponseDTO.class);

            return new ResponseEntity<>(Objects.requireNonNull(result.getBody()).getStatusCode() == 0 ?
                    "Session " + sessionID + " started successfully!\n" + result.getBody():
                    "Session starting failed!\n" + result.getBody(), HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>("Error! Please try again.", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity<?> endSession(final Integer sessionID) {
        try {
            URI urlTemplate = UriComponentsBuilder.fromHttpUrl(baseURL)
                    .path("/sessions/" + sessionID)
                    .encode()
                    .build().toUri();

            ResponseEntity<StandardResponseDTO> result =
                    restTemplate.exchange(urlTemplate, HttpMethod.DELETE, null, StandardResponseDTO.class);

            return new ResponseEntity<>(Objects.requireNonNull(result.getBody()).getStatusCode() == 0 ?
                    "Session " + sessionID + " ended successfully!\n" + result.getBody():
                    "Session ending failed!\n" + result.getBody(), HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>("Error! Please try again.", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
