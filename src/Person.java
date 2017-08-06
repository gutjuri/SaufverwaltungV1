import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Person {
	String name;
	double guth;
	int statsAlk;
	int statsAnt;
	
	public Person(String name, double guth){
		this.name = name;
		this.guth = guth;
	}
	
	/** statistiken für person einlesen */
	public void setstats(){
		Path p = Paths.get("stats.txt");
		String pfad = p.toString();
		BufferedReader b = null;
		try {
			b = new BufferedReader(new FileReader(pfad));
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		String wort = "";
		while(wort != null){
			
			if(wort.startsWith(name)){
				statsAlk = Integer.parseInt(wort.substring(wort.indexOf(' ')+1, wort.lastIndexOf(' ')));
				statsAnt = Integer.parseInt(wort.substring(wort.lastIndexOf(' ')+1));
				return;
			}
			try {
				wort = b.readLine();
			}catch(IOException e){
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		statsAlk = 0;
		statsAnt = 0;
	}
	
	
}
