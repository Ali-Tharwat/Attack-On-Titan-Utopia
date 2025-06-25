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
import javafx.scene.paint.Color;
import javafx.scene.shape.StrokeType;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class creditsView {
 private VBox root;
	 
	 public creditsView(){
	 root = new VBox();
     root.setAlignment(Pos.CENTER);
     root.setSpacing(50);
     
     
     BackgroundImage myBI= new BackgroundImage(new Image("file:./src//game//gui//contentNeeded//images/credits_screen.jpeg",2667,2000,false,true),
		        BackgroundRepeat.ROUND, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT,
		          BackgroundSize.DEFAULT);
		root.setBackground(new Background(myBI));


     
     
     Text creditsText = new Text("Ali Tharwat \n Yassin Ebaid \n Eslam Alaa");
     creditsText.setStyle("-fx-font-family: 'ditty'; -fx-font-size: 180 ; -fx-fill: white;");;
     creditsText.setStroke(Color.BLACK); creditsText.setStrokeWidth(3); creditsText.setStrokeType(StrokeType.OUTSIDE);
     
     Button back = new Button("Exit to Main Menu") ;
     back.setStyle("-fx-font-family: 'Ditty'; -fx-font-size: 200; -fx-text-fill: white ; -fx-background-color: transparent;"
     		+ " -fx-effect: dropshadow( gaussian  , black , 10 , 1 , 2 , 0 )" );
     back.setOnAction(event ->{
     	gameStart menu = new gameStart();
     	back.getScene().setRoot(menu.getRoot());
         } ) ;
     
     
     root.getChildren().addAll(creditsText,back);
	 }
     
	 


	public Parent getRoot() {
		
		return root;
	}

}
