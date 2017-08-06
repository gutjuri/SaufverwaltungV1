import java.awt.Desktop;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class Gui {
	public static int selUser; //aktuell ausgewählte person
	public static JFrame frm;
	@SuppressWarnings("rawtypes")
	public Gui(){
		frm = new JFrame();
		frm.setTitle("Saufverwaltungssystem Version "+Main.VERSION);
		frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Toolkit tk = Toolkit.getDefaultToolkit();
		Image beer = tk.getImage(getClass().getResource("Beer-icon.png"));
		frm.setIconImage(beer);
		frm.setSize(550,220);
		frm.setLocationRelativeTo(null);
		
		GridLayout layout = new GridLayout(4, 2);
		
		
		JPanel pan = new JPanel();
		pan.setLayout(layout);
		
		JLabel frage = new JLabel("Welches Mitglied wollen sie bearbeiten?", SwingConstants.CENTER);
		
		@SuppressWarnings("unchecked")
		JComboBox auswahl = new JComboBox(Arrays.stream(Main.namen).filter(x -> x!=null).toArray());
		
		JButton knopf1 = new JButton("Mitglied wählen");
		knopf1.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				selUser = auswahl.getSelectedIndex();
				//System.out.println(DateiTest.namen[selUser]);
				@SuppressWarnings("unused")
				Gui2 ausw = new Gui2();
			}
		});
		
		
		
		JButton knopfS = new JButton("Statistik anschauen");
		knopfS.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				selUser = auswahl.getSelectedIndex();
				//System.out.println(DateiTest.namen[selUser]);
				@SuppressWarnings("unused")
				GuiS ausw = new GuiS();
			}
		});
		;
		JButton knopfC = new JButton("Info über dieses Programm");
		knopfC.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				@SuppressWarnings("unused")
				GuiC c = new GuiC();
				
			}
		});
		
		
		JButton knopf2 = new JButton("Liste erstellen und beenden");
		knopf2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
					Main.makefile(Main.liste);
					closethis();
					System.exit(0);
				}catch(IOException er){
					JOptionPane.showMessageDialog(null, "Irgendwie hats ned funktioniert, kp warum ^^. Entwickler ist nicht schuld btw. Error Code IO");
				}catch(Exception er){
					JOptionPane.showMessageDialog(null, "Irgendwie hats ned funktioniert, kp warum ^^. Entwickler ist nicht schuld btw. Error Code Exception");
				}
				
			}
		});
		
		JButton knopfP = new JButton("Liste erstellen, drucken und beenden");
		knopfP.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
					if(!Desktop.isDesktopSupported()) throw new OutOfMemoryError();
					Desktop desktop = Desktop.getDesktop();
					
					Main.makefile(Main.liste);
					
					File file = new File(Main.pfad);
					desktop.print(file);
					
					closethis();
					System.exit(0);
				}catch(IOException er){
					JOptionPane.showMessageDialog(null, "Irgendwie hats ned funktioniert, kp warum ^^. Entwickler ist nicht schuld btw. Error Code IO");
				}catch(Exception er){
					JOptionPane.showMessageDialog(null, "Irgendwie hats ned funktioniert, kp warum ^^. Entwickler ist nicht schuld btw. Error Code Exception");
				}catch(OutOfMemoryError er){
					JOptionPane.showMessageDialog(null, "Auf diesem System nicht möglich.");
				}
				
			}
		});
		
		JButton knopfO = new JButton("Liste erstellen, öffnen und beenden");
		knopfO.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
					if(!Desktop.isDesktopSupported()) throw new OutOfMemoryError();
					Desktop desktop = Desktop.getDesktop();
					
					Main.makefile(Main.liste);
					
					File file = new File(Main.pfad);
					desktop.open(file);
					
					closethis();
					System.exit(0);
				}catch(IOException er){
					JOptionPane.showMessageDialog(null, "Irgendwie hats ned funktioniert, kp warum ^^. Entwickler ist nicht schuld btw. Error Code IO");
				}catch(Exception er){
					JOptionPane.showMessageDialog(null, "Irgendwie hats ned funktioniert, kp warum ^^. Entwickler ist nicht schuld btw. Error Code Exception");
				}catch(OutOfMemoryError er){
					JOptionPane.showMessageDialog(null, "Auf diesem System nicht möglich.");
				}
				
			}
		});
		
		
		pan.add(frage);
		pan.add(auswahl);
		pan.add(knopfS);
		pan.add(knopf1);
		pan.add(knopfC);
		pan.add(knopfO);
		pan.add(knopf2);
		pan.add(knopfP);
		
		
		frm.add(pan);
		//frm.pack();
		frm.setVisible(true);
		
	}
	public void closethis(){
		frm.setVisible(false);
		frm.dispose();
	}
}
