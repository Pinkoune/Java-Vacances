import java.awt.Graphics;
import java.awt.Image;

import javax.swing.JPanel;

class AfficheImage extends JPanel{
	
	// Déclaration de la propriété fond de type Image
	private Image fond;
	
	// Création du constructeur de la classe
	public AfficheImage(String s) {
		
		// Permet de charger une image
		fond = getToolkit().getImage(s);
	}
	
	/* Cette méthode est appelée automatiquement lors du chargement ou du redimensionnement
	de la fenêtre*/
	@Override
	public void paintComponent(Graphics g){
		
		super.paintComponent(g);
		g.drawImage(fond, 400, 400, getWidth(), getHeight(), this);
		
	}
}