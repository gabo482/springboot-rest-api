package net.javaguides.springbootrestapi.controller;
import java.util.ArrayList;
import java.util.List;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
public class UserController {
	private List<String> users = new ArrayList<>();
    @GetMapping
    public List<String> getAllUsers() {
        return users;
    }
    @PostMapping
    public String createUser(@RequestBody String user) {
        users.add(user);
        return "User created: " + user;
    }
    @DeleteMapping("/{user}")
    public String deleteUser(@PathVariable String user) {
        if (users.contains(user)) {
            users.remove(user);
            return "User deleted: " + user;
        }
        return "User not found";
    }
	
}

/*

		Create a user:
		curl -X POST -H "Content-Type: application/json" -d '{"name":"John Doe"}' http://localhost:8080/api/users
		Get all users:
		curl http://localhost:8080/api/users
		Delete a user:
		curl -X DELETE http://localhost:8080/api/users/John%20Doe
		Get all users again:
		curl http://localhost:8080/api/users

*/