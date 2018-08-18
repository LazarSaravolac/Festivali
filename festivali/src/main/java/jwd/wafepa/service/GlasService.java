package jwd.wafepa.service;

import jwd.wafepa.model.Glas;

public interface GlasService {

	Glas save(Glas glas);
	Glas voteForABook(Long id,Long broj);
}
