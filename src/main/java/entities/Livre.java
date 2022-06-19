package entities;

import java.io.Serializable;

public class Livre implements Serializable {

	private Long id;
	private String nom;
	private int quantite;
	private String description;
	private int year;
	private String edition;
	private String langue;
	private int pages;
	private String isbn;
	
	public Livre() {
		super();
	}

	public Livre(String nom, int quantite, String description, int year, String edition, String langue, int pages,
			String isbn) {
		super();
		this.nom = nom;
		this.quantite = quantite;
		this.description = description;
		this.year = year;
		this.edition = edition;
		this.langue = langue;
		this.pages = pages;
		this.isbn = isbn;
	}

	public Livre(Long id, String nom, int quantite, String description, int year, String edition, String langue,
			int pages, String isbn) {
		super();
		this.id = id;
		this.nom = nom;
		this.quantite = quantite;
		this.description = description;
		this.year = year;
		this.edition = edition;
		this.langue = langue;
		this.pages = pages;
		this.isbn = isbn;
	}

	
	
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public int getQuantite() {
		return quantite;
	}

	public void setQuantite(int quantite) {
		this.quantite = quantite;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public String getEdition() {
		return edition;
	}

	public void setEdition(String edition) {
		this.edition = edition;
	}

	public String getLangue() {
		return langue;
	}

	public void setLangue(String langue) {
		this.langue = langue;
	}

	public int getPages() {
		return pages;
	}

	public void setPages(int pages) {
		this.pages = pages;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	@Override
	public String toString() {
		return "Livre [id=" + id + ", nom=" + nom + ", quantite=" + quantite + ", description=" + description
				+ ", year=" + year + ", edition=" + edition + ", langue=" + langue + ", pages=" + pages + ", isbn="
				+ isbn + "]";
	}
	
	
}
