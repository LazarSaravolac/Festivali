package jwd.wafepa.support;

import java.util.ArrayList;
import java.util.List;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import jwd.wafepa.model.Sajam;
import jwd.wafepa.web.dto.SajamDTO;

@Component
public class SajamToSajamDTO implements Converter<Sajam, SajamDTO>{

	@Override
	public SajamDTO convert(Sajam sajam) {
		// TODO Auto-generated method stub
		SajamDTO dto=new SajamDTO();
		dto.setCenaKarte(sajam.getCenaKarte());
		dto.setDatumOtvaranja(sajam.getDatumOtvaranja());
		dto.setDatumZatvaranja(sajam.getDatumZatvaranja());
		dto.setId(sajam.getId());
		dto.setNaziv(sajam.getNaziv());
		
		return dto;
	}
	
	public List<SajamDTO>convert(List<Sajam>sajmovi){
		List<SajamDTO>dto=new ArrayList<>();
		for(Sajam s:sajmovi) {
			dto.add(convert(s));
		}
		return dto;
	}

}
