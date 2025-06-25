package game.gui.views;



import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Separator;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import game.engine.Battle;
import game.engine.exceptions.InvalidLaneException;
import game.engine.lanes.Lane;
import game.engine.titans.Titan;
import game.engine.weapons.Weapon;
import game.gui.model.TitanView;
import game.gui.model.laneView;
import game.gui.model.wallView;

 public class StartEasy  extends Start{
	
	private Battle battle  ;
	 
	private int selectedLaneIndex ;
	private BorderPane root ;
	
	private HBox infoBox ;
	private VBox lanes ;
	
	private VBox titans ;
	
	private ArrayList<laneView> laneViews = new ArrayList<>();
	
	private ArrayList<TitanView> titanViews = new ArrayList<>();
	
    private StackPane layeredPane;
    
    private Label scoreLabel ;
    private Label resourcesLabel ;
    private Label selectedLane ;
    private Label turnLabel  ;
    private Label phaseLabel ;
	
    
	public StartEasy() throws IOException{
		 battle  = new Battle(1,0,2500,3,250) ;
		selectedLaneIndex = 2;
		super.setBattle(battle);
		weaponShopView weaponShop = new weaponShopView(this);
		root = new BorderPane();
	    root.setPadding(new Insets(10));

	    layeredPane = new StackPane();
	    
	    layeredPane.setPadding(new Insets(10));
	    root.getChildren().addAll(layeredPane);
	 // Call updateLaneSelection after UI setup
	  
	    initializeUI() ;
	    initializeGame(); 
	    super.setSelectedLaneIndex(selectedLaneIndex);
		 root.setOnKeyPressed(event -> handleKeyPress(event));
	}
	
	private void initializeUI() {
        root = new BorderPane();
        

        infoBox = createInfoBox();
        root.setTop(infoBox);

        lanes = createLanesView();
        root.setCenter(lanes);
        
        
        //titans = createTitansView();
      //  root.getChildren().add(titans);
       // titans.setAlignment(Pos.TOP_RIGHT);
        
    } 
	
	
	private void initializeGame() {
	// Ensure titans are initialized in the battle
        updateLaneViews(); // Create visual representation of lanes 
        
	}
	
	
	
	// will be needed in weaponShop
	 public Lane getLaneFromIndex(int selectedIndex) throws InvalidLaneException {
	        switch (selectedIndex) {
	            case 1:
	                return laneViews.get(0).getLane() ;
	            case 2:
	                return laneViews.get(1).getLane();
	            case 3:
	                return laneViews.get(2).getLane();
	            default:
	                throw new InvalidLaneException(); // Handle invalid index
	        }
	    }
	
	 // for selected lane  to be updated
	 private void updateLaneSelection(boolean markSelected) {
		    // Reset the visual state of all lanes to not selected
		    for (laneView laneView : laneViews) {
		        laneView.setSelected(false);
		    }

		    // Set the selected lane based on the current index if marking is requested
		    if (markSelected && selectedLaneIndex >= 0 && selectedLaneIndex <= laneViews.size()) {
		        laneViews.get(selectedLaneIndex -1).setSelected(true); // Array indexing starts at 0, lane indexing starts at 1
		    }
		}
	 
	 private void handleKeyPress(KeyEvent event) {
		    KeyCode keyCode = event.getCode();
		    switch (keyCode) {
		        case UP:
		            if (selectedLaneIndex > 1) {
		                selectedLaneIndex--; // Move selection up
		                updateLaneSelection(false); // Update visual without marking as selected
		                updateUI();
		            }
		            break;
		        case DOWN:
		            if (selectedLaneIndex < 3) {
		                selectedLaneIndex++; // Move selection down
		                updateLaneSelection(false);
		                updateUI(); // Update visual without marking as selected
		            }
		            break;
		        case S:
		            battle.passTurn(); // Simulate the "Start" button action
		            createTitansView();
		            updateTurnLabel();
		            updatePhaseLabel();
		            updateScoreLabel();
		            break;
		        case W:
		            try {
		                weaponShopView weapon = new weaponShopView(this);
		                weapon.setStart(this);
		                root.getScene().setRoot(weapon.getRoot()); // Simulate the "Weapon Shop" button action
		            } catch (Exception e) {
		                e.printStackTrace();
		            }
		            break;
		        case ESCAPE:
		            gameStart menu = new gameStart(); // Simulate the "Exit to Main Menu" button action
		            root.getScene().setRoot(menu.getRoot());
		            break;
		        case ENTER:
		            updateLaneSelection(true); // Mark the current lane as selected and update visuals
		            updateUI();
		            updateSelectedLaneLabel(); // Update the "Selected Lane" label
		            System.out.println("Selected lane index: " + selectedLaneIndex);
		            break;
		        default:
		            // Ignore other keys
		            break;
		    }
		}
	
	 public void setSelectedLaneIndex(int selectedLaneIndex) {
			this.selectedLaneIndex = selectedLaneIndex;
		}

		
	 private void updateSelectedLaneLabel() {
		    selectedLane.setText("Selected Lane: " + selectedLaneIndex); // Assuming 'selectedLane' is a Label
		}
 
	 // creating InfoBox
    private HBox createInfoBox() {
    	HBox infoBox = new HBox();
    	infoBox.setAlignment(Pos.CENTER);
        infoBox.setSpacing(10);
        infoBox.setStyle("-fx-background-color:  black;");
        
        Button StartGame = new Button("Start ");  StartGame.setTranslateY(-10);
        StartGame.setStyle("-fx-font-family: 'Ditty'; -fx-font-size: 65; -fx-text-fill: white ; -fx-background-color: transparent;"
        		+ " -fx-effect: dropshadow( gaussian  , black , 5 , 1 , 2 , 0 )" );
        StartGame.setOnAction(event ->{battle.passTurn();
                                       createTitansView(); 
                                       updateTurnLabel();
                                       updatePhaseLabel(); 
                                       updateScoreLabel();}); 

        // Add labels for score, turn, phase, etc.
        scoreLabel = new Label("Current Score: " + battle.getScore() );
        scoreLabel.setStyle("-fx-font-family: 'fantasy'; -fx-font-size: 35; -fx-text-fill: white ; -fx-background-color: transparent;"
        		+ " -fx-effect: dropshadow( gaussian  , black , 5 , 1 , 2 , 0 )" );
        
        turnLabel = new Label("Current Turn: " + battle.getNumberOfTurns());
        turnLabel.setStyle("-fx-font-family: 'fantasy'; -fx-font-size: 35; -fx-text-fill: white ; -fx-background-color: transparent;"
        		+ " -fx-effect: dropshadow( gaussian  , black , 5 , 1 , 2 , 0 )" );
       
        phaseLabel = new Label("Current Phase : " + battle.getBattlePhase());
        phaseLabel.setStyle("-fx-font-family: 'fantasy'; -fx-font-size: 35; -fx-text-fill: white ; -fx-background-color: transparent;"
        		+ " -fx-effect: dropshadow( gaussian  , black , 5 , 1 , 2 , 0 )" );
       
        resourcesLabel = new Label();
        resourcesLabel.textProperty().bind(battle.resourcesProperty().asString("Current Resources: %d"));
        resourcesLabel.setStyle("-fx-font-family: 'dutch'; -fx-font-size: 35; -fx-text-fill: white; -fx-background-color: transparent; -fx-effect: dropshadow(gaussian, black, 5, 1, 2, 0)");

        selectedLane = new Label("Selected Lane : " +  this.getSelectedLaneIndex());
        selectedLane.setStyle("-fx-font-family: 'fantasy'; -fx-font-size: 35; -fx-text-fill: white ; -fx-background-color: transparent;"
        		+ " -fx-effect: dropshadow( gaussian  , black , 5 , 1 , 2 , 0 )" );
        
        
        Button WeaponShop = new Button("Weapon Shop ");  WeaponShop.setTranslateY(-10);
        WeaponShop.setStyle("-fx-font-family: 'Ditty'; -fx-font-size: 65; -fx-text-fill: white ; -fx-background-color: transparent;"
        		+ " -fx-effect: dropshadow( gaussian  , black , 5 , 1 , 2 , 0 )" );
        WeaponShop.setOnAction(event -> {
            try {
                weaponShopView weapon = new weaponShopView(this);
                weapon.setStart(this);
                WeaponShop.getScene().setRoot(weapon.getRoot());
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
        
        Button back = new Button("Exit to Main Menu") ;
        back.setStyle("-fx-font-family: 'Ditty'; -fx-font-size: 70; -fx-text-fill: white ; -fx-background-color: transparent;"
        		+ " -fx-effect: dropshadow( gaussian  , black , 5 , 1 , 2 , 0 )" ); back.setTranslateY(-10);
        back.setOnAction(event ->{
        	gameStart menu = new gameStart();
        	back.getScene().setRoot(menu.getRoot());
            } ) ;
       
     
        infoBox.getChildren().addAll(StartGame, turnLabel, phaseLabel, resourcesLabel,selectedLane, scoreLabel, WeaponShop, back);
        return infoBox;
    }

    // for lanes graphical representation
    private VBox createLanesView() {
        VBox lanesBox = new VBox();
       lanesBox.setSpacing(5);
       lanesBox.setTranslateX(-10);
        lanesBox.setAlignment(Pos.CENTER);

        for (Lane lane : battle.getLanes()) {
            laneView laneView = new laneView(lane);
            Node view = laneView.getView();  // Ensure getView() is not returning null
            if (view != null) {
                laneViews.add(laneView);
                lanesBox.getChildren().add(view);
            } else {
                System.err.println("Error: Created laneView is null for lane: " + lane);
            }
        }

        return lanesBox;
    }
    
    
    private void updateLaneViews() {
        for (laneView LaneView : laneViews) {
            LaneView.updateView(); // Refresh the visual components of each lane
        }
    }
    
    private void updateTurnLabel() {
        turnLabel.setText("Current Turn: " + battle.getNumberOfTurns()); // Update label text to reflect new turn count
    }
    
    private void updatePhaseLabel() {
        phaseLabel.setText("Current Phase: " + battle.getBattlePhase()); // Update label text to reflect new game phase
    }
    private void updateScoreLabel() {
        scoreLabel.setText("Current Score: " + battle.getScore() ); // Update label text to reflect new score
    }
    private void updateUI() {
	    for (laneView lv : laneViews) {
	        lv.updateVisuals(); // Now safe to call, since visuals should be initialized
	    }
    }
    
    
    
    private void createTitansView(){
    	
    	VBox titansBox = new VBox(20) ;
    	int X = 600 ;
    	titansBox.setTranslateY(X);
    	titansBox.setTranslateX(battle.getTitanSpawnDistance());
    	TitanView titanv ;
    	
    	for (Lane lane : battle.getLanes()) {
    		titansBox.setTranslateY(X-200);
    		for (Titan titan : lane.getTitans() ){
          titanv = new TitanView(titan);  // Assume wall size matches lane
           titanViews.add(titanv);
           titansBox.getChildren().add(titanv.getView());
         	
           
          // root.getChildren().add(titanv.getView());
           //titanv.getView().setAlignment(Pos.TOP_RIGHT);
       	//return titansBox ;
        }
    	}
    	root.getChildren().add(titansBox);
   
    //titansBox.setAlignment(Pos.TOP_RIGHT);
    	//return titansBox ;
    }
    
	public BorderPane getRoot() {
		return root;
	}


	public VBox getLanes() {
		return lanes;
	}


	public HBox getInfoBox() {
		return infoBox ;
	}


	public Battle getBattle() {
		return battle;
	}

	public int getSelectedLaneIndex() {
		return selectedLaneIndex;
	}

	
	
 }
