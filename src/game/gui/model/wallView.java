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
	private StackPane stackPane ;
	 private ProgressBar healthBar ;
	    private Text healthText ;
	    private double x ;
	
	    public wallView(Wall wall, double X) {
	        this.wall = wall;
	        x = X ;
	        createView();  // Make sure createView setups everything correctly
	        updateHealth();  // Initial health update
	    }
	
	public Wall getWall() {
		return wall;
	}

	private void createView() {
        stackPane = new StackPane();

        Rectangle wallSquare = new Rectangle(550/x, 550/x);
        Image wallImage = new Image("file:./src/game/gui/contentNeeded/images/wall.png");
        ImagePattern imagePattern = new ImagePattern(wallImage);
        wallSquare.setFill(imagePattern);

        // Create a ProgressBar to represent the health bar
        healthBar = new ProgressBar();
        healthBar.setPrefWidth(135/x); // Set width equal to the wall side length
        healthBar.setProgress((double) wall.getCurrentHealth() / wall.getBaseHealth()); // Set progress based on health percentage
        healthBar.setStyle("-fx-accent: green;"); // Set progress color to green
        healthBar.setTranslateX(-50/x);healthBar.setTranslateY(-220/x);

        // Create a Text node to display the current health value
        healthText = new Text(String.valueOf(wall.getCurrentHealth()));
        healthText.setFill(Color.BLACK);
        healthText.setTranslateX(-50/x);healthText.setTranslateY(-220/x);
        healthText.setFont(Font.font(40/x));

        stackPane.getChildren().addAll(wallSquare, healthBar, healthText);
    }
	
	 public void updateHealth() {
	        double progress = (double) wall.getCurrentHealth() / wall.getBaseHealth();
	        healthBar.setProgress(progress);
	        healthText.setText("" + wall.getCurrentHealth());
	    }

	public StackPane getView() {
		return stackPane;
	}
	
	
	
}
