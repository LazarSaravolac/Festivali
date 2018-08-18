package jwd.wafepa.web.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import jwd.wafepa.model.Izdavac;
import jwd.wafepa.model.Knjiga;
import jwd.wafepa.repository.IzdavacRepository;
import jwd.wafepa.service.IzdavacService;
import jwd.wafepa.service.KnjigaService;
import jwd.wafepa.support.IzdavacToIzdavacDTO;
import jwd.wafepa.support.KnjigaToKnjigaDTO;
import jwd.wafepa.web.dto.IzdavacDTO;
import jwd.wafepa.web.dto.KnjigaDTO;
import jwd.wafepa.web.dto.StandDTO;

@RestController
@RequestMapping("/api/izdavaci")
public class ApiIzdavacController {

	@Autowired
	IzdavacService izdavacService;
	
	@Autowired
	IzdavacToIzdavacDTO toDTO;
	
	@Autowired
	KnjigaToKnjigaDTO toDTOKnjiga;
	
	@Autowired
	KnjigaService knjigeService;
	
	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<List<IzdavacDTO>> get(){
		
		List<Izdavac>izdavaci=izdavacService.findAll();
		
		
		return new ResponseEntity<>(toDTO.convert(izdavaci),HttpStatus.OK);
	}
	
	
	@RequestMapping(value="/{id}",method=RequestMethod.GET)
	public ResponseEntity<IzdavacDTO> getIzdavac(@PathVariable Long id){
		
		Izdavac izdavac=izdavacService.findOne(id);
		
		return new ResponseEntity<>(toDTO.convert(izdavac),HttpStatus.OK);
		
	}
	
	@RequestMapping(value="/{izdavacId}/knjige")
	public ResponseEntity<List<KnjigaDTO>> izdavaciKnjige
			(@PathVariable Long izdavacId,@RequestParam(defaultValue="0") int pageNum){
		
			Page<Knjiga>knjige=knjigeService.findByKnjigaId(pageNum, izdavacId);
			
			return new ResponseEntity<>(toDTOKnjiga.convert(knjige.getContent()),HttpStatus.OK);
			
			
	}
	
	
}
