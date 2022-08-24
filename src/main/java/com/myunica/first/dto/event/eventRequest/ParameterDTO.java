package com.myunica.first.dto.event.eventRequest;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Builder;
import lombok.Data;

import javax.annotation.Generated;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "n",
        "v",
        "t"
})

@Generated("jsonschema2pojo")
@Data
@Builder
public class ParameterDTO {
    @JsonProperty("n")
    private String n;
    @JsonProperty("t")
    private String t;
    @JsonProperty("v")
    private Object v;
}
