/**
 * Fenetre de l'affichage
 *@author j�r�my 
 */

import java.awt.*;
import java.awt.event.ActionEvent;
import javax.swing.*;
import java.awt.event.ActionListener;
public class FenetreAffichage extends JFrame implements ActionListener {
	private JPanel monPanel;
	private JPanel monPanelGlobal = new JPanel();
	private JPanel panelHaut;
	private JPanel panelMil;
	private JLabel lblContenuSonovente;
	//le menu
	private JMenuBar menu;
	private JMenu menuPdt;

	private Sonovente uneSonovente;
	private JTable tableau;
	JScrollPane scrollPane;
	
	public FenetreAffichage(Sonovente unSonovente) {
		
		this.uneSonovente = unSonovente;
      
        monPanel = new JPanel ( ) ;
        panelHaut = new JPanel ( ) ;
        panelMil = new JPanel ();
        monPanel.setLayout(new BorderLayout());
        panelMil.setLayout(new FlowLayout());
        panelHaut.setLayout(new FlowLayout());
        panelHaut.setBackground(Color.white);
        monPanelGlobal.setLayout(new BorderLayout());
        this.monPanelGlobal.add(monPanel, BorderLayout.CENTER);
        
		if(uneSonovente.getNombreInstruments() == 0) {
			lblContenuSonovente = new JLabel("Il n'y a aucun instrument dans le sonovente");
		}
		else {
			lblContenuSonovente = new JLabel("Voici les instruments dans le sonovente");
		}
                                     
        // Mise en forme du titre afficher dans la fen�tre         
        Font f = new Font("Sherif", Font.BOLD, 18);          
        lblContenuSonovente.setFont(f);
        panelMil.add(lblContenuSonovente);
 
        // TABLEAU : compos� d'une ligne de titres de colonnes (title) et de donn�es (data) 
        Object data[][]= new Object[10][10]; 
        int i = 0; 
		for (Instruments unInstrument : uneSonovente.getListeInstruments()) {
			data[i][0] = i + " - " + unInstrument.getMarque();
			data[i][1] = unInstrument.getMatiere();
			i++;
		}
        String [] title = {"Marque", "Mati�re"};                         
        this.tableau = new JTable(data,title);                
        this.tableau.setPreferredScrollableViewportSize(new Dimension(350, 300)); 

         this.tableau.setRowHeight(30); 
         //espacement des cellules                 
         // le tableau doit �tre obligatoirement ajout� dans un composant JScrollPane         
         this.scrollPane = new JScrollPane(this.tableau);          
         this.panelMil.add(this.scrollPane); 
           
        monPanel.add(panelHaut, BorderLayout.NORTH);
        monPanel.add(panelMil, BorderLayout.CENTER);
        
        
        
        this.setAlwaysOnTop(true);
        this.monPanelGlobal.add(this.scrollPane);
        this.getContentPane().add(monPanel); // UN SEUL panel DANS LE GET CONTENT
        this.setVisible(true);
	}
		
	//les getter et setter
	  public JPanel getMonPanelGlobal() {
	    return monPanelGlobal;
	  }
	
	
	public void actionPerformed (ActionEvent e) {
		
	}
}



