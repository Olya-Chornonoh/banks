package bank.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import bank.model.User;
import bank.repository.UserRepository;

@Controller
public class SignUpController {

	private UserRepository userRepository;
	
	@Autowired
	public SignUpController(UserRepository userRepository) {
		this.userRepository = userRepository;
	}
	
	@GetMapping("/signup")
	public String getSignUp() {
		return "signup";
	}
	
	@PostMapping("/signup")
	public String postSignUp(@RequestParam String email, @RequestParam String password, @RequestParam String confirmPassword) {
		if(password.equals(confirmPassword)) {
			User user = new User();
			user.setEmail(email);
			user.setPassword(password);
			userRepository.save(user);
			return "login";
		} else {
			return "signup";
		}
	}
}
