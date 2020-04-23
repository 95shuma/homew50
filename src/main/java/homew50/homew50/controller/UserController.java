package homew50.homew50.controller;

import homew50.homew50.dto.UserDTO;
import homew50.homew50.model.Users;
import homew50.homew50.repository.UsersRepository;
import homew50.homew50.service.UserAuthService;
import homew50.homew50.service.UserService;
import homew50.homew50.util.SecurityConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UsersRepository ur;

    UserService us;

    public UserController(UserService us) {
        this.us = us;
    }

    @PostMapping("/registration")
    public Users createUser(@RequestParam("email")String email, @RequestParam("name")String name,
                            @RequestParam("login")String login, @RequestParam("password")String password){
        var user = new Users(UUID.randomUUID().toString(), name, login, email, password);
        user.setPassword(user.getPassword());
        ur.save(user);
        return user;
    }



    @PostMapping()
    public UserDTO createUser(@RequestBody UserDTO userDTO) {
        return us.createUser(userDTO);
    }

    @DeleteMapping("/delete/{name}")
    public void deleteUser(@PathVariable("name") String name){
        us.deleteUsersByName(name);
    }

    @GetMapping("/name/{name}")
    public UserDTO getUserByName (@PathVariable("name") String name){
        return us.getUserByName(name);
    }

    @GetMapping("/mail/{mail}")
    public UserDTO getUserByMail (@PathVariable("mail") String mail){
        return us.getUserByMail(mail);
    }

    @GetMapping("/exist/{mail}")
    public boolean existUserByMail (@PathVariable("mail") String mail) {
        return us.existUserByMail(mail);
    }
}
