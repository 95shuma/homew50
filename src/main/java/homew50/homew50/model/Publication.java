package homew50.homew50.model;

import homew50.homew50.util.Generator;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Document(collection = "publicationList")
@Data
@Builder
public class Publication {
    @Id
    private String id;
    private String description;
    @DBRef
    private PublicationImage image;
    private LocalDateTime date;
    @DBRef
    private Users user;
    @DBRef
    @Builder.Default
    private List<Comment> commentList = new ArrayList<>();

    public static Publication addPost(Users user) {
        return builder()
                .user(user)
                .description(Generator.makeDescription())
                .date(LocalDateTime.now())
                .build();
    }

}
