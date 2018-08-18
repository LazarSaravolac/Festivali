package jwd.wafepa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import jwd.wafepa.model.Sajam;
import jwd.wafepa.model.Stand;

@Repository
public interface StandRepository extends JpaRepository<Stand, Long> {
	List<Stand>findBySajamId(Long sajamId);
	
	List<Stand>findBySajam(Sajam sajam);
	
}
