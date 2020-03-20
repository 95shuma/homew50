package homew50.homew50.model;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

@Document(collection = "userList")
@Data
@Builder
public class Users {
    @Id
    private String id;
    private String name;
    private String mail;
    private String pass;
    @DBRef
    private List<Publication> publicationList = new ArrayList<>();

    @DBRef
    private List<Users> subsciptions;

    @DBRef
    private List<Users> subscibers;

    public Users(String name, String mail, String pass) {
        this.name = name;
        this.mail = mail;
        this.pass = pass;
    }

}
