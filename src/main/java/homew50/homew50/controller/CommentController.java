package homew50.homew50.controller;

import homew50.homew50.model.Comment;
import homew50.homew50.model.Publication;
import homew50.homew50.repository.CommentRepository;
import homew50.homew50.repository.PublicationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/comment")
public class CommentController {
    @Autowired
    CommentRepository cr;

    @PostMapping()
    public Comment createComment(@RequestBody Comment com) {
        cr.save(com);
        return com;
    }

    @DeleteMapping("/delete/{id}")
    public void deleteComment(@PathVariable("id") String id){
        cr.deleteCommentById(id);
    }

    @GetMapping("/all")
    public Iterable<Comment> findAll(){
        return cr.findAll();
    }
}
