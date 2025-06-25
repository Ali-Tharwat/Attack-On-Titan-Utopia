package game.gui.views;
import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.StrokeType;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.File;

public class gameStart {
    private VBox root;
    
    public gameStart() {
        root = new VBox();
        root.setAlignment(Pos.CENTER);
      
        // add custom font
        Font ditty = Font.loadFont("file:./src//game//gui//contentNeeded//fonts/Ditty-Rp72W.ttf", 45);
      
        //add background
        BackgroundImage myBI= new BackgroundImage(new Image("file:./src//game//gui//contentNeeded//images/start_screen.jpg",2667,2000,false,true),
		        BackgroundRepeat.ROUND, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT,
		          BackgroundSize.DEFAULT);
		root.setBackground(new Background(myBI));

        // Apply CSS styles to buttons
        String buttonStyle = "-fx-font-family: 'Ditty'; -fx-font-size: 130; -fx-background-color: transparent ;"
        		+ "-fx-text-fill: #edd6bf ;  -fx-effect: dropshadow( gaussian  , black , 10 , 1 , 2 , 0 )" ;
        
        // Create buttons
        Button startButton = createStyledButton("Start", buttonStyle);
        startButton.setOnAction(event ->{
        startView start = new startView();
        startButton.getScene().setRoot(start.getRoot());
        } ) ;
       
        
        Button descriptionButton = createStyledButton("Description", buttonStyle );
        descriptionButton.setStyle(" -fx-font-size: 90; -fx-background-color: transparent; -fx-text-fill: #edd6bf; -fx-font-family: 'ditty';"
        		+ "; -fx-effect: dropshadow( gaussian  , black , 10 , 1 , 2 , 0 )" );
        descriptionButton.setOnAction(event ->{
        	descriptionView description = new descriptionView();
        	descriptionButton.getScene().setRoot(description.getRoot());
            } ) ;
        
        
        Button settingsButton = createStyledButton("Settings", buttonStyle);
        settingsButton.setOnAction(event ->{
        	settingsView settings = new settingsView();
        	descriptionButton.getScene().setRoot(settings.getRoot());
            } ) ;
        
        Button creditsButton = createStyledButton("Credits", buttonStyle);
      
        creditsButton.setOnAction(event ->{
        	creditsView credits = new creditsView();
        	creditsButton.getScene().setRoot(credits.getRoot());
            } ) ;
        
        Button exitButton = createStyledButton("Exit", buttonStyle);
        
        exitButton.setOnAction(event -> Platform.exit());
     
        root.setOnKeyPressed(event -> {
            if (event.getCode() == KeyCode.ESCAPE) {
                Platform.exit();
            }
        });
       
        // Add buttons to root layout
        root.getChildren().addAll(startButton, descriptionButton, settingsButton, creditsButton, exitButton );
    
    }
    
    

    private Button createStyledButton(String text, String style) {
        Button button = new Button(text);
        
        button.setStyle(style);
        button.setTranslateY(320);
        
   
        return button;
    }
    

    public VBox getRoot() {
        return root;
    }
}