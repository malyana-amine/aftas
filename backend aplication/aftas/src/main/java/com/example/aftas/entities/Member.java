package com.example.aftas.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull; // Use jakarta.validation.constraints.NotNull
import lombok.*;

import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private String name;

    @NotNull
    private String familyName;


    private Date accessionDate;

    @NotNull
    private String nationality;

    @NotNull
    @Enumerated(EnumType.STRING)
    private IdentityDocumentType identityDocumentType;

    @NotNull
    private String identityNumber;

    @OneToMany(mappedBy = "member")
    @ToString.Exclude
    private List<Ranking> rankings;

    @OneToMany(mappedBy = "member")
    @ToString.Exclude
    private List<Hunting> huntings;
}
