package bank.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import bank.model.Statement;
import bank.repository.AccountRepository;
import bank.repository.StatementRepository;
import bank.repository.UserRepository;

@RestController
public class StatementController {

	private StatementRepository statementRepository;
	
	@Autowired
	public StatementController(StatementRepository statementRepository) {
		this.statementRepository = statementRepository;
	}
	
	@RequestMapping(value = "/statement", method = RequestMethod.POST)
	public ResponseEntity<Void> history(String name, String description){
		Statement statement = new Statement();
		statement.getName();
		statement.getDescription();
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
	
//	public static class StatementRequest{
//		public String name;
//		public String description;
//	}
}
