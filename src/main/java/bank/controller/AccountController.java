package bank.controller;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import bank.model.Account;
import bank.model.Statement;
import bank.repository.AccountRepository;
import bank.repository.StatementRepository;
import bank.repository.UserRepository;

@RestController
public class AccountController {

	private UserRepository userRepository;
	private AccountRepository accountRepository;
	private StatementRepository statementRepository;
	
	@Autowired
	public AccountController(UserRepository userRepository, AccountRepository accountRepository, StatementRepository statementRepository) {
		this.userRepository = userRepository;
		this.accountRepository = accountRepository;
		this.statementRepository = statementRepository;
	}
	
	@RequestMapping(value = "/account/add_money", method = RequestMethod.POST)
	public ResponseEntity<Account> addMoney(@RequestBody AccountRequest body){
		Account account = new Account();
		account.setBalance(body.balance);
		body.balance = account.getBalance().add(body.value);
		account.setBalance(body.balance);
		accountRepository.save(account);
		Statement statement = new Statement();
		statement.setName(body.name);
		statement.setDescription(body.description);
		statementRepository.save(statement);
		return new ResponseEntity<Account>(account, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/account/subtract_money", method = RequestMethod.POST)
	public ResponseEntity<Account> subtractMoney(@RequestBody AccountRequest body){
		Account account = new Account();
		if(! account.getBalance().equals(null)) {
		account.setBalance(body.balance);
		body.balance = account.getBalance().subtract(body.value);
		account.setBalance(body.balance);
		accountRepository.save(account);
		Statement statement = new Statement();
		statement.setName(body.name);
		statement.setDescription(body.description);
		statementRepository.save(statement);
		return new ResponseEntity<Account>(account, HttpStatus.OK);
		} else { 
			return null;
		}
	}
	
	public static class AccountRequest{
		public BigDecimal balance;
		public BigDecimal value;
		public String name;
		public String description;
	}
}
