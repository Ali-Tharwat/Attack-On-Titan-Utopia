package game.gui.views;



import javafx.application.Platform;
import javafx.geometry.Insets;

import java.io.IOException;






import game.engine.exceptions.InsufficientResourcesException;
import game.engine.exceptions.InvalidLaneException;
import game.engine.lanes.Lane;
import game.gui.model.laneView;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.StrokeType;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class weaponShopView   {
	
	private Start start ;
	private GridPane root ;
	private Text resources ;
	
	public weaponShopView(Start start) throws IOException{
		this.start = start ;
		root = new GridPane();
		root.setPadding(new Insets(5));
		root.setHgap(900);
		root.setVgap(400);
		
		
		
		 BackgroundImage myBI= new BackgroundImage(new Image("file:./src//game//gui//contentNeeded//images/WeaponShop.jpg",3000,1950,false,true),
			        BackgroundRepeat.ROUND, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT,
			          BackgroundSize.DEFAULT);
			root.setBackground(new Background(myBI));
			
			
		
	   
	     
		VBox PiercingCannon = CreateWeaponBox("PiercingCannon3D.png" ,"Anti-Titan Shell","Piercing Cannon" , 25 , 10 , 1); 
		VBox SniperCannon = CreateWeaponBox("SniperCannon3D.png" ,"Long Range Spear","Sniper Cannon" , 25 , 35 , 2); 
		VBox VolleyCannon = CreateWeaponBox("VolleySpreadCannon3D.png" ,"Wall Spread Cannon","Volley Spread Cannon" , 100 , 5 , 3); 
		VBox WallTrap = CreateWeaponBox("WallTrap3D.png","Proximity Trap", "Wall Trap",75,100,4);
		
		resources = new Text("Current Resources : " + start.getBattle().getResourcesGathered());
		resources.setTranslateX(1270); resources.setTranslateY(900);
		resources.setStyle("-fx-font-family: 'monospace'; -fx-font-size: 50; -fx-background-color: transparent; -fx-text-fill: white ;"
	     		+ " -fx-effect: dropshadow( gaussian  , white , 10 , 1 , 2 , 0 )" );
		
		Button back = new Button("Back") ;
	     back.setStyle("-fx-font-family: 'Ditty'; -fx-font-size: 200; -fx-text-fill: white ; -fx-background-color: transparent;"
	     		+ " -fx-effect: dropshadow( gaussian  , black , 10 , 1 , 2 , 0 )" );
	     back.setOnAction(event ->{
	    	 back.getScene().setRoot(start.getRoot());
	         } ) ; 
	     back.setTranslateX(1270); back.setTranslateY(1300);
	     
		SniperCannon.setTranslateX(2100); VolleyCannon.setTranslateY(1150); WallTrap.setTranslateX(2100); WallTrap.setTranslateY(1150);
		root.getChildren().addAll(PiercingCannon,SniperCannon , VolleyCannon, WallTrap,resources, back);

			
		
		
		
	}
	
	public VBox CreateWeaponBox(String imageName , String name , String type , int price , int damage , int code ){
		VBox weapon = new VBox();
		weapon.setTranslateX(200);
		weapon.setTranslateY(350);
		weapon.setStyle("-fx-spacing: 10;-fx-background-color:  #fafad2;");
		weapon.setAlignment(Pos.CENTER);
		Image image=new Image("file:./src//game//gui//contentNeeded//images/"+imageName); ImageView imageView=new ImageView(image);
		Text Name = new Text("Name : " + name); 
		Text Type = new Text("Type : " + type); 
		Text Price = new Text("Price : " + price) ; 
		Text Damage = new Text("Damage : "+ damage);
		Button Purchase = new Button("Purchase Weapon");
		
		weapon.getChildren().addAll(imageView, Name ,Type, Price,Damage) ;
		
		if(imageName.equals("VolleySpreadCannon3D.png")){
			weapon.getChildren().addAll(new Text("Min Range : 20      	Max Range : 50" )) ;
		}
		weapon.getChildren().addAll(Purchase) ;
		if (start != null) { // Add null check for start object
	        Purchase.setOnAction(event -> {
	            try {
	            	Lane lane = start.getLaneFromIndex(start.getSelectedLaneIndex());
	                start.getBattle().purchaseWeapon(code, lane);
	                
	                // Update resources label immediately
	                resources.setText("Current Resources : " + start.getBattle().getResourcesGathered());

	                // Update lane view to reflect new weapon
	                laneView laneViewToUpdate = start.findLaneView(lane); // You need a method to get the correct laneView
	                laneViewToUpdate.updateWeaponsDisplay();

	                // Assuming you switch back to the main view, ensure it's refreshed.
	                Purchase.getScene().setRoot(start.getRoot());
	                
	            } catch (Exception e) {
	            	Platform.runLater(() -> {
	            		 Stage popupStage = new Stage();
	                     popupStage.setTitle("Not enough resources");
	                     
	                     Label label = new Label(InsufficientResourcesException.getMsg() + start.getBattle().getResourcesGathered());
	                     VBox vbox = new VBox(label);
	                     vbox.setSpacing(10);
	                     vbox.setStyle("-fx-padding: 20;");
	                     
	                     Scene scene = new Scene(vbox, 900, 300);
	                     popupStage.setScene(scene);
	                     
	                     popupStage.show();
	                });
	            }
	        }) ;
		}
		return weapon ;
	}
	public Text createText(String text,int Y){
		Text m = new Text(text);
		m.setStyle("-fx-font-family: 'ditty'; -fx-font-size: 150 ; -fx-fill: white;");
	     m.setStroke(Color.BLACK); m.setStrokeWidth(3); m.setStrokeType(StrokeType.OUTSIDE);
	     m.setTranslateX(1150); m.setTranslateY(Y);
	     
	     return m;
	}
	public GridPane getRoot() {
		return root;
	}

	public Start getStart() {
		return start;
	}

	public void setStart(Start start) {
		this.start = start;
	}
	
	
}
