package Assets;

import java.awt.event.*;

public class game {

    
    choiceHandler ChoiceHandler = new choiceHandler();
    String nextPos1, nextPos2, nextPos3, nextPos4;

    public static void main(String[] args) {
        new game();
    }

    public game() {
        ui.createUI(cHandler);
        story.defaultSetup();
        vm.showTitleScreen();

    }

    // This handles the choice buttons so that when the user clicks on a button the windown listens for the action an registers a response
    public class choiceHandler implements ActionListener{
        public void actionPerformed(ActionEvent event){

            String yourChoice = event.getActionCommand();
            switch (yourChoice) {
                case "start": vm.titleToTown(); story.townGate(); break;
            }
        }
    }
}