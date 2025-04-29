package Assets;

public class visibilityManager extends UI{
    public visibilityManager(UI userInter) {
        ui = userInter;
    }
    
    public void showTitleScreen() {

        // Adds visibilty to the game screen contained by the window
        ui.titleNamePanel.setVisible(true);
        ui.startButtonPanel.setVisible(true);

        ui.mainTextPanel.setVisible(false);
        ui.choiceButtonPanel.setVisible(false);
        ui.playerPanel.setVisible(false);
    }
}