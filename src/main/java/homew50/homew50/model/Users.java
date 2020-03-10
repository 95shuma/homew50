package homew50.homew50.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
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

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public int getCountPub() {
        return countPub;
    }

    public void setCountPub(int countPub) {
        this.countPub = countPub;
    }

    public int getCountSubscriptions() {
        return countSubscriptions;
    }

    public void setCountSubscriptions(int countSubscriptions) {
        this.countSubscriptions = countSubscriptions;
    }

    public int getCountSubscribers() {
        return countSubscribers;
    }

    public void setCountSubscribers(int countSubscribers) {
        this.countSubscribers = countSubscribers;
    }
}
