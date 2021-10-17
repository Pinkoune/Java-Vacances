/**
 * Classe de la cat�gorie basse
 * @author j�r�my
 *
 */

public class Basse extends Instruments {
	//Attributs priv�s
	private int nbMicro;
	
	//Constructeur
	public Basse (String unType, String uneMarque, String uneMatiere, int unNbMicro) {
		super(unType, uneMarque, uneMatiere);
		this.nbMicro = unNbMicro;
	}
	
	public Basse (String unType, String uneMarque, String uneMatiere) {
		super(unType, uneMarque, uneMatiere);
	}
	
	//Accesseur
	public int getNbMicro() {
		return nbMicro;
	}

	public void setNbCordes(int unNbMicro) {
		this.nbMicro = unNbMicro;
	}
	
	@Override
	public String toString() {
		return "\nGuitare : " + getMarque() + " - " + getMatiere()+ " - "  + this.nbMicro + " Cordes";
	}

}
