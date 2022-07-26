package de.db.betriebsstellen.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import de.db.betriebsstellen.service.CSVService;
import de.db.betriebsstellen.helper.CSVHelper;
import de.db.betriebsstellen.message.ResponseMessage;
import de.db.betriebsstellen.model.Betriebsstelle;

@CrossOrigin(origins = "https://localhost:8100")
@Controller
@RequestMapping("/db")
public class BetriebsstellenController {

    @Autowired
    CSVService csvService;

    @PostMapping("/betriebsstellen")
    public ResponseEntity<ResponseMessage> uploadFile(@RequestParam("file") MultipartFile file) {
        String message = "";
        if (CSVHelper.hasCSVFormat(file)) {
            try {
                csvService.save(file);
                message = "Die Datei: " + file.getOriginalFilename() + " wurde erfolgreich hochgeladen.";
                return ResponseEntity.status(HttpStatus.OK).body(new ResponseMessage(message));
            } catch (Exception e) {
                message = "Die Datei: " + file.getOriginalFilename() + " konnte nicht hochgeladen werden!";
                return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new ResponseMessage(message));
            }
        }
        message = "Bitte laden Sie eine CSV Datei hoch!";
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ResponseMessage(message));
    }

    @GetMapping("/betriebsstellen")
    public ResponseEntity<List<Betriebsstelle>> getAllBetriebsstellen() {
        try {
            List<Betriebsstelle> bs = csvService.getAllBetriebsstellen();
            if (bs.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(bs, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/betriebsstellen/{code}")
    public ResponseEntity<List<Betriebsstelle>> getBetriebsstelleByCode( @PathVariable String code) {
        try {
            List<Betriebsstelle>  bs = this.csvService.findBsByCode(code);
            return new ResponseEntity<>(bs, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
