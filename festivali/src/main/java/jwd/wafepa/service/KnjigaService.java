package jwd.wafepa.service;



import org.springframework.data.domain.Page;
import org.springframework.data.repository.query.Param;

import jwd.wafepa.model.Knjiga;

public interface KnjigaService {
	Page<Knjiga> findByKnjigaId(int pageNum, Long knjigaId);
	Knjiga findByOne(Long id);
	Page<Knjiga>findAll(int page);
	Knjiga save(Knjiga knjiga);
	void delete(Long id);
	Page<Knjiga> pretraga(
			@Param("naziv") String naziv, 
			@Param("pisac") String pisac, 
			@Param("minGlasova") Integer minGlasova,
			int page);
}
