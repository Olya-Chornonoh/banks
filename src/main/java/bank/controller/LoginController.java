package bank.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import bank.model.Account;
import bank.model.Statement;
import bank.model.User;
import bank.repository.AccountRepository;
import bank.repository.StatementRepository;
import bank.repository.UserRepository;

@Controller
public class LoginController {

	private UserRepository userRepository;
	private AccountRepository accountRepository;
	private StatementRepository statementRepository;
	
	@Autowired
	public LoginController(UserRepository userRepository, AccountRepository accountRepository, StatementRepository statementRepository) {
		this.userRepository = userRepository;
		this.accountRepository = accountRepository;
		this.statementRepository = statementRepository;
	}
	
	@GetMapping("/login")
	public String getLogin() {
		return "login";
	}
	
	@PostMapping("/login")
	public String postLogin(@RequestParam String email, @RequestParam String password, Model model) {
		Optional<User> user = userRepository.findByEmailAndPassword(email, password);
		if(user.isPresent()) {
			Statement statement = new Statement();
			model.addAttribute(user.get().getUser_id());
			model.addAttribute(email);
			model.addAttribute(accountRepository.findByUser(user));
			model.addAttribute(accountRepository.findAllByStatement(statement));
			return "index";
		} else {
			return "login";
		}
	}
}
