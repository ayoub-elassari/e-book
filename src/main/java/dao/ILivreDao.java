package dao;

import java.util.List;

import entities.Livre;
import entities.LivresReserved;

public interface ILivreDao {
	public List<Livre> getBooks (String MotCle);
	public List<LivresReserved> getBooksReserved (Long id_user);
	public void reserverLivre(Long id_user, Long id_livre);
	public List<Livre> listReserved(Long id_user);
	public void deleteReservation(Long id_user, Long id_livre);
	public List<Livre> getRecommendations();
}
