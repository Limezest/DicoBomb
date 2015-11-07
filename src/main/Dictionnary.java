package main;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Dictionnary implements java.io.Serializable {
	private static final long serialVersionUID = 2940976109874271907L;
	private String name;
	private String path;
	private String osType_slash;
	private String currentPattern;
	private ArrayList<String> usedWords;
	
	private String getPattern(String word) {
		String pattern;
		int nb_char_pattern = 2 + (int) (Math.random() * (3));
		int randomNum = 0 + (int) (Math.random() * (word.length() - 4));
		pattern = word.substring(randomNum, randomNum + nb_char_pattern);
		return pattern;
	}

	
	public Dictionnary(String name, String path) {
		this.name = name;
		this.path = path;
		this.usedWords = new ArrayList<String>();
		//Gestion des differents syst�mes d'exploitation
		if (System.getProperty("os.name").contains("Windows")) {
			this.osType_slash = "\\";
		} else {
			this.osType_slash = "/";
		}
	}
	
	public String getName(){
		return this.name;
	}
	
	public String getCurrentPattern(){
		return this.currentPattern;
	}
	
	public ArrayList<String> getUsedWords(){
		return this.usedWords;
	}
	public boolean wordExiste(String word) {
		try {
			String dico_first_word = path + osType_slash + word.charAt(0) + ".txt";
			String ligne;
			InputStream ips = new FileInputStream(dico_first_word);
			InputStreamReader ipsr = new InputStreamReader(ips);
			BufferedReader br = new BufferedReader(ipsr);
			
			// System.out.println("chemin dico :" + dico_first_word);
			while ((ligne = br.readLine()) != null) {
				if (ligne.compareToIgnoreCase(word) == 0 && ligne.contains(currentPattern) && (!usedWords.contains(word))) {
					usedWords.add(word);
					br.close();
					return true;
				}
				br.close();
			}
			
		} catch (Exception e) {
			System.out.println(e.toString());
		}
		return false;
	}

	public boolean isUsedWord(String word) {
		if (usedWords.contains(word)){return true;} else {return false;}
	}
	
	public String genPattern() {
		int randomNum = 0 + (int) (Math.random() * 25); // génération du
														// nombre aleatoire
														// correspondant au nom
														// du dico
		/* Generation de l'alphabet */
		String first_word = "";
		for (int i = 0; i < 26; i++) {
			first_word += ((char) (97 + i));
		}
		int nb_mot = 0;
		List<String> liste_mots = new ArrayList<String>();
		try {
			String dico_first_word = this.path + osType_slash + first_word.charAt(randomNum) + ".txt";
			// System.out.println("chemin dico :" + dico_first_word);
			InputStream ips = new FileInputStream(dico_first_word);
			InputStreamReader ipsr = new InputStreamReader(ips);
			BufferedReader br = new BufferedReader(ipsr);
			String ligne;
			while ((ligne = br.readLine()) != null) {
				liste_mots.add(ligne);
				nb_mot++;
			}
			br.close();
		} catch (Exception e) {
			System.out.println(e.toString());
		}
		randomNum = 0 + (int) (Math.random() * (nb_mot - 1));
		liste_mots.get(randomNum);
		while (liste_mots.get(randomNum).length() < 3) {
			randomNum = 0 + (int) (Math.random() * (nb_mot - 1));
		}
		this.currentPattern = getPattern(liste_mots.get(randomNum));
		return this.currentPattern;
	}
	@Override
	public String toString() {
		return "Dictionnary [name=" + name + ", path=" + path + "]";
	}

}