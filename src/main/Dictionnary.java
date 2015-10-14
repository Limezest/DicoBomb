package main;

import java.io.*;

public class Dictionnary {
	private String name;
	private String path;
	
	

	public Dictionnary(String name, String path) {
		this.name = name;
		this.path = path;
	}
	public boolean wordExiste(String word){
		boolean b=false;
		try{
			String dico_first_word = "src\\main\\"+path+'\\'+word.charAt(0)+".txt";
			System.out.println("chemin dico :" + dico_first_word);
			InputStream ips=new FileInputStream(dico_first_word); 
			InputStreamReader ipsr=new InputStreamReader(ips);
			BufferedReader br=new BufferedReader(ipsr);
			String ligne;
			while ((ligne=br.readLine())!=null){
				//
				
				if(ligne.compareToIgnoreCase(word)==0)
				{
					System.out.println(ligne);
					b= true;
				}
				
			}
			br.close(); 
		}		
		catch (Exception e){
			System.out.println(e.toString());
		}
		return b;
	}
	
	@Override
	public String toString() {
		return "Dictionnary [name=" + name + ", path=" + path + "]";
	}
	

	public static void main(String[] args) {
		
		Dictionnary monDico = new Dictionnary("dictionnaireFrançais","C:/");
		System.out.println(monDico);
	}

}
