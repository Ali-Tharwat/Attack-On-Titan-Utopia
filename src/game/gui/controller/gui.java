package game.gui.controller;

import game.engine.Battle;
import game.gui.views.*;
import javafx.application.*;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;
import javafx.stage.Window;

public class gui extends Application{
	
	private gameOpen GameOpen = new gameOpen();
	private gameStart GameStart  = new gameStart();;
	

	private startView start = new startView();
	private descriptionView description = new descriptionView();
	private settingsView settings = new settingsView();
	private creditsView credits  = new creditsView();
	
	private Stage stage;
	private Scene s ;
	
	

	@Override
	public void start(Stage primaryStage) throws Exception {
		
		stage= primaryStage ;
		stage.setMaximized(true);
		stage.setTitle("Attack on Titan: Utopia");
		stage.setResizable(false);
	    Scene s = new Scene( GameOpen.getRoot(), 3000, 2000);
	    stage.getIcons().add(new Image("file:./src//game//gui//contentNeeded//images/icon.jpg"));
	    stage.setScene(s);
	    stage.show();
	    GameOpen.requestFocus();
	    
	    
	}

	
	public Stage getStage() {
		return stage;
	}
	
	public Scene getS() {
		return s;
	}

	public static void main (String[]args){
	    
		launch(args);}
}
