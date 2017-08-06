import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;

public class GuiC {
	int selUser;
	JFrame frm;
	public GuiC(){
		frm = new JFrame();
		frm.setTitle("Saufverwaltungssystem Version "+Main.VERSION+" Info");
		frm.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		Toolkit tk = Toolkit.getDefaultToolkit();
		Image beer = tk.getImage(getClass().getResource("Beer-icon.png"));
		frm.setIconImage(beer);
		frm.setSize(500,220);
		frm.setLocationRelativeTo(null);
		
		//GridLayout layout = new GridLayout(5, 1);
		
		JPanel pan = new JPanel();
		//pan.setLayout(layout);
		JLabel info = new JLabel("Made by Juri Dispan (2017)", SwingConstants.CENTER);
		pan.add(info);
		
		JTextArea infotext = new JTextArea("Benutzung des Programms: \n"
											+ "-Die neu generierte Liste ist unter \"db.txt\" zu finden.\n"
											+ "-Sie dient gleichzeitig als Datenbank, sollte also nicht verändert werden.\n"
											+ "-Um neue Mitglieder hinzuzufügen, eine neue Zeile in der Datenbank erstellen,\n"
											+ " natürlich nach den Schema in dem die anderen Einträge sind.\n"
											+ "-Namen dürfen nicht so lang sein, dass das Schema zerstört wird\n"
											+ " (ansonsten wird die Tabelle hässlich).", 3, 3);
		infotext.setEditable(false);
		
		pan.add(infotext);
		
		
		
		JButton knopfOK = new JButton("Ok.");
		knopfOK.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				closethis();
				
			}
		});
		
		
		pan.add(knopfOK);
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
