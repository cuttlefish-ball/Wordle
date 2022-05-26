import java.awt.event.*;
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class GameStarter {
        public void buildGUI(){
                JFrame  wordle=new JFrame("Wordle");
                wordle.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
                wordle.setVisible(true);
                wordle.setBounds(500,250,500,500);
                wordle.setLayout(new FlowLayout());
                JLabel gameName=new JLabel("WORDLE",SwingConstants.CENTER);

                wordle.add(gameName);
        };
        public void intiGame(){

        };
}
