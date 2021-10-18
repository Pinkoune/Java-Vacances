/**
 * Page principale du programme
 * @author Jeremy
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
  private JMenuItem ajouterPdt;
  private JMenuItem supprimerPdt;
  private JMenuItem afficherPdt;
  private JMenuItem rechercherPdt;
  
  //La barre menu
  private JMenuBar menu;
  
  private JLabel lblMessage;
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
    this.setSize(900, 700);
    this.setResizable(false);

    //INSTANCIATION DU PANEL GLOBAL

    this.monPanel.setLayout(new FlowLayout(1, 4, 2));
    this.monPanel.setBackground(Color.pink);
    
    this.setContentPane(new AfficheImage("/Users/jeremy/Desktop/fondbois.jpg"));
    this.getContentPane().setLayout(new BorderLayout());

    monPanelGlobal = new JPanel();
    monPanelGlobal.setLayout(new BorderLayout());
    

 // Creation de la barre de menu
    JMenuBar menu = new JMenuBar();
    
    // Creation d'element de menu
    this.ajouterPdt = new JMenuItem("Ajouter un instrument");
    this.afficherPdt = new JMenuItem("Afficher les instruments");
    this.rechercherPdt = new JMenuItem("Rechercher un instrument");
    this.supprimerPdt = new JMenuItem("Supprimer un instrument");
    
    // Ajout de l'element au menu 
    menu.add(ajouterPdt);
    menu.add(afficherPdt);
    menu.add(rechercherPdt);
    menu.add(supprimerPdt);

    //on ecoute les items du menu
    this.ajouterPdt.addActionListener(this);
    this.afficherPdt.addActionListener(this);
    this.rechercherPdt.addActionListener(this);
    this.supprimerPdt.addActionListener(this);


    // Permet de definir le menu utilise dans la JFrame
    this.setJMenuBar(menu);

    //LABEL PERMETTANT D'AFFICHER UN TEXTE
    this.lblMessage = new JLabel();
    this.lblMessage.setText("Magasin SONOVENTE");

    this.monPanel.add(lblMessage);

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

    if (e.getSource().equals(ajouterPdt)) {							//Panel d'Ajout si bouton cliqué.
    	this.getContentPane().removeAll();  			      			 //on va supprimer le panel
    	this.getContentPane().add(new FenetreInstruments(uneSonovente).getMonPanelGlobal());       //on va ajouter un panel
    	this.getContentPane().revalidate();								//
    	this.getContentPane().repaint();
    	
    } else if (e.getSource().equals(afficherPdt)) {					//Panel d'Affichage si bouton cliqué.
      
    	this.getContentPane().removeAll();      					     //on va supprimer le panel
		this.getContentPane().add(new FenetreAffichage(uneSonovente).getMonPanelGlobal());       //on va ajouter un panel
		this.getContentPane().revalidate();
		this.getContentPane().repaint();
		
    } else if (e.getSource().equals(rechercherPdt)) {					//Panel de suppression si bouton cliqué.
        
    	this.getContentPane().removeAll();      					     //on va supprimer le panel
		this.getContentPane().add(new FenetreRecherche(uneSonovente).getMonPanelGlobal());       //on va ajouter un panel
		this.getContentPane().revalidate();
		this.getContentPane().repaint();
		
    } else if (e.getSource().equals(supprimerPdt)) {				//Panel de suppression si bouton cliqué.
    	
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