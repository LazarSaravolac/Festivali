package jwd.wafepa.model;
import javax.persistence.*;


@Entity
public class Stand {
	@Id
	@GeneratedValue
	@Column
	private Long id;
	@Column
	private String zakupac;
	@Column
	private String povrsina;
	@ManyToOne(fetch=FetchType.EAGER)
	private Sajam sajam;
	
	
	public Stand() {
		super();
	}
	public Stand(String zakupac, String povrsina, Sajam sajam) {
		super();
		this.zakupac = zakupac;
		this.povrsina = povrsina;
		this.sajam = sajam;
	}
	public Stand(Long id, String zakupac, String povrsina, Sajam sajam) {
		super();
		this.id = id;
		this.zakupac = zakupac;
		this.povrsina = povrsina;
		this.sajam = sajam;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getZakupac() {
		return zakupac;
	}
	public void setZakupac(String zakupac) {
		this.zakupac = zakupac;
	}
	public String getPovrsina() {
		return povrsina;
	}
	public void setPovrsina(String povrsina) {
		this.povrsina = povrsina;
	}
	public Sajam getSajam() {
		return sajam;
	}
	public void setSajam(Sajam sajam) {
		this.sajam = sajam;
		if (!sajam.getStandovi().contains(this)) {
			sajam.getStandovi().add(this);
		}
	}
	
	
}
