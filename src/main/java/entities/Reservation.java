package entities;

public class Reservation {
	Long id;
	Long id_user;
	Long id_livre;
	String nom_user;
	String prenom;
	String nom_livre;
	
	public Reservation() {
		super();
	}

	public Reservation(Long id_user, Long id_livre, String nom_user, String prenom, String nom_livre) {
		super();
		this.id_user = id_user;
		this.id_livre = id_livre;
		this.nom_user = nom_user;
		this.prenom = prenom;
		this.nom_livre = nom_livre;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getId_user() {
		return id_user;
	}

	public void setId_user(Long id_user) {
		this.id_user = id_user;
	}

	public Long getId_livre() {
		return id_livre;
	}

	public void setId_livre(Long id_livre) {
		this.id_livre = id_livre;
	}

	public String getNom_user() {
		return nom_user;
	}

	public void setNom_user(String nom_user) {
		this.nom_user = nom_user;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getNom_livre() {
		return nom_livre;
	}

	public void setNom_livre(String nom_livre) {
		this.nom_livre = nom_livre;
	}

	@Override
	public String toString() {
		return "Reservation [id=" + id + ", id_user=" + id_user + ", id_livre=" + id_livre + ", nom_user=" + nom_user
				+ ", prenom=" + prenom + ", nom_livre=" + nom_livre + "]";
	}
	
	

}
