package bank.model;

import static javax.persistence.GenerationType.IDENTITY;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "account")

public class Account {

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "account_id")
	private Integer account_id;
	
	@Column(name = "balance")
	private BigDecimal balance;
	
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "statement_id", nullable = false)
	private Statement statement;

	public Account() {}

	public Integer getAccount_id() {
		return account_id;
	}

	public void setAccount_id(Integer account_id) {
		this.account_id = account_id;
	}

	public BigDecimal getBalance() {
		return balance;
	}

	public void setBalance(BigDecimal balance) {
		this.balance = balance;
	}

	public Statement getStatement() {
		return statement;
	}

	public void setStatement(Statement statement) {
		this.statement = statement;
	}
	
}
