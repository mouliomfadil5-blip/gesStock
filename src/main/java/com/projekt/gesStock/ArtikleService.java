package com.projekt.gesStock;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.config.ConfigDataResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ArtikleService {
    @Autowired
    private ArtikleRepository artikleRepository;

    public List<Artikle> getAllArtikle() {
        return artikleRepository.findAll();
    }
    public Artikle getArtikleById(Long id) {
       Artikle artikleVorhanden = artikleRepository.findById(id).orElseThrow( () -> new ResourceNotFoundException("Arktile mit der ID " +id+ "konnte nicht gefunden werden"));
            return artikleVorhanden;
    }
    public Artikle saveArtikle(Artikle neuArtikle) {
       return  artikleRepository.save(neuArtikle);
    }
    public Artikle updateArtikle(Long id, Artikle updatedArtikle){
        Artikle artikleVorhanden = artikleRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Arktile mit der ID " +id+ "konnte nicht gefunden werden"));

            artikleVorhanden.setMenge(updatedArtikle.getMenge());
            artikleVorhanden.setName(updatedArtikle.getName());
            artikleVorhanden.setPreis(updatedArtikle.getPreis());
            return artikleRepository.save(artikleVorhanden);
    }
    public ResponseEntity<String> deleteArtikle(Long id) {
        Optional<Artikle> optionalArtikle= artikleRepository.findById(id);
        if(optionalArtikle.isPresent()){
            Artikle deletedArtikle= optionalArtikle.get();
            artikleRepository.delete(deletedArtikle);
            return new ResponseEntity<> ("Der Artikle mit der ID: " +id+ " wurde erfolgreich gelöscht", HttpStatus.OK);
        } return new ResponseEntity<>("Es existiert kein Artikle mit der ID: " +id, HttpStatus.OK);
    }

}
