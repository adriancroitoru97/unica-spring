package com.myunica.first.dto.standardResponse;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Data;

import javax.annotation.Generated;
import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "messages",
        "sessionId",
        "version",
        "statusCode",
})

@Generated("jsonschema2pojo")
@Data
public class StandardResponseDTO {

    @JsonProperty("messages")
    private List<StandardMessageDTO> messages;
    @JsonProperty("sessionId")
    private String sessionId;
    @JsonProperty("version")
    private String version;
    @JsonProperty("statusCode")
    private Integer statusCode;
}
