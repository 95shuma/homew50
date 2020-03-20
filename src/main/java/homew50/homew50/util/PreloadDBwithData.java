package homew50.homew50.util;

import homew50.homew50.model.*;
import homew50.homew50.repository.*;
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
    private final SingerRepository singerRepository;
    private final SongRepository songRepository;
    private final AlbumRepository albumRepository;

    public PreloadDBwithData(UsersRepository ur, CommentRepository cr, EventRepository er, LikeRepository lr, PublicationRepository pr,
                             SingerRepository singerRepository,SongRepository songRepository,AlbumRepository albumRepository) {
        this.ur = ur;
        this.cr = cr;
        this.er = er;
        this.lr = lr;
        this.pr = pr;
        this.singerRepository = singerRepository;
        this.songRepository = songRepository;
        this.albumRepository = albumRepository;
    }

    private List <Users> createUsers(){
        List<Users> users = new ArrayList<>();
        users.add(new Users("Aibek","aib@asd.ru","qwer"));
        users.add(new Users("Arstan","ars@asd.ru","asdf"));
        users.add(new Users("Ali","ali@asd.ru","zxcv"));
        return users;
    }

    private List <Singer> createSinger(){
        List<Singer> singers = new ArrayList<>();
        singers.add(new Singer("Bilan"));
        singers.add(new Singer("Lazarev"));
        singers.add(new Singer("Omar"));
        return singers;
    }

    @Bean
    CommandLineRunner initDB(){
        ur.deleteAll();
        cr.deleteAll();
        er.deleteAll();
        lr.deleteAll();
        pr.deleteAll();
        singerRepository.deleteAll();
        albumRepository.deleteAll();
        songRepository.deleteAll();



        ur.saveAll(createUsers());
        pr.save(new Publication("some description 1",LocalDateTime.now()));
        pr.save(new Publication("some description 2",LocalDateTime.now()));

        cr.save(new Comment("some text 1", LocalDateTime.now(),ur.findUsersByName("Arstan").getId()));
        cr.save(new Comment("some text 2", LocalDateTime.now(),ur.findUsersByName("Arstan").getId()));

        var user = ur.findUsersByName("Aibek");
        user.getPublicationList().add(pr.findPublicationByDescription("some description 1"));
        user.getPublicationList().add(pr.findPublicationByDescription("some description 2"));
        var publ = pr.findPublicationByDescription("some description 1");
        publ.getCommentList().add(cr.findCommentByText("some text 1"));
        publ.getCommentList().add(cr.findCommentByText("some text 2"));

        pr.save(publ);
        ur.save(user);

        //System.out.println(ur.findUsersByName("Aibek").getPublicationList().toString());
        //System.out.println(pr.findPublicationByDescription("some description 1").getCommentList().toString());

        singerRepository.saveAll(createSinger());

        albumRepository.save(new Album("Rain",1999));
        albumRepository.save(new Album("Sky",2000));

        songRepository.save(new Song("Hello"));
        songRepository.save(new Song("Bye"));

        var singer = singerRepository.findSingerByName("Bilan");
        singer.getAlbumList().add(albumRepository.findAlbumByName("Rain"));
        singer.getAlbumList().add(albumRepository.findAlbumByReleaseYear(2000));
        singerRepository.save(singer);

        var alb = albumRepository.findAlbumByReleaseYear(1999);
        alb.getSongList().add(songRepository.findSongByName("Hello"));
        alb.getSongList().add(songRepository.findSongByName("Bye"));
        albumRepository.save(alb);

        //System.out.println(singerRepository.findAll());

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
