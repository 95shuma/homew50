package homew50.homew50.repository;

import homew50.homew50.model.Event;
import org.springframework.data.repository.CrudRepository;

public interface EventRepository extends CrudRepository <Event, String> {
    //
}
