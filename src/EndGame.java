import javax.swing.*;
import java.awt.*;

public class EndGame {
    public static void win(){
        JFrame winner=new JFrame("You Win");
        JLabel winMessage=new JLabel("<html><body>"+"You have got the right word:<br>"+GameStarter.randomWord+
                "<br>would you like to start a new game?"+"</body></html>");
        winMessage.setFont(new Font("宋体", Font.PLAIN,16));
        winner.add(winMessage);
        winner.setBounds(600,400,300,100);
        winner.setVisible(true);
        winner.setResizable(false);
    }
    public static void lose(){
        JFrame loser=new JFrame("You Lose");
        JLabel loseMessage=new JLabel("<html><body>"+"You have NOT got the right word:<br>"+GameStarter.randomWord+
                "<br>would you like to start a new game?"+"</body></html>");
        loseMessage.setFont(new Font("宋体", Font.PLAIN,16));
        loser.add(loseMessage);
        loser.setBounds(600,400,300,100);
        loser.setVisible(true);
        loser.setResizable(false);
    }

}
