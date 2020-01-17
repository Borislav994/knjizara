package jwd.knjizara.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name = "tblIzdavac")
public class Izdavac {

	@Id
	@GeneratedValue
	@Column(name = "id")
	private Long id;
	@Column(name = "naziv")
	private String naziv;
	@Column(name = "adresa")
	private String adresa;
	@Column(name = "telefon")
	private String telefon;
	@OneToMany(mappedBy="izdavac", cascade=CascadeType.ALL, fetch=FetchType.LAZY)
	public List<Knjiga> knjige= new ArrayList<>();

	public Izdavac() {
		super();
	}

	
	public List<Knjiga> getKnjige() {
		return knjige;
	}


	public void setKnjige(List<Knjiga> knjige) {
		this.knjige = knjige;
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

}

