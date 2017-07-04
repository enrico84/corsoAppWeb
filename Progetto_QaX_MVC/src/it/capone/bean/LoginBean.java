package it.capone.bean;

import it.capone.dao.UtenteDAO;
import it.capone.utility.Data;

public class LoginBean {
	
	private int idutente;
	private String password;
	private String nome;
	private String email;
	private Data dataregistrazione;
	
	
	/**
	 * @return the idutente
	 */
	public int getIdutente() {
		return idutente;
	}
	
	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}
	
	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	
	/**
	 * @return the nome
	 */
	public String getNome() {
		return nome;
	}
	
	/**
	 * @param nome the nome to set
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}
	
	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	
	/**
	 * @return the dataregistrazione
	 */
	public Data getDataregistrazione() {
		return dataregistrazione;
	}
	

	/**
	 * @param dataregistrazione the dataregistrazione to set
	 */
	public void setDataregistrazione(Data dataregistrazione) {
		this.dataregistrazione = dataregistrazione;
	}
	
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "LoginBean [password=" + password + ", nome=" + nome + ", email=" + email + ", dataregistrazione="
				+ dataregistrazione + "]";
	}

	

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof LoginBean))
			return false;
		LoginBean other = (LoginBean) obj;
		if (dataregistrazione == null) {
			if (other.dataregistrazione != null)
				return false;
		} else if (!dataregistrazione.equals(other.dataregistrazione))
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		return true;
	}
	

}
