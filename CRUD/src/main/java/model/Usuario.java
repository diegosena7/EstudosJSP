package model;

/**
 * User.java
 * Esta ? uma classe de modelo que representa uma entidade de usu?rio
 * @author Diego Sena
 */
public class Usuario {
	
	/** The id. */
	private int id;
	
	/** The nome. */
	private String nome;
	
	/** The email. */
	private String email;
	
	/** The pais. */
	private String pais;
	
	/**
	 * Instantiates a new usuario.
	 */
	public Usuario() {
	}
	
	/**
	 * Instantiates a new usuario.
	 * @param nome the nome
	 * @param email the email
	 * @param pais the pais
	 */
	public Usuario(String nome, String email, String pais) {
		super();
		this.nome = nome;
		this.email = email;
		this.pais = pais;
	}

	/**
	 * Instantiates a new usuario.
	 * @param id the id
	 * @param nome the nome
	 * @param email the email
	 * @param pais the pais
	 */
	public Usuario(int id, String nome, String email, String pais) {
		super();
		this.id = id;
		this.nome = nome;
		this.email = email;
		this.pais = pais;
	}

	/**
	 * Gets the id.
	 * @return the id
	 */
	public int getId() {
		return id;
	}
	
	/**
	 * Sets the id.
	 * @param id the new id
	 */
	public void setId(int id) {
		this.id = id;
	}
	
	/**
	 * Gets the nome.
	 * @return the nome
	 */
	public String getNome() {
		return nome;
	}
	
	/**
	 * Sets the name.
	 * @param nome the new name
	 */
	public void setName(String nome) {
		this.nome = nome;
	}
	
	/**
	 * Gets the email.
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}
	
	/**
	 * Sets the email.
	 * @param email the new email
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	
	/**
	 * Gets the pais.
	 * @return the pais
	 */
	public String getPais() {
		return pais;
	}
	
	/**
	 * Sets the pais.
	 * @param pais the new pais
	 */
	public void setPais(String pais) {
		this.pais = pais;
	}
}
