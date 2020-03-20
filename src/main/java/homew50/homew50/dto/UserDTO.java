package homew50.homew50.dto;

import homew50.homew50.model.Publication;
import homew50.homew50.model.Users;
import lombok.*;
import org.springframework.data.mongodb.core.mapping.DBRef;

import java.util.ArrayList;
import java.util.List;

@Data
@Builder(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PRIVATE, force = true)
public class UserDTO {
    private String id;
    private String name;
    private String mail;
    private String pass;
    private List<Publication> publicationList = new ArrayList<>();
    private List<Users> subsciptions;
    private List<Users> subscibers;

    public static UserDTO from(Users user) {
        return builder()
                .id(user.getId())
                .name(user.getName())
                .mail(user.getMail())
                .pass(user.getPass())
                .publicationList(user.getPublicationList())
                .subsciptions(user.getSubsciptions())
                .subscibers(user.getSubscibers())
                .build();
    }
}
