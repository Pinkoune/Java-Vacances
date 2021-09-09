/**
 * Classe qui contient la liste
 * @author jérémy
 *
 */

import java.util.ArrayList;
public class Sonovente {
	private ArrayList<Instruments> listeInstruments;
	
	public Sonovente() {
		this.listeInstruments = new ArrayList<Instruments>();
	}
	
	public int getNombreInstruments() {
		return this.listeInstruments.size();
	}
	
	public void ajoutInstruments(Instruments unInstrument) {
		this.listeInstruments.add(unInstrument);
	}
	
	public ArrayList<Instruments> getListeInstruments(){
		return this.listeInstruments;
	}
	
	public String recherche(String uneMatiere) {
		int index = 0;
		String result = "\nCet instrument n'est pas présent";
		while(index < this.listeInstruments.size() && !this.listeInstruments.get(index).getMatiere().equals(uneMatiere)) {
			index = index + 1;
		}
		if (index < this.listeInstruments.size()) {
			result = "\nVoici l'instrument recherché :" + uneMatiere  + this.listeInstruments.get(index).toString();
		}
		return result;
	}
	
	public int rechercheInt(String uneMatiere) {
		int index = 0;
		int result = -1;
		while(index < this.listeInstruments.size() && !this.listeInstruments.get(index).getMatiere().equals(uneMatiere)) {
			index = index + 1;
		}
		if (index < this.listeInstruments.size()) {
			result = index;
		}
		return result;
	}
	
	public void supprimer(int indice) {
		this.listeInstruments.remove(indice);
	}
	
	public void supprimer(Instruments unInstrument) {
		this.listeInstruments.remove(unInstrument);
	}
	
	public boolean supprimer(String uneMatiere) {
		boolean rep = false;
		int index = this.rechercheInt(uneMatiere);
		if (index != -1) {
			this.listeInstruments.remove(index);
			rep = true;
		}
		return rep;
	}
	
	public String toString() {
		String entete = "**** PRESENTATION DU SONOVENTE ****";
		String resultat = "";
		if (this.listeInstruments.size() == 0) {
			resultat = "\nSonovente ne contient aucun instrument";
		}
		else {
			for(int i = 0 ; this.listeInstruments.size() > i ; i++) {
				resultat = resultat + i + this.listeInstruments.get(i).toString();
			}
			
		}
		return entete + resultat;
	}
}
