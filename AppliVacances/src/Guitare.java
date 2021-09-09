/**
 * Classe de la cat�gorie guitare
 * @author j�r�my
 *
 */

public class Guitare extends Instruments {
	//Attributs priv�s
	private int nbCordes;
	
	//Constructeur
	public Guitare (String uneMarque, String uneMatiere, int unNbCordes) {
		super(uneMarque, uneMatiere);
		this.nbCordes = unNbCordes;
	}
	
	public Guitare (String uneMarque, String uneMatiere) {
		super(uneMarque, uneMatiere);
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
