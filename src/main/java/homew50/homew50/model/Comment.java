package homew50.homew50.model;

import homew50.homew50.util.Generator;
import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import java.time.LocalDateTime;

@Document(collection = "commentList")
@Data
@Builder
public class Comment {
    @Id
    private String id;
    private String text;
    private LocalDateTime date;
    @DBRef
    private Users user;

    public static Comment addComment(Users user, Publication post){
        return builder()
                .text(Generator.makeDescription())
                .date(LocalDateTime.now())
                .user(user)
                .build();
    }

}
