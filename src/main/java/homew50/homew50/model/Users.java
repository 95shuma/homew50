package homew50.homew50.model;

import homew50.homew50.util.SecurityConfig;
import homew50.homew50.util.Generator;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Document(collection = "userList")
@AllArgsConstructor(access = AccessLevel.PUBLIC)
@Data
@Builder
public class Users implements UserDetails {
    @Id
    private String id;
    private String name;
    private String login;
    private String mail;
    private String pass;
    /*@DBRef
    @Builder.Default
    private List<Publication> publicationList = new ArrayList<>();

    @DBRef
    @Builder.Default
    private List<Users> subsciptions= new ArrayList<>();

    @DBRef
    @Builder.Default
    private List<Users> subscibers= new ArrayList<>();*/

    public static Users random() {
        return builder()
                .mail(Generator.makeEmail())
                .name(Generator.makeName())
                .pass(SecurityConfig.encoder().encode(Generator.makePassword()))
                .build();
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority("FULL"));
    }

    @Override
    public String getPassword() {
        return this.pass;
    }

    public void setPassword(String password) {
        this.pass = SecurityConfig.encoder().encode(password);
    }

    @Override
    public String getUsername() {
        return getMail();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
