package homew50.homew50.controller;

import homew50.homew50.annotations.ApiPageable;
import homew50.homew50.dto.PublicationDTO;
import homew50.homew50.model.Publication;
import homew50.homew50.repository.PublicationRepository;
import homew50.homew50.service.PublicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import springfox.documentation.annotations.ApiIgnore;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;


@ApiPageable
@RestController
@RequestMapping("/post")
public class PublicationController {
    @Autowired
    PublicationRepository pr;
    PublicationService ps;

    public PublicationController(PublicationService ps) {
        this.ps = ps;
    }



    /*@PostMapping()
    public PublicationDTO createPublication(@RequestBody PublicationDTO pubDTO) {
        return ps.createPublication(pubDTO);
    }*/

    @DeleteMapping("/delete/{id}")
    public void deletePublication(@PathVariable("id") String id){
        ps.deletePublicationById(id);
    }

    @GetMapping("/all")
    public List<Publication> findAll(){
        return pr.findAll();
    }

    /*@GetMapping("/all")
    public Iterable<PublicationDTO> findAll(@ApiIgnore Pageable pageable){
        return ps.findAllPub(pageable);
    }*/

    @GetMapping("/id/{id}")
    public PublicationDTO findPubId(@PathVariable("id") String id){
        return ps.findPublicationById(id);
    }

    @GetMapping("/mail/{mail}")
    public List<PublicationDTO> findPubByUsMail(@PathVariable("mail") String mail){
        return ps.findPubByUsMail(mail);
    }
}
