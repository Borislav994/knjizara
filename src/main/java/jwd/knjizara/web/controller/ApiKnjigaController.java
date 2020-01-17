package jwd.knjizara.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import jwd.knjizara.model.Knjiga;
import jwd.knjizara.service.KnjigaService;
import jwd.knjizara.support.KnjigaDTOtoKnjiga;
import jwd.knjizara.support.KnjigaToKnjigaDTO;
import jwd.knjizara.web.dto.KnjigaDTO;


@Controller
@RequestMapping("/api/knjige")
public class ApiKnjigaController {

	@Autowired
	private KnjigaService knjigeService;

	@Autowired
	private KnjigaToKnjigaDTO toDTO;

	@Autowired
	private KnjigaDTOtoKnjiga toKnjiga;

	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<KnjigaDTO>> get(@RequestParam(value = "pageNum", defaultValue = "0") int pageNum) {

		Page<Knjiga> recordsPage = null;

		recordsPage = knjigeService.findAll(pageNum);

		return new ResponseEntity<>(toDTO.convert(recordsPage.getContent()), HttpStatus.OK);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<KnjigaDTO> get(@PathVariable Long id) {

		Knjiga kn = knjigeService.findOne(id);

		return new ResponseEntity<>(toDTO.convert(kn), HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.POST, consumes = "application/json")
	public ResponseEntity<KnjigaDTO> add(@Validated @RequestBody KnjigaDTO newArtikal) {
try {
		Knjiga persisted = knjigeService.save(toKnjiga.convert(newArtikal));

		knjigeService.save(persisted);

		return new ResponseEntity<>(toDTO.convert(persisted), HttpStatus.CREATED);}
catch (Exception e) {
	 e.printStackTrace();
	 return new ResponseEntity<>( HttpStatus.I_AM_A_TEAPOT);
	 
}
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT, consumes = "application/json")
	public ResponseEntity<KnjigaDTO> edit(@PathVariable Long id, @RequestBody KnjigaDTO editetKnjiga) {

		if (id == null || !id.equals(editetKnjiga.getId())) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}

		Knjiga kn = knjigeService.save(toKnjiga.convert(editetKnjiga));

		return new ResponseEntity<>(toDTO.convert(kn), HttpStatus.OK);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<KnjigaDTO> delete(@PathVariable Long id) {
		Knjiga ar = knjigeService.findOne(id);

		knjigeService.delete(id);

		return new ResponseEntity<>(toDTO.convert(ar), HttpStatus.NO_CONTENT);

	}

	@ExceptionHandler(value = DataIntegrityViolationException.class)
	public ResponseEntity<Void> handle() {
		return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
	}

}
