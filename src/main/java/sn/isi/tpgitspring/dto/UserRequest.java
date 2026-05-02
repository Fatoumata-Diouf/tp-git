package sn.isi.tpgitspring.dto;


import lombok.*;

import java.sql.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class UserRequest {

    @NonNull
    private String nom;

    @NonNull
    private String prenom;

    @NonNull
    private Date dateNaissance;

    @NonNull
    private String adresse;

    @NonNull
    private String email;

    @NonNull
    private String password;

}
