package homew50.homew50.controller;

import homew50.homew50.model.Users;
import homew50.homew50.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UsersRepository ur;

    @PostMapping()
    public Users createUser(@RequestBody Users user) {
        ur.save(user);
        return user;
    }

    @DeleteMapping("/delete/{name}")
    public void deleteUser(@PathVariable("name") String name){
        ur.deleteUsersByName(name);
    }
}
