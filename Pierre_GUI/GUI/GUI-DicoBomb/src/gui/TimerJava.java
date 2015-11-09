package gui;

import java.awt.event.*;
import javax.swing.*;

public class TimerJava {
    public static Thread t1;

    public static void main(String [] args) throws Exception{

        System.out.println("Début de la bombe");

        ActionListener taskPerformer = new ActionListener() {
            public void actionPerformed(ActionEvent evt) {


                System.out.println("La bombe a explosé");
            }
        };

        int maximum = 35;
        int minimum = 45;
        int time = minimum + (int)(Math.random()* ((maximum - minimum) + 1)); ;

        System.out.println(time + " secondes");

        Timer timer = new Timer(time*1000 ,taskPerformer);
        timer.setRepeats(true);

		t1 = new Thread(timer.start());
		t1.start();
    }
}
