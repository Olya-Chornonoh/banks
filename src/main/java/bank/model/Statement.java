package bank.model;

import static javax.persistence.GenerationType.IDENTITY;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "statement")
public class Statement {

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "statement_id")
	private Integer statement_id;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "description")
	private String description;
	
	@OneToMany(mappedBy = "statement")
	private Set<Account> account;
	
	public Statement() {}

	public Integer getStatement_id() {
		return statement_id;
	}

	public void setStatement_id(Integer statement_id) {
		this.statement_id = statement_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Set<Account> getAccount() {
		return account;
	}

	public void setAccount(Set<Account> account) {
		this.account = account;
	}
	
}
