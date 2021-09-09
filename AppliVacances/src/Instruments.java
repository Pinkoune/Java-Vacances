/**
 * Classe Abstraite des instruments
 * @author j�r�my
 *
 */

public abstract class Instruments {
	//attributs priv�s
	private String marque;
	private String matiere;

	
	//Constructeur
	public Instruments(String uneMarque, String unMatiere) {
		this.marque = uneMarque;
		this.matiere = unMatiere;
	}
	
	//Accesseurs
	public String getMarque() {
		return marque;
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
	
}
