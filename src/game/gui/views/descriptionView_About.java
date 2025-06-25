package game.gui.views;

import java.awt.Font;

import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.StrokeType;
import javafx.scene.text.Text;

public class descriptionView_About {
 private VBox root;
	 
	 public descriptionView_About(){
	 root = new VBox();
	 root.setSpacing(50);
  
     
     
     
     BackgroundImage myBI= new BackgroundImage(new Image("file:./src//game//gui//contentNeeded//images/about.jpeg",2500,2000,false,true),
		        BackgroundRepeat.ROUND, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT,
		          BackgroundSize.DEFAULT);
     
		root.setBackground(new Background(myBI));

		Text a = new Text("Attack on Titan: Utopia is a one-player, Tower-Defense * ENDLESS** game.") ;
		a.setTranslateY(100); a.setStyle("-fx-font-family: 'fantasy'; -fx-font-size: 60 ; -fx-fill: white;-fx-font-weight : bold");
		a.setStroke(Color.BLACK); a.setStrokeWidth(1); 
		
		Text b = new Text("Inspired by the hit anime <Attack on Titan>. The anime story revolves around how titans, gigantic humanoid creatures, \n emerged one day and wiped out most of humanity.  The few surviving humans fled and hid behind 3 great walls \n that provided safe haven from the titan threats. \n Wall Maria is the outer wall, Wall Rose is the middle wall  and Wall Sina is the inside wall.");
		b.setTranslateY(100); b.setStyle("-fx-font-family: 'fantasy'; -fx-font-size: 55 ; -fx-fill: white;-fx-font-weight : bold");
		b.setStroke(Color.BLACK); b.setStrokeWidth(1); 
		
		Text c = new Text("This game takes place in an imaginary scenario where the Titans have breached their way throughout Wall Maria \n and reached the northern border of Wall Rose at the Utopia District. The human forces stationed in Utopia \n engage the Titans in battle for one last hope of preventing the Titans from breaching Wall Rose. The humans fight \n by deploying different types of Anti-Titan weapons in order to stop the Titan’s onslaught \n and keep Utopia’s (and Wall Rose’s) walls safe.");
		c.setTranslateY(100); c.setStyle("-fx-font-family: 'fantasy'; -fx-font-size: 55 ; -fx-fill: white;-fx-font-weight : bold");
		c.setStroke(Color.BLACK); c.setStrokeWidth(1);
		
		Text d = new Text("* Tower Defense Games: is a type of game where the player controls a base and the objective \n is to continue defending  this base from incoming enemies by deploying some \n weapons/tools to get rid of these enemies. In our case, the base we need to protect is the Utopia District Walls.");
		d.setTranslateY(100); d.setStyle("-fx-font-family: 'fantasy'; -fx-font-size: 65 ; -fx-fill: white;-fx-font-weight : bold");
		d.setStroke(Color.BLACK); d.setStrokeWidth(2);
		
		Text e = new Text("** ENDLESS: it means that the game will have no winning condition and the player will \n keep playing and defeat as many enemies as possible.");
		e.setTranslateY(100); e.setStyle("-fx-font-family: 'fantasy'; -fx-font-size: 70 ; -fx-fill: white; -fx-font-weight : bold");
		e.setStroke(Color.BLACK); e.setStrokeWidth(3);
		
		Button back = new Button("Back to Description") ;
		back.setStyle("-fx-font-family: 'Ditty'; -fx-font-size: 200; -fx-text-fill: white ; -fx-background-color: transparent;"
	     		+ " -fx-effect: dropshadow( gaussian  , black , 10 , 1 , 2 , 0 )" );
		back.setTranslateX(700);
	     back.setOnAction(event ->{
	     	descriptionView menu = new descriptionView();
	     	back.getScene().setRoot(menu.getRoot());
	         } ) ;
	     
		root.getChildren().addAll(a, b , c, d ,e, back) ;
}

	public Parent getRoot() {
		
		return root;
	}
}
