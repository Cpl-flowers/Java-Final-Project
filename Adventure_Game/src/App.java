
public class App {
    public static void main(String[] args) {
    }


/*   
    // unused code
    public void setChoices(String[] actions) {
        choiceButtonPanel.removeAll();
        choiceButtonPanel.setLayout(new GridLayout(actions.length,1));
        choices = new JButton[actions.length];
        System.out.println(choices.length);
        for(int i=0;i<choices.length;i++) {
            choices[i] = new JButton(actions[i]);
            choices[i].setBackground(Color.black);
            choices[i].setForeground(Color.white);
            choices[i].setFont(bodyFont);
            choices[i].setFocusPainted(false);
            choiceButtonPanel.add(choices[i]);
        }
    }

    // getter
    public void townGate() {
        position = "townGate";
        mainTextArea.setText("You are at the gate of the town. \nA guard is standing in front of you. \n\nWhat do you do?");
        choice1.setText("Talk to the guard.");
        choice2.setText("Attack the guard");
        choice3.setText("Leave");
        choice4.setText("");

    }

    public void talkGuard () {

        if (silverRing < 1) {       
            position = "talkGuard";
            mainTextArea.setText("Guard: Hello Stranger.\nI have never seen your face before.\nI'm sorry but I cannot let a stanger enter this town.");
            choice1.setText(">");
            choice2.setText("");
            choice3.setText("");
            choice4.setText("");
        }
        else {
            position = "endGame";
            mainTextArea.setText("[You present your silver ring to the guard] \nGuard: Oh so you defeated that goblin, thank you!");
            choice1.setText(">");
            choice2.setText("");
            choice3.setText("");
            choice4.setText("");
        }
    }

    public void attackGuard() {
        position = "attackGuard";
        mainTextArea.setText("Guard: Hey! Don't act foolish! \n[The Guard strikes you with the butt of his sword] \n[You recieve 3 damage.]");
        playerHP -= 3;
        hpLabel.setText("HP: " + playerHP);
        choice1.setText(">");
        choice2.setText("");
        choice3.setText("");
        choice4.setText("");
    }

    public void crossRoad() {
        position = "crossRoad";
        mainTextArea.setText("[You leave town, you arrive at a cross roads. \nBehind you to the south is the town]");
        choice1.setText("Go north");
        choice2.setText("Go south");
        choice3.setText("Go east");
        choice4.setText("Go west");

    }

    public void north() {
        position = "north";
        mainTextArea.setText("[There is a river. You cup your hands to take a drink]\n[This heals you somewhat.]");
        playerHP += 2;
        hpLabel.setText("HP: " + playerHP);
        choice1.setText("Return to road");
        choice2.setText("");
        choice3.setText("");
        choice4.setText("");
    }
    
    public void east() {
        position = "east";
        mainTextArea.setText("[You walked into a forest]\n[You discovered a long sword]");
        playerWeapon = "Long Sword";
        weaponLabel.setText("Weapon: " + playerWeapon);
        choice1.setText("Return to road");
        choice2.setText("");
        choice3.setText("");
        choice4.setText("");
    }
    
    public void west() {
        position = "west";
        mainTextArea.setText("[You encountered a goblin!]");
        if (monsterHP > 1) {   

            choice1.setText("Fight");
            choice2.setText("Run Away");
            choice3.setText("");
            choice4.setText("");
        }

        else {
            mainTextArea.setText("nothing worth seeing here");
            choice1.setText("Walk away");
            choice2.setText("");
            choice3.setText("");
            choice4.setText("");
        }
    }

    public void fight() {
        position = "fight";
         
        mainTextArea.setText("MonsterHP: " + monsterHP + "\n[What do you do?]");
        choice1.setText("Swing your " + playerWeapon);
        choice2.setText("Run Away");
        choice3.setText("");
        choice4.setText("");

    }

    public void attackGoblin() {
        position = "attackGoblin";

        int playerDamage = 0;
        int monsterdamage = 0;

        if (playerWeapon.equals("Knife")) {
            playerDamage = new java.util.Random().nextInt(4);
        }
        else if (playerWeapon.equals("Long Sword")) {
            playerDamage = new java.util.Random().nextInt(9);
        }

        monsterHP -= playerDamage;
        
        monsterdamage = new java.util.Random().nextInt(3);
        playerHP -= monsterdamage;
        goblin.attack();
        hpLabel.setText("HP: " + playerHP);

        if (monsterHP < 1) {
            position = "win";
            mainTextArea.setText("[The goblin is defeated!]\n[A silver ring was dropped]");
            silverRing = 1;
            
            choice1.setText("Walk away");
            choice2.setText("");
            choice3.setText("");
            choice4.setText("");
        }
        else if (playerHP < 1){
            position = "playerDeath";
            mainTextArea.setText("[You were slain]");

            choice1.setText("Death arrives");
            choice2.setText("");
            choice3.setText("");
            choice4.setText("");

        }
        else {
            mainTextArea.setText("[You swing your " + playerWeapon +  " at the goblin]\n[you dealt " + playerDamage
            + " damage to the goblin]\n[The goblin now has " + monsterHP + " health]"
            + "\n[The goblin swings back with its claw for " + monsterdamage + " damage]");

            choice1.setText("Swing again");
            choice2.setText("Run away");
            choice3.setText("");
            choice4.setText("");
        }
    }

    public void playerDeath() {
        position = "playerDeath";

        window.dispatchEvent(new WindowEvent(window, WindowEvent.WINDOW_CLOSING));
    }

    public void endGame() {
        mainTextArea.setText("[Congradulations you have beaten the game.\nThank you so much for playing]");
    }


    // This handles the choice buttons so that when the user clicks on a button the windown listens for the action an registers a response
    public class choiceHandler implements ActionListener{
        public void actionPerformed(ActionEvent event){

            String yourChoice = event.getActionCommand();

            switch (position) {
            case "townGate":
                switch(yourChoice) {
                case "c1": talkGuard(); break;
                case "c2": attackGuard(); break;
                case "c3": crossRoad(); break;
                case "c4": break; 
                }
            break;

            case "talkGuard":
                switch (yourChoice) {
                case "c1": townGate(); break;
                }
            break;

            case "attackGuard":
                switch (yourChoice) {
                case "c1": townGate(); break;
                }
            break;

            case "crossRoad":
                switch (yourChoice) {
                case "c1": north(); break; 
                case "c2": townGate(); break;
                case "c3": east(); break;
                case "c4": west(); break;
                }
            break;

            case "north":
                switch (yourChoice) {
                    case "c1": crossRoad(); break;
                }
            break;
            
            case "east":
                switch (yourChoice) {
                    case "c1": crossRoad(); break;
                }
            break;
            
            case "west":
                if (monsterHP < 1) {
                switch (yourChoice) {
                    case "c1": crossRoad(); break;
                    case "c2": crossRoad(); break;
                    }
                }
                else {
                switch (yourChoice) {
                    case "c1": fight(); break;
                    case "c2": crossRoad(); break;
                    }
                }
            
            break;

            case "fight":
                switch (yourChoice) {
                    case "c1": attackGoblin(); break;
                    case "c2": crossRoad(); break;
                }
            break;

            case "attackGoblin":
                switch (yourChoice) {
                    case "c1": attackGoblin(); break;
                    case "c2": crossRoad(); break;
                }
            break;

            case "playerDeath":
                switch (yourChoice) {
                    case "c1": playerDeath(); break;
                }
            break;

            case "win":
                switch (yourChoice) {
                    case "c1": crossRoad();
                }
            break;

            case "endGame": 
                switch (yourChoice) {
                    case "c1": endGame(); break;
            }
            break;
        }
    }*/
}