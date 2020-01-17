package jwd.knjizara.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import jwd.knjizara.model.Izdavac;
import jwd.knjizara.model.Knjiga;
import jwd.knjizara.service.IzdavacService;
import jwd.knjizara.service.KnjigaService;
import jwd.knjizara.support.IzdavacToIzdavacDTO;
import jwd.knjizara.support.KnjigaToKnjigaDTO;
import jwd.knjizara.web.dto.IzdavacDTO;
import jwd.knjizara.web.dto.KnjigaDTO;

@RestController
@RequestMapping("/api/izdavaci")
public class ApiIzdavacController {

	@Autowired
	private IzdavacService izdavaciService;

	@Autowired
	private KnjigaService knjigaService;

	@Autowired
	private IzdavacToIzdavacDTO toDTO;

	@Autowired
	private KnjigaToKnjigaDTO toDTOk;

	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<IzdavacDTO>> getActivities() {

		List<Izdavac> izdavaci = izdavaciService.findAll();

		return new ResponseEntity<>(toDTO.convert(izdavaci), HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/{id}")
	public ResponseEntity<IzdavacDTO> getOne(@PathVariable Long id) {
		Izdavac ac = izdavaciService.findOne(id);
		if (ac == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity<>(toDTO.convert(ac), HttpStatus.OK);
	}

	@RequestMapping(value = "{izdavacId}/knjige", method = RequestMethod.GET)
	public ResponseEntity<List<KnjigaDTO>> getAllId(@PathVariable Long izdavacId) {
		List<Knjiga> auto = knjigaService.findByIzdavac(izdavacId);

		return new ResponseEntity<>(toDTOk.convert(auto), HttpStatus.OK);
	}



	@ExceptionHandler(value = DataIntegrityViolationException.class)
	public ResponseEntity<Void> handle() {
		return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
	}

}
