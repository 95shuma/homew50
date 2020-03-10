package homew50.homew50.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Document
public class Event {
    @Id
    private String id;
    private String publUsId;
    private String subUsId;
    private LocalDateTime date;

    public Event(String publUsId, String subUsId, LocalDateTime date) {
        this.publUsId = publUsId;
        this.subUsId = subUsId;
        this.date = date;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPublUsId() {
        return publUsId;
    }

    public void setPublUsId(String publUsId) {
        this.publUsId = publUsId;
    }

    public String getSubUsId() {
        return subUsId;
    }

    public void setSubUsId(String subUsId) {
        this.subUsId = subUsId;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }
}
