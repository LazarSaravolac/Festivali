package jwd.wafepa.support;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import jwd.wafepa.model.Sajam;
import jwd.wafepa.service.SajamService;
import jwd.wafepa.web.dto.SajamDTO;

@Component
public class SajamDTOtoSajam implements Converter<SajamDTO, Sajam> {
	
	@Autowired
	SajamService sajamService;
	
	@Override
	public Sajam convert(SajamDTO dto) {
		// TODO Auto-generated method stub
		Sajam sajam=new Sajam();
		if(dto.getId()!=null) {
			sajam=sajamService.findOne(dto.getId());
		}
		if(sajam==null) {
			throw new IllegalStateException("Tried to "
					+ "modify non-existant stand");
		}
		
		sajam.setCenaKarte(dto.getCenaKarte());
		sajam.setDatumOtvaranja(dto.getDatumOtvaranja());
		sajam.setDatumZatvaranja(dto.getDatumZatvaranja());
		sajam.setNaziv(dto.getNaziv());
		sajam.setId(dto.getId());
		return sajam;
	}
	
	public List<Sajam> convert(List<SajamDTO>dto){
		List<Sajam>sajmovi=new ArrayList<>();
		for(SajamDTO s:dto) {
			sajmovi.add(convert(s));
		}
		return sajmovi;
	}

}
