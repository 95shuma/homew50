package homew50.homew50.service;

import homew50.homew50.dto.ImageDTO;
import homew50.homew50.exception.ResourceNotFoundException;
import homew50.homew50.model.PublicationImage;
import homew50.homew50.repository.PublicationImageRepository;
import org.bson.types.Binary;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service
public class PublicationImageService {
    private final PublicationImageRepository pir;

    public PublicationImageService(PublicationImageRepository pir) {
        this.pir = pir;
    }

    public ImageDTO addImage(MultipartFile file) {
        byte[] data = new byte[0];
        try {
            data = file.getBytes();
        } catch (IOException e) {
            e.printStackTrace();
        }

        if (data.length == 0) {
            // TODO return no content or something or throw exception
            //  which will be processed on controller layer
        }

        Binary bData = new Binary(data);
        PublicationImage image = PublicationImage.builder().pubData(bData).build();

        pir.save(image);

        return ImageDTO.builder()
                .imageId(image.getId())
                .build();
    }

    public Resource getById(String imageId) {
        PublicationImage movieImage = pir.findById(imageId)
                .orElseThrow(() -> new ResourceNotFoundException("Movie Image with " + imageId + " doesn't exists!"));
        return new ByteArrayResource(movieImage.getPubData().getData());
    }
}
