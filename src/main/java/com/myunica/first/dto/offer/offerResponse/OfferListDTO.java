package com.myunica.first.dto.offer.offerResponse;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Data;

import javax.annotation.Generated;
import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "ip",
        "defaultString",
        "offers"
})

@Generated("jsonschema2pojo")
@Data
public class OfferListDTO {

    @JsonProperty("ip")
    private String ip;
    @JsonProperty("defaultString")
    private Object defaultString;
    @JsonProperty("offers")
    private List<OfferDTO> offers = null;
}