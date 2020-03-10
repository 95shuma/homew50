package homew50.homew50.model;

import org.springframework.data.repository.CrudRepository;

public interface PublicationRepository extends CrudRepository <Publication, String> {
    public Publication findPublicationByDescription(String des);
}