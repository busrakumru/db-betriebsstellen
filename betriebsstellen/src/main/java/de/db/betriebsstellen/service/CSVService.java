package de.db.betriebsstellen.service;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import de.db.betriebsstellen.helper.CSVHelper;
import de.db.betriebsstellen.model.Betriebsstelle;
import de.db.betriebsstellen.repository.BetriebsstellenRepository;

@Service
public class CSVService {

    @Autowired
    BetriebsstellenRepository bsRepository;

    public void save(MultipartFile file) {

        try {
            List<Betriebsstelle> bs = CSVHelper.csvToBetriebsstelle(file.getInputStream());
            bsRepository.saveAll(bs);
        } catch (IOException e) {
            throw new RuntimeException("Die Datei kann nicht im Datenbank gespeichert werden: " + e.getMessage());
        }
    }

    public List<Betriebsstelle> getAllBetriebsstellen() {
        return bsRepository.findAll();
    }

    public List<Betriebsstelle> findBsByCode(String code) {
        return bsRepository.findByCode(code);
    }

}
