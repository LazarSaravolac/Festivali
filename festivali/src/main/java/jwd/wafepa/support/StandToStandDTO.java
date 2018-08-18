package jwd.wafepa.support;

import java.util.ArrayList;
import java.util.List;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import jwd.wafepa.model.Stand;
import jwd.wafepa.web.dto.StandDTO;

@Component
public class StandToStandDTO implements Converter<Stand, StandDTO> {

	@Override
	public StandDTO convert(Stand stand) {
		StandDTO dto=new StandDTO();
		dto.setId(stand.getId());
		dto.setPovrsina(stand.getPovrsina());
		dto.setZakupac(stand.getZakupac());
		
		return dto;
	}
	
	public List<StandDTO>convert(List<Stand>standovi){
		List<StandDTO>dto=new ArrayList<>();
		for(Stand s:standovi) {
			dto.add(convert(s));
		}
		return dto;
	}

}
