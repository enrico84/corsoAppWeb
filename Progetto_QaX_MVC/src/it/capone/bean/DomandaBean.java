package it.capone.bean;

import java.util.List;

import it.capone.utility.Data;

public class DomandaBean {
	
	private int iddomanda;
	private String titolo;
	private String descrizione;
	private Data datacreazione;
	private CategoriaBean categoria;
	private UtenteBean utente;
	private RispostaBean rispostascelta;
	private List<RispostaBean> risposte;


	//Costruttore con parametri
	public DomandaBean(int iddomanda, String titolo, String descrizione, Data datacreazione, CategoriaBean categoria, 
			           UtenteBean utente) {
		this.iddomanda = iddomanda;
		this.titolo = titolo;
		this.descrizione = descrizione;
		this.datacreazione = datacreazione;
		this.categoria = categoria;
		this.utente = utente;
	}
	
	//Costruttore vuoto
	public DomandaBean() {}
	
	
	public int getIddomanda() {
		return iddomanda;
	}

	
	public String getTitolo() {
		return titolo;
	}
	
	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}
	
	public String getDescrizione() {
		return descrizione;
	}
	
	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}
	
	public Data getDatacreazione() {
		return datacreazione;
	}
	
	public void setDatacreazione(Data datacreazione) {
		this.datacreazione = datacreazione;
	}

	
	public CategoriaBean getCategoria() {
		return categoria;
	}


	
	public void setCategoria(CategoriaBean categoria) {
		this.categoria = categoria;
	}


	
	public UtenteBean getUtente() {
		return utente;
	}


	
	public void setUtente(UtenteBean utente) {
		this.utente = utente;
	}


	
	public RispostaBean getRispostascelta() {
		return rispostascelta;
	}


	public void setRispostascelta(RispostaBean rispostascelta) {
		this.rispostascelta = rispostascelta;
	}
	
	
	public List<RispostaBean> getRisposte() {
	    return risposte;
	}

	
    public void setRisposte(List<RispostaBean> risposte) {
	    this.risposte = risposte;
	}

	
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof DomandaBean))
			return false;
		DomandaBean other = (DomandaBean) obj;
		if (iddomanda != other.iddomanda)
			return false;
		if (!categoria.equals(other.categoria))
			return false;
		if(!utente.equals(other.utente))
			return false;
		if (descrizione == null) {
			if (other.descrizione != null)
				return false;
		} else if (!descrizione.equals(other.descrizione))
			return false;
		if (titolo == null) {
			if (other.titolo != null)
				return false;
		} else if (!titolo.equals(other.titolo))
			return false;
		return true;
	}
	

}
