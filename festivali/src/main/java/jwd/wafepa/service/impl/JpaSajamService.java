package jwd.wafepa.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import jwd.wafepa.model.Sajam;
import jwd.wafepa.repository.SajamRepository;
import jwd.wafepa.service.SajamService;

@Service
public class JpaSajamService implements SajamService{

	@Autowired
	SajamRepository sajamRepository;
	
	@Override
	public Sajam findOne(Long id) {
		// TODO Auto-generated method stub
		return sajamRepository.findOne(id);
	}

	@Override
	public List<Sajam> findAll() {
		// TODO Auto-generated method stub
		return sajamRepository.findAll();
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		sajamRepository.delete(id);
	}

	@Override
	public Sajam save(Sajam sajam) {
		// TODO Auto-generated method stub
		return sajamRepository.save(sajam);
	}

	@Override
	public Page<Sajam> findAll(int page) {
		// TODO Auto-generated method stub
		return sajamRepository.findAll(new PageRequest(page,10));
	}

}
