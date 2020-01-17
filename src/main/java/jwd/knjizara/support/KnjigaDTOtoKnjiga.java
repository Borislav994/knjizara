package jwd.knjizara.support;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import jwd.knjizara.model.Izdavac;
import jwd.knjizara.model.Knjiga;
import jwd.knjizara.service.IzdavacService;
import jwd.knjizara.service.KnjigaService;
import jwd.knjizara.web.dto.KnjigaDTO;




@Component
public class KnjigaDTOtoKnjiga implements Converter<KnjigaDTO, Knjiga> {
	
	@Autowired
	private KnjigaService knjigaSevice;
	
	@Autowired
	private IzdavacService izdavacService;

	@Override
	public Knjiga convert(KnjigaDTO knjigaDTO) {
		Izdavac izdavac = izdavacService.findOne(knjigaDTO.getIzdavacId());

		if (izdavac != null) {

			Knjiga knjiga = null;

			if (knjigaDTO.getId() != null) {
				knjiga = knjigaSevice.findOne(knjigaDTO.getId());
			} else {
				knjiga = new Knjiga();
			}

			knjiga.setId(knjigaDTO.getId());
			knjiga.setNaziv(knjigaDTO.getNaziv());
			knjiga.setBrGlasova(knjigaDTO.getBrGlasova());
			knjiga.setIzdanje(knjigaDTO.getIzdanje());
			knjiga.setPisac(knjigaDTO.getPisac());
			knjiga.setISBN(knjigaDTO.getISBN());
			knjiga.setIzdavac(izdavac);
			

			return knjiga;
		} else {
			throw new IllegalStateException("Trying to attach to non-existant entities");
		}		
	}
	
	public List<Knjiga> convert(List<KnjigaDTO> knjigeDTOs) {
		List<Knjiga> ret = new ArrayList<>();

		for (KnjigaDTO knjogaDTO : knjigeDTOs) {
			ret.add(convert(knjogaDTO));
		}

		return ret;
	}

}
