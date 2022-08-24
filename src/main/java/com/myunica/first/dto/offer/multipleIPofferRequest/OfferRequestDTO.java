package com.myunica.first.dto.offer.multipleIPofferRequest;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Builder;
import lombok.Data;

import javax.annotation.Generated;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "dupPolicy",
        "ip",
        "numberRequested"
})

@Generated("jsonschema2pojo")
@Data
@Builder
public class OfferRequestDTO {

    @JsonProperty("dupPolicy")
    private Integer dupPolicy;
    @JsonProperty("ip")
    private String ip;
    @JsonProperty("numberRequested")
    private Integer numberRequested;
}
