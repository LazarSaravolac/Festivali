package jwd.wafepa.web.dto;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

public class KnjigaDTO {

	private Long id;
	@NotBlank
	private String naziv;
	@Min(value=0)
	@Max(value=9999)
	private int izdavanje;
	private String pisac;
	@Size(max=16)
	private String isbn;
	private Integer brojGlasova;
	
	private Long izdavacId;
	private String izdavacNaziv;
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
	
	public Integer getIzdavanje() {
		return izdavanje;
	}
	public void setIzdavanje(Integer izdavanje) {
		this.izdavanje = izdavanje;
	}
	public String getPisac() {
		return pisac;
	}
	public void setPisac(String pisac) {
		this.pisac = pisac;
	}
	public String getIsbn() {
		return isbn;
	}
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	public Integer getBrojGlasova() {
		return brojGlasova;
	}
	public void setBrojGlasova(Integer brojGlasova) {
		this.brojGlasova = brojGlasova;
	}
	public Long getIzdavacId() {
		return izdavacId;
	}
	public void setIzdavacId(Long izdavacId) {
		this.izdavacId = izdavacId;
	}
	public String getIzdavacNaziv() {
		return izdavacNaziv;
	}
	public void setIzdavacNaziv(String izdavacNaziv) {
		this.izdavacNaziv = izdavacNaziv;
	}
	
}
