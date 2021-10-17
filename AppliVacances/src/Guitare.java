/**
 * Classe de la cat�gorie guitare
 * @author j�r�my
 *
 */

public class Guitare extends Instruments {
	//Attributs priv�s
	private int nbCordes;
	
	//Constructeur
	public Guitare (String unType, String uneMarque, String uneMatiere, int unNbCordes) {
		super(unType, uneMarque, uneMatiere);
		this.nbCordes = unNbCordes;
	}
	
	public Guitare (String unType, String uneMarque, String uneMatiere) {
		super(unType, uneMarque, uneMatiere);
	}
	
	//Accesseur
	public int getNbCordes() {
		return nbCordes;
	}

	public void setNbCordes(int unNbCordes) {
		this.nbCordes = unNbCordes;
	}
	
	@Override
	public String toString() {
		return "\nGuitare : " + getMarque() + " - " + getMatiere()+ " - "  + this.nbCordes + " Cordes";
	}

}
