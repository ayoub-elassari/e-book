package dao;

import java.util.List;

import entities.Utilisateur;

public interface IUtilisateurDao {
	public Utilisateur saveUser(Utilisateur utilisateur);
	public Utilisateur getUser(String email, String mot_de_passe);
	public void addUserOpinion(Long id_user, String titre, String opinion);
}
