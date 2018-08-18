package jwd.wafepa.support;

import java.util.ArrayList;
import java.util.List;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import jwd.wafepa.model.Knjiga;
import jwd.wafepa.web.dto.KnjigaDTO;

@Component
public class KnjigaToKnjigaDTO implements Converter<Knjiga, KnjigaDTO>{

	@Override
	public KnjigaDTO convert(Knjiga knjiga) {
		// TODO Auto-generated method stub
		
		KnjigaDTO dto=new KnjigaDTO();
		dto.setBrojGlasova(knjiga.getBrojGlasova());
		dto.setId(knjiga.getId());
		dto.setIsbn(knjiga.getIsbn());
		dto.setNaziv(knjiga.getNaziv());
		dto.setPisac(knjiga.getPisac());
		dto.setIzdavanje(knjiga.getIzdavanje());
		dto.setIzdavacNaziv(knjiga.getIzdavac().getNaziv());
		dto.setIzdavacId(knjiga.getIzdavac().getId());
		return dto;
	}

	
	public List<KnjigaDTO>convert(List<Knjiga>knjige){
		List<KnjigaDTO>dto=new ArrayList<>();
		for(Knjiga a:knjige) {
			dto.add(convert(a));
		}
		return dto;
		
		
	}
}
