package sn.isi.tpgitspring.service.Interface;

import sn.isi.tpgitspring.dto.UserRequest;
import sn.isi.tpgitspring.dto.UserResponse;

import java.util.List;

public interface IUser {

    // Créer un user
    UserResponse save(UserRequest userRequest);

    // Récupérer tous les users
    List<UserResponse> findAll();

    // Récupérer un user par son id
    UserResponse findById(Long id);

    // Modifier un user
    UserResponse update(Long id, UserRequest userRequest);

    // Supprimer un user
    void delete(Long id);

}
