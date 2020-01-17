package jwd.knjizara.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "tblKnjiga")
public class Knjiga {

	@Id
	@GeneratedValue
	@Column(name = "id")
	private Long id;
	@Column(name = "naziv",nullable=false)
	private String naziv;
	@Column(name = "izdanje",nullable=false)
	private String izdanje;
	@Column(name = "pisac",nullable=false)
	private String pisac;
	@Column(name = "ISBN",nullable=false, unique=true)
	private String ISBN;
	@Column(name = "brGlasova")
	private Integer brGlasova;
	@ManyToOne(fetch = FetchType.EAGER)
	private Izdavac izdavac;

	public Knjiga() {
		super();
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

	public String getIzdanje() {
		return izdanje;
	}

	public void setIzdanje(String izdanje) {
		this.izdanje = izdanje;
	}

	public String getPisac() {
		return pisac;
	}

	public void setPisac(String pisac) {
		this.pisac = pisac;
	}

	public String getISBN() {
		return ISBN;
	}

	public void setISBN(String iSBN) {
		ISBN = iSBN;
	}

	public Integer getBrGlasova() {
		return brGlasova;
	}

	public void setBrGlasova(Integer brGlasova) {
		this.brGlasova = brGlasova;
	}

	public Izdavac getIzdavac() {
		return izdavac;
	}

	public void setIzdavac(Izdavac izdavac) {
		this.izdavac = izdavac;
		if (!izdavac.getKnjige().contains(this)) {
			izdavac.getKnjige().add(this);
		}
	}

}