package web;


import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
//import javax.websocket.Session;

import dao.AdminDaoImpl;
import dao.IAdminDao;
import dao.ILivreDao;
import dao.IUtilisateurDao;
import dao.LivreDaoImpl;
import dao.UtilisateurDaoImpl;
import entities.Livre;
import entities.LivresReserved;
import entities.Reservation;
import entities.Utilisateur;



@WebServlet(name = "servlet",urlPatterns = {"*.do"})
public class Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	IUtilisateurDao metierUtilisteurDao;
	HttpSession session;
	List<Livre> livres;
	List<LivresReserved> livresReserveds;
	ILivreDao metierLivre;
	IAdminDao metierAdmin;
 
    public Servlet() {
        super();
    }
    
    @Override
    public void init() throws ServletException {
    	super.init();
    	metierUtilisteurDao = new UtilisateurDaoImpl();
    	metierLivre = new LivreDaoImpl();
    	metierAdmin = new AdminDaoImpl();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String path = request.getServletPath();
		if(path.equals("/visiteur.do")) {
			String motCle = request.getParameter("motCle");
			if(motCle == null) {
				livres = metierLivre.getBooks("%%");
				request.setAttribute("livres", livres);
				request.getRequestDispatcher("visiteur.jsp").forward(request, response);
			}else {
				motCle = "%" + motCle + "%";
				/*System.out.println(motCle);*/
				livres = metierLivre.getBooks(motCle);
				request.setAttribute("livres", livres);
				request.getRequestDispatcher("visiteur.jsp").forward(request, response);
			}
		}else if(path.equals("/seConnecter.do")) {
			request.getRequestDispatcher("connection.jsp").forward(request, response);
		}else if (path.equals("/sInscrire.do")) {
			request.getRequestDispatcher("inscription.jsp").forward(request, response);
		}else if(path.equals("/seDeconnecter.do")) {
			if(!(session == null)){
				session.invalidate();
			}
			response.sendRedirect("/e-book/visiteur.do");
//			request.getRequestDispatcher("/visiteur.do").forward(request, response);
		} else if(path.equals("/utilisateur-livres.do")) {
			
			
			String motCle = request.getParameter("motCle");
			if(motCle == null) {
				livres = metierLivre.getBooks("%%");
				
				Utilisateur utilisateur = (Utilisateur) session.getAttribute("utilisateur");
				livresReserveds = metierLivre.getBooksReserved(utilisateur.getId());
				
				System.out.println(utilisateur.getId());
				for(LivresReserved livreRserved: livresReserveds) {
					System.out.println(livreRserved);
				}
				//System.out.println("maktb walo");
				request.setAttribute("livresReserveds", livresReserveds);
				request.setAttribute("livres", livres);
				request.getRequestDispatcher("utilisateur-livres.jsp").forward(request, response);
			}else {
				motCle = "%" + motCle + "%";   
				livres = metierLivre.getBooks(motCle);
				request.setAttribute("livres", livres);
				request.getRequestDispatcher("utilisateur-livres.jsp").forward(request, response);
			}
			
			
//			response.sendRedirect("/e-book/utilisateur-livres.do");
			//request.getRequestDispatcher("utilisateur-livres.jsp").forward(request, response);
		}else if(path.equals("/reserver.do")) {
			String string_user = request.getParameter("id_user");
			String string_livre = request.getParameter("id_livre");
			Long id_user = (long) Integer.parseInt(string_user);
			Long id_livre = (long) Integer.parseInt(string_livre);
			System.out.println(id_user);
			System.out.println(id_livre);
			metierLivre.reserverLivre(id_user, id_livre);
			response.sendRedirect("/e-book/utilisateur-livres.do");
			
		}else if(path.equals("/livresReserves.do")) {
			Utilisateur utilisateur = (Utilisateur) session.getAttribute("utilisateur");
			List<Livre> livres = metierLivre.listReserved(utilisateur.getId());
			for(Livre livre: livres) {
				System.out.println(livre);
				System.out.println(livre.getId());
			}/*had hna mzian*/
			request.setAttribute("livres", livres);/*aji hna*/
			request.getRequestDispatcher("utilisateur-livresReserves.jsp").forward(request, response);
		}else if(path.equals("/deleteReservation.do")) {
			String string_user = request.getParameter("id_user");
			Long id_user = (long) Integer.parseInt(string_user);
			String string_livre = request.getParameter("id_livre");
			Long id_livre = (long) Integer.parseInt(string_livre);
			metierLivre.deleteReservation(id_user, id_livre);
			response.sendRedirect("/e-book/livresReserves.do");
		}else if(path.equals("/proposerLivre.do")) {
			request.getRequestDispatcher("utilisateur-proposer.jsp").forward(request, response);
		}else if(path.equals("/adminAjouterLivre.do")) {
			request.getRequestDispatcher("admin-ajouter.jsp").forward(request, response);
		}else if(path.equals("/adminAjouterInfoLivre.do")) {
			String titre = request.getParameter("titre");
			String description = request.getParameter("description");
			String quantite_string = (String) request.getParameter("quantite");
			int quantite = Integer.parseInt(quantite_string);
			int year = Integer.parseInt((String)request.getParameter("year"));
			String edition = request.getParameter("edition");
			String langue =  request.getParameter("langue");
			int pages = Integer.parseInt((String) request.getParameter("pages"));
			String isbn = request.getParameter("isbn");
			String categorie = request.getParameter("categorie");
			System.out.println("categorie:" + categorie);
			String auteur = request.getParameter("auteur");
			Livre livre = new Livre();
			livre.setNom(titre);
			livre.setDescription(description);
			livre.setQuantite(quantite);
			livre.setYear(year);
			livre.setEdition(edition);
			livre.setLangue(langue);
			livre.setPages(pages);
			livre.setIsbn(isbn);
			metierAdmin.AddBook(livre, categorie, auteur);
			System.out.println("ici");//ha fin kayn lmochkil
			response.sendRedirect("/e-book/adminAjouterLivre.do");
			
		}else if(path.equals("/admin-supprimer-livre.do")) {
			List<Livre> livres = metierAdmin.getBooks();
			System.out.println(livres);
			request.setAttribute("livres", livres);
			request.getRequestDispatcher("admin-supprimer-livre.jsp").forward(request, response);
		}else if (path.equals("/supprimerLivre.do")) {
			String id_livre_string = request.getParameter("id_livre");
			Long id_livre = (long) Integer.parseInt(id_livre_string);
			metierAdmin.deleteBook(id_livre);
			response.sendRedirect("/e-book/admin-supprimer-livre.do");
		}else if(path.equals("/admin-supprimer-utilisateur.do")) {
			List<Utilisateur> utilisateurs;
			utilisateurs = metierAdmin.getUsers();
			request.setAttribute("utilisateurs", utilisateurs);
			request.getRequestDispatcher("admin-supprimer-utilisateur.jsp").forward(request, response);
		}else if(path.equals("/supprimerUtilisateur.do")) {
			String id_user_string = request.getParameter("id_user");
		    Long id_user = (long) Integer.parseInt(id_user_string);
			metierAdmin.deleteUser(id_user);
//			System.out.println(id_user_string);
//			System.out.println(id_user);
			response.sendRedirect("admin-supprimer-utilisateur.do");
		}else if(path.equals("/admin-supprimer-reservation.do")) {
			List<Reservation> reservations = metierAdmin.getReservation();
			request.setAttribute("reservations", reservations);
			System.out.println(reservations);
			request.getRequestDispatcher("admin-supprimer-reservation.jsp").forward(request, response);
		}else if(path.equals("/supprimerReservation.do")) {
			String id_string = request.getParameter("id");
			Long id = (long) Integer.parseInt(id_string);
			metierAdmin.deleteReservation(id);
			response.sendRedirect("/e-book/admin-supprimer-reservation.do");
		}else if(path.equals("/utilisateur-recommandations.do")){
			List<Livre> livres = metierLivre.getRecommendations();
			System.out.println("195" + livres);
			request.setAttribute("livres", livres);
			request.getRequestDispatcher("utilisateur-recommandations.jsp").forward(request, response);
		}else if(path.equals("/modifier-livre.do")) {
			request.getRequestDispatcher("admin-modifier.jsp").forward(request, response);
		}else if(path.equals("/adminmodifierInfoLivre.do"))	{
			String id_livre_string = request.getParameter("id_livre");
			Long id_livre = (long) Integer.parseInt(id_livre_string);
			System.out.println(id_livre);
			
			String titre = request.getParameter("titre");
			String description = request.getParameter("description");
			String quantite_string = (String) request.getParameter("quantite");
			int quantite = Integer.parseInt(quantite_string);
			int year = Integer.parseInt((String)request.getParameter("year"));
			String edition = request.getParameter("edition");
			String langue =  request.getParameter("langue");
			int pages = Integer.parseInt((String) request.getParameter("pages"));
			String isbn = request.getParameter("isbn");
			String categorie = request.getParameter("categorie");
			System.out.println("categorie:" + categorie);
			String auteur = request.getParameter("auteur");
			Livre livre = new Livre();
			livre.setNom(titre);
			livre.setDescription(description);
			livre.setQuantite(quantite);
			livre.setYear(year);
			livre.setEdition(edition);
			livre.setLangue(langue);
			livre.setPages(pages);
			livre.setIsbn(isbn);
			livre.setId(id_livre);
			metierAdmin.modifier(livre, categorie, auteur);
			System.out.println("ici");//ha fin kayn lmochkil
			response.sendRedirect("/e-book/admin-supprimer-livre.do");
			
		}
		
		
		
		
		}

	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String path = request.getServletPath();
		doGet(request, response);
		if (path.equals("/ajouterUtilisateur.do")) {
			Utilisateur utilisateur = new Utilisateur();
			utilisateur.setNom(request.getParameter("nom"));
			utilisateur.setPrenom(request.getParameter("prenom"));
			utilisateur.setEmail(request.getParameter("email"));
			utilisateur.setNumero(request.getParameter("numero"));
			utilisateur.setMot_de_passe(request.getParameter("mot_de_passe"));
			utilisateur = metierUtilisteurDao.saveUser(utilisateur);
			System.out.println(utilisateur);
			
			session = request.getSession();
			session.setAttribute("utilisateur", utilisateur);
			response.sendRedirect("/e-book/utilisateur-livres.do");
//			request.getRequestDispatcher("utilisateur-livres.jsp").forward(request, response);
		} else if(path.equals("/verifier.do")) {
			String email = request.getParameter("email");
			String mot_de_passe = request.getParameter("mot_de_passe");
			Utilisateur utilisateur = metierUtilisteurDao.getUser(email, mot_de_passe);
			Long id = utilisateur.getId();
			if(id == null) {
				response.sendRedirect("/e-book/seConnecter.do");
			}else {
				session = request.getSession();
				session.setAttribute("utilisateur", utilisateur);
				response.sendRedirect("/e-book/utilisateur-livres.do");
			}
		}else if(path.equals("/ajouterOpinion.do")) {
			Utilisateur utilisateur = (Utilisateur) session.getAttribute("utilisateur");
			Long id_user = utilisateur.getId();
			String titre = (String) request.getParameter("titre");
			String opinion = (String) request.getParameter("opinion");
			metierUtilisteurDao.addUserOpinion(id_user, titre, opinion);
			response.sendRedirect("/e-book/proposerLivre.do");
		}
	}

}
