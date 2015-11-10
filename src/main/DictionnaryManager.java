package main;

import java.util.List;

public class DictionnaryManager {
	private static List<Dictionnary> dictionnaries;

	public DictionnaryManager(List<Dictionnary> dictionnaires) {
		//dictionnaries = dictionnaires;
	}

	@Override
	public String toString() {
		return "DictionnaryManager [dictionnaires=" + dictionnaries + "]";
	}

	public static boolean addItem(Dictionnary dico) {
		dictionnaries.add(dico);
		return dictionnaries.contains(dico);
	}

	public static boolean delItem(Dictionnary dico) {
		dictionnaries.remove(dico);
		return (!dictionnaries.contains(dico));
	}
	public static boolean itemExist(String diconame) {
//		String itemName;
//		for (User item : users) {
//			itemName = item.getName();
//			if (itemName.compareTo(username) == 0) {
//				return true;
//			}
//		}
		return dictionnaries.contains(getItem(diconame));
	}

	public static Dictionnary getItem(String diconame) {
		String itemName;
		for (Dictionnary item : dictionnaries) {
			itemName = item.getName();
			if (itemName.compareTo(diconame) == 0) {
				return item;
			}
		}
		return null;
	}

	
	public static void main(String[] args) {
		// Dictionnary monDico = new Dictionnary("dictionnaire
		// Fran�ais","dictionnaire");
		// System.out.println(monDico);
		// System.out.println(monDico.wordExiste("mouillera"));
		// System.out.println(monDico.genPattern());
	}
}