/**
 * Classe de la catégorie basse
 * @author jérémy
 *
 */

public class Basse extends Instruments {
	//Attributs privés
	private int nbMicro;
	
	//Constructeur
	public Basse (String uneMarque, String uneMatiere, int unNbMicro) {
		super(uneMarque, uneMatiere);
		this.nbMicro = unNbMicro;
	}
	
	public Basse (String uneMarque, String uneMatiere) {
		super(uneMarque, uneMatiere);
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
