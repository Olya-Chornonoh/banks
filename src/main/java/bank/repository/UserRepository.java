package bank.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import bank.model.User;

public interface UserRepository extends JpaRepository<User, Integer> {

	Optional<User> findByEmailAndPassword(String email, String password);
}
