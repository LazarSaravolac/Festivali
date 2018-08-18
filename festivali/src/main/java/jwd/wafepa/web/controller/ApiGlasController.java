package jwd.wafepa.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import jwd.wafepa.model.Glas;
import jwd.wafepa.service.GlasService;

@Controller
@RequestMapping("/api/glas")
public class ApiGlasController {

	@Autowired
	GlasService glasService;
	
	@RequestMapping(
			method=RequestMethod.POST,
			consumes="application/json")
	public ResponseEntity<Glas> add(
			@RequestBody Glas novGlas){
		
		glasService.save(novGlas);
		
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	
	
	
}
