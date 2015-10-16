package main;

public class MessageHandler {
	private static String order;
	private static String parameter;
	
	public static void messageHandler(String message){
		if (message.contains("=")){
			order = (message.split("="))[0];
			parameter = (message.split("="))[1]; 
		}else {order=message;}
		switch (order) {
        	case "user:newUser" :  UserManager.addItem(parameter);
                break;
        	case "user:quit" 	:  UserManager.delItem(parameter);
         		break;
        	case "user:getList" :  System.out.println(UserManager.getItems());
         		break;
        	case "game:newGame" :  GameManager.addItem(parameter);
         		break;
        	case "game:delGame" :  GameManager.delItem(parameter);
         		break;
        	case "game:getList" :  System.out.println(GameManager.getItems());
         		break;
        	case "game:joinGame" :  GameManager.joinGame((parameter.split(","))[0], (parameter.split(","))[1]);
         		break;
        	case "game:quitGame" :  GameManager.quitGame((parameter.split(","))[0], (parameter.split(","))[1]);
         		break;
        	case "game:startGame" :  GameManager.startGame(parameter);
     			break;
        	case "send:word" 	:  UserManager.addItem(parameter);
         		break;
		}
	}
}
