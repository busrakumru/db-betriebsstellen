package de.db.betriebsstellen.model;

import javax.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "betriebsstellen")
public class Betriebsstelle {

    @Column(name = "plc")
    private String plc;

    @Id
    @Column(name = "rl100_code")
    private String code;

    @Column(name = "rl100_langname")
    private String langname;

    @Column(name = "rl_kurzname")
    private String kurzname;

    @Column(name = "typ_kurz")
    private String typ_kurz;

    @Column(name = "typ_lang")
    private String typ_lang;

    @Column(name = "betriebszustand")
    private String betriebszustand;

    @Column(name = "datum_ab")
    private String datum_ab;

    @Column(name = "datum_bis")
    private String datum_bis;

    @Column(name = "niederlassung")
    private String niederlassung;

    @Column(name = "regionalbereich")
    private String regionalbereich;

    @Column(name = "letzte_änderung")
    private String aenderung;

    public Betriebsstelle() {
    }

    public Betriebsstelle(
            String plc,
            String code,
            String langname,
            String kurzname,
            String typ_kurz,
            String typ_lang,
            String betriebszustand,
            String datum_ab,
            String datum_bis,
            String niederlassung,
            String regionalbereich,
            String aenderung) {

        this.plc = plc;
        this.code = code;
        this.langname = langname;
        this.kurzname = kurzname;
        this.typ_kurz = typ_kurz;
        this.typ_lang = typ_lang;
        this.betriebszustand = betriebszustand;
        this.datum_ab = datum_ab;
        this.datum_bis = datum_bis;
        this.niederlassung = niederlassung;
        this.regionalbereich = regionalbereich;
        this.aenderung = aenderung;
    }
}
