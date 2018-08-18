package jwd.wafepa.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

@Entity
public class Sajam {
	@Id
	@GeneratedValue
	@Column
	private Long id;
	@Column
	private String naziv;
	@Column
	private String datumOtvaranja;
	@Column
	private String datumZatvaranja;
	@Column
	private double cenaKarte;
	@OneToMany(mappedBy="sajam")
	private List<Stand>standovi=new ArrayList<>();
	
	
	
	
	public Sajam() {
		super();
	}
	public Sajam(String naziv, String datumOtvaranja, String datumZatvaranja, double cenaKarte, List<Stand> standovi) {
		super();
		this.naziv = naziv;
		this.datumOtvaranja = datumOtvaranja;
		this.datumZatvaranja = datumZatvaranja;
		this.cenaKarte = cenaKarte;
		this.standovi = standovi;
	}
	public Sajam(Long id, String naziv, String datumOtvaranja, String datumZatvaranja, double cenaKarte,
			List<Stand> standovi) {
		super();
		this.id = id;
		this.naziv = naziv;
		this.datumOtvaranja = datumOtvaranja;
		this.datumZatvaranja = datumZatvaranja;
		this.cenaKarte = cenaKarte;
		this.standovi = standovi;
	}
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
	public String getDatumOtvaranja() {
		return datumOtvaranja;
	}
	public void setDatumOtvaranja(String datumOtvaranja) {
		this.datumOtvaranja = datumOtvaranja;
	}
	public String getDatumZatvaranja() {
		return datumZatvaranja;
	}
	public void setDatumZatvaranja(String datumZatvaranja) {
		this.datumZatvaranja = datumZatvaranja;
	}
	public double getCenaKarte() {
		return cenaKarte;
	}
	public void setCenaKarte(double cenaKarte) {
		this.cenaKarte = cenaKarte;
	}
	public List<Stand> getStandovi() {
		return standovi;
	}
	public void setStandovi(List<Stand> standovi) {
		this.standovi = standovi;
	}
	
	public void addStandovi(Stand stand) {
		this.standovi.add(stand);
		if(stand.getSajam()!=null && !stand.getSajam().equals(this)) {
			stand.setSajam(this);
		}
	}
	
}
