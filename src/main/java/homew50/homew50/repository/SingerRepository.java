package homew50.homew50.repository;

import homew50.homew50.model.Singer;
import org.springframework.data.repository.CrudRepository;

public interface SingerRepository extends CrudRepository<Singer,String> {
    public Singer findSingerByName(String name);
}
