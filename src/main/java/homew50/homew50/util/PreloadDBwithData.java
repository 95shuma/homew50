package homew50.homew50.util;

import homew50.homew50.model.*;
import homew50.homew50.repository.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

@Configuration
public class PreloadDBwithData {
    Random r = new Random();

    @Bean
    CommandLineRunner initDatabase(UsersRepository ur, PublicationRepository pr,
                                   CommentRepository cr) {
        return (args) -> {
            ur.deleteAll();
            pr.deleteAll();
            cr.deleteAll();

            var user = Users.random();
            user.setMail("admin");
            user.setPassword("admin");
            ur.save(user);

            List<Users> users = Stream.generate(Users::random)
                    .limit(10)
                    .collect(toList());
            ur.saveAll(users);

            List<Publication> posts = Stream.generate(() -> Publication.addPost(users.get(r.nextInt(users.size()))))
                    .limit(2)
                    .collect(toList());
            pr.saveAll(posts);

            List<Comment> comments = Stream.generate(() -> Comment.addComment(users.get(r.nextInt(users.size())), posts.get(r.nextInt(posts.size()))))
                    .limit(1)
                    .collect(toList());
            cr.saveAll(comments);
            System.out.println("done");
        };
    }

}
