package com.myunica.first.dto.standardResponse;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Data;

import javax.annotation.Generated;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "msgCode",
        "msgLevel",
        "msg",
        "detailMsg"
})

@Generated("jsonschema2pojo")
@Data
public class StandardMessageDTO {

    @JsonProperty("msgCode")
    private Integer msgCode;
    @JsonProperty("msgLevel")
    private Integer msgLevel;
    @JsonProperty("msg")
    private String msg;
    @JsonProperty("detailMsg")
    private String detailMsg;
}
