package homew50.homew50.model;

import org.springframework.data.repository.CrudRepository;

public interface UsersRepository extends CrudRepository <Users, String> {
    public Users findUsersByName(String name);
}
