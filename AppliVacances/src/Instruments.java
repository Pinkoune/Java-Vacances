/**
 * Classe Abstraite des instruments
 * @author j�r�my
 *
 */

public abstract class Instruments {
	//attributs priv�s
	private String marque;
	private String matiere;
	private String type;

	
	//Constructeur
	public Instruments(String unType, String uneMarque, String unMatiere) {
		this.type = unType;
		this.marque = uneMarque;
		this.matiere = unMatiere;
	}
	
	//Accesseurs
	public String getMarque() {
		return this.marque;
	}

	public void setMarque(String marque) {
		this.marque = marque;
	}

	public String getMatiere() {
		return matiere;
	}

	public void setModele(String matiere) {
		this.matiere = matiere;
	}	
	
	public String getType() {
		return this.type;
	}
	
}
