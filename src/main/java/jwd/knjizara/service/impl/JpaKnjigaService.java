package jwd.knjizara.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import jwd.knjizara.model.Knjiga;
import jwd.knjizara.repository.KnjigaRepository;
import jwd.knjizara.service.KnjigaService;

@Service
public class JpaKnjigaService implements KnjigaService {
	
	@Autowired
	private KnjigaRepository knjRep;

	@Override
	public Knjiga findOne(Long id) {
		// TODO Auto-generated method stub
		return knjRep.findOne(id);
	}

	@Override
	public Page<Knjiga> findAll(int pageNum) {
		// TODO Auto-generated method stub
		return knjRep.findAll(new PageRequest(pageNum, 5));
	}

	@Override
	public Knjiga save(Knjiga knjiga) {
		// TODO Auto-generated method stub
		return knjRep.save(knjiga);
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		 knjRep.delete(id);
	}

	@Override
	public List<Knjiga> findByIzdavac(Long izdavacId) {
		// TODO Auto-generated method stub
		return knjRep.findByIzdavacId(izdavacId);
	}
	

}
