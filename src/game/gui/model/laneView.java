package game.gui.model;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Region;
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
    private GridPane laneGrid;
    
    private wallView WallView ;
    private GridPane weaponDisplay ;// displays weapons
    private HBox titanDisplay;  // HBox to hold titan views
    private int n ;
   
    
    private double x ;
    private Label dangerLevelLabel;
    private boolean selected = false;

    public laneView(Lane lane, double X,int N) {
        this.lane = lane;
        n = N ;
       x = X ;
        createLaneView();
        // Ensure initial display is correct
       
        updateWallHealth();
    }

    private void createLaneView() {
        laneGrid = new GridPane(); 
        setBackground(laneGrid);
     
     // Set preferred size
        laneGrid.setPrefSize(2870, 600/x);  // Preferred width = 2870 height = 685

        // Setup for the wall view
        WallView = new wallView(lane.getLaneWall(), x);
        laneGrid.add(WallView.getView(), 0, 0);  // Wall in the first column
     
        // Weapon display setup as a GridPane
        weaponDisplay = new GridPane();
        weaponDisplay.setHgap(10); // Horizontal gap between cells
        weaponDisplay.setVgap(10); // Vertical gap between cells
        updateWeaponsDisplay();
        weaponDisplay.setTranslateY(-30);
        weaponDisplay.setAlignment(Pos.BOTTOM_RIGHT);
        laneGrid.add(weaponDisplay, 1, 0);
        
        // Titan display setup
        titanDisplay = new HBox(10);  // Spacing between titan views
        titanDisplay.setAlignment(Pos.BOTTOM_LEFT);  // Align titans from left to right
        updateTitansDisplay();
        titanDisplay.setTranslateX(n);
        laneGrid.add(titanDisplay, 4, 0);  // Titans in the last column
        
        // Initialize danger level label
        dangerLevelLabel = new Label("Danger Level: " + lane.getDangerLevel());
        laneGrid.add(dangerLevelLabel,3, 0);  // Initial position for titans, dynamically updated

        updateWallHealth();
    }


    private void setBackground(GridPane gridPane) {
        // Load the image from the specified path
        Image backgroundImage = new Image("file:./src/game/gui/contentNeeded/images/lane.jpg");
        
        // Create a BackgroundImage object
        BackgroundImage bgImage = new BackgroundImage(
            backgroundImage, 
            BackgroundRepeat.ROUND,  // Adjust as necessary if you want the image to repeat
            BackgroundRepeat.ROUND , 
            BackgroundPosition.DEFAULT, 
            BackgroundSize.DEFAULT
        );
        
        // Set the background of the gridPane
        gridPane.setBackground(new Background(bgImage));
    }

   
    public Node getView() {
        return laneGrid;
    }

    public void updateLaneInfo() {
        dangerLevelLabel.setText("Danger Level: " + lane.getDangerLevel());
        // Consider calling updateWeaponsDisplay() here if weapon status changes
    }

    public void updateWallHealth() {
         {
            WallView.updateHealth();
        }
    }
    
   
	public void setSelected(boolean b) {
		selected = b ;
		
	}
	
	
	public void updateWeaponsDisplay() {
	    weaponDisplay.getChildren().clear(); // Clear previous weapon views

	    final int maxColumns = 3; // Maximum number of columns
	    List<Weapon> weapons = new ArrayList<>(lane.getWeapons());
	    int totalWeapons = weapons.size();
	    int totalRows = (int) Math.ceil(totalWeapons / (double) maxColumns); // Calculate the total rows needed

	    for (int i = 0; i < weapons.size(); i++) {
	        Weapon weapon = weapons.get(i);
	        weaponView weaponView = new weaponView(weapon,x);

	        // Calculate column and row
	        int column = i % maxColumns;
	        int row = totalRows - 1 - (i / maxColumns); // Reverse the row order

	        // Add the weapon view to the grid
	        weaponDisplay.add(weaponView.getView(), column, row);
	    }
	}

	public void updateTitansDisplay() {
	    titanDisplay.getChildren().clear();  // Clear previous titan views
	    for (Titan titan : lane.getTitans()) {
	        TitanView titanView = new TitanView(titan, x);  // Assuming a constructor that takes a Titan
	        titanDisplay.getChildren().add(titanView.getView());
	    }
	    
	    // Calculate the intended translation
	    double intendedTranslateX = 2000 - 250 * lane.getTitans().size();
	    
	    // Determine the maximum translateX allowed to keep titans on the screen
	    // Assuming 2000 is the width of your screen or window where the laneGrid is being displayed
	    double maxTranslateX = 0; // Modify this value based on your screen or window width
	    
	    // Apply the smaller (more leftward) of the calculated translate or the maximum allowed
	    titanDisplay.setTranslateX(Math.max(intendedTranslateX, maxTranslateX));
	}



	public void updateVisuals() {
	    // Update border based on selection
	    if (selected) {
	        laneGrid.setStyle("-fx-border-color: green; -fx-border-width: 20; -fx-border-style: solid outside;");
	    } else {
	        laneGrid.setStyle("-fx-border-color: transparent;");
	    }

	    // Handle lane lost status by applying a semi-transparent overlay
	    final String overlayStyle = "-fx-background-color: rgba(25, 25, 25, 0.5);";  // Semi-transparent dark overlay
	    if (lane.isLaneLost()) {
	        // Create an overlay if not already present
	        if (!laneGrid.getStyle().contains(overlayStyle)) {
	            laneGrid.setStyle(laneGrid.getStyle() + overlayStyle);
	        }
	    } else {
	        // Remove the overlay if lane is not lost anymore
	        String style = laneGrid.getStyle().replace(overlayStyle, "");
	        laneGrid.setStyle(style);
	    }
	}


	
	public Lane getLane() {
		return lane;
	}
}