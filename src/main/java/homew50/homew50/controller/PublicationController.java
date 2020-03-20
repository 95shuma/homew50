package homew50.homew50.controller;

import homew50.homew50.dto.PublicationDTO;
import homew50.homew50.service.PublicationService;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import java.util.List;

@RestController
@RequestMapping("/publication")
public class PublicationController {
    PublicationService ps;

    @PostMapping()
    public PublicationDTO createPublication(@RequestBody PublicationDTO pubDTO) {
        return ps.createPublication(pubDTO);
    }

    @DeleteMapping("/delete/{id}")
    public void deletePublication(@PathVariable("id") String id){
        ps.deletePublicationById(id);
    }

    @GetMapping("/all")
    public Iterable<PublicationDTO> findAll(@ApiIgnore Pageable pageable){
        return ps.findAllPub(pageable);
    }

    @GetMapping("/{id}")
    public PublicationDTO findPubId(@PathVariable("id") String id){
        return ps.findPublicationById(id);
    }

    @GetMapping("/{mail}")
    public List<PublicationDTO> findPubByUsMail(@PathVariable("mail") String mail){
        return ps.findPubByUsMail(mail);
    }
}
