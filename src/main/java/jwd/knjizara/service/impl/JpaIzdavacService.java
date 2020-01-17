package jwd.knjizara.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jwd.knjizara.model.Izdavac;
import jwd.knjizara.repository.IzdavacRepository;
import jwd.knjizara.service.IzdavacService;

@Service
public class JpaIzdavacService implements IzdavacService{
	
	@Autowired
	private IzdavacRepository izRep;

	@Override
	public List<Izdavac> findAll() {
		// TODO Auto-generated method stub
		return izRep.findAll();
	}

	@Override
	public Izdavac findOne(Long id) {
		// TODO Auto-generated method stub
		return izRep.findOne(id);
	}

	@Override
	public Izdavac save(Izdavac izdavac) {
		// TODO Auto-generated method stub
		return izRep.save(izdavac);
	}

}
