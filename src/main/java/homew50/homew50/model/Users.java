package homew50.homew50.model;

import lombok.AccessLevel;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@Data
public class Users {
    @Id
    private String id;
    private String name;
    private String mail;
    private String pass;
    private int countPub;
    private int countSubscriptions;
    private int countSubscribers;

    public Users(String name, String mail, String pass) {
        this.name = name;
        this.mail = mail;
        this.pass = pass;
    }

}
