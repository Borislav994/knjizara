package jwd.knjizara.support;

import java.util.ArrayList;
import java.util.List;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import jwd.knjizara.model.Izdavac;
import jwd.knjizara.web.dto.IzdavacDTO;
@Component
public class IzdavacToIzdavacDTO implements Converter<Izdavac, IzdavacDTO> {
	
	@Override
	public IzdavacDTO convert(Izdavac izdavac) {
		IzdavacDTO retValue = new IzdavacDTO();
		retValue.setId(izdavac.getId());
		retValue.setNaziv(izdavac.getNaziv());
		retValue.setAdresa(izdavac.getAdresa());
		retValue.setTelefon(izdavac.getTelefon());
		
		return retValue;
	}
	
	public List<IzdavacDTO> convert(List<Izdavac> izdavaci) {
		List<IzdavacDTO> ret = new ArrayList<>();

		for (Izdavac izdavac : izdavaci) {
			ret.add(convert(izdavac));
		}

		return ret;
	}

}
