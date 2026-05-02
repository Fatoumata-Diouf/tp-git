package sn.isi.tpgitspring.controller;


import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
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
@Slf4j
@Tag(name = "Utilisateur", description = "API de gestion des utilisateurs")
public class UserController {

    private final UserServiceImplementation userServiceImplementation;

    // GET tous les users
    @Operation(summary = "Lister tous les utilisateurs")
    @GetMapping
    public ResponseEntity<List<UserResponse>> findAll() {
        log.info("Début de la transaction");
        return ResponseEntity.ok(userServiceImplementation.findAll());
    }

    // GET un user par id
    @Operation(summary = "Lister un utilisateur specefique")
    @GetMapping("/{id}")
    public ResponseEntity<UserResponse> findById(@PathVariable Long id) {
        log.info("Début de la transaction liste individuelle");
        return ResponseEntity.ok(userServiceImplementation.findById(id));
    }

    // POST créer un user
    @Operation(summary = "Créer un utilisateur")
    @PostMapping
    public ResponseEntity<UserResponse> save(@RequestBody UserRequest userRequest) {
        log.info("Début de la transaction création");
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(userServiceImplementation.save(userRequest));
    }

    // PUT modifier un user
    @Operation(summary = "Modifier un utilisateur")
    @PutMapping("/{id}")
    public ResponseEntity<UserResponse> update(@PathVariable Long id,
                                               @RequestBody UserRequest userRequest) {
        log.info("Début de la transaction modification");
        return ResponseEntity.ok(userServiceImplementation.update(id, userRequest));
    }

    // DELETE supprimer un user
    @Operation(summary = "Supprimer un utilisateur")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        log.info("Début de la transaction Suppression");
        userServiceImplementation.delete(id);
        log.info("Fin de la transaction");
        return ResponseEntity.noContent().build();
    }
}
