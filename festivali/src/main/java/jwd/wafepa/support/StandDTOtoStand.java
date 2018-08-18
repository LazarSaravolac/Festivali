package jwd.wafepa.support;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import jwd.wafepa.model.Stand;
import jwd.wafepa.service.StandService;
import jwd.wafepa.web.dto.StandDTO;

@Component
public class StandDTOtoStand implements Converter<StandDTO, Stand> {

	@Autowired
	StandService standService;
	
	@Override
	public Stand convert(StandDTO dto) {
		Stand stand=new Stand();
		if(dto.getId()!=null) {
			stand=standService.findOne(dto.getId());
		}
		if(stand==null) {
			throw new IllegalStateException("Tried to "
					+ "modify non-existant stand");
		}
		stand.setId(dto.getId());
		stand.setPovrsina(dto.getPovrsina());
		stand.setZakupac(dto.getZakupac());
		
		return stand;
	}

	public List<Stand> convert(List<StandDTO>dto){
		List<Stand>standovi=new ArrayList<>();
		for(StandDTO e:dto) {
			standovi.add(convert(e));
		}
		return standovi;
		
	}
}
