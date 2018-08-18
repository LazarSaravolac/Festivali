package jwd.wafepa.service;

import java.util.List;

import jwd.wafepa.model.Izdavac;
import jwd.wafepa.model.Knjiga;

public interface IzdavacService {

	Izdavac findOne(Long id);
	List<Izdavac>findAll();
	Izdavac save(Izdavac izdavac);
	void delete(Long id);
//	List<Izdavac>findByKnjigaId(Long knjigaId);
	
	
}
