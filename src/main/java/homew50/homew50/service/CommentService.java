package homew50.homew50.service;

import homew50.homew50.dto.CommentDTO;
import homew50.homew50.dto.PublicationDTO;
import homew50.homew50.dto.UserDTO;
import homew50.homew50.model.Comment;
import homew50.homew50.model.Users;
import homew50.homew50.repository.CommentRepository;
import homew50.homew50.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.stereotype.Service;
import springfox.documentation.annotations.ApiIgnore;

@Service
public class CommentService {
    @Autowired
    UsersRepository ur;

    @Autowired
    CommentRepository cr;

    public CommentDTO createComment(CommentDTO commentDTO){
        Comment com = Comment.builder()
                .id(commentDTO.getId())
                .text(commentDTO.getText())
                .date(commentDTO.getDate())
                .user(ur.findUsersById(commentDTO.getUserId()))
                .build();
        cr.save(com);
        return CommentDTO.from(com);
    }

    public void deleteCommentById(String id){
        cr.deleteCommentById(id);
    }

    public Slice<CommentDTO> findAllCom(@ApiIgnore Pageable pageable){
        return cr.findAll(pageable).map(CommentDTO::from);
    }
}
