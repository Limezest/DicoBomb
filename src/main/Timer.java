package main;

public class Timer implements Runnable {
	private String myGame;
	
	public Timer(String myGame){
		this.myGame = myGame;
	}
	public void run() {
		int time = 5;
		while (time > 0){
			try {
				Thread.sleep(1000);
				time --;
				System.out.println("Restant "+time);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		GameManager.getItem(myGame).timeElapsed();
		System.out.println("TERMINE :"+myGame);
	}

}
