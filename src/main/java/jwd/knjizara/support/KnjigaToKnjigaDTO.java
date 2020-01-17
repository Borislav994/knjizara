package jwd.knjizara.support;

import java.util.ArrayList;
import java.util.List;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import jwd.knjizara.model.Knjiga;
import jwd.knjizara.web.dto.KnjigaDTO;

@Component
public class KnjigaToKnjigaDTO implements Converter<Knjiga, KnjigaDTO> {
	
	@Override
	public KnjigaDTO convert(Knjiga knjiga) {
		KnjigaDTO retValue = new KnjigaDTO();
		retValue.setId(knjiga.getId());
		retValue.setNaziv(knjiga.getNaziv());
		retValue.setBrGlasova(knjiga.getBrGlasova());
		retValue.setISBN(knjiga.getISBN());
		retValue.setIzdanje(knjiga.getIzdanje());
		retValue.setPisac(knjiga.getPisac());
		retValue.setIzdavacId(knjiga.getIzdavac().getId());
		retValue.setIzdavacNaziv(knjiga.getIzdavac().getNaziv());
		
		return retValue;
	}
	
	public List<KnjigaDTO> convert(List<Knjiga> knjige) {
		List<KnjigaDTO> ret = new ArrayList<>();

		for (Knjiga knjiga : knjige) {
			ret.add(convert(knjiga));
		}

		return ret;
	}
}
