/*package game.gui.view;

import game.engine.Battle;
import game.engine.lanes.Lane;
import game.engine.titans.ArmoredTitan;
import game.engine.titans.ColossalTitan;
import game.engine.titans.PureTitan;
import game.engine.titans.Titan;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.scene.control.ProgressBar;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class EasyGameView extends BorderPane {

    private static final String BUTTON_STYLE_NORMAL =
            "-fx-font-family: 'impact'; " +
                    "-fx-font-size: 30px; " +
                    "-fx-text-fill: white; " +
                    "-fx-background-color: transparent; " +
                    "-fx-background-radius: 10px; " +
                    "-fx-border-color: transparent; " +
                    "-fx-padding: 10px 20px; " +
                    "-fx-effect: dropshadow(three-pass-box, rgba(0,0,0,0.3), 10, 0, 0, 0);" +
                    "-fx-text-transform: lowercase;";

    private static final String BUTTON_STYLE_HOVER = "-fx-background-color: #666666; " +
            "-fx-font-family: 'impact'; " +
            "-fx-font-size: 30px; " +
            "-fx-text-fill: black; " +
            "-fx-background-radius: 10px; " +
            "-fx-padding: 10px 20px; " +
            "-fx-effect: dropshadow(three-pass-box, rgba(0,0,0,0.3), 10, 0, 0, 0);";

    private static final String LABEL_STYLE = "-fx-font-family: 'Arial'; -fx-font-size: 18px; -fx-text-fill: white;";
    private static final String INFO_BOX_STYLE = "-fx-background-color: rgba(0, 0, 0, 0.5); -fx-padding: 10px; -fx-spacing: 20px;";
    private Battle battle;

    public EasyGameView(Stage primaryStage, Battle battle) {
        // Load the background image

        this.battle = battle;
        Image backgroundImage = new Image("bggg-ezgif.com-webp-to-jpg-converter (1).jpg");

        // Create a BackgroundImage
        BackgroundImage background = new BackgroundImage(
                backgroundImage,
                BackgroundRepeat.NO_REPEAT,
                BackgroundRepeat.NO_REPEAT,
                BackgroundPosition.DEFAULT,
                new BackgroundSize(BackgroundSize.AUTO, BackgroundSize.AUTO, true, true, true, true)
        );

        // Set the background image to the BorderPane
        setBackground(new Background(background));

        // Create labels for game information
        Label scoreLabel = new Label("Score: " + battle.getScore());
        Label resourcesLabel = new Label("Resources: " + battle.getResourcesGathered());
        Label turnLabel = new Label("Turn: " + battle.getNumberOfTurns());
        Label currentPhaseLabel = new Label("Current Phase: " + battle.getBattlePhase());

        // Style labels
        scoreLabel.setStyle(BUTTON_STYLE_NORMAL);
        resourcesLabel.setStyle(BUTTON_STYLE_NORMAL);
        turnLabel.setStyle(BUTTON_STYLE_NORMAL);
        currentPhaseLabel.setStyle(BUTTON_STYLE_NORMAL);

        // Create a layout to hold the labels and buttons
        HBox infoBox = new HBox(20);
        infoBox.setAlignment(Pos.TOP_LEFT);
        infoBox.setPadding(new Insets(10));
        infoBox.setStyle(INFO_BOX_STYLE); // Apply styling to the HBox

        // Create a Region to push the buttons to the right
        Region spacer = new Region();
        HBox.setHgrow(spacer, Priority.ALWAYS);

        // Create Weapon Shop button
        Button weaponShopButton = new Button("Weapon Shop");
        weaponShopButton.setStyle(BUTTON_STYLE_NORMAL);
        weaponShopButton.setOnMouseEntered(e -> weaponShopButton.setStyle(BUTTON_STYLE_HOVER));
        weaponShopButton.setOnMouseExited(e -> weaponShopButton.setStyle(BUTTON_STYLE_NORMAL));
        weaponShopButton.setOnAction(e -> {
            // Create a new instance of the WeaponShop
            WeaponShopView weaponShop = new WeaponShopView(primaryStage); // Pass primaryStage as an argument
            primaryStage.getScene().setRoot(weaponShop);

            // Create a new stage for the WeaponShop
            Stage weaponShopStage = new Stage();
            weaponShopStage.setTitle("Weapon Shop");
            weaponShopStage.setScene(new Scene(weaponShop, 600, 400)); // Adjust size as needed
            weaponShopStage.show();
        });

        // Create Back button
        Button backButton = new Button("Back");
        backButton.setStyle(BUTTON_STYLE_NORMAL);
        backButton.setOnMouseEntered(event -> backButton.setStyle(BUTTON_STYLE_HOVER));
        backButton.setOnMouseExited(event -> backButton.setStyle(BUTTON_STYLE_NORMAL));
        backButton.setOnAction(event -> {
            GameDifficultyView gameDifficultyView = new GameDifficultyView(primaryStage);
            primaryStage.getScene().setRoot(gameDifficultyView);
        });

        // Add labels and buttons to the infoBox
        infoBox.getChildren().addAll(scoreLabel, resourcesLabel, turnLabel, currentPhaseLabel, spacer, weaponShopButton, backButton);

        // Add the layout to the top of the EasyGameView
        setTop(infoBox);

        // Insert titans
        insertTitans();

        // Create lanes
        createLanes();

//        updateHeathHealth();

    }


    private void insertTitans() {
        // Load images for each type of titan
        Image pureTitanImage = new Image("eren_titan_mappa__png_by_dariotsc_dfjn72y-375w-2x.png");
        Image abnormalTitanImage = new Image("abn.png");
        Image armoredTitanImage = new Image("Armor_titan-ezgif.com-gif-maker-removebg.png");
        Image colossalTitanImage = new Image("colosllaltitan-removebg-preview.png");

        // Create ImageViews to display the titan images
        ImageView pureTitanView = new ImageView(pureTitanImage);
        ImageView abnormalTitanView = new ImageView(abnormalTitanImage);
        ImageView armoredTitanView = new ImageView(armoredTitanImage);
        ImageView colossalTitanView = new ImageView(colossalTitanImage);

        double imageSize = 100; // Adjust this value as needed
        pureTitanView.setFitWidth(imageSize);
        pureTitanView.setFitHeight(imageSize);
        abnormalTitanView.setFitWidth(140);
        abnormalTitanView.setFitHeight(140);
        armoredTitanView.setFitWidth(170);
        armoredTitanView.setFitHeight(100);
        colossalTitanView.setFitWidth(80);
        colossalTitanView.setFitHeight(200);

    }

    private void createLanes() {
        // Create VBox for lanes
        VBox laneBox = new VBox(20); // Adjust spacing as needed
        laneBox.setAlignment(Pos.CENTER_LEFT);
        laneBox.setPadding(new Insets(125, 0, 0, 0)); // Adjust top padding to move all rectangles down

        // Get the lanes from the battle object
        List<Lane> lanes = new ArrayList<>(battle.getLanes());

        // Create VBox for each lane
        for (Lane lane : lanes) {
            // Create a VBox to hold the lane elements
            VBox laneVBox = new VBox();
            laneVBox.setAlignment(Pos.CENTER_LEFT);

            // Create a StackPane to hold the wall image and progress bar
            StackPane laneStackPane = new StackPane();
            laneStackPane.setMinSize(1500, 100); // Set the size to match the lane rectangle

            // Create a Rectangle to represent the lane
            Rectangle laneRectangle = new Rectangle(1500, 100); // Adjust size as needed
            laneRectangle.setFill(Color.TRANSPARENT);
            laneRectangle.setStroke(Color.TRANSPARENT); // Set border color
            laneRectangle.setStrokeWidth(2); // Set border width

            // Load the wall image
            Image wallImage = new Image("stone-castle-wall-background-vector-600nw-1986484865-ezgif.com-webp-to-jpg-converter-removebg-preview.png");

            // Create an ImageView for the wall image
            ImageView wallImageView = new ImageView(wallImage);
            wallImageView.setFitWidth(100); // Adjust width as needed
            wallImageView.setFitHeight(100); // Adjust height as needed

            // Align the wall image to the right of the lane rectangle
            StackPane.setAlignment(wallImageView, Pos.CENTER_RIGHT);
            StackPane.setMargin(wallImageView, new Insets(0, 30, 0, 0)); // Adjust margins as needed

            // Create a ProgressBar to represent the wall's health
            int currentHealth = lane.getLaneWall().getCurrentHealth();
            double progress = (double) currentHealth / lane.getLaneWall().getBaseHealth();

            ProgressBar healthProgressBar = new ProgressBar(progress); // Set progress directly
            healthProgressBar.setPrefWidth(100); // Set preferred width for the progress bar

            String progressBarStyle = "-fx-accent: green;";
            healthProgressBar.setStyle(progressBarStyle);

            StackPane.setMargin(healthProgressBar, new Insets(150, 0, 0, 1380));

            // Add the lane rectangle, wall image, and progress bar to the StackPane
            laneStackPane.getChildren().addAll(laneRectangle, wallImageView, healthProgressBar);

            // Add titans to the lane StackPane
            battle.passTurn();
            for (Titan titan : lane.getTitans()) {
                ImageView titanImageView;
                if (titan instanceof PureTitan) {
                    titanImageView = new ImageView(new Image("eren_titan_mappa__png_by_dariotsc_dfjn72y-375w-2x.png"));
                    titanImageView.setFitWidth(100);
                    titanImageView.setFitHeight(100);
                } else if (titan instanceof ArmoredTitan) {
                    titanImageView = new ImageView(new Image("Armor_titan-ezgif.com-gif-maker-removebg.png"));
                    titanImageView.setFitWidth(100);
                    titanImageView.setFitHeight(100);
                } else if (titan instanceof ColossalTitan) {
                    titanImageView = new ImageView(new Image("colosllaltitan-removebg-preview.png"));
                    titanImageView.setFitWidth(100);
                    titanImageView.setFitHeight(100);
                } else {
                    titanImageView = new ImageView(new Image("abn.png"));
                    titanImageView.setFitWidth(200);
                    titanImageView.setFitHeight(100);
                }

                // Customize the positioning of the titan image within the lane
                // For example, you can use StackPane.setMargin to adjust the position
                // of each titan image individually
                StackPane.setMargin(titanImageView, new Insets(10, 0, 0, -1450)); // Adjust margins as needed

                // Add the titan image to the lane StackPane
                laneStackPane.getChildren().add(titanImageView);
            }

            // Add the StackPane containing wall image and progress bar to the lane VBox
            laneVBox.getChildren().add(laneStackPane);

            // Add the lane VBox to the laneBox
            laneBox.getChildren().add(laneVBox);
        }

        // Add laneBox to the bottom of the EasyGameView
        setCenter(laneBox);
    }




    private void updateWallHealth() {
        // Iterate through lanes and update health
        for (Lane lane : battle.getLanes()) {
            // Get current health of the wall
            int currentHealth = lane.getLaneWall().getCurrentHealth();

            // Calculate progress percentage


            // Create label to display health
            Label healthLabel = new Label("Health: " + currentHealth);
            healthLabel.setStyle(LABEL_STYLE); // Use existing label style

            // Create a VBox to hold the progress bar and label
            VBox healthBox = new VBox(5); // Adjust spacing as needed
            healthBox.setAlignment(Pos.CENTER_LEFT);
            healthBox.getChildren().addAll(healthLabel);

            // Add healthBox to the info box
            ((HBox)getTop()).getChildren().add(healthBox);
        }
    }



    private void showHeightDifference() {
        // Iterate through lanes
        for (Lane lane : battle.getLanes()) {
            // Get titans in the lane
            PriorityQueue<Titan> titans = lane.getTitans();

            // Calculate height difference for each titan type
            // Update UI accordingly
        }
    }

    private void showPositionDifference() {
        // Iterate through lanes
        for (Lane lane : battle.getLanes()) {
            // Get titans in the lane
            PriorityQueue<Titan> titans = lane.getTitans();

            // Calculate position difference for each titan
            // Update UI accordingly
        }
    }

    private void showSpeedDifference() {
        // Iterate through lanes
        for (Lane lane : battle.getLanes()) {
            // Get titans in the lane
            PriorityQueue<Titan> titans = lane.getTitans();

            // Calculate speed difference for each titan
            // Update UI accordingly
        }
    }

    private void removeDefeatedTitans() {
        // Iterate through lanes
        for (Lane lane : battle.getLanes()) {
            // Get titans in the lane
            PriorityQueue<Titan> titans = lane.getTitans();

            // Remove defeated titans from the lane
            // Update UI accordingly
        }
    }

}*/