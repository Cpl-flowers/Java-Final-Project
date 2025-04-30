import assets.*;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.*;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

// Class called App
public class App {

    // instanciating objects
    // creates the window that displays when debugging
    JFrame window;

    // idk
    Container con;

    // creates the panels that are used to contain lables
    JPanel titleNamePanel, startButtonPanel, mainTextPanel, choiceButtonPanel, playerPanel;

    // labels that are used to display text for the time being
    JLabel titleNameLabel, hpLabel, hpLabelNumber, weaponLabel, weaponLabelNumber;
    Font titleFont = new Font("Consolas", Font.PLAIN, 48);

    // allows for a button to be created that can be interacted by the user
    JButton startButton, choice1, choice2, choice3, choice4;
    JButton[] choices;
    Font startButtonFont = new Font("Consolas", Font.PLAIN, 32);

    // allows for an area of text to display and sets its font attributes
    JTextArea mainTextArea;
    Font bodyFont = new Font("Consolas", Font.PLAIN, 20);
    Font headerFont = new Font("Consolas", Font.PLAIN, 20);

    // creates the title screen handler
    TitleScreenHandler tsHandler = new TitleScreenHandler();
    choiceHandler ChoiceHandler = new choiceHandler();

    int playerHP, monsterHP, silverRing;
    String playerWeapon, position;

    // main method
    public static void main(String[] args) throws Exception {
        new App();
    }

    // An Object Called App
    public App() {

        // creates a new JFrame object called window
        // this allows for an actual window to display on a monitor
        // window.setSize the resolution of the window
        // window.setDefaultCloseOperation allows for the window to be properly closed
        // window.getContentPane sets the background of the window color to black
        // window.setLayout disables the default layout of the JFrame window
        // window.setVisible Allows for the window to be visible
        window = new JFrame("Blackjack & Hookers");
        window.setSize(800, 600);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.getContentPane().setBackground(Color.black);
        window.setLayout(null);
        window.setVisible(true);

        // Container con is a object it is capable of holding interactive objects such as a button
        // or static objects like strings of texts
        con = window.getContentPane();

        // this allows for a title card to be made
        // setbounds is what allows for the placement and size setting of the title card
        titleNamePanel = new JPanel();
        titleNamePanel.setBounds(100, 100, 600, 150); 
        titleNamePanel.setBackground(Color.black);
        con.add(titleNamePanel);

        // allows for a label to be made and customized
        // titleNameLable.setForeground sets the color of the text to white
        // titleNamePanel.add allows the text from titleNameLable to be added on top of titleNamePanel
        // titleNameLable.setFont sets the font for the titleNameLabel
        titleNameLabel = new JLabel("Adventure");
        titleNameLabel.setForeground(Color.white);
        titleNamePanel.add(titleNameLabel);
        titleNameLabel.setFont(titleFont);

        // this stores an oject in startButtonPanel
        // sets bounds, text, font, and font size
        startButtonPanel = new JPanel();
        startButtonPanel.setBounds(300, 400, 200, 100);
        startButtonPanel.setBackground(Color.black);
        con.add(startButtonPanel);

        // this creates the button that can be interacted with
        // JButton has one parameter that can be inputted with a string
        // startButton.add adds the button to the panel container startButtonPanel
        // When a user clicks the Start button will recognize the click based on the TitleScreenHandler method
        startButton = new JButton("Start");
        startButton.setBackground(Color.black);
        startButton.setForeground(Color.white);
        startButtonPanel.add(startButton);
        startButton.setFont(startButtonFont);
        startButton.addActionListener(tsHandler);
        startButton.setFocusPainted(false);

        ////////////////
        // End of App //
        ////////////////
    }

    // method that creates a game screen that will display text and information for the end user
    public void createGameScreen(){

        titleNamePanel.setVisible(false);
        startButtonPanel.setVisible(false);

        // this will create another panel that will contain text like the previous panels have done
        // sets bound's X/Y position and width/length as well as its background color to blue
        mainTextPanel = new JPanel();
        mainTextPanel.setBounds(100, 100, 600, 250);
        mainTextPanel.setBackground(Color.black);
        con.add(mainTextPanel);

        // sets multiple attribute for mainTextArea such as its bounds, back/fore grounds, font,
        // and line wrapping so that the text does not go out of bounds
        // mainTextArea.setLineWrap allows for the text to remain in set bound
        // mainTextArea.setEditable disallows the user from editing text on screen
        mainTextArea = new JTextArea("good game gg no re");
        mainTextArea.setBounds(100, 100, 600, 250);
        mainTextArea.setBackground(Color.black);
        mainTextArea.setForeground(Color.white);
        mainTextArea.setFont(bodyFont);
        mainTextArea.setLineWrap(true);
        mainTextArea.setEditable(false);

        // makes the text withing bound to wrap inside the bound
        // mainTextArea.setWrapStyleWord(true); // doesn't feel like it does anything
        mainTextPanel.add(mainTextArea);

        // Formats the layout of the buttons in play screen
        choiceButtonPanel = new JPanel();
        choiceButtonPanel.setBounds(250, 350, 300, 150);
        choiceButtonPanel.setBackground(Color.black);
        choiceButtonPanel.setLayout(new GridLayout(4,1));
        con.add(choiceButtonPanel);

        // instanciates the buttons for user choices
        choice1 = ChoiceButton("choice 1");
        choice1.setActionCommand("c1");
        choiceButtonPanel.add(choice1);

        choice2 = ChoiceButton("choice 2");
        choice2.setActionCommand("c2");
        choiceButtonPanel.add(choice2);
        
        choice3 = ChoiceButton("choice 3");
        choice3.setActionCommand("c3");
        choiceButtonPanel.add(choice3);
        
        choice4 = ChoiceButton("choice 4");
        choice4.setActionCommand("c4");
        choiceButtonPanel.add(choice4);

        // creates a panel that is able to contain improtant info on the player stats
        playerPanel = new JPanel();
        playerPanel.setBounds(100, 15, 600, 50);
        playerPanel.setBackground(Color.black);
        playerPanel.setLayout(new GridLayout(1, 2));
        con.add(playerPanel);

        // contains the health stat header
        hpLabel = new JLabel("HP: ");
        hpLabel.setFont(headerFont);
        hpLabel.setForeground(Color.white);
        playerPanel.add(hpLabel);

        // contains the health stat counter
        hpLabelNumber = new JLabel();
        hpLabelNumber.setFont(headerFont);
        hpLabelNumber.setForeground(Color.white);
        playerPanel.add(hpLabelNumber);

        // contains the weapon stat header
        weaponLabel = new JLabel("Weapon: ");
        weaponLabel.setFont(headerFont);
        weaponLabel.setForeground(Color.white);
        playerPanel.add(weaponLabel);

        // contains the weapon's type stat
        weaponLabelNumber = new JLabel();
        weaponLabelNumber.setFont(headerFont);
        weaponLabelNumber.setForeground(Color.white);
        playerPanel.add(weaponLabelNumber);

        playerSetup();
        
        /////////////////////////////
        // End of createGameScreen //
        /////////////////////////////

    }

    // ChoiceButton allows instanciating buttons to be streamlined
    // A setter method
    public JButton ChoiceButton(String x){
        JButton button;
        button = new JButton(x);
        button.setBackground(Color.black);
        button.setForeground(Color.white);
        button.setFont(bodyFont);
        button.setFocusPainted(false);
        button.addActionListener(ChoiceHandler);
        return button;
    }

    // getter
    public void playerSetup() {
        playerHP = 15;
        playerWeapon = "Knife";

        monsterHP = 20;
    
        hpLabel.setText("HP: " + playerHP);
        weaponLabel.setText("Weapon: " + playerWeapon);

        townGate();

    }

    // class that will hold scripts for interactive buttons that progress the game
    public class TitleScreenHandler implements ActionListener{
        public void actionPerformed(ActionEvent event){

            createGameScreen();
        }
    }
    
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
        
        // monsterdamage = new java.util.Random().nextInt(3);
        // playerHP -= monsterdamage;
        Goblin gob = new Goblin();
        playerHP  -= gob.attack();
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
    }
}
}