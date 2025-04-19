// imports color for setBackground
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class App {

    // instanciating objects
    JFrame window;
    Container con;
    JPanel titleNamePanel;
    JLabel titleNameLabel;
    Font titleFont = new Font("Comic Sans", Font.PLAIN, 28);

    public static void main(String[] args) throws Exception {
        new App();
    }


    public App() {
        // creates a new JFrame object called window
        // this allows for an actual window to display on a monitor
        window = new JFrame();
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
        titleNamePanel.setBackground(Color.blue);
        con.add(titleNamePanel);

        // allows for a label to be made and customized
        titleNameLabel = new JLabel("Adventure");
        // sets the color of the text to white
        titleNameLabel.setForeground(Color.white);
        // this allows the text from titleNameLable to be added on top of titleNamePanel
        titleNamePanel.add(titleNameLabel);
        // sets the font for the titleNameLabel
        titleNameLabel.setFont(titleFont);


    }
}