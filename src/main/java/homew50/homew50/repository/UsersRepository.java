package homew50.homew50.repository;

import homew50.homew50.model.Users;
import org.springframework.data.repository.CrudRepository;

public interface UsersRepository extends CrudRepository <Users, String> {
    Users findUsersByName(String name);

    Users findUsersByMail(String mail);

    boolean existsUsersByMail(String mail);

    void deleteUsersByName(String name);


}
