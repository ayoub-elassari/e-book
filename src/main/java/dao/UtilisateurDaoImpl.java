package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import entities.Utilisateur;

public class UtilisateurDaoImpl implements IUtilisateurDao{

	@Override
	public Utilisateur saveUser(Utilisateur utilisateur) {
		Connection connection = SingletonConnection.getConnection();
		try {
			PreparedStatement ps = connection.prepareStatement
					("INSERT INTO USER (NOM, PRENOM, NUMERO, EMAIL, MOT_DE_PASSE) VALUES(?,?,?,?,?)");
			ps.setString(1, utilisateur.getNom());
			ps.setString(2, utilisateur.getPrenom());
			ps.setString(3, utilisateur.getNumero());
			ps.setString(4, utilisateur.getEmail());
			ps.setString(5, utilisateur.getMot_de_passe());
			ps.executeUpdate();
			PreparedStatement ps2 = connection.prepareStatement
					("SELECT MAX(ID) AS MAXID FROM USER");
			ResultSet rs = ps2.executeQuery();
			if(rs.next()) {
				utilisateur.setId(rs.getLong("MAXID"));
				System.out.println(utilisateur.getId());
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return utilisateur;
	}

	@Override
	public Utilisateur getUser(String email, String mot_de_passe) {
		Utilisateur utilisateur = new Utilisateur();
		Connection connection = SingletonConnection.getConnection();
		try {
			PreparedStatement ps = connection.prepareStatement
					("SELECT * FROM USER WHERE EMAIL = ? AND MOT_DE_PASSE = ?");
			ps.setString(1, email);
			ps.setString(2, mot_de_passe);
			ResultSet rs=ps.executeQuery();
			if(rs.next()){
				utilisateur.setId(rs.getLong("ID"));
				utilisateur.setNom(rs.getString("NOM"));
				utilisateur.setPrenom(rs.getNString("PRENOM"));
				utilisateur.setEmail(rs.getNString("EMAIL"));
				utilisateur.setMot_de_passe(rs.getString("MOT_DE_PASSE"));
				utilisateur.setNumero(rs.getString("NUMERO"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return utilisateur;
	}

	@Override
	public void addUserOpinion(Long id_user, String titre, String opinion) {
		Connection connection = SingletonConnection.getConnection();
		try {
			PreparedStatement ps = connection.prepareStatement
					("INSERT INTO PROPOSITION (ID_USER, TITRE, OPINION) VALUES (?, ?, ?)");
			ps.setLong(1, id_user);
			ps.setString(2, titre);
			ps.setString(3, opinion);
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
