package jwd.wafepa.web.dto;

public class SajamDTO {

	private Long id;
	private String naziv;
	private String datumOtvaranja;
	private String datumZatvaranja;
	private double cenaKarte;
	
	
	
	
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
	
	
}
