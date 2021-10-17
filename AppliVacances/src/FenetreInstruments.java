/**
 * Fenetre d'ajout
 * @author j�r�my
 */

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import javax.swing.*;
import java.awt.event.ActionListener;
public class FenetreInstruments extends JFrame implements ActionListener{
	private JPanel monPanel;
	private JPanel panelHaut;
	private JPanel panelBas;
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
        panelHaut = new JPanel () ;
        panelBas = new JPanel () ;
        monPanel.setLayout(new BorderLayout());
        monPanelGlobal.setLayout(new BorderLayout());
        GroupLayout layout = new GroupLayout(panelHaut);
        layout.setAutoCreateGaps(true);
        layout.setAutoCreateContainerGaps(true);
        panelHaut.setLayout(layout);
        
        //test
        messageTest = new JLabel("test");
        monPanel.add(messageTest);
        
        
        //LABELS
		lblMarque = new JLabel ("Marque : ");
		lblMatiere = new JLabel ("Matiere : ");
		lblType = new JLabel ("Type : ");
		
		//SAISIES DE TEXTES
		jtfMarque = new JTextField ("");
		jtfMarque.setMaximumSize(new Dimension(250,30));
		jtfMatiere = new JTextField ("");
		jtfMatiere.setMaximumSize(new Dimension(250,30));
		
		//BOUTONS
		btnValider = new JButton ("Valider");
		btnValider.addActionListener(this);
		panelBas.add(btnValider);
		
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
		
		
        monPanel.add(panelHaut, BorderLayout.NORTH);
        monPanel.add(panelBas, BorderLayout.CENTER);
		
      //Cr�ation de 2 groupes horizontaux 
		layout.setHorizontalGroup(layout.createSequentialGroup() 
			.addGroup (layout.createParallelGroup (GroupLayout.Alignment.LEADING) //1er groupe
				.addComponent(lblMarque)
				.addComponent(jtfMarque)
				.addComponent(lblType)
				.addComponent(liste)
				)
			.addGroup (layout.createParallelGroup (GroupLayout.Alignment.LEADING)//2eme groupe
				.addComponent(lblMatiere)
				.addComponent(jtfMatiere)
				.addComponent(acoustique)
				.addComponent(electrique))		
		);
		
		
		layout.setVerticalGroup(layout.createSequentialGroup()
				.addGroup (layout.createParallelGroup (GroupLayout.Alignment.BASELINE) //Les deux premiers �l�ments sont sur le m�me alignement
					.addComponent(lblMarque)
					.addComponent(lblMatiere))
				.addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
					.addGroup (layout.createSequentialGroup ()
							.addComponent(jtfMarque) //Contenu de la premi�re colonne
							.addComponent(lblType)
							.addComponent(liste)

							)
					.addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
						.addGroup (layout.createSequentialGroup ()
							.addComponent(jtfMatiere) //Contenu de la deuxi�me Colonne
							.addComponent(acoustique)
							.addComponent(electrique))
							)		
				)	
		);
        
        this.setAlwaysOnTop(true);
        this.getContentPane().add(monPanel);
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
    	if(evenement.getSource() == btnValider) {//Si la source de l'�v�nement est le JButton appel� 
    		String marque = jtfMarque.getText();	
    		String matiere = jtfMatiere.getText();
    		String type = liste.getSelectedItem().toString();
    		String mode = choixMode();
    		
    		if(type == "Guitare") {
    			Guitare uneGuitare = new Guitare("Guitare", marque, matiere);
    			uneSonovente.ajoutInstruments(uneGuitare);
    			JLabel guit = new JLabel("Guitare ajoutee ! ");
        		panelBas.add(guit);
        		panelBas.revalidate();
        		panelBas.repaint();
    		}
    		else {
    			Basse uneBasse = new Basse("Basse", marque, matiere);
    			uneSonovente.ajoutInstruments(uneBasse);
    			JLabel bass = new JLabel("Basse ajoutee ! ");
    			panelBas.add(bass);
    			panelBas.revalidate();
    			panelBas.repaint();
    		}

    	}
    }
}
