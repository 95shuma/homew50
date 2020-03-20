package homew50.homew50.controller;

import homew50.homew50.model.Publication;
import homew50.homew50.model.Users;
import homew50.homew50.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class Controller {
    /*@Autowired
    CommentRepository cr;

    @Autowired
    EventRepository er;*/

    @Autowired
    LikeRepository lr;

    /*@Autowired
    PublicationRepository pr;*/

    @Autowired
    UsersRepository ur;

    /*@GetMapping("/2/1/1/{name}")
    public Users getUserByName(@PathVariable("name") String name){
        return ur.findUsersByName(name);
    }

    @GetMapping("/2/1/2/{mail}")
    public Users getUserByMail(@PathVariable("mail") String mail){
        return ur.findUsersByMail(mail);
    }

    @GetMapping("/2/2/{mail}")
    public boolean existUserByMail(@PathVariable("mail") String mail){
        return ur.existsUsersByMail(mail);
    }

    @GetMapping("/2/3/{id}")
    public Iterable<Publication> getPubById(@PathVariable("id") String id){
        return pr.findAllBy(id);
    }

    @GetMapping("/2/4/{mail}")
    public Iterable<Publication> getPubByUs(@PathVariable("mail") String mail){
        List<Publication> res = new ArrayList<>();
        Users user = ur.findUsersByMail(mail);
        List<Users> subs = user.getSubsciptions();
        for (Users s: subs) {
            res.addAll(s.getPublicationList());
        }
        return res;
    }*/

    @GetMapping("/2/5/{mail}")
    public boolean checkLikePub(@PathVariable("mail") String mail){
        return lr.existsLikeByUserId(ur.findUsersByMail("mail").getId());
    }

}
