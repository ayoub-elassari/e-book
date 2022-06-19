package entities;

public class LivresReserved {
	private Long id;
	private Long id_user;
	private Long id_livre;
	
	
	
	public LivresReserved() {
		super();
	}
	public LivresReserved(Long id_user, Long id_livre) {
		super();
		this.id_user = id_user;
		this.id_livre = id_livre;
	}
	public LivresReserved(Long id, Long id_user, Long id_livre) {
		super();
		this.id = id;
		this.id_user = id_user;
		this.id_livre = id_livre;
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
	@Override
	public String toString() {
		return "LivresReserved [id=" + id + ", id_user=" + id_user + ", id_livre=" + id_livre + "]";
	}
	
	
	
	
}
