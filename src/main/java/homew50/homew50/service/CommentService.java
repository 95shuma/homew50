package homew50.homew50.service;

import homew50.homew50.dto.CommentDTO;
import homew50.homew50.dto.UserDTO;
import homew50.homew50.model.Users;
import homew50.homew50.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommentService {
    @Autowired
    CommentRepository cr;

    public CommentDTO createComment(CommentDTO commentDTO){
        Users user = Users.builder()
                .id(commentDTO.getId())
                .name(userDTO.getName())
                .mail(userDTO.getMail())
                .pass(userDTO.getPass())
                .publicationList(userDTO.getPublicationList())
                .subscibers(userDTO.getSubscibers())
                .subsciptions(userDTO.getSubsciptions())
                .build();
        cr.save(user);
        return UserDTO.from(user);
    }
}
