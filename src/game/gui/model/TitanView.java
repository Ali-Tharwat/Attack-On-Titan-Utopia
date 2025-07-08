package game.gui.model;

import game.engine.titans.ColossalTitan;
import game.engine.titans.Titan;
import javafx.geometry.Pos;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

public class TitanView {
	
	private Titan titan;
    private VBox viewContainer;
    private ImageView titanImage;
    private Text infoText;
    private double x ;
    public TitanView(Titan titan,double X) {
        this.titan = titan;
        titan.setSpeed(titan.getSpeed()*1.2);
        x = X ;
        createView();
    }

    private void createView() {
        viewContainer = new VBox(); // Space between elements
      

        // Set up the image view for the titan
        titanImage = new ImageView();
        titanImage.setImage(mapTitanImage(titan));
        titanImage.setFitHeight(titan.getHeightInMeters()*8/x) ; // Set the display size
        titanImage.setPreserveRatio(true);
       

        // Info text could display additional data like health or type
        infoText = new Text("Health: " + titan.getCurrentHealth());
       // System.out.print(("Health: " + titan.getCurrentHealth()));

        viewContainer.getChildren().addAll(infoText,titanImage );
        viewContainer.setAlignment(Pos.BOTTOM_CENTER);
        updateView();
    }

    private Image mapTitanImage(Titan titan) {
        // Determine the image path based on the Titan type code
        switch (titan.getTypeCode()) {
            case 1: // PureTitan
                return new Image("file:./src//game//gui//contentNeeded//images/PureTitan.png");
            case 2: // AbnormalTitan
                return new Image("file:./src//game//gui//contentNeeded//images/AbnormalTitan.png");
            case 3: // ArmoredTitan
                return new Image("file:./src//game//gui//contentNeeded//images/ArmoredTitan.png");
            case 4: // ColossalTitan
                return new Image("file:./src//game//gui//contentNeeded//images/ColossalTitan.png");
            default:
                return new Image("file:./src//game//gui//contentNeeded//images/wall.png"); // Default image if type is unknown
        }
    }

    public VBox getView() {
        return viewContainer;
    }

    public void updateView() {
        // This method can be called to update the info text based on the titan's current state
        infoText.setText("Health: " + titan.getCurrentHealth());
    }

}
