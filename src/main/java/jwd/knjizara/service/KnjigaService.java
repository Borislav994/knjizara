package jwd.knjizara.service;

import java.util.List;

import org.springframework.data.domain.Page;

import jwd.knjizara.model.Knjiga;

public interface KnjigaService {
	
	Knjiga findOne(Long id);

	Page<Knjiga> findAll(int pageNum);

	Knjiga save(Knjiga knjiga);

	void delete(Long id);

	List<Knjiga> findByIzdavac(Long izdavacId);

}
