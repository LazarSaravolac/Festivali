package jwd.wafepa.support;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import jwd.wafepa.model.Izdavac;
import jwd.wafepa.service.IzdavacService;
import jwd.wafepa.web.dto.IzdavacDTO;

@Component
public class IzdavacDTOtoIzdavac implements Converter<IzdavacDTO, Izdavac> {

	@Autowired
	IzdavacService izdavacService;
	
	@Override
	public Izdavac convert(IzdavacDTO dto) {
		// TODO Auto-generated method stub
		Izdavac izdavac=new Izdavac();
		if(dto.getId()!=null) {
			izdavac=izdavacService.findOne(dto.getId());
			if(izdavac==null) {
				throw new IllegalStateException("greska izdavacDTO");
			}
		}
		
		izdavac.setAdresa(dto.getAdresa());
		izdavac.setId(dto.getId());
		izdavac.setNaziv(dto.getNaziv());
		izdavac.setTelefon(dto.getTelefon());
		
		return izdavac;
	}
	
	public List<Izdavac>convert(List<IzdavacDTO>dto){
		List<Izdavac>izdavaci=new ArrayList<>();
		for(IzdavacDTO a:dto) {
			izdavaci.add(convert(a));
		}
		return izdavaci;
	}

}
