package com.myunica.first.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.myunica.first.dto.offer.multipleIPofferRequest.GetOfferRequestsDTO;
import com.myunica.first.dto.offer.multipleIPofferRequest.OfferRequestDTO;
import com.myunica.first.dto.offer.offerResponse.ResponseDTO;
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

@Service
public class OffersService {
    @Autowired
    RestTemplate restTemplate;
    @Value("${server-base-url}")
    private String baseURL;

    public ResponseEntity<?> getOffers(final Integer sessionID, final String IP) {
        try {
            URI urlTemplate = UriComponentsBuilder.fromHttpUrl(baseURL)
                    .path("/offers/" + sessionID + "/" + IP)
                    .queryParam("number", 1)
                    .encode()
                    .build().toUri();

            ResponseEntity<ResponseDTO> result =
                    restTemplate.exchange(urlTemplate, HttpMethod.GET, null, ResponseDTO.class);

            return new ResponseEntity<>(result.getStatusCode().value() == 200 ?
                    "Offers received successfully!\n" + result.getBody():
                    "getOffers operation failed!\n" + result.getBody(), HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>("Error! Please try again.", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity<?> getOffersForMultipleIP(final Integer sessionID, final List<String> IPs) {
        try {
            URI urlTemplate = UriComponentsBuilder.fromHttpUrl(baseURL)
                    .path("/offers/" + sessionID)
                    .encode()
                    .build().toUri();


            List<OfferRequestDTO> jsons = new ArrayList<>();
            for (String IP : IPs) {
                OfferRequestDTO json = OfferRequestDTO.builder()
                        .dupPolicy(1)
                        .ip(IP)
                        .numberRequested(1)
                        .build();
                jsons.add(json);
            }
            GetOfferRequestsDTO dtos = GetOfferRequestsDTO.builder().getOfferRequests(jsons).build();


            ObjectMapper objectMapper = new ObjectMapper();
            String body = objectMapper.writeValueAsString(dtos);

            HttpEntity<String> entity = new HttpEntity<>(body);

            ResponseEntity<ResponseDTO> result =
                    restTemplate.exchange(urlTemplate, HttpMethod.POST, entity, ResponseDTO.class);

            return new ResponseEntity<>(result.getStatusCode().value() == 200 ?
                    "Offers for multiple IPs received successfully!\n" + result.getBody():
                    "getOffersForMultipleIPs operation failed!\n" + result.getBody(), HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>("Error! Please try again.", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
