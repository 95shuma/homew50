package homew50.homew50.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Document(collection = "publicationList")
@Data
public class Publication {
    @Id
    private String id;
    private String description;
    @DBRef
    private PublicationImage image;
    private LocalDateTime date;
    @DBRef
    private List<Comment> commentList = new ArrayList<>();

    public Publication(String description, LocalDateTime date) {
        this.description = description;
        this.date = date;
    }

}
