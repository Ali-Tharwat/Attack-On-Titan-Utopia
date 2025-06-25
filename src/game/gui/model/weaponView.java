package game.gui.model;

import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import game.engine.base.Wall;
import game.engine.weapons.*;

public class weaponView {
	private Weapon weapon ;
	private VBox weaponContainer;
	private ImageView weaponImage;
	private Label infoBox ;
	
	public weaponView(Weapon weapon) {
        this.weapon = weapon;
        getView();
    }
	
	public Node getView() {
		 // Create a StackPane to hold the weapon, health bar, and health text
      StackPane stackPane = new StackPane();
      
      
		     weaponImage = new ImageView() ; 
		     
		     if (weapon instanceof VolleySpreadCannon ){
		     weaponImage.setImage( new Image("file:./src//game//gui//contentNeeded//images/VolleySpreadCannon2D.png")) ;}
		     
		     if (weapon instanceof SniperCannon ){
			     weaponImage.setImage( new Image("file:./src//game//gui//contentNeeded//images/SniperCannon2D.png")) ;}
		   
		     if (weapon instanceof PiercingCannon ){
			     weaponImage.setImage( new Image("file:./src//game//gui//contentNeeded//images/PiercingCannon2D.png")) ;}
		   
		     if (weapon instanceof WallTrap ){
			     weaponImage.setImage( new Image("file:./src//game//gui//contentNeeded//images/WallTrap2D.png")) ;}
      
		    weaponImage.setFitHeight(300) ; // Set the display size
		    weaponImage.setFitWidth(300);
	        stackPane.getChildren().addAll(weaponImage);

	        return stackPane;
  }
}
	 


