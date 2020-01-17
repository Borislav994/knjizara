package jwd.knjizara.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import jwd.knjizara.model.Izdavac;
import jwd.knjizara.model.Knjiga;

@Repository
public interface KnjigaRepository extends JpaRepository<Knjiga, Long> {
	
	List<Knjiga> findByIzdavacId(Long IzdavacId);
	
	List<Knjiga> findByIzdavac(Izdavac izdavac);

}
