package jwd.wafepa.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;



@Entity
@Table(name="knjigee")
public class Knjiga {
	@Id
	@GeneratedValue
	private Long id;
	@Column(nullable=false)
	private String naziv;
	@Column(nullable=false)
	private Integer izdavanje;
	
	public List<Glas> getGlasovi() {
		return glasovi;
	}

	public void setGlasovi(List<Glas> glasovi) {
		this.glasovi = glasovi;
	}

	@OneToMany(mappedBy="knjiga",fetch=FetchType.LAZY,cascade=CascadeType.ALL)
	private List<Glas> glasovi = new ArrayList<>();
	
	
	public Integer getIzdavanje() {
		return izdavanje;
	}

	public void setIzdavanje(Integer izdavanje) {
		this.izdavanje = izdavanje;
	}

	@Column(nullable=false)
	private String pisac;
	@Column(nullable=false,unique=true)
	private String isbn;
	private Integer brojGlasova;
	
	@ManyToOne(fetch=FetchType.EAGER)
	Izdavac izdavac;

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

	public Izdavac getIzdavac() {
		return izdavac;
	}

	public void setIzdavac(Izdavac izdavac) {
		this.izdavac = izdavac;
	}

	public Knjiga(String naziv, String pisac, String isbn, int brojGlasova, Izdavac izdavac) {
		super();
		this.naziv = naziv;
		this.pisac = pisac;
		this.isbn = isbn;
		this.brojGlasova = brojGlasova;
		this.izdavac = izdavac;
	}

	public Knjiga(Long id, String naziv, String pisac, String isbn, int brojGlasova, Izdavac izdavac) {
		super();
		this.id = id;
		this.naziv = naziv;
		this.pisac = pisac;
		this.isbn = isbn;
		this.brojGlasova = brojGlasova;
		this.izdavac = izdavac;
	}

	public Knjiga() {
		super();
	}
	
	
}
