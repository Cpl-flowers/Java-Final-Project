package Assets;
import java.awt.event.*;

public class game {

    choiceHandler cHandler = new choiceHandler();
    UI ui = new UI();
    visibilityManager vm = new visibilityManager(ui);


    public static void main(String[] args) {
    
        new game();
    }

    public game() {
        ui.createUI(cHandler);
        vm.showTitleScreen();

    }

    // This handles the choice buttons so that when the user clicks on a button the windown listens for the action an registers a response
    public class choiceHandler implements ActionListener{
        public void actionPerformed(ActionEvent event){

            String yourChoice = event.getActionCommand();
            switch (yourChoice) {
                case "start": break;
                case "c1": break;
                case "c2": break;
                case "c3": break;
                case "c4": break;
            }
        }
    }
}