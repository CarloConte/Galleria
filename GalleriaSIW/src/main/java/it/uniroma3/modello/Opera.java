package it.uniroma3.modello;


import javax.persistence.*;
import javax.validation.constraints.*;


@Entity
public class Opera {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@NotNull
	@Size(min = 1)
	private String titolo;
	
	@NotNull
	@Max(2017)
	private Integer anno;
	
	@NotNull
	private String tecnica;
	
	@NotNull
	@Size(min=1)
	private String dimensioni;
	
	@ManyToOne
	private Autore autore;
	
	private String imgUrl;
	
	public Opera() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitolo() {
		return titolo;
	}

	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}

	public Integer getAnno() {
		return anno;
	}

	public void setAnno(Integer anno) {
		this.anno = anno;
	}

	public String getTecnica() {
		return tecnica;
	}

	public void setTecnica(String tecnica) {
		this.tecnica = tecnica;
	}

	public String getDimensioni() {
		return dimensioni;
	}

	public void setDimensioni(String dimensioni) {
		this.dimensioni = dimensioni;
	}

	public Autore getAutore() {
		return autore;
	}

	public void setAutore(Autore autore) {
		this.autore = autore;
	}

	public String getImgUrl() {
		return imgUrl;
	}

	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}
	
	
	
//	@Override
//	public boolean equals(Object o) {
//		Opera that = (Opera)o;
//		return this.getId().equals(that.getId());
//	}
//	
//	@Override
//	public int hashCode() {
//		return this.getId().hashCode()+this.getClass().hashCode();
//	}
}
