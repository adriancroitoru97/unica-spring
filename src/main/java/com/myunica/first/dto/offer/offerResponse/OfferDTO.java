package com.myunica.first.dto.offer.offerResponse;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Data;

import javax.annotation.Generated;
import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "n",
        "code",
        "treatmentCode",
        "score",
        "desc",
        "attributes"
})

@Generated("jsonschema2pojo")
@Data
public class OfferDTO {

    @JsonProperty("n")
    private String n;
    @JsonProperty("code")
    private List<String> code = null;
    @JsonProperty("treatmentCode")
    private String treatmentCode;
    @JsonProperty("score")
    private Integer score;
    @JsonProperty("desc")
    private String desc;
    @JsonProperty("attributes")
    private List<AttributeDTO> attributes = null;
}