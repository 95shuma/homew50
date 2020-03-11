package homew50.homew50.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.time.LocalDateTime;

@Document
@Data
public class Comment {
    @Id
    private String id;
    private String text;
    private LocalDateTime date;
    private String userId;

    public Comment(String text, LocalDateTime date, String userId) {
        this.text = text;
        this.date = date;
        this.userId = userId;
    }

}
