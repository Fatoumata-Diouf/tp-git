package sn.isi.tpgitspring.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import sn.isi.tpgitspring.dto.UserRequest;
import sn.isi.tpgitspring.dto.UserResponse;
import sn.isi.tpgitspring.entity.User;
import sn.isi.tpgitspring.mapper.UserMapper;
import sn.isi.tpgitspring.repository.UserRepository;
import sn.isi.tpgitspring.service.Interface.IUser;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserServiceImplementation implements IUser {

    private final UserRepository userRepository;

    @Override
    public UserResponse save(UserRequest userRequest) {
        // Validation dde l'email  — correction du bug
        if (!userRequest.getEmail().contains("@")) {
            throw new RuntimeException("L'email n'est pas valide");
        }
        User user = UserMapper.toEntity(userRequest);
        return UserMapper.toDto(userRepository.save(user));
    }

    @Override
    public List<UserResponse> findAll() {
        return userRepository.findAll()
                .stream()
                .map(UserMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public UserResponse findById(Long id) {
        User user = userRepository.findById(Math.toIntExact(id))
                .orElseThrow(() -> new RuntimeException("User non trouvé : " + id));
        return UserMapper.toDto(user);
    }

    @Override
    public UserResponse update(Long id, UserRequest userRequest) {
        User existing = userRepository.findById(Math.toIntExact(id))
                .orElseThrow(() -> new RuntimeException("User non trouvé : " + id));
        existing.setNom(userRequest.getNom());
        existing.setPrenom(userRequest.getPrenom());
        existing.setDateNaissance(userRequest.getDateNaissance());
        existing.setAdresse(userRequest.getAdresse());
        existing.setEmail(userRequest.getEmail());
        existing.setPassword(userRequest.getPassword());
        return UserMapper.toDto(userRepository.save(existing));
    }

    @Override
    public void delete(Long id) {
        userRepository.deleteById(Math.toIntExact(id));
    }
}
