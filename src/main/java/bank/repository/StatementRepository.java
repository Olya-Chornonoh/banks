package bank.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import bank.model.Statement;

public interface StatementRepository extends JpaRepository<Statement, Integer> {

}
