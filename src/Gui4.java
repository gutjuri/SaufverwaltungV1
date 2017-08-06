import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Gui4 {
	int selUser;
	JFrame frm;
	public Gui4(){
		frm = new JFrame();
		frm.setTitle("Saufverwaltungssystem Version "+Main.VERSION);
		frm.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		Toolkit tk = Toolkit.getDefaultToolkit();
		Image beer = tk.getImage(getClass().getResource("Beer-icon.png"));
		frm.setIconImage(beer);
		frm.setSize(550,110);
		frm.setLocationRelativeTo(null);
		
		
		JPanel pan = new JPanel();
		JLabel frage = new JLabel("Wieviel will "+Main.namen[Gui.selUser]+" (Guthaben: "+Main.liste[Gui.selUser].guth+" €) einzahlen?");
		pan.add(frage);
		JTextField feld = new JTextField();
		feld.setPreferredSize(new Dimension(50,20));
		pan.add(feld);
		
		
		
		JButton knopf1 = new JButton("confirm");
		knopf1.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				try{
					Main.liste[Gui.selUser].guth += Double.parseDouble(feld.getText());
					JOptionPane.showMessageDialog(null, "Neues Guthaben von "+Main.namen[Gui.selUser]+" beträgt "+Main.liste[Gui.selUser].guth+" €.");
					closethis();
				}catch(NumberFormatException er){
					JOptionPane.showMessageDialog(null, "Bitte eine Zahl eingeben, statt Kommata Punkte verwenden, gegebenenfalls Minus-Zeichen benutzen");
				}
			}
		});
		//JPanel pan2 = new JPanel();
		//JLabel guthinfo = new JLabel(DateiTest.namen[Gui.selUser]+" besitzt zur Zeit ein Guthaben von "+DateiTest.liste[Gui.selUser].guth+" €.");
		//pan2.add(guthinfo);
		
		
		pan.add(knopf1);
		frm.add(pan);
		//frm.add(pan2);
		//frm.pack();
		frm.setVisible(true);
		
	}
	
	public void closethis(){
		frm.setVisible(false);
		frm.dispose();
	}
}	
