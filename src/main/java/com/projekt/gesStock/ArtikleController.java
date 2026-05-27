package com.projekt.gesStock;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/DB")
public class ArtikleController {
    @Autowired
    ArtikleService artikleService;

    @GetMapping("/overview")
    public ResponseEntity<List<Artikle>> getAll() {
        List<Artikle> uebersicht= artikleService.getAllArtikle();
        return new ResponseEntity<>(uebersicht, HttpStatus.OK);
    }
    @GetMapping("/{id}")
        public ResponseEntity<Artikle> getById(@PathVariable Long id) {
        Artikle derArtikle= artikleService.getArtikleById(id);
        return new ResponseEntity<>(derArtikle, HttpStatus.OK);
        }
        @PostMapping("/add")
    public ResponseEntity<Artikle> addArtikle(@Valid @RequestBody Artikle neuArtikle){
        Artikle hinzugefuegt= artikleService.saveArtikle(neuArtikle);
        return new ResponseEntity<>(hinzugefuegt, HttpStatus.OK);
        }
        @PutMapping("/{id}")
    public ResponseEntity<Artikle> updateArtikle(@PathVariable Long id, @RequestBody Artikle neueDaten){
        Artikle updatedArtikle= artikleService.updateArtikle(id, neueDaten);
        return new ResponseEntity<>(updatedArtikle, HttpStatus.OK);
        }
        @DeleteMapping("/{id}")
    public ResponseEntity<String> delArtikle(@PathVariable Long  id){
        return artikleService.deleteArtikle(id);
        }

}
