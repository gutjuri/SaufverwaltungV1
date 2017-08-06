import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Main {

	public static final double VERSION = 0.2;

	static final int SUPPORTED_MEMBERS = 50;
	static final double ALC_PRICE = 1.5;
	static final double ANTIALC_PRICE = 1;

	public static String[] namen;
	public static int[] statsAlk;
	public static int[] statsAnt;
	public static Person[] liste;
	static String pfad;

	public static void main(String[] args) throws IOException {
		Path p = Paths.get("db.txt");
		pfad = p.toString();
		BufferedReader b = new BufferedReader(new FileReader(pfad));
		namen = new String[SUPPORTED_MEMBERS];
		double[] guth = new double[SUPPORTED_MEMBERS];
		String curr = "";
		int i = 0;
		b.readLine();
		b.readLine();
		b.readLine();
		b.readLine();
		while (true) { // aktuelles guthaben von mitgliedern wird eingelesen
			curr = b.readLine();
			if (curr == null)
				break;
			namen[i] = curr.substring(0, curr.indexOf('\t'));
			guth[i] = Double.parseDouble(curr.substring(curr.lastIndexOf(' ') + 1));
			b.readLine();
			i++;
		}
		printlist(namen, guth);

		liste = new Person[i];
		statsAlk = new int[i];
		statsAnt = new int[i];

		// guthaben von personen wird in array abgespeichert

		for (int j = 0; j < i; j++) {
			liste[j] = new Person(namen[j], guth[j]);
			liste[j].setstats();
		}
		b.close();
		new Gui(); // fenster wird erzeugt

	}

	/** für debugging */
	public static void printlist(String[] namen, double[] guth) {
		// System.out.println();
		for (int i = 0; i < namen.length; i++) {
			if (namen[i] == null)
				break;
			System.out.println(namen[i] + "          " + guth[i]);
		}
	}

	/** Schreibt das array aus personen in die dateien db.txt und stats.txt */

	public static void makefile(Person[] liste) throws Exception {

		Date date = Calendar.getInstance().getTime(); // Datum
		SimpleDateFormat dateFormatter = new SimpleDateFormat("dd.MM.yyyy");
		String dateString = dateFormatter.format(date);

		BufferedWriter w = new BufferedWriter(new FileWriter("db.txt"));
		BufferedWriter wr = new BufferedWriter(new FileWriter("stats.txt"));
		w.write("Strichliste:\t \t \t \t \t \t \t   " + dateString);
		w.newLine();
		w.newLine();
		w.write("Name: \t | Alkoholisches (" + ALC_PRICE + ".0\u20ac)       |     Antialkoholisches (" + ANTIALC_PRICE
				+ "\u20ac) | Kapital");
		w.newLine();
		w.write("---------+-----------------------------+----------------------------+--------");
		w.newLine();
		for (int i = 0; i < liste.length; i++) {
			w.write(liste[i].name + "\t | \t \t \t       | \t\t\t    | " + liste[i].guth);
			w.newLine();
			w.write("---------+-----------------------------+----------------------------+--------");
			w.newLine();
			wr.write(liste[i].name + " " + liste[i].statsAlk + " " + liste[i].statsAnt);
			wr.newLine();

		}
		w.flush();
		wr.flush();
		w.close();
		wr.close();

	}

}
