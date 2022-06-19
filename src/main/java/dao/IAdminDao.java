package dao;

import java.util.List;

import entities.Livre;
import entities.Reservation;
import entities.Utilisateur;

public interface IAdminDao {
	public void AddBook(Livre livre, String categorie, String auteur );
	public List<Livre> getBooks();
	public void deleteBook(Long id_livre);
	public List<Utilisateur> getUsers();
	public void deleteUser(Long id_user);
	public List<Reservation> getReservation();
	public void deleteReservation(Long id);
	public void modifier(Livre livre, String categorie, String auteur);
	
}
