package com.myunica.first.dto.offer.offerResponse;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.myunica.first.dto.standardResponse.StandardMessageDTO;
import lombok.Data;

import javax.annotation.Generated;
import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "messages",
        "sessionId",
        "version",
        "statusCode",
        "offerLists"
})

@Generated("jsonschema2pojo")
@Data
public class ResponseDTO {

    @JsonProperty("messages")
    private List<StandardMessageDTO> messages;
    @JsonProperty("sessionId")
    private String sessionId;
    @JsonProperty("version")
    private String version;
    @JsonProperty("statusCode")
    private Integer statusCode;
    @JsonProperty("offerLists")
    private List<OfferListDTO> offerLists;
}
