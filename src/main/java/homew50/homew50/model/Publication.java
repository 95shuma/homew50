package homew50.homew50.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Document
@Data
public class Publication {
    @Id
    private String id;
    private String description;
    private String image;
    private LocalDateTime date;

    public Publication(String description, String image, LocalDateTime date) {
        this.description = description;
        this.image = image;
        this.date = date;
    }

}
