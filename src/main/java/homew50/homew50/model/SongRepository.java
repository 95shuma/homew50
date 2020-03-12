package homew50.homew50.model;

import org.springframework.data.repository.CrudRepository;

public interface SongRepository extends CrudRepository <Song,String> {
    public Song findSongByName(String name);
}
