package jwd.wafepa.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import jwd.wafepa.model.Stand;
import jwd.wafepa.service.StandService;
import jwd.wafepa.support.StandDTOtoStand;
import jwd.wafepa.support.StandToStandDTO;
import jwd.wafepa.web.dto.StandDTO;

@Controller
@RequestMapping(value="/api/standovi")
public class ApiStandController {

	@Autowired
	StandService standService;
	
	@Autowired
	StandToStandDTO toDTO;
	
	@Autowired
	StandDTOtoStand toStand;
	
	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<List<StandDTO>> getStandovi(@RequestParam(defaultValue="0") int page){
		List<Stand>standovi;
		Page<Stand>standoviPage=standService.findAll(page);
		standovi=standoviPage.getContent();
		
		if(standovi==null || standovi.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		
		return new ResponseEntity<>(toDTO.convert(standovi),HttpStatus.OK);
	}
	
	@RequestMapping(value="/{id}",method=RequestMethod.GET)
	public ResponseEntity<StandDTO> getStand(@PathVariable Long id){
		Stand stand=standService.findOne(id);
		if(stand==null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<>(toDTO.convert(stand),HttpStatus.OK);
	}
	

	@RequestMapping(method=RequestMethod.POST, consumes="application/json")
	public ResponseEntity<StandDTO> add (@RequestBody StandDTO newStand){
		
		if(newStand==null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		Stand stand=standService.save(toStand.convert(newStand));
		
		return new ResponseEntity<>(toDTO.convert(stand),HttpStatus.CREATED);
		
		
		
	}
	
	@RequestMapping(method=RequestMethod.PUT, value="/{id}", consumes="application/json")
	public ResponseEntity<StandDTO> edit (@RequestBody StandDTO stand,@PathVariable Long id){
		
		if(!stand.getId().equals(id))
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		
		Stand stand1=standService.save(toStand.convert(stand));
		
		
		return new ResponseEntity<>(toDTO.convert(stand1),HttpStatus.OK);
	}
	
	
	@RequestMapping(value="/{id}", method=RequestMethod.DELETE)
	public ResponseEntity<Stand> delete(@PathVariable Long id){
		
		standService.delete(id);
		
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
}
