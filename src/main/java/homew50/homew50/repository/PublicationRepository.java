package homew50.homew50.repository;

import homew50.homew50.model.Publication;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface PublicationRepository extends CrudRepository <Publication, String> {
    Publication findPublicationByDescription(String des);

    @Query("{'id' : {'$ne' : '?0'}}")
    Iterable<Publication> findAllBy(String id);

    void deletePublicationById(String id);
}