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
	public boolean addDictionnary(Dictionnary dico)
	{
		boolean b = false;
		this.dictionnaries.add(dico);
		if (this.dictionnaries.contains(dico))
		{
			b= true;
		}
		return b;
	}
	public boolean deleteDictionnary(Dictionnary dico)
	{
		this.dictionnaries.remove(dico);
		return (!this.dictionnaries.contains(dico));
		
	}

	public static void main(String[] args) {
		
		Dictionnary monDico = new Dictionnary("dictionnaire Français","dictionnaire");
		System.out.println(monDico);
		
		System.out.println(monDico.wordExiste("mouillera"));
	}
	
	

}
