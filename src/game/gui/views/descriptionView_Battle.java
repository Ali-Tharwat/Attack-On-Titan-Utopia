package game.gui.views;

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
import javafx.scene.text.Text;

public class descriptionView_Battle {
	private VBox root;
	public descriptionView_Battle(){
		 root = new VBox();
		 root.setSpacing(50);
	  
	     
	     
	     
	     BackgroundImage myBI= new BackgroundImage(new Image("file:./src//game//gui//contentNeeded//images/description_battle.jpg",2500,2000,false,true),
			        BackgroundRepeat.ROUND, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT,
			          BackgroundSize.DEFAULT);
	     
			root.setBackground(new Background(myBI));

			Text a = new Text("The battlefield is divided into multiple lanes, each lane will have the following:") ;
			a.setTranslateY(100); a.setStyle("-fx-font-family: 'fantasy'; -fx-font-size: 60 ; -fx-fill: white;-fx-font-weight : bold");
			a.setStroke(Color.BLACK); a.setStrokeWidth(1); 
			
			Text b = new Text("1. A part of the wall to be defended. This wall part will have a starting HP (health points) that decreases after being \n attacked and if this part of the wall is destroyed  , this lane will no longer be considered an active lane and will be a lost lane.");
			b.setTranslateY(100); b.setStyle("-fx-font-family: 'fantasy'; -fx-font-size: 50 ; -fx-fill: white;-fx-font-weight : bold");
			b.setStroke(Color.BLACK); b.setStrokeWidth(1);  b.setTranslateX(50);
			
			Text c = new Text("2. The weapons that the player has already deployed into this lane");
			c.setTranslateY(100); c.setStyle("-fx-font-family: 'dutch'; -fx-font-size: 55 ; -fx-fill: white;-fx-font-weight : bold");
			c.setStroke(Color.BLACK); c.setStrokeWidth(1); c.setTranslateX(50);
			
			Text d = new Text("3. The titans that are on their way to attack the part of the wall at the end of the lane. \n The titans can be at different distances from the walls depending on how much they have already moved.\n Each titan will have a starting HP  (health points) that decreases after being attacked.");
			d.setTranslateY(100); d.setStyle("-fx-font-family: 'fantasy'; -fx-font-size: 55 ; -fx-fill: white;-fx-font-weight : bold");
			d.setStroke(Color.BLACK); d.setStrokeWidth(2); d
			.setTranslateX(50);
			
			Text f = new Text("Each lane will have a danger level that can be calculated based on the number and types of titans inside this lane. ");
			f.setTranslateY(100); f.setStyle("-fx-font-family: 'dutch'; -fx-font-size: 50 ; -fx-fill: white; -fx-font-weight : bold");
			f.setStroke(Color.BLACK); f.setStrokeWidth(2.7);
			
			Text e = new Text("The Battle has 3 phases depending on the number of turns that already passed: \n Early, Intense, Grumbling.");
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
		     
			root.getChildren().addAll(a, b , c, d ,f ,e, back) ;
	}

		public Parent getRoot() {
			
			return root;
		}
	}

