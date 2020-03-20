package homew50.homew50.controller;

import homew50.homew50.annotations.ApiPageable;
import homew50.homew50.dto.CommentDTO;
import homew50.homew50.service.CommentService;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;


@ApiPageable
@RestController
@RequestMapping("/comment")
public class CommentController {
    CommentService cs;

    public CommentController(CommentService cs) {
        this.cs = cs;
    }

    @PostMapping()
    public CommentDTO createComment(@RequestBody CommentDTO com) {
        return cs.createComment(com);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteComment(@PathVariable("id") String id){
        cs.deleteCommentById(id);
    }

    @GetMapping("/all")
    public Slice<CommentDTO> findAll(@ApiIgnore Pageable pageable){
        return cs.findAllCom(pageable);
    }
}
