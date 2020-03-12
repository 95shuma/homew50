package homew50.homew50.util;

import homew50.homew50.model.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Configuration
public class PreloadDBwithData {
    private final UsersRepository ur;
    private final CommentRepository cr;
    private final EventRepository er;
    private final LikeRepository lr;
    private final PublicationRepository pr;

    public PreloadDBwithData(UsersRepository ur, CommentRepository cr, EventRepository er, LikeRepository lr, PublicationRepository pr) {
        this.ur = ur;
        this.cr = cr;
        this.er = er;
        this.lr = lr;
        this.pr = pr;
    }

    private List <Users> createUsers(){
        List<Users> users = new ArrayList<>();
        users.add(new Users("Aibek","aib@asd.ru","qwer"));
        users.add(new Users("Arstan","ars@asd.ru","asdf"));
        users.add(new Users("Ali","ali@asd.ru","zxcv"));
        return users;
    }

    @Bean
    CommandLineRunner initDB(){
        ur.deleteAll();
        cr.deleteAll();
        er.deleteAll();
        lr.deleteAll();
        pr.deleteAll();

        ur.saveAll(createUsers());
        Publication pc = new Publication("some description 1","1.jpg",LocalDateTime.now());
        pr.save(pc);
        pr.save(new Publication("some description 2","2.jpg",LocalDateTime.now()));

        var user = ur.findUsersByName("Aibek");
        System.out.println(user.toString());

        user.getPublicationList().add(pc);
        user.getPublicationList().add(pr.findPublicationByDescription("some description 2"));
        ur.save(user);

        System.out.println(ur.findUsersByName("Aibek").getPublicationList().toString());
        //new Publication("some description 1","1.jpg",LocalDateTime.now()));
        /*cr.save(new Comment("some text", LocalDateTime.now(),ur.findUsersByName("Aibek").getId()));
        cr.save(new Comment("some text", LocalDateTime.now(),ur.findUsersByName("Arstan").getId()));
        cr.save(new Comment("some text", LocalDateTime.now(),ur.findUsersByName("Ali").getId()));

        er.save(new Event(ur.findUsersByName("Aibek").getId(),ur.findUsersByName("Arstan").getId(),LocalDateTime.now()));
        er.save(new Event(ur.findUsersByName("Arstan").getId(),ur.findUsersByName("Ali").getId(),LocalDateTime.now()));
        er.save(new Event(ur.findUsersByName("Ali").getId(),ur.findUsersByName("Aibek").getId(),LocalDateTime.now()));

        pr.save(new Publication("some description 1","1.jpg",LocalDateTime.now()));
        pr.save(new Publication("some description 2","2.jpg",LocalDateTime.now()));
        pr.save(new Publication("some description 3","3.jpg",LocalDateTime.now()));

        lr.save(new Like(ur.findUsersByName("Aibek").getId(),pr.findPublicationByDescription("some description 1").getId(),LocalDateTime.now()));
        lr.save(new Like(ur.findUsersByName("Arstan").getId(),pr.findPublicationByDescription("some description 2").getId(),LocalDateTime.now()));
        lr.save(new Like(ur.findUsersByName("Ali").getId(),pr.findPublicationByDescription("some description 3").getId(),LocalDateTime.now()));
*/
        return null;
    }

}
