package main;

public class Main {

	public static void main(String[] args) {
		MessageHandler.messageHandler("user:newUser=benoit");
		MessageHandler.messageHandler("user:newUser=pierre");
		MessageHandler.messageHandler("user:newUser=lens");
		MessageHandler.messageHandler("user:newUser=cyril");
		MessageHandler.messageHandler("game:newGame=Partie1,Dico1");
		MessageHandler.messageHandler("game:joinGame=benoit,Partie1");
		MessageHandler.messageHandler("game:joinGame=pierre,Partie1");
		MessageHandler.messageHandler("game:joinGame=lens,Partie1");
		MessageHandler.messageHandler("game:joinGame=cyril,Partie1");
		MessageHandler.messageHandler("game:getList");
		MessageHandler.messageHandler("user:getList");
		MessageHandler.messageHandler("game:startGame=Partie1");
		while (true) 
		{
			GameManager.nextPlayer("Partie1");
		}
	}
}