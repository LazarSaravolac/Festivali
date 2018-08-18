package jwd.wafepa.service;


import java.util.List;

import org.springframework.data.domain.Page;

import jwd.wafepa.model.Sajam;


public interface SajamService {
	Sajam findOne(Long id);
	List<Sajam> findAll();
	void delete(Long id);
	Sajam save(Sajam sajam);
	Page<Sajam>findAll(int page);
}
