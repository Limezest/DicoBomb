package client;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Scanner;

import javax.swing.Timer;

/**
 * 
 * @classe Chronometre
 * 
 * @extends JPanel
 * 
 * @description Classe qui d�finit un chronometre
 * 
 */
public class Bomb implements Runnable {
	private Timer timer;
	private int tempsRestant;
	private int temps;
	private Scanner sc = new Scanner(System.in);
	private Thread t;

	public Bomb(int N) {
		timer = createTimer();
		timer.start();
		t = new Thread(new Bomb());
		t.start();
		this.setTempsRestant(N);
		this.setTemps(N);
	}

	public Bomb() {
		// TODO Auto-generated constructor stub
		int N =5;
		timer = createTimer();
		timer.start();
		t = new Thread(new Bomb());
		t.start();
		this.setTempsRestant(N);
		this.setTemps(N);
	}

	public void start() {
		timer.start();
	}

	public void stop() {
		timer.stop();
	}

	public boolean state() {
		return this.timer.isRunning();
	}

	private Timer createTimer() {
		ActionListener action = new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				if (tempsRestant > 0) {
					tempsRestant--;
					System.out.println("Temp restant :"+getTempsRestant());
				} else {
					timer.stop();
					System.out.println("BOOM");
				}
			}
		};
		return new Timer(1000, action);
	}

	public Timer getTimer() {
		return timer;
	}

	public void setTimer(Timer timer) {
		this.timer = timer;
	}

	public int getTempsRestant() {
		return tempsRestant;
	}

	public void setTempsRestant(int tempsRestant) {
		this.tempsRestant = tempsRestant;
	}

	public int getTemps() {
		return temps;
	}

	public void setTemps(int temps) {
		this.temps = temps;
	}

	public static void main(String[] args) {
		//new Bomb();
	}

	@Override
	public void run() {
		System.out.println("Ouverture du scanner");
		System.out.println("Jai lu :" + sc.nextLine());
	}

}