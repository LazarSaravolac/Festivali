package jwd.wafepa.web.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import jwd.wafepa.web.dto.GlasDTO;
import jwd.wafepa.model.Glas;
import jwd.wafepa.model.Knjiga;
import jwd.wafepa.model.User;
import jwd.wafepa.service.GlasService;
import jwd.wafepa.service.KnjigaService;
import jwd.wafepa.support.KnjigaDTOtoKnjiga;
import jwd.wafepa.support.KnjigaToKnjigaDTO;
import jwd.wafepa.support.KupovinaToKupovinaDTO;
import jwd.wafepa.web.dto.IzdavacDTO;
import jwd.wafepa.web.dto.KnjigaDTO;
import jwd.wafepa.web.dto.StandDTO;
import jwd.wafepa.web.dto.UserDTO;

@RestController
@RequestMapping("/api/knjige")
public class ApiKnjigaController {
	
	@Autowired
	GlasService glasService;
	
	
	@Autowired
	KnjigaService knjigaService;
	
	@Autowired
	KnjigaToKnjigaDTO toDTO;
	
	@Autowired
	KupovinaToKupovinaDTO toKupovinaDTO;
	
	@Autowired
	KnjigaDTOtoKnjiga toKnjiga;

	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<List<KnjigaDTO>> get(
			@RequestParam(required=false) String naziv,
			@RequestParam(required=false) String pisac,
			@RequestParam(required=false) Integer minGlasova,@RequestParam(defaultValue="0") int page){
		
		Page<Knjiga>knjige;
		if(naziv != null || pisac != null || minGlasova != null) {
			knjige = knjigaService.pretraga(naziv, pisac, minGlasova, page);
		}else{
			knjige = knjigaService.findAll(page);
		}
		
		HttpHeaders headers = new HttpHeaders();
		headers.add("totalPages", Integer.toString(knjige.getTotalPages()) );
		return new ResponseEntity<>(toDTO.convert(knjige.getContent()),headers,HttpStatus.OK);
	}
	
	
	@RequestMapping(value="/{id}",method=RequestMethod.GET)
	public ResponseEntity<KnjigaDTO> getKnjiga(@PathVariable Long id){
		
		Knjiga knjige=knjigaService.findByOne(id);
		
		return new ResponseEntity<>(toDTO.convert(knjige),HttpStatus.OK);
		
	}
	
//	@RequestMapping(value="/{najveci}",method=RequestMethod.GET)
//	public ResponseEntity<KnjigaDTO> getKnjigaNajveci(@PathVariable Long najveci,@RequestParam(defaultValue="0") int page){
//		Page<Knjiga>knjige=knjigaService.findAll(page);
//		Knjiga a=knjige.getContent().get(0);
//		for(int i=0;i<knjige.getSize();i++) {
//			if(a.getBrojGlasova()<knjige.getContent().get(i).getBrojGlasova()) {
//				a=knjige.getContent().get(i);
//			}
//		}
//		
//		return new ResponseEntity<>(toDTO.convert(a),HttpStatus.OK);
//		
//	}
	
	
	@RequestMapping(method=RequestMethod.POST, consumes="application/json")
	public ResponseEntity<KnjigaDTO> add ( @Validated @RequestBody  KnjigaDTO novaKnjiga){
		
		
		
		Knjiga knjiga=toKnjiga.convert(novaKnjiga);
		
		Knjiga k=knjigaService.save(knjiga);
		
		return new ResponseEntity<>(toDTO.convert(k),HttpStatus.CREATED);
	}
	
	@RequestMapping(method=RequestMethod.POST, value="/{id}/{broj}/glasanje")
	public ResponseEntity<GlasDTO> vote(@PathVariable Long id,@PathVariable Long broj){
		
		Glas g=glasService.voteForABook(id,broj);
		
		
		
		return new ResponseEntity<>(toKupovinaDTO.convert(g),HttpStatus.CREATED);
		
	}
	
	
	@RequestMapping(method=RequestMethod.PUT,
			value="/{id}",
			consumes="application/json")
	public ResponseEntity<KnjigaDTO> edit(
			@RequestBody KnjigaDTO dto,
			@PathVariable Long id){
		
		
		if(!id.equals(dto.getId())) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		
		Knjiga saved=knjigaService.save(toKnjiga.convert(dto));
		
		
		return new ResponseEntity<>(toDTO.convert(saved),HttpStatus.OK);
		
		
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.DELETE)
	ResponseEntity<Knjiga> delete(@PathVariable Long id){
		knjigaService.delete(id);
		
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
	
	
	@ExceptionHandler(value=DataIntegrityViolationException.class)
	public ResponseEntity<Void> handle() {
		return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
	}
	
	
	
	
	
	
	
}
