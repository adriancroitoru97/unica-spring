package com.myunica.first.dto.offer.multipleIPofferRequest;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
@Builder
public class GetOfferRequestsDTO {
    @JsonProperty("getOfferRequests")
    private List<OfferRequestDTO> getOfferRequests;
}
