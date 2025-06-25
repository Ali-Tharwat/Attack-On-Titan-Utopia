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
import javafx.scene.layout.VBox;

public class descriptionView {
 private VBox root;
	 
	 public descriptionView(){
	 root = new VBox();
     root.setAlignment(Pos.CENTER);
     
     
     
     BackgroundImage myBI= new BackgroundImage(new Image("file:./src//game//gui//contentNeeded//images/description.jpg",2667,2000,false,true),
		        BackgroundRepeat.ROUND, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT,
		          BackgroundSize.DEFAULT);
		root.setBackground(new Background(myBI));


     String buttonStyle = "-fx-font-family: 'Ditty'; -fx-font-size: 150; -fx-text-fill: white ; -fx-background-color: transparent;"
        		+ " -fx-effect: dropshadow( gaussian  , black , 10 , 1 , 2 , 0 )" ;
     
     Button about = createStyledButton("About", buttonStyle);
     about.setOnAction(event ->{
    	 descriptionView_About A = new descriptionView_About();
      	about.getScene().setRoot(A.getRoot());
          } ) ;
     
     Button battleSetting = createStyledButton("Battle Setting", buttonStyle);
     battleSetting.setOnAction(event ->{
    	 descriptionView_Battle B = new descriptionView_Battle();
      	battleSetting.getScene().setRoot(B.getRoot());
          } ) ;
     Button titansInfo = createStyledButton("Titans Info", buttonStyle) ;
     Button weaponsInfo = createStyledButton("Weapons Info", buttonStyle) ;
     Button gameRules =  createStyledButton("Game Rules", buttonStyle) ;
     
     Button back = createStyledButton("Exit to Main Menu", buttonStyle) ;
     back.setOnAction(event ->{
     	gameStart menu = new gameStart();
     	back.getScene().setRoot(menu.getRoot());
         } ) ;
     
     
     root.getChildren().addAll(about, battleSetting , titansInfo , weaponsInfo ,gameRules , back);
	 }
     
	 private Button createStyledButton(String text, String style) {
	        Button button = new Button(text);
	      
	        button.setStyle(style);
	        return button;
	    }

	public Parent getRoot() {
		
		return root;
	}

}


	

