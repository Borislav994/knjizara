package jwd.knjizara;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import jwd.knjizara.model.Izdavac;
import jwd.knjizara.model.Knjiga;
import jwd.knjizara.service.IzdavacService;
import jwd.knjizara.service.KnjigaService;

@Component
public class TestData {
	
	@Autowired
	private KnjigaService knjigaService;
	
	@Autowired
	private IzdavacService izdavacService;
	
	@PostConstruct
	public void init() {
		
		Izdavac iz1 = new Izdavac();
		iz1.setNaziv("izdavac1");
		iz1.setAdresa("Lenjinova");
		iz1.setTelefon("258455");
		izdavacService.save(iz1);
		
		Izdavac iz2 = new Izdavac();
		iz2.setNaziv("izdavac2");
		iz2.setAdresa("Puskinova");
		iz2.setTelefon("25138455");
		izdavacService.save(iz2);
		
		
		
		Knjiga kn1 = new Knjiga();
		kn1.setBrGlasova(2);
		kn1.setISBN("isbn1");
		kn1.setIzdanje("izdanje1");
		kn1.setNaziv("naziv1");
		kn1.setPisac("Branko");
		kn1.setIzdavac(iz1);
		knjigaService.save(kn1);
		
		Knjiga kn2 = new Knjiga();
		kn2.setBrGlasova(2);
		kn2.setISBN("isbn2");
		kn2.setIzdanje("izdanje2");
		kn2.setNaziv("naziv2");
		kn2.setPisac("Marko");
		kn2.setIzdavac(iz2);
		knjigaService.save(kn2);
		
	}

}
