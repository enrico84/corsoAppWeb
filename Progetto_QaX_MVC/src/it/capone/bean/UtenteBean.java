package it.capone.bean;

import it.capone.utility.Data;

public class UtenteBean {
	
	private int idutente;
	private String password;
	private String nome;
	private String email;
	private Data dataregistrazione;
	
	public UtenteBean() {
		
	}
	
	public UtenteBean(int id, String pass, String nome, String email, Data dataReg) {
		this.idutente=id;
		this.password=pass;
		this.nome=nome;
		this.email=email;
		this.dataregistrazione=dataReg;
	}

	public int getIdutente() {
		return idutente;
	}


	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Data getDataregistrazione() {
		return dataregistrazione;
	}

	public void setDataregistrazione(Data dataregistrazione) {
		this.dataregistrazione = dataregistrazione;
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
		if (!(obj instanceof UtenteBean))
			return false;
		UtenteBean other = (UtenteBean) obj;
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
