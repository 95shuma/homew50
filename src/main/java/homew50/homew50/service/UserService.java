package homew50.homew50.service;

import homew50.homew50.util.SecurityConfig;
import homew50.homew50.dto.UserDTO;
import homew50.homew50.model.Users;
import homew50.homew50.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    UsersRepository ur;

    public UserDTO getUserByName(String name){
        return UserDTO.from(ur.findUsersByName(name));
    }

    public Users getUserByEmail(String mail){
        return ur.findUsersByMail(mail);
    }

    public UserDTO getUserByMail(String mail){
        return UserDTO.from(ur.findUsersByMail(mail));
    }

    public boolean existUserByMail(String mail){
        return ur.existsUsersByMail(mail);
    }

    public UserDTO createUser(UserDTO userDTO){
        Users user = Users.builder()
                .id(userDTO.getId())
                .name(userDTO.getName())
                .mail(userDTO.getMail())
                .pass(SecurityConfig.encoder().encode(userDTO.getPass()))
                .publicationList(userDTO.getPublicationList())
                .subscibers(userDTO.getSubscibers())
                .subsciptions(userDTO.getSubsciptions())
                .build();
        ur.save(user);
        return UserDTO.from(user);
    }

    public void deleteUsersByName(String name){
        ur.deleteUsersByName(name);
    }
}
