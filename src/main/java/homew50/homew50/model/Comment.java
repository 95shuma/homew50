package homew50.homew50.model;

import homew50.homew50.util.Generator;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import java.time.LocalDateTime;

@Document(collection = "commentList")
@AllArgsConstructor(access = AccessLevel.PUBLIC)
@Data
@Builder
public class Comment {
    @Id
    private String id;
    private String text;
    private LocalDateTime date;
    private String userId;
    private String postId;

    public static Comment addComment(Users user, Publication post){
        return builder()
                .text(Generator.makeDescription())
                .date(LocalDateTime.now())
                .userId(user.getId())
                .build();
    }

}
