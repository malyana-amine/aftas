package com.example.aftas.DTO.requestBody;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

@Getter
@Setter
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class FishRequest {
    private String name;
    private Integer av;
    private Long level;
}
