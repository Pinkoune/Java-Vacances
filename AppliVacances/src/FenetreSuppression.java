/**
 * Fenetre de suppresion
 * @author j�r�my
 */

import java.awt.*;
import java.awt.event.ActionEvent;
import javax.swing.*;
import java.awt.event.ActionListener;
public class FenetreSuppression extends JFrame implements ActionListener {
	private JPanel monPanel;
	private JPanel monPanelGlobal = new JPanel();
	private JPanel panelHaut;
	private JPanel panelMil;
	private JPanel panelSupp;
	private JLabel lblSupp1;
	private JTextField jtfSupp1;
	private JButton btnValider1;
	//le menu
	  private JMenuBar menu;
	  private JMenu menuPdt;

	  private Sonovente uneSonovente;
	
	public FenetreSuppression(Sonovente unSonovente) {
		
		this.uneSonovente = unSonovente;

        
        monPanel = new JPanel ( ) ;
        panelHaut = new JPanel ( ) ;
        panelMil = new JPanel ();
        panelSupp = new JPanel();
        monPanel.setLayout(new BorderLayout());
        panelMil.setLayout(new FlowLayout());
        panelHaut.setLayout(new FlowLayout());
        monPanelGlobal.setLayout(new BorderLayout());
        
        lblSupp1 = new JLabel("Entrez la matiere a supprimer : ");
        jtfSupp1 = new JTextField("");
        jtfSupp1.setPreferredSize(new Dimension(150, 30));
        
        btnValider1 = new JButton("Valider");
        btnValider1.addActionListener(new ActionListener() {
        public void actionPerformed (ActionEvent e) {
        	String matiere = jtfSupp1.getText();
        	if(uneSonovente.supprimer(matiere)) {
        		JLabel sucess = new JLabel("Suppression reussie ! ");
        		panelSupp.removeAll();
        		panelSupp.add(sucess);
        		panelSupp.revalidate();
        		panelSupp.repaint();
        	}
        	else {
        		JLabel failure = new JLabel("Suppression echouee ! ");
        		panelSupp.removeAll();
        		panelSupp.add(failure);
        		panelSupp.revalidate();
        		panelSupp.repaint();
        	}
    	}
        
	});
        
        panelMil.add(lblSupp1);
        panelMil.add(jtfSupp1);
        panelMil.add(btnValider1);
        panelMil.add(panelSupp);
        
        monPanel.add(panelMil, BorderLayout.NORTH);
        monPanel.add(panelSupp, BorderLayout.CENTER);
        
        
        
        this.setAlwaysOnTop(true);
        this.getContentPane().add(monPanel); // UN SEUL panel DANS LE GET CONTENT
        this.monPanelGlobal.add(monPanel, BorderLayout.CENTER);
	    this.getContentPane().add(this.monPanelGlobal);
	}
	
	//les getter et setter
	  public JPanel getMonPanelGlobal() {
	    return monPanelGlobal;
	  }
	  
    public void actionPerformed(ActionEvent e) {

    }
	
}