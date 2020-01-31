package bank.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import bank.model.Account;
import bank.model.Statement;
import bank.model.User;

public interface AccountRepository extends JpaRepository<Account, Integer> {

	Optional<User> findByUser(Optional<User> user);
	List<Account> findAllByStatement(Statement statement);
}
