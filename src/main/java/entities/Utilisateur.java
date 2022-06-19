package entities;
import java.io.Serializable;

public class Utilisateur implements Serializable {
	private Long id;
	private String nom;
	private String prenom;
	private String numero;
	private String email;
	private String mot_de_passe;
	
	
	
	public Utilisateur() {
		super();
	}
	
	
	public Utilisateur(String nom, String prenom, String numero, String email, String mot_de_passe) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.numero = numero;
		this.email = email;
		this.mot_de_passe = mot_de_passe;
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
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public String getNumero() {
		return numero;
	}
	public void setNumero(String numero) {
		this.numero = numero;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getMot_de_passe() {
		return mot_de_passe;
	}
	public void setMot_de_passe(String mot_de_passe) {
		this.mot_de_passe = mot_de_passe;
	}


	@Override
	public String toString() {
		return "Utilisateur [id=" + id + ", nom=" + nom + ", prenom=" + prenom + ", numero=" + numero + ", email="
				+ email + ", mot_de_passe=" + mot_de_passe + "]";
	}

	
}
