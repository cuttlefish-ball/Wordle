import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class EndGame {
    public static JFrame result;
    public static void end(boolean outcome){
//        build the end game GUI
        result=new JFrame();
        JButton yes=new JButton("Yes");
        result.add(yes);
        yes.setBounds(10,90,75,20);
        yes.addActionListener(new YesActionListener());

        JButton no=new JButton("No");
        result.add(no);
        no.setBounds(200,90,75,20);
        no.addActionListener(new NoActionListener());

        JLabel message = new JLabel();
        message.setFont(new Font("宋体", Font.PLAIN, 16));

//        output the different message depending on winning or losing the game
        if (outcome) {
            message.setText("<html><body>" + "You have got the right word:<br>" + GameStarter.randomWord +
                    "<br>would you like to start a new game?" + "</body></html>");
            result.setTitle("You win");
        }
        else{
            message.setText("<html><body>" + "You have NOT got the right word:<br>" + GameStarter.randomWord +
                    "<br>would you like to start a new game?" + "</body></html>");
            result.setTitle("You lose");
        }

        result.add(message);
        result.setBounds(600,400,300,150);
        result.setVisible(true);
        result.setResizable(false);
        result.setLayout(null);
    }
}

//when the user chooses "NO", exit the game
class NoActionListener implements ActionListener{
    public void actionPerformed(ActionEvent e) {
        System.exit(0);
    }
}

//when the user chooses "YES", restart the game
class YesActionListener implements ActionListener{
    public void actionPerformed(ActionEvent e) {
        EndGame.result.dispose();
        GameStarter.wordle.dispose();
        GameStarter gameStarter=new GameStarter();
    }
}



