package homew50.homew50.model;

import homew50.homew50.util.Generator;
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
    @Builder.Default
    private List<Publication> publicationList = new ArrayList<>();

    @DBRef
    @Builder.Default
    private List<Users> subsciptions= new ArrayList<>();

    @DBRef
    @Builder.Default
    private List<Users> subscibers= new ArrayList<>();

    public static Users random() {
        return builder()
                .mail(Generator.makeEmail())
                .name(Generator.makeName())
                .pass(Generator.makePassword())
                .build();
    }

}
