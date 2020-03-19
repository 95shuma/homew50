package homew50.homew50.controller;

import homew50.homew50.model.Publication;
import homew50.homew50.model.Users;
import homew50.homew50.repository.PublicationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/publication")
public class PublicationController {

    @Autowired
    PublicationRepository pr;

    @PostMapping()
    public Publication createPublication(@RequestBody Publication pub) {
        pr.save(pub);
        return pub;
    }

    @DeleteMapping("/delete/{id}")
    public void deletePublication(@PathVariable("id") String id){
        pr.deletePublicationById(id);
    }
}
