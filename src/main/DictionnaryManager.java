package main;

import java.util.List;

public class DictionnaryManager {
	private List<Dictionnary> dictionnaries;

	public DictionnaryManager(List<Dictionnary> dictionnaires) {
		this.dictionnaries = dictionnaires;
	}

	@Override
	public String toString() {
		return "DictionnaryManager [dictionnaires=" + dictionnaries + "]";
	}
	
	

	public static void main(String[] args) {
		
		Dictionnary monDico = new Dictionnary("dictionnaire Fran�ais","C:/");
		System.out.println(monDico);
	}
	
	

}
