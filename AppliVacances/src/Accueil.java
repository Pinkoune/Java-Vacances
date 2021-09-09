/**
 * Page principale du programme
 * @author j�r�my
 */

import java.awt.BorderLayout;
import java.awt.Color;
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

  //Les textes
  private JLabel lblMessage;

  //le menu
  private JMenuBar menu;
  private JMenu menuPdt;

  private JMenuItem ajouterPdt;
  private JMenuItem supprimerPdt;
  private JMenuItem afficherPdt;
  private JMenuItem rechercherPdt;
  
  private Sonovente uneSonovente;


  //CONSTRUCTEURS
  public Accueil(Sonovente uneSonovente) {
	  
    this.uneSonovente = uneSonovente;
    
    //configuration fenetre
    this.setTitle("Sonovente");
    this.setLocationRelativeTo(null);
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.setSize(700, 500);
    this.setResizable(false);

    //INSTANCIATION DU PANEL GLOBALE

    this.monPanel.setLayout(new FlowLayout(1, 4, 2));
    this.monPanel.setBackground(Color.pink);

    monPanelGlobal = new JPanel();
    monPanelGlobal.setLayout(new BorderLayout());
    

    // Cr�ation de la barre de menu
    JMenuBar menu = new JMenuBar();

    // Cr�ation d'un "bouton menu" Produit dans la barre de menu
    JMenu menuPdt = new JMenu("Instruments");

    // Cr�ation d'�l�ment de menu
    this.ajouterPdt = new JMenuItem("Ajouter un instrument");
    this.afficherPdt = new JMenuItem("Afficher les instruments");
    this.rechercherPdt = new JMenuItem("Rechercher un instrument");
    this.supprimerPdt = new JMenuItem("Supprimer un instrument");

    // Ajout de l'�l�ment au menu 
    menuPdt.add(ajouterPdt);
    menuPdt.add(afficherPdt);
    menuPdt.add(rechercherPdt);
    menuPdt.add(supprimerPdt);

    //on ecoute les items du menu
    this.ajouterPdt.addActionListener(this);
    this.afficherPdt.addActionListener(this);
    this.rechercherPdt.addActionListener(this);
    this.supprimerPdt.addActionListener(this);
    
    // Ajout du menu dans la barre de menu
    menu.add(menuPdt);


    // Permet de d�finir le menu utilis� dans la JFrame
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