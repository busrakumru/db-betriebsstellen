package de.db.betriebsstellen.helper;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.csv.*;
import org.springframework.web.multipart.MultipartFile;
import de.db.betriebsstellen.model.Betriebsstelle;

public class CSVHelper {

    public static String TYPE = "text/csv";
    static String[] HEADERs = {"PLC", "RL100-Code", "RL100-Langname", "RL100-Kurzname", "Typ Kurz", "Typ Lang", "Betriebszustand", "Datum ab", "Datum bis", "Niederlassung", "Regionalbereich", "Letzte Änderung"};
    public static boolean hasCSVFormat(MultipartFile file){
        if (!TYPE.equals(file.getContentType())){
            return false;
        }
        return true;
    }
    public static List<Betriebsstelle> csvToBetriebsstelle(InputStream is){
        try (BufferedReader fileReader = new BufferedReader(new InputStreamReader(is, "UTF-8"));
            CSVParser csvParser = new CSVParser(fileReader,  CSVFormat.DEFAULT.withDelimiter(';').withFirstRecordAsHeader().withIgnoreHeaderCase().withTrim());){
                List<Betriebsstelle> bs = new ArrayList<Betriebsstelle>();
                Iterable<CSVRecord> csvRecords = csvParser.getRecords();
                for (CSVRecord csvRecord : csvRecords){
                    Betriebsstelle betriebsstelle = new Betriebsstelle(
                        csvRecord.get("PLC"),
                        csvRecord.get("RL100-Code"),
                        csvRecord.get("RL100-Langname"),
                        csvRecord.get("RL100-Kurzname"),
                        csvRecord.get("Typ Kurz"),
                        csvRecord.get("Typ Lang"),
                        csvRecord.get("Betriebszustand"),
                        csvRecord.get("Datum ab"),
                        csvRecord.get("Datum bis"),
                        csvRecord.get("Niederlassung"),
                        csvRecord.get("Regionalbereich"),
                        csvRecord.get("Letzte Änderung")
                    );                    
                    bs.add(betriebsstelle);
                }
                return bs;
            }catch (IOException e) {
                throw new RuntimeException("Die Datei kann nicht gelesen werden: " + e.getMessage());
            }
    }

}