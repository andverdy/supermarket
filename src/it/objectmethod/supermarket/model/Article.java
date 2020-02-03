package it.objectmethod.supermarket.model;

public class Article {

	private String codArt;
	private String descrizione;
	private int pzCart;
	private int idIva;
	private int idStatoArt;
	private int idFamAss;

	public Article(String codArt2, String descrizione2, int pzCart2, int idIva2, int idStatoArt2, int idFamAss2) {
	}

	public Article() {
	}

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

	public int getIdStatoArt() {
		return idStatoArt;
	}

	public void setIdStatoArt(int idStatoArt) {
		this.idStatoArt = idStatoArt;
	}

	public int getIdFamAss() {
		return idFamAss;
	}

	public void setIdFamAss(int idFamAss) {
		this.idFamAss = idFamAss;
	}

	@Override
	public String toString() {
		return "codArt = " + codArt + ", descrizione = " + descrizione + ", pzCart = " + pzCart + ", idIva = " + idIva
				+ ", idStatoArt = " + idStatoArt + ", idFamAss = " + idFamAss;
	}

}
