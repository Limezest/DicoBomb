package main;

public class Dictionnary {
	String name;
	String path;
	

	public Dictionnary(String name, String path) {
		this.name = name;
		this.path = path;
	}

	
	@Override
	public String toString() {
		return "Dictionnary [name=" + name + ", path=" + path + "]";
	}


	public static void main(String[] args) {
		
		Dictionnary monDico = new Dictionnary("dictionnaire Français","C:/");
		System.out.println(monDico);
	}

}
