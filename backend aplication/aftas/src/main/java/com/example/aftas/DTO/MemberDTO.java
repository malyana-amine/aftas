package com.example.aftas.DTO;

import com.example.aftas.entities.Hunting;
import com.example.aftas.entities.IdentityDocumentType;
import com.example.aftas.entities.Ranking;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
import java.util.List;



@Getter
@Setter
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class MemberDTO {
    private Long id;
    private String name;
    private String familyName;

    @JsonProperty("accession_date")
    private Date accessionDate;
    private String nationality;
    private IdentityDocumentType identityDocumentType;
    private String identityNumber;
    private List<Ranking> rankings;
    private List<Hunting> huntings;
}
