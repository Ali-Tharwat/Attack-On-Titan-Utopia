package game.gui.model;
import java.util.stream.Collectors;

import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.layout.HBox;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.StrokeType;
import game.engine.lanes.Lane;
import game.engine.titans.Titan;
import game.engine.weapons.Weapon;

public class laneView {
    private Lane lane;
    private StackPane laneContainer;
    private Rectangle laneGraphic;
    private wallView WallView; // Include wall view
    
    private HBox weaponDisplay;
    private HBox titanDisplay;
    
    private Label dangerLevelLabel;
    private boolean selected = false;

    public laneView(Lane lane) {
        this.lane = lane;
        createLaneView();
    }

    private void createLaneView() {
        laneContainer = new StackPane();
        laneContainer.setAlignment(Pos.CENTER);

        // Lane graphic setup
        laneGraphic = new Rectangle(2970, 585);
        laneGraphic.setFill(new ImagePattern(new Image("file:./src/game/gui/contentNeeded/images/lane.jpg")));

        weaponDisplay= new HBox();
        weaponDisplay.setAlignment(Pos.CENTER);
        updateWeaponsDisplay(); 
       
        // Titan display setup
        // Titan display setup
        titanDisplay = new HBox();  // Space between titan views
       

        
        
        
        this.WallView = new wallView(lane.getLaneWall());
        Node wallViewNode = this.WallView.getView();
        wallViewNode.setTranslateX(-1220);

        // Danger level label
        dangerLevelLabel = new Label("Danger Level: " + lane.getDangerLevel());
        dangerLevelLabel.setStyle("-fx-font-size: 90px; -fx-effect: dropshadow(gaussian, black, 5, 1, 2, 0);");
        dangerLevelLabel.setAlignment(Pos.TOP_CENTER); dangerLevelLabel.setTextFill(Color.WHITE);
        dangerLevelLabel.setTranslateY(-250);
        
        laneContainer.getChildren().addAll( laneGraphic, dangerLevelLabel , wallViewNode , weaponDisplay, titanDisplay);
         updateTitansDisplay(); 
    }
    
    private void updateTitansDisplay() {
        titanDisplay.getChildren().clear();  // Clear previous views
        for (Titan titan : lane.getTitans()) {
            TitanView titanView = new TitanView(titan);
            titanDisplay.getChildren().add(titanView.getView());
        }
    } 

  

   
    public Node getView() {
        return laneContainer;
    }

    public void updateView() {
        dangerLevelLabel.setText("Danger Level: " + lane.getDangerLevel());
        updateWeaponsDisplay();  
       // updateTitansDisplay(); // Refresh Titan display
    }
    public void updateWallHealth() {
        if (WallView != null) {
            WallView.updateHealth();
        }
    }
    
    private void updateWeaponsDisplay() {
        weaponDisplay.getChildren().clear(); // Clear previous weapon views
        for (Weapon weapon : lane.getWeapons()) {
            weaponView weaponView = new weaponView(weapon);
            weaponDisplay.getChildren().add(weaponView.getView());
        }
    }

	public void setSelected(boolean b) {
		selected = b ;
		
	}
	 public void updateVisuals() {
	        if (selected) {
	        	laneGraphic.setStroke(Color.GREEN);
	        	laneGraphic.setStrokeWidth(20);
	        	laneGraphic.setStrokeType(StrokeType.OUTSIDE);
	        } else {
	        	laneGraphic.setStroke(null);
	        }
	        if (lane.isLaneLost()) {
	        	Rectangle lostLane = new Rectangle(2970, 585);
	        	lostLane.setFill(new Color(0.1, 0.1, 0.1, 0.5));  // Grey color with 50% opacity
	        	laneContainer.getChildren().add(lostLane) ;
	        }
	    }

	public Lane getLane() {
		return lane;
	}
}