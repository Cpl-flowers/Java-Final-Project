// imports color for setBackground
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.*;
// import java.awt.GraphicsEnvironment;
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
    JPanel titleNamePanel, startButtonPanel, mainTextPanel, choiceButtonPanel;

    // labels that are used to display text for the time being
    JLabel titleNameLabel;
    Font titleFont = new Font("Consolas", Font.PLAIN, 48);

    // allows for a button to be created that can be interacted by the user
    JButton startButton, choice1, choice2, choice3, choice4;
    Font startButtonFont = new Font("Consolas", Font.PLAIN, 32);

    // allows for an area of text to display and sets its font attributes
    JTextArea mainTextArea;
    Font textAreaFont = new Font("Comic Sans MS", Font.PLAIN, 32);

    // creates the title screen handler
    TitleScreenHandler tsHandler = new TitleScreenHandler();

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

    }

    // method that creates a game screen that will display text and information for the end user
    public void createGameScreen(){

        titleNamePanel.setVisible(false);
        startButtonPanel.setVisible(false);

        // this will create another panel that will contain text like the previous panels have done
        // sets bound's X/Y position and width/length as well as its background color to blue
        mainTextPanel = new JPanel();
        mainTextPanel.setBounds(100, 100, 600, 250);
        mainTextPanel.setBackground(Color.blue);
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

        //
        choiceButtonPanel = new JPanel();
        choiceButtonPanel.setBounds(250, 350, 300, 150);
        choiceButtonPanel.setBackground(Color.blue);
        con.add(choiceButtonPanel);

        //
        choice1 = new JButton();
        choice1.setBackground(Color.black);
        choice1.setForeground(Color.white);
        choice1.setFont(textAreaFont);
        choiceButtonPanel.add(choice1);

        choice2 = new JButton();
        choice2.setBackground(Color.black);
        choice2.setForeground(Color.white);
        choice2.setFont(textAreaFont);
        choiceButtonPanel.add(choice1);

        choice3 = new JButton();
        choice3.setBackground(Color.black);
        choice3.setForeground(Color.white);
        choice3.setFont(textAreaFont);
        choiceButtonPanel.add(choice1);

        choice4 = new JButton();
        choice4.setBackground(Color.black);
        choice4.setForeground(Color.white);
        choice4.setFont(textAreaFont);
        choiceButtonPanel.add(choice1);
    }

    // class that will hold scripts for interactive buttons that progress the game
    public class TitleScreenHandler implements ActionListener{
        public void actionPerformed(ActionEvent event){

            createGameScreen();
        }
    }

}