package jwd.knjizara.service;

import java.util.List;

import jwd.knjizara.model.Izdavac;

public interface IzdavacService {
	
	List<Izdavac> findAll();

	Izdavac findOne(Long id);
	
	Izdavac save(Izdavac izdavac);

}
