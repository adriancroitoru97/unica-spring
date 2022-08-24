package com.myunica.first.dto.offer.offerResponse;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Data;

import javax.annotation.Generated;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "n",
        "t",
        "v"
})

@Generated("jsonschema2pojo")
@Data
public class AttributeDTO {
    @JsonProperty("n")
    private String n;
    @JsonProperty("t")
    private String t;
    @JsonProperty("v")
    private Object v;
}