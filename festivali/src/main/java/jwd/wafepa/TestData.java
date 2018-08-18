package jwd.wafepa;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import jwd.wafepa.model.Activity;
import jwd.wafepa.model.Address;
import jwd.wafepa.model.Izdavac;
import jwd.wafepa.model.Knjiga;
import jwd.wafepa.model.Sajam;
import jwd.wafepa.model.Stand;
import jwd.wafepa.model.User;
import jwd.wafepa.service.ActivityService;
import jwd.wafepa.service.AddressService;
import jwd.wafepa.service.IzdavacService;
import jwd.wafepa.service.KnjigaService;
import jwd.wafepa.service.SajamService;
import jwd.wafepa.service.StandService;
import jwd.wafepa.service.UserService;

@Component
public class TestData {

	@Autowired
	private ActivityService activityService;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private AddressService addressService;
	
	@Autowired
	private SajamService sajamService;
	
	@Autowired
	private StandService standService;
	
	@Autowired
	private IzdavacService izdavacService;
	
	@Autowired
	private KnjigaService knjigeService;
	
//	@PostConstruct
	public void init() {
		activityService.save(new Activity("Swimming"));
		activityService.save(new Activity("Running"));
		
		//pravimo 5 korisnika
		for (int i = 1; i <= 50; i++) {
			User user = new User();
			user.setFirstName("First name " + i);
			user.setLastName("Last name " + i);
			user.setEmail("email" + i + "@example.com");
			user.setPassword("123");
			userService.save(user);

			//za svakog korisnika pravimo po 3 adrese
			for (int j = 1; j <= 3; j++) {
				Address address = new Address();
				address.setNumber(Integer.toString(j));
				address.setStreat("Laze nancica");
				user.addAddress(address);
				userService.save(user);
				addressService.save(address);

			}
		}
	}
	
	@PostConstruct
	public void inicijalizacija() {
		for (int i = 1; i <= 10; i++) {
			Sajam sajam=new Sajam();
			sajam.setNaziv("Name" + i);
			sajam.setDatumOtvaranja("10-06-2018");
			sajam.setDatumZatvaranja("15-06-2018");
			sajam.setCenaKarte(250);
			sajamService.save(sajam);
			
			for(int j=1;j<=3;j++) {
				Stand stand = new Stand();
				stand.setZakupac("Zakupac" + i);
				stand.setPovrsina("30");
				stand.setSajam(sajam);
				standService.save(stand);
				sajam.addStandovi(stand);
				sajamService.save(sajam);
			}
	}
		
		Izdavac izdavac=new Izdavac();
		izdavac.setAdresa("Rudjera");
		izdavac.setNaziv("Lazar");
		izdavac.setTelefon("06212321");
		izdavacService.save(izdavac);
		
		Knjiga knjiga=new Knjiga();
		knjiga.setBrojGlasova(4);
		knjiga.setIzdavanje(132);
		knjiga.setIsbn("1231-1");
		knjiga.setNaziv("za kim zvona zvone");
		knjiga.setPisac("Hemingvej");
		knjiga.setIzdavac(izdavac);
		knjigeService.save(knjiga);
		izdavac.addKnjiga(knjiga);
		izdavacService.save(izdavac);
	}
	

	
	
}