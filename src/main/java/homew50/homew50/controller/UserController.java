package homew50.homew50.controller;

import homew50.homew50.dto.UserDTO;
import homew50.homew50.service.UserService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {
    UserService us;

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
