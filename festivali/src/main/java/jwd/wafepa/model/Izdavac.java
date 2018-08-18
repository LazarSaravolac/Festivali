package jwd.wafepa.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity

public class Izdavac {
	@Id
	@GeneratedValue
	private Long id;
	private String naziv;
	private String adresa;
	private String telefon;
	
	@OneToMany(mappedBy="izdavac")
	private List<Knjiga>knjige=new ArrayList<>();

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNaziv() {
		return naziv;
	}

	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}

	public String getAdresa() {
		return adresa;
	}

	public void setAdresa(String adresa) {
		this.adresa = adresa;
	}

	public String getTelefon() {
		return telefon;
	}

	public void setTelefon(String telefon) {
		this.telefon = telefon;
	}

	public List<Knjiga> getKnjige() {
		return knjige;
	}

	public void setKnjige(List<Knjiga> knjige) {
		this.knjige = knjige;
	}

	public Izdavac(String naziv, String adresa, String telefon, List<Knjiga> knjige) {
		super();
		this.naziv = naziv;
		this.adresa = adresa;
		this.telefon = telefon;
		this.knjige = knjige;
	}

	public Izdavac(Long id, String naziv, String adresa, String telefon, List<Knjiga> knjige) {
		super();
		this.id = id;
		this.naziv = naziv;
		this.adresa = adresa;
		this.telefon = telefon;
		this.knjige = knjige;
	}

	public Izdavac() {
		super();
	}
	
	public void addKnjiga(Knjiga knjiga) {
		this.knjige.add(knjiga);
		if(knjiga.getIzdavac()!=null && !knjiga.getIzdavac().equals(this)) {
			knjiga.setIzdavac(this);
		}
	}
}
