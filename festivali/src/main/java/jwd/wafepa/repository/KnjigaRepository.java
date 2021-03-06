package jwd.wafepa.repository;


import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import jwd.wafepa.model.Knjiga;

@Repository
public interface KnjigaRepository  extends PagingAndSortingRepository<Knjiga, Long>{

	Page<Knjiga>findByIzdavacId(Long izdavacId, Pageable pageRequest);
	
	@Query("SELECT k FROM Knjiga k WHERE "
	+ "(:naziv IS NULL or k.naziv like :naziv ) AND "
	+ "(:pisac IS NULL OR k.pisac like :pisac  ) AND "
	+ "(:minGlasova IS NULL OR k.brojGlasova  >= :minGlasova)"
	)
Page<Knjiga> pretraga(
	@Param("naziv") String naziv, 
	@Param("pisac") String pisac, 
	@Param("minGlasova") Integer minGlasova,
	Pageable pageRequest);
}
