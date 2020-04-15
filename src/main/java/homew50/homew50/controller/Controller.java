package homew50.homew50.controller;

import homew50.homew50.model.Publication;
import homew50.homew50.model.Users;
import homew50.homew50.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.util.StreamUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.time.LocalDateTime;

@org.springframework.stereotype.Controller
public class Controller {
    /*@Autowired
    CommentRepository cr;

    @Autowired
    EventRepository er;*/

    @Autowired
    LikeRepository lr;

    @Autowired
    PublicationRepository pr;

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

    @GetMapping("/like/{mail}")
    public boolean checkLikePub(@PathVariable("mail") String mail){
        return lr.existsLikeByUserId(ur.findUsersByMail(mail).getId());
    }

    @GetMapping("/")
    public String demo1(Model model) {
        return "index";
    }

    @GetMapping("/demo")
    public String demo(Model model) {
        return "demo";
    }

    @PostMapping("/demo/post")
    public String postDemo(@RequestParam("login") String login,@RequestParam("password") String password) {
        System.out.println(login);
        System.out.println(password);
        return "redirect:/demo";
    }

    @PostMapping("/post")
    public String rootSave(@RequestParam("des") String des,
                           @RequestParam("id") String id,
                           @RequestParam("photo") MultipartFile photo) throws IOException {
        File photoFile = new File("../img/"+photo.getOriginalFilename());
        //photoFile.createNewFile();
        FileOutputStream os = new FileOutputStream(photoFile);
        os.write(photo.getBytes());
        os.close();

        Publication publication = new Publication(id,des,"../img/"+photo.getOriginalFilename(),
                LocalDateTime.now(), null);
        pr.save(publication);

        return "success";
    }

    @GetMapping("/img/{name}")
    @ResponseBody
    public ResponseEntity<byte[]> getImage(@PathVariable("name") String name) {
        String path = "../img";
        try {
            InputStream is = new FileInputStream(new File(path) + "/" + name);
            return ResponseEntity
                    .ok()
                    .contentType(name.toLowerCase().contains(".png")? MediaType.IMAGE_PNG:MediaType.IMAGE_JPEG)
                    .body(StreamUtils.copyToByteArray(is));
        } catch (Exception e) {
            InputStream is = null;
            try {
                is = new FileInputStream(new File(path) + "/" + name);
                return ResponseEntity
                        .ok()
                        .contentType(name.toLowerCase().contains(".png")?MediaType.IMAGE_PNG:MediaType.IMAGE_JPEG)
                        .body(StreamUtils.copyToByteArray(is));
            } catch (IOException ex) {
                ex.printStackTrace();
            }
            e.printStackTrace();
        }
        return null;
    }
}
