package jwd.wafepa.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



import jwd.wafepa.model.Glas;
import jwd.wafepa.model.Knjiga;
import jwd.wafepa.repository.GlasRepository;
import jwd.wafepa.repository.KnjigaRepository;
import jwd.wafepa.service.GlasService;

@Service
public class JpaGlasService implements GlasService {

	@Autowired
	GlasRepository glasRepository;
	
	@Autowired
	KnjigaRepository knjigaRepository;
	
	@Override
	public Glas save(Glas glas) {
		// TODO Auto-generated method stub
		return glasRepository.save(glas);
	}


	@Override
	public Glas voteForABook(Long knjigaId,Long broj) {
		if(knjigaId == null) {
			throw new IllegalArgumentException("Id of a book cannot be null!");
		}
		
		Knjiga knjiga = knjigaRepository.findOne(knjigaId);
		if(knjiga == null) {
			throw new IllegalArgumentException("There is no book with given id!");
		}
		
		Glas glas = new Glas();
		glas.setKnjiga(knjiga);
		glas.setBroj(broj);
		knjiga.setBrojGlasova(knjiga.getBrojGlasova() + (int)(long)broj);
		glasRepository.save(glas);
		knjigaRepository.save(knjiga);
		
		return glas;
	}

}
