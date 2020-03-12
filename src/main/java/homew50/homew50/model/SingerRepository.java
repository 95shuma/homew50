package homew50.homew50.model;

import org.springframework.data.repository.CrudRepository;

public interface SingerRepository extends CrudRepository<Singer,String> {
    public Singer findSingerByName(String name);
}
