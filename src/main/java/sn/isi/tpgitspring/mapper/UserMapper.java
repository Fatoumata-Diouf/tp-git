package sn.isi.tpgitspring.mapper;


import org.springframework.stereotype.Component;
import sn.isi.tpgitspring.dto.UserRequest;
import sn.isi.tpgitspring.dto.UserResponse;
import sn.isi.tpgitspring.entity.User;


public class UserMapper {

    public static UserResponse toDto (User user) {

        return  UserResponse.builder().
                id(user.getId()).
                nom(user.getNom()).
                prenom(user.getPrenom()).
                email(user.getEmail()).
                build();
    }

    public static User toEntity (UserRequest userRequest) {
        return User.builder()
                .nom(userRequest.getNom())
                .prenom(userRequest.getPrenom())
                .dateNaissance(userRequest.getDateNaissance())
                .adresse(userRequest.getAdresse())
                .email(userRequest.getEmail())
                .password(userRequest.getPassword())
                .build();

    }
}
