package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entities.Livre;
import entities.LivresReserved;

public class LivreDaoImpl implements ILivreDao {

	@Override
	public List<Livre> getBooks(String motCle) {
		List<Livre> livres = new ArrayList<Livre>();
		Connection connection = SingletonConnection.getConnection();
		try {
			PreparedStatement ps = connection.prepareStatement
					("SELECT * FROM LIVRE WHERE NOM LIKE ?");
			ps.setString(1, motCle);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				Livre livre = new Livre();
				livre.setId(rs.getLong("ID"));
				livre.setNom(rs.getString("NOM"));
				livre.setQuantite(rs.getInt("QUANTITE"));
				livre.setDescription(rs.getString("DESCRIPTION"));
				livre.setYear(rs.getInt("YEAR"));
				livre.setEdition(rs.getString("EDITION"));
				livre.setLangue(rs.getNString("LANGUE"));
				livre.setPages(rs.getInt("PAGES"));
				livre.setIsbn(rs.getString("ISBN"));
				livres.add(livre);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return livres;
	}

	@Override
	public List<LivresReserved> getBooksReserved(Long id_user) {
		List<LivresReserved> livresReserved = new ArrayList<LivresReserved>();
		Connection connection = SingletonConnection.getConnection();
		try {
			PreparedStatement ps = connection.prepareStatement
					("SELECT * FROM RESERVATION WHERE id_user LIKE ?");
			ps.setLong(1, id_user);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				LivresReserved livreReserved = new LivresReserved();
				livreReserved.setId(rs.getLong("ID"));
				livreReserved.setId_user(rs.getLong("ID_USER"));
				livreReserved.setId_livre(rs.getLong("ID_Livre"));
				livresReserved.add(livreReserved);
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return livresReserved;
	}

	@Override
	public void reserverLivre(Long id_user, Long id_livre) {
		Connection connection =  SingletonConnection.getConnection();
		try {
			
			PreparedStatement ps = connection.prepareStatement
					("SELECT * FROM RESERVATION");
			boolean statu = true;
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				Long table_user_id = rs.getLong("ID_USER");
				Long tabble_livre_id = rs.getLong("ID_LIVRE");
				if(table_user_id == id_user && tabble_livre_id == id_livre) {
					statu = false;
				}
			}
			if(statu == true) {
				PreparedStatement ps2 = connection.prepareStatement
						("INSERT INTO RESERVATION (ID_USER, ID_LIVRE) VALUES (?, ?)");
				ps2.setLong(1, id_user);
				ps2.setLong(2, id_livre);
				ps2.executeUpdate();
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public List<Livre> listReserved(Long id_user) {
		List<Livre> livres = new ArrayList<Livre>();
		Connection connection = SingletonConnection.getConnection();
		try {
			PreparedStatement ps = connection.prepareStatement
					("SELECT livre.id, livre.nom, quantite, description, year, edition, langue, pages, isbn "
							+ "FROM reservation JOIN livre JOIN user "
							+ "ON reservation.id_user=user.id AND reservation.id_livre=livre.id WHERE user.id = ?");
			ps.setLong(1, id_user);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				Livre livre = new Livre();
				livre.setId(rs.getLong("ID"));
				livre.setNom(rs.getString("NOM"));
				livre.setQuantite(rs.getInt("QUANTITE"));
				livre.setDescription(rs.getString("DESCRIPTION"));
				livre.setYear(rs.getInt("YEAR"));
				livre.setEdition(rs.getString("EDITION"));
				livre.setLangue(rs.getString("LANGUE"));
				livre.setPages(rs.getInt("PAGES"));
				livre.setIsbn(rs.getString("ISBN"));
				livres.add(livre);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return livres;
	}

	@Override
	public void deleteReservation(Long id_user, Long id_livre) {
		Connection connection = SingletonConnection.getConnection();
		try {
			PreparedStatement ps = connection.prepareStatement
					("DELETE FROM RESERVATION WHERE id_user = ? and id_livre = ?");
			ps.setLong(1, id_user);
			ps.setLong(2, id_livre);
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public List<Livre> getRecommendations() {
		List<Livre> livres = new ArrayList<Livre>();
		Connection connection = SingletonConnection.getConnection();
		try {
			PreparedStatement ps = connection.prepareStatement
					("SELECT id_livre, COUNT(id_livre) as nbrReservation from reservation GROUP BY id_livre ASC LIMIT 3;");
			ResultSet rs = ps.executeQuery();
			Long id1=0L, id2=0L, id3=0L;
			if(rs.next()) {
				id1 = rs.getLong("ID_LIVRE");
			}
			if(rs.next()) {
				id2 = rs.getLong("ID_LIVRE");
			}
			if(rs.next()) {
				id3 = rs.getLong("ID_LIVRE");
			}
			
			PreparedStatement ps2 = connection.prepareStatement
					("SELECT * FROM livre WHERE id = ? or id = ? or id = ?");
			ps2.setLong(1, id1);
			ps2.setLong(2, id2);
			ps2.setLong(3, id3);
			ResultSet rs2 = ps2.executeQuery();
			while(rs2.next()) {
				Livre livre = new Livre();
				livre.setId(rs2.getLong("ID"));
				livre.setNom(rs2.getString("NOM"));
				livre.setQuantite(rs2.getInt("QUANTITE"));
				livre.setDescription(rs2.getString("DESCRIPTION"));
				livre.setYear(rs2.getInt("YEAR"));
				livre.setEdition(rs2.getString("EDITION"));
				livre.setLangue(rs2.getString("LANGUE"));
				livre.setPages(rs2.getInt("PAGES"));
				livre.setIsbn(rs2.getString("ISBN"));
				livres.add(livre);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(livres);
		return livres;
	}

}
