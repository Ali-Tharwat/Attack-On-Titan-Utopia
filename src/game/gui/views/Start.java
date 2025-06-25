package game.gui.views;

import javafx.scene.Parent;
import game.engine.Battle;
import game.engine.exceptions.InvalidLaneException;
import game.engine.lanes.Lane;

public abstract class Start {
	private Battle battle ;
	 private int selectedLaneIndex = 2;

    public abstract Lane getLaneFromIndex(int selectedIndex) throws InvalidLaneException;
	 
	public Battle getBattle() {
		return battle;
	}

	public void setBattle(Battle battle) {
		this.battle = battle;
	}

	public int getSelectedLaneIndex() {
		return selectedLaneIndex;
	}

	public void setSelectedLaneIndex(int selectedLaneIndex) {
		this.selectedLaneIndex = selectedLaneIndex;
	} 
	
	public abstract Parent getRoot() ;
	
	
	
	
	
	
	
	

}
