package com.example.aftas.DTO;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

@Getter
@Setter
@ToString
@Builder
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ResponseDTO {
    private String status;
    private String message;
    private Object data;

    public ResponseDTO(String status, String message, Object data) {
        this.status = status;
        this.message = message;
        this.data = data;
    }

    public ResponseDTO(String status, String message) {
        this.status = status;
        this.message = message;
    }

    public String getCode() {
        return status;
    }
}
