package jwd.wafepa.service;

import java.util.List;

import org.springframework.data.domain.Page;

import jwd.wafepa.model.Stand;

public interface StandService {
	Stand findOne(Long id);
	void delete(Long id);
	Stand save(Stand stand);
	List<Stand>findAll();
	Page<Stand>findAll(int page);
	List<Stand> findBySajam(Long sajamId);
}
