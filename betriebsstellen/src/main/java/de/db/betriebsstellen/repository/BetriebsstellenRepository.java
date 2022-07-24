package de.db.betriebsstellen.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import de.db.betriebsstellen.model.Betriebsstelle;


@Repository
public interface BetriebsstellenRepository extends JpaRepository<Betriebsstelle,String>{

   List<Betriebsstelle> findByCode(String code);

}
