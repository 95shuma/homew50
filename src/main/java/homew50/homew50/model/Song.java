package homew50.homew50.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "songList")
@Data
public class Song {

    @Id
    private String id;
    private String name;

    public Song(String name) {
        this.name = name;
    }
}
