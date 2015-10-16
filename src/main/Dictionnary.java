package main;

import java.io.*;
import java.util.ArrayList;

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
	public String genPattern(){
		int randomNum = 0 + (int)(Math.random()*25); 
		String first_word = "";
		for (int i = 0; i < 26; i++) {
			first_word = (String)(97 + i);
		}
		ArrayList<String> liste_mots;
		try{
			
			String dico_first_word = "src\\main\\"+path+'\\'+word.charAt(0)+".txt";
			System.out.println("chemin dico :" + dico_first_word);
			InputStream ips=new FileInputStream(dico_first_word); 
			InputStreamReader ipsr=new InputStreamReader(ips);
			BufferedReader br=new BufferedReader(ipsr);
			String ligne;
			while ((ligne=br.readLine())!=null){
				liste_mots.add(ligne);		
			}
			br.close(); 
		}		
		catch (Exception e){
			System.out.println(e.toString());
		}
		return liste_mots.get(randomNum);
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
