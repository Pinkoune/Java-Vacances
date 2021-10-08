/**
 * Page principale du programme
 * @author j�r�my
 */

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

public class Accueil extends JFrame implements ActionListener {

  //les panel classiques
  private JPanel monPanel = new JPanel();
  private JPanel monPanelGlobal = new JPanel();

  //Les boutons
  private JButton ajouterPdt;
  private JButton supprimerPdt;
  private JButton afficherPdt;
  private JButton rechercherPdt;
  
  private Sonovente uneSonovente;


  //CONSTRUCTEURS
  public Accueil(Sonovente uneSonovente) {
	  
    this.uneSonovente = uneSonovente;
    
    this.setContentPane(new AfficheImage("/Users/jeremy/Desktop/fondbois.jpg"));
    this.getContentPane().setLayout(new BorderLayout());
    //configuration fenetre
    this.setTitle("Sonovente");
    this.setLocationRelativeTo(null);
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.setSize(700, 500);
    this.setResizable(false);

    //INSTANCIATION DU PANEL GLOBAL

    this.monPanel.setLayout(new FlowLayout(1, 4, 2));
    this.monPanel.setOpaque(false);
    
    this.setContentPane(new AfficheImage("/Users/jeremy/Desktop/fondbois.jpg"));
    this.getContentPane().setLayout(new BorderLayout());

    monPanelGlobal = new JPanel();
    monPanelGlobal.setLayout(new BorderLayout());
    

    // Cr�ation d'element de menu
    this.ajouterPdt = new JButton("Ajouter un instrument");
    this.afficherPdt = new JButton("Afficher les instruments");
    this.rechercherPdt = new JButton("Rechercher un instrument");
    this.supprimerPdt = new JButton("Supprimer un instrument");
    
    //Taille des boutons
    this.ajouterPdt.setPreferredSize(new Dimension(200, 80));
    this.afficherPdt.setPreferredSize(new Dimension(200, 80));
    this.rechercherPdt.setPreferredSize(new Dimension(200, 80));
    this.supprimerPdt.setPreferredSize(new Dimension(200, 80));


    // Ajout de l'element au menu 
    monPanel.add(ajouterPdt);
    monPanel.add(afficherPdt);
    monPanel.add(rechercherPdt);
    monPanel.add(supprimerPdt);

    //on ecoute les items du menu
    this.ajouterPdt.addActionListener(this);
    this.afficherPdt.addActionListener(this);
    this.rechercherPdt.addActionListener(this);
    this.supprimerPdt.addActionListener(this);

    this.monPanelGlobal.add(monPanel, BorderLayout.CENTER);

    this.getContentPane().add(this.monPanelGlobal);
    this.setVisible(true);

  }

  //les getter et setter
  public JPanel getMonPanelGlobal() {
    return monPanelGlobal;
  }

 

  //va  lancer le changement de panel celon le clic
  public void actionPerformed(ActionEvent e) {

    if (e.getSource().equals(ajouterPdt)) {							//Panel d'Ajout d'�l�ve si bouton cliqu�.
    	this.getContentPane().removeAll();  			      			 //on va supprimer le panel
    	this.getContentPane().add(new FenetreInstruments(uneSonovente).getMonPanelGlobal());       //on va ajouter un panel
    	this.getContentPane().revalidate();								//
    	this.getContentPane().repaint();
    	
    } else if (e.getSource().equals(afficherPdt)) {					//Panel d'Affichage de la classe si bouton cliqu�.
      
    	this.getContentPane().removeAll();      					     //on va supprimer le panel
		this.getContentPane().add(new FenetreAffichage(uneSonovente).getMonPanelGlobal());       //on va ajouter un panel
		this.getContentPane().revalidate();
		this.getContentPane().repaint();
		
    } else if (e.getSource().equals(rechercherPdt)) {					//Panel de suppression de la classe si bouton cliqu�.
        
    	this.getContentPane().removeAll();      					     //on va supprimer le panel
		this.getContentPane().add(new FenetreRecherche(uneSonovente).getMonPanelGlobal());       //on va ajouter un panel
		this.getContentPane().revalidate();
		this.getContentPane().repaint();
		
    } else if (e.getSource().equals(supprimerPdt)) {				//Panel de suppression d'�l�ve si bouton cliqu�.
    	
      this.getContentPane().removeAll();       							//on va supprimer le panel
      this.getContentPane().add(new FenetreSuppression(uneSonovente).getMonPanelGlobal());       //on va ajouter un panel
      this.getContentPane().revalidate();
      this.getContentPane().repaint();
    }

  }
  
  public static void main(String[] args) {
    	Sonovente leSonovente = new Sonovente();
      Accueil Fenetre = new Accueil(leSonovente);
  }
} 