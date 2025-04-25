import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.*;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JButton;

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
    Font startButtonFont = new Font("Consolas", Font.PLAIN, 32);

    // allows for an area of text to display and sets its font attributes
    JTextArea mainTextArea;
    Font textAreaFont = new Font("Comic Sans MS", Font.PLAIN, 32);

    // creates the title screen handler
    TitleScreenHandler tsHandler = new TitleScreenHandler();

    int playerHP;
    String playerWeapon;

    // main method
    public static void main(String[] args) throws Exception {
        new App();
    }

    // An Object Called App
    public App() {

        // creates a new JFrame object called window
        // this allows for an actual window to display on a monitor
        window = new JFrame("Blackjack & Hookers");
        // Sets the resolution of the window
        window.setSize(800, 600);
        // allows for the window to be properly closed
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // Sets the background of the window color to black
        window.getContentPane().setBackground(Color.black);
        // disables the default layout of the JFrame window
        window.setLayout(null);
        // Allows for the window to be visible
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
        titleNameLabel = new JLabel("Adventure");
        // sets the color of the text to white
        titleNameLabel.setForeground(Color.white);
        // this allows the text from titleNameLable to be added on top of titleNamePanel
        titleNamePanel.add(titleNameLabel);
        // sets the font for the titleNameLabel
        titleNameLabel.setFont(titleFont);

        // this stores an oject in startButtonPanel
        // sets bounds, text, font, and font size
        startButtonPanel = new JPanel();
        startButtonPanel.setBounds(300, 400, 200, 100);
        startButtonPanel.setBackground(Color.black);
        con.add(startButtonPanel);

        // this creates the button that can be interacted with
        // JButton has one parameter that can be inputted with a string
        startButton = new JButton("Start");
        startButton.setBackground(Color.black);
        startButton.setForeground(Color.white);

        // this add the button to the panel container startButtonPanel
        startButtonPanel.add(startButton);
        startButton.setFont(startButtonFont);

        // When a user clicks the Start button will recognize the click based on the TitleScreenHandler method
        startButton.addActionListener(tsHandler);

        ////////////////
        // End of App //
        ////////////////
    }

    public JButton ChoiceButton(String x){
        JButton button;
        button = new JButton(x);
        button.setBackground(Color.black);
        button.setForeground(Color.white);
        button.setFont(textAreaFont);
        return button;
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
        mainTextArea = new JTextArea("good game gg no re");
        mainTextArea.setBounds(100, 100, 600, 250);
        mainTextArea.setBackground(Color.black);
        mainTextArea.setForeground(Color.white);
        mainTextArea.setFont(textAreaFont);
        // setLineWrap allows for the text to remain in set bound
        mainTextArea.setLineWrap(true);
        // disallows the uesr from editing text on screen
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
        choiceButtonPanel.add(choice1);
        choice2 = ChoiceButton("choice 2");
        choiceButtonPanel.add(choice2);
        choice3 = ChoiceButton("choice 3");
        choiceButtonPanel.add(choice3);
        choice4 = ChoiceButton("choice 4");
        choiceButtonPanel.add(choice4);

        // creates a panel that is able to contain improtant info on the player stats
        playerPanel = new JPanel();
        playerPanel.setBounds(100, 15, 600, 50);
        playerPanel.setBackground(Color.blue);
        playerPanel.setLayout(new GridLayout(1, 4));
        con.add(playerPanel);

        // contains the health stat header
        hpLabel = new JLabel("HP: ");
        hpLabel.setFont(textAreaFont);
        hpLabel.setForeground(Color.white);
        playerPanel.add(hpLabel);

        // contains the health stat counter
        hpLabelNumber = new JLabel();
        hpLabelNumber.setFont(textAreaFont);
        hpLabelNumber.setForeground(Color.white);
        playerPanel.add(hpLabelNumber);

        // contains the weapon stat header
        weaponLabel = new JLabel("Weapon: ");
        weaponLabel.setFont(textAreaFont);
        weaponLabel.setForeground(Color.white);
        playerPanel.add(weaponLabel);

        // contains the weapon's type stat
        weaponLabelNumber = new JLabel();
        weaponLabelNumber.setFont(textAreaFont);
        weaponLabelNumber.setForeground(Color.white);
        playerPanel.add(weaponLabelNumber);

        playerSetup();
        /////////////////////////////
        // End of createGameScreen //
        /////////////////////////////

    }

    public void playerSetup() {
        playerHP = 15;
        playerWeapon = "Knife";
    
        hpLabelNumber.setText(Integer.toString(playerHP));
        weaponLabelNumber.setText(playerWeapon);

    }
    


    // class that will hold scripts for interactive buttons that progress the game
    public class TitleScreenHandler implements ActionListener{
        public void actionPerformed(ActionEvent event){

            createGameScreen();
        }
    }

}