package sn.isi.tpgitspring.controller;


import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sn.isi.tpgitspring.dto.UserRequest;
import sn.isi.tpgitspring.dto.UserResponse;
import sn.isi.tpgitspring.service.UserServiceImplementation;

import java.util.List;


@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
@Tag(name = "Utilisateur", description = "API de gestion des utilisateurs")
public class UserController {

    private final UserServiceImplementation userServiceImplementation;

    // GET tous les users
    @Operation(summary = "Lister tous les utilisateurs")
    @GetMapping
    public ResponseEntity<List<UserResponse>> findAll() {
        return ResponseEntity.ok(userServiceImplementation.findAll());
    }

    // GET un user par id
    @Operation(summary = "Lister un utilisateur specefique")
    @GetMapping("/{id}")
    public ResponseEntity<UserResponse> findById(@PathVariable Long id) {
        return ResponseEntity.ok(userServiceImplementation.findById(id));
    }

    // POST créer un user
    @Operation(summary = "Créer un utilisateur")
    @PostMapping
    public ResponseEntity<UserResponse> save(@RequestBody UserRequest userRequest) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(userServiceImplementation.save(userRequest));
    }

    // PUT modifier un user
    @Operation(summary = "Modifier un utilisateur")
    @PutMapping("/{id}")
    public ResponseEntity<UserResponse> update(@PathVariable Long id,
                                               @RequestBody UserRequest userRequest) {
        return ResponseEntity.ok(userServiceImplementation.update(id, userRequest));
    }

    // DELETE supprimer un user
    @Operation(summary = "Supprimer un utilisateur")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        userServiceImplementation.delete(id);
        return ResponseEntity.noContent().build();
    }
}
