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
			InputStream ips=new FileInputStream(path); 
			InputStreamReader ipsr=new InputStreamReader(ips);
			BufferedReader br=new BufferedReader(ipsr);
			String ligne;
			while ((ligne=br.readLine())!=null){
				if(ligne==word)
				{
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
