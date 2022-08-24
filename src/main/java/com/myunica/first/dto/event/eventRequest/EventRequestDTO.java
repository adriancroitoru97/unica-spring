package com.myunica.first.dto.event.eventRequest;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Builder
@Data
public class EventRequestDTO {
    @JsonProperty("parameters")
    private List<ParameterDTO> parameters;
}
