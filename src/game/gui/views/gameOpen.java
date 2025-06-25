package game.gui.views;

import javafx.animation.*;
import javafx.application.Platform;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.util.Duration;

public class gameOpen {
    private VBox root;

    public gameOpen() {
        root = new VBox();
        root.setAlignment(Pos.CENTER);
        // Background image setup
        BackgroundImage myBI = new BackgroundImage(new Image("file:./src/game/gui/contentNeeded/images/GameOpen.png", 2667, 2000, false, true),
                BackgroundRepeat.ROUND, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT,
                BackgroundSize.DEFAULT);
        root.setBackground(new Background(myBI));

        // Make sure the pane can receive keyboard focus
        root.setFocusTraversable(true);

        // Main title
        Text titleMain = new Text("Attack On Titan:");
        titleMain.setFill(Color.GAINSBORO);
        titleMain.setStyle("-fx-font-family: 'Ditty'; -fx-font-size: 300; -fx-background-color: transparent;"
         		+ " -fx-effect: dropshadow( gaussian  , black , 10 , 1 , 2 , 0 )" );
        titleMain.setTranslateY(-120);

        // Subtitle for animated display
        Text titleSub = new Text("");
        titleSub.setStyle("-fx-font-family: 'Ditty'; -fx-font-size: 270; -fx-fill: firebrick ; -fx-background-color: transparent;"
         		+ " -fx-effect: dropshadow( gaussian  , black , 10 , 1 , 2 , 0 )" );
        titleSub.setTranslateY(-190);
        titleSub.setOpacity(0); // Start invisible
       

        // Label setup
        Label label = new Label("Press Any Button To Start");
        label.setStyle("-fx-font-family: 'Ditty'; -fx-font-size: 150 ; -fx-background-color: transparent;"
         		+ " -fx-effect: dropshadow( gaussian  , black , 4 , 1 , 2 , 0 )" );
      label.setTextFill(Color.WHITESMOKE);
      label.setTranslateY(60);
        label.setOpacity(0); // Start invisible

        // Adding children to root
        root.getChildren().addAll(titleMain, titleSub, label);

        // Animation for title appearance
        ScaleTransition scaleTransition = new ScaleTransition(Duration.seconds(1), titleMain);
        scaleTransition.setFromX(0.5);
        scaleTransition.setFromY(0.5);
        scaleTransition.setToX(1.0);
        scaleTransition.setToY(1.0);
        scaleTransition.setCycleCount(2);

        // Sequential appearance of "UTOPIA"
        String utopia = "UTOPIA";
        SequentialTransition sequentialTransition = new SequentialTransition();
        for (int i = 0; i < utopia.length(); i++) {
            final int index = i;
            PauseTransition pause = new PauseTransition(Duration.seconds(0.5 ));
            pause.setOnFinished(e -> {
                titleSub.setText(utopia.substring(0, index + 1));
                titleSub.setOpacity(1.0); // Make visible
            });
            sequentialTransition.getChildren().add(pause);
        }

        // Fade transition for label
        FadeTransition fadeTransition = new FadeTransition(Duration.seconds(1), label);
        fadeTransition.setFromValue(0);
        fadeTransition.setToValue(1);
        fadeTransition.setCycleCount(Animation.INDEFINITE);
        fadeTransition.setAutoReverse(true);

        scaleTransition.setOnFinished(e -> sequentialTransition.play());
        sequentialTransition.setOnFinished(e -> fadeTransition.play());

        scaleTransition.play();

        // Key press handling
        root.setOnKeyPressed(event -> handleKeyPress(event));
    }

    private void handleKeyPress(KeyEvent event) {
        KeyCode keyCode = event.getCode();
        // Navigate to gameStart view on any key press
        gameStart menu = new gameStart();
        root.getScene().setRoot(menu.getRoot());
    }

    public Parent getRoot() {
        return root;
    }

    public void requestFocus() {
        root.requestFocus();
    }
}