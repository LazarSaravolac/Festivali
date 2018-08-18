package jwd.wafepa.web.dto;

public class StandDTO {
	private Long id;
	private String zakupac;
	private String povrsina;
	
	
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
}
