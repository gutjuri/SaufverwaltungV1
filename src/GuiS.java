import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class GuiS {
	int selUser;
	JFrame frm;

	public GuiS() {
		frm = new JFrame();
		frm.setTitle("Saufverwaltungssystem Version " + Main.VERSION);
		frm.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

		Toolkit tk = Toolkit.getDefaultToolkit();
		Image beer = tk.getImage(getClass().getResource("Beer-icon.png"));
		frm.setIconImage(beer);
		frm.setSize(340, 150);
		frm.setLocationRelativeTo(null);

		JPanel pan = new JPanel();
		JLabel frage = new JLabel("Statistiken für " + Main.namen[Gui.selUser] + ":");
		pan.add(frage);

		JTextArea infotext = new JTextArea("Alkoholische Getränke: " + Main.liste[Gui.selUser].statsAlk
				+ " für insgesamt " + Main.liste[Gui.selUser].statsAlk * Main.ALC_PRICE + " € \n"
				+ "Antialkoholische Getränke: " + Main.liste[Gui.selUser].statsAnt + " für insgesamt "
				+ Main.liste[Gui.selUser].statsAnt * Main.ANTIALC_PRICE + " €", 2, 3);
		infotext.setEditable(false);
		pan.add(infotext);

		JButton knopf1 = new JButton("Ok.");
		knopf1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				closethis();
			}
		});

		pan.add(knopf1);
		frm.add(pan);
		frm.setVisible(true);

	}

	public void closethis() {
		frm.setVisible(false);
		frm.dispose();
	}
}
