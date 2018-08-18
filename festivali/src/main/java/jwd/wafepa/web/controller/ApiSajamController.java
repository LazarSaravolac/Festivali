package jwd.wafepa.web.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import jwd.wafepa.model.Sajam;
import jwd.wafepa.service.SajamService;
import jwd.wafepa.service.StandService;
import jwd.wafepa.support.SajamToSajamDTO;
import jwd.wafepa.web.dto.SajamDTO;
import jwd.wafepa.web.dto.StandDTO;

@Controller
@RequestMapping(value="/api/sajmovi")
public class ApiSajamController {

	@Autowired
	SajamService sajamService;
	
	@Autowired
	private StandService standService;
	
	@Autowired
	SajamToSajamDTO toDTO;
	
	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<List<SajamDTO>> getSajmovi(@RequestParam(defaultValue="0") int page){
		List<Sajam>sajmovi;
		Page<Sajam>sajmoviPage=sajamService.findAll(page);
		sajmovi=sajmoviPage.getContent();
		
		if(sajmovi.isEmpty() || sajmovi==null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<>(toDTO.convert(sajmovi),HttpStatus.OK);
		
	}
	
	@RequestMapping(value="/{id}",method=RequestMethod.GET)
	public ResponseEntity<SajamDTO> getSajam(@PathVariable Long id){
		Sajam sajam=sajamService.findOne(id);
		
		if(sajam==null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<>(toDTO.convert(sajam),HttpStatus.OK);
		
	}
	
	
	
	@RequestMapping(value="/{sajamId}/standovi")
	public ResponseEntity<List<StandDTO>> standoviSajma
	(@PathVariable Long sajamId,@RequestParam(defaultValue="0") int pageNum)
	{
	
		
		return null;
	}
}
