package jwd.wafepa.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import jwd.wafepa.model.Stand;
import jwd.wafepa.repository.StandRepository;
import jwd.wafepa.service.StandService;

@Service
public class JpaStandService implements StandService {

	@Autowired
	StandRepository standRepository;
	@Override
	public Stand findOne(Long id) {
		// TODO Auto-generated method stub
		return standRepository.findOne(id);
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		standRepository.delete(id);
	}

	@Override
	public Stand save(Stand stand) {
		// TODO Auto-generated method stub
		return standRepository.save(stand);
	}

	@Override
	public List<Stand> findAll() {
		// TODO Auto-generated method stub
		return standRepository.findAll();
	}

	@Override
	public Page<Stand> findAll(int page) {
		// TODO Auto-generated method stub
		return standRepository.findAll(new PageRequest(page,10));
	}

	@Override
	public List<Stand> findBySajam(Long sajamId) {
		// TODO Auto-generated method stub
		return standRepository.findBySajamId(sajamId);
	}

}
