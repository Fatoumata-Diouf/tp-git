package sn.isi.tpgitspring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sn.isi.tpgitspring.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
}
