package homew50.homew50.repository;

import homew50.homew50.model.Album;
import org.springframework.data.repository.CrudRepository;

public interface AlbumRepository extends CrudRepository <Album,String> {
    public Album findAlbumByName(String name);
    public Album findAlbumByReleaseYear(int releaseYear);
}
