package game.gui.views;

import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.util.Pair;

public class startView {
	
	 private VBox root;
	
	 
	 public startView(){
		 
	 root = new VBox();
	 
	 
     root.setAlignment(Pos.CENTER);
     root.setSpacing(-100);
     
     
     BackgroundImage myBI= new BackgroundImage(new Image("file:./src//game//gui//contentNeeded//images/startGame_screen.jpg",3000,1950,false,true),
		        BackgroundRepeat.ROUND, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT,
		          BackgroundSize.DEFAULT);
		root.setBackground(new Background(myBI));


     String buttonStyle = "-fx-font-family: 'Ditty'; -fx-font-size: 200; -fx-text-fill: white ; -fx-background-color: transparent;"
        		+ " -fx-effect: dropshadow( gaussian  , black , 10 , 1 , 2 , 0 )" ;
     
     Button easyButton = createStyledButton("EASY", buttonStyle);
     easyButton.setOnAction(event ->{
    	
		try { StartEasy easy = new StartEasy();
			 easyButton.getScene().setRoot(easy.getRoot());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
         } ) ;
     
     Button hardButton = createStyledButton("HARD", buttonStyle) ;
     
     
     Button back = createStyledButton("Exit to Main Menu", buttonStyle) ;
     back.setOnAction(event ->{
     	gameStart menu = new gameStart();
     	back.getScene().setRoot(menu.getRoot());
         } ) ;
     
     
     root.getChildren().addAll(easyButton, hardButton, back);
     
	 }
     
	 private Button createStyledButton(String text, String style) {
	        Button button = new Button(text);
	      
	        button.setStyle(style);
	        button.setTranslateY(250);
	   
	        return button;
	    }

	public Parent getRoot() {
		
		return root;
	}

}
