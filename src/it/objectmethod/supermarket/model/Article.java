package it.objectmethod.supermarket.model;

public class Article implements Comparable<Article>{

	private String codArt;
	private String descrizione;
	private int pzCart;
	private int idIva;
	private int idFamAss;

	public String getCodArt() {
		return codArt;
	}

	public void setCodArt(String codArt) {
		this.codArt = codArt;
	}

	public String getDescrizione() {
		return descrizione;
	}

	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}

	public int getPzCart() {
		return pzCart;
	}

	public void setPzCart(int pzCart) {
		this.pzCart = pzCart;
	}

	public int getIdIva() {
		return idIva;
	}

	public void setIdIva(int idIva) {
		this.idIva = idIva;
	}

	public int getIdFamAss() {
		return idFamAss;
	}

	public void setIdFamAss(int idFamAss) {
		this.idFamAss = idFamAss;
	}

	@Override
	public int compareTo(Article a) {
		if(this.codArt.compareTo(a.codArt) > 0 ) return +1;
		else if(this.codArt.compareTo(a.codArt) < 0 ) return -1;
		return 0;
	}
	
	@Override
	public String toString() {
		return "codArt = " + codArt + ", descrizione = " + descrizione + ", pzCart = " + pzCart + ", idIva = " + idIva
				+ ", descFamAss = " + idFamAss;
	}

}
