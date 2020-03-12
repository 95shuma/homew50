package homew50.homew50.model;

import org.springframework.data.repository.CrudRepository;

public interface AlbumRepository extends CrudRepository <Album,String> {
    public Album findAlbumByName(String name);
    public Album findAlbumByReleaseYear(int releaseYear);
}
