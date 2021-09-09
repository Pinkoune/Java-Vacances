/**
 * Fenetre d'ajout
 * @author jérémy
 */

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import javax.swing.*;
import java.awt.event.ActionListener;
public class FenetreInstruments extends JFrame implements ActionListener{
	private JPanel monPanel;
	private JPanel pannelHaut;
	private JPanel pannelBas;
	private JPanel monPanelGlobal = new JPanel();
	private JLabel lblMarque;
	private JLabel lblMatiere;
	private JLabel lblType;
	private JTextField jtfMarque;
	private JTextField jtfMatiere;
    private JButton btnValider;
    private JComboBox<String> liste;
    private JCheckBox acoustique;
    private JCheckBox electrique;
    private ButtonGroup groupeCheckbox;
    private Sonovente uneSonovente;
    private JLabel messageTest;
	
	public FenetreInstruments(Sonovente unSonovente) {
		this.uneSonovente = unSonovente; 
        
        //PANEL
        monPanel = new JPanel () ;
        pannelHaut = new JPanel () ;
        pannelBas = new JPanel () ;
        monPanel.setLayout(new BorderLayout());
        monPanelGlobal.setLayout(new BorderLayout());
        GroupLayout layout = new GroupLayout(pannelHaut);
        layout.setAutoCreateGaps(true);
        layout.setAutoCreateContainerGaps(true);
        pannelHaut.setLayout(layout);
        
        //test
        messageTest = new JLabel("test");
        monPanel.add(messageTest);
        
        
        //LABELS
		lblMarque = new JLabel ("Marque : ");
		lblMatiere = new JLabel ("Matière : ");
		lblType = new JLabel ("Type : ");
		
		//SAISIES DE TEXTES
		jtfMarque = new JTextField ("");
		jtfMarque.setMaximumSize(new Dimension(250,30));
		jtfMatiere = new JTextField ("");
		jtfMatiere.setMaximumSize(new Dimension(250,30));
		
		//BOUTONS
		btnValider = new JButton ("Valider");
		btnValider.addActionListener(this);
		pannelBas.add(btnValider);
		
		//LISTE DEROULANTE
		liste = new JComboBox<String>();
		liste.addItem("Guitare");
		liste.addItem("Basse");
		liste.setMaximumSize(new Dimension(100,30));
		
		//CHECKBOX
		acoustique = new JCheckBox("Acoustique");
		electrique = new JCheckBox("Electrique");
		groupeCheckbox = new ButtonGroup();
		groupeCheckbox.add(acoustique);
		groupeCheckbox.add(electrique);
		
		
        monPanel.add(pannelHaut, BorderLayout.NORTH);
        monPanel.add(pannelBas, BorderLayout.CENTER); 
		
      //Création de 2 groupes horizontaux 
		layout.setHorizontalGroup(layout.createSequentialGroup() 
			.addGroup (layout.createParallelGroup (GroupLayout.Alignment.LEADING) //1er groupe
				.addComponent(lblMarque)
				.addComponent(jtfMarque)
				.addComponent(lblMatiere)
				.addComponent(jtfMatiere)
				)
			.addGroup (layout.createParallelGroup (GroupLayout.Alignment.LEADING)//2eme groupe
				.addComponent(lblType)
				.addComponent(liste)
				.addComponent(acoustique)
				.addComponent(electrique))		
		);
		
		
		layout.setVerticalGroup(layout.createSequentialGroup()
				.addGroup (layout.createParallelGroup (GroupLayout.Alignment.BASELINE) //Les deux premiers éléments sont sur le même alignement
					.addComponent(lblMarque)
					.addComponent(lblType))
				.addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
					.addGroup (layout.createSequentialGroup ()
							.addComponent(jtfMarque) //Contenu de la première colonne
							.addComponent(lblMatiere)
							.addComponent(jtfMatiere)

							)
					.addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
						.addGroup (layout.createSequentialGroup ()
							.addComponent(liste) //Contenu de la deuxième Colonne
							.addComponent(acoustique)
							.addComponent(electrique))
							)		
				)	
		);
        
        this.setAlwaysOnTop(true);
        this.getContentPane().add(monPanel);
        this.setVisible(true);
        this.monPanelGlobal.add(monPanel, BorderLayout.CENTER);

        this.getContentPane().add(this.monPanelGlobal);
	}
	


	  //les getter et setter
	  public JPanel getMonPanelGlobal() {
	    return monPanelGlobal;
	  }
	
	public String choixMode() {
		String mode = "";
		if(acoustique.isSelected() == true) {
			mode = "Acoustique";
		}
		else {
			mode = "Electrique";
		}
		return mode;
	}
	
    public void actionPerformed ( ActionEvent evenement) {
    	if(evenement.getSource() == btnValider) {//Si la source de l'évènement est le JButton appelé 
    		String marque = jtfMarque.getText();	
    		String matiere = jtfMatiere.getText();
    		String type = liste.getSelectedItem().toString();
    		String mode = choixMode();
    		
    		if(type == "Guitare") {
    			Guitare uneGuitare = new Guitare(marque, matiere);
    			uneSonovente.ajoutInstruments(uneGuitare);
    		}
    		else {
    			Basse uneBasse = new Basse(marque, matiere);
    			uneSonovente.ajoutInstruments(uneBasse);
    		}

    	}
    }
}
