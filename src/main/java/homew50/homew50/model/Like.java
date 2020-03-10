package homew50.homew50.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Document
public class Like {
    @Id
    private String id;
    private String userId;
    private String pubId;
    private LocalDateTime date;

    public Like(String userId, String pubId, LocalDateTime date) {
        this.userId = userId;
        this.pubId = pubId;
        this.date = date;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getPubId() {
        return pubId;
    }

    public void setPubId(String pubId) {
        this.pubId = pubId;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }
}
