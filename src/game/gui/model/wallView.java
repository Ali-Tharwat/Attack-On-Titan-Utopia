package game.gui.model;

import javafx.scene.Node;
import javafx.scene.control.ProgressBar;
import javafx.scene.image.Image;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import game.engine.base.Wall;
import game.engine.lanes.Lane;

public class wallView {
	private Wall wall ;
	 private ProgressBar healthBar = new ProgressBar();
	    private Text healthText = new Text();
	
	public wallView(Wall wall) {
        this.wall = wall;
        updateHealth();
    }
	
	public Wall getWall() {
		return wall;
	}

	public Node getView() {
		 // Create a StackPane to hold the wall rectangle, health bar, and health text
       StackPane stackPane = new StackPane();
       
       // Create a Rectangle as the graphical representation of the wall
		 Rectangle wallSQUARE = new Rectangle(550 , 550);
		    Image wallImage = new Image("file:./src//game//gui//contentNeeded//images/wall.png");
		    ImagePattern imagePattern = new ImagePattern(wallImage);
		    wallSQUARE.setFill(imagePattern); // Set image
       
       
		 // Create a ProgressBar to represent the health bar
	        ProgressBar healthBar = new ProgressBar();
	        healthBar.setPrefWidth(135); // Set width equal to the wall side length
	        healthBar.setProgress((double) wall.getCurrentHealth() / wall.getBaseHealth()); // Set progress based on health percentage
	        healthBar.setStyle("-fx-accent: green;"); // Set progress color to green
	        healthBar.setTranslateX(-50);healthBar.setTranslateY(-220);

	        // Create a Text node to display the current health value
	        Text healthText = new Text(String.valueOf(wall.getCurrentHealth()));
	        healthText.setFill(Color.BLACK);
	        healthText.setTranslateX(-50);healthText.setTranslateY(-220);
	        healthText.setFont(Font.font(40));
	        
	        
	     // Add the wall rectangle, health bar, and health text to the StackPane
	        stackPane.getChildren().addAll(wallSQUARE, healthBar, healthText);
	        updateHealth();
	        return stackPane;
   }
	
	public void updateHealth() {
        healthBar.setProgress(wall.getCurrentHealth() / (double) wall.getBaseHealth());
        healthText.setText("" + wall.getCurrentHealth() );
    }
	
	
	
}
