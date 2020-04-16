package homew50.homew50.dto;

import homew50.homew50.model.Comment;
import homew50.homew50.model.Users;
import lombok.*;

import java.time.LocalDateTime;

@Data
@Builder(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PRIVATE, force = true)
public class CommentDTO {
    private String id;
    private String text;
    private LocalDateTime date;

    public static CommentDTO from(Comment com) {
        return builder()
                .id(com.getId())
                .text(com.getText())
                .date(com.getDate())
                .build();
    }
}
