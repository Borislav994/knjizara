package jwd.knjizara.web.dto;


public class KnjigaDTO {

	private Long id;
	private String naziv;
	private String izdanje;
	private String pisac;
	private String ISBN;
	private Integer brGlasova;
	private Long izdavacId;
	private String izdavacNaziv;

	public KnjigaDTO() {
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
