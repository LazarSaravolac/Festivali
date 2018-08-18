package jwd.wafepa.support;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import jwd.wafepa.model.Knjiga;
import jwd.wafepa.service.IzdavacService;
import jwd.wafepa.service.KnjigaService;
import jwd.wafepa.web.dto.KnjigaDTO;

@Component
public class KnjigaDTOtoKnjiga implements Converter<KnjigaDTO, Knjiga> {

	@Autowired
	KnjigaService knjigaService;
	
	@Autowired
	private IzdavacService izdavacService;
	@Override
	public Knjiga convert(KnjigaDTO dto) {
		// TODO Auto-generated method stub
		Knjiga knjiga;
		
		if(dto.getId()==null) {
			knjiga=new Knjiga();
			knjiga.setIzdavac(izdavacService.findOne(dto.getIzdavacId()));
		}else {
			knjiga=knjigaService.findByOne(dto.getId());
		}
		
		knjiga.setBrojGlasova(dto.getBrojGlasova());
		knjiga.setId(dto.getId());
		knjiga.setIsbn(dto.getIsbn());
		knjiga.setNaziv(dto.getNaziv());
		knjiga.setPisac(dto.getPisac());
		knjiga.setIzdavanje(dto.getIzdavanje());
		return knjiga;
	}

	public List<Knjiga>convert(List<KnjigaDTO> dto){
		List<Knjiga>knjige=new ArrayList<>();
		for(KnjigaDTO a:dto) {
			knjige.add(convert(a));		
			}
		return knjige;
		
	}
	
}
