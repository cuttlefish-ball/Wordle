import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EndGame {
    public static JFrame winner=new JFrame("You Win");
    public static void win(){

        JButton yes=new JButton("Yes");
        winner.add(yes);
        yes.setBounds(10,90,75,20);
        yes.addActionListener(new YesActionListener());

        JButton no=new JButton("No");
        winner.add(no);
        no.setBounds(200,90,75,20);
        no.addActionListener(new NoActionListener());

        JLabel winMessage=new JLabel("<html><body>"+"You have got the right word:<br>"+GameStarter.randomWord+
                "<br>would you like to start a new game?"+"</body></html>");
        winMessage.setFont(new Font("宋体", Font.PLAIN,16));

        winner.add(winMessage);
        winner.setBounds(600,400,300,150);
        winner.setVisible(true);
        winner.setResizable(false);
        winner.setLayout(null);
    }
    public static void lose(){
        JFrame loser=new JFrame("You Lose");
        JLabel loseMessage=new JLabel("<html><body>"+"You have NOT got the right word:<br>"+GameStarter.randomWord+
                "<br>would you like to start a new game?"+"</body></html>");
        loseMessage.setFont(new Font("宋体", Font.PLAIN,16));
        loser.add(loseMessage);
        loser.setBounds(600,400,300,150);
        loser.setVisible(true);
        loser.setResizable(false);
    }
}

class NoActionListener implements ActionListener{
    public void actionPerformed(ActionEvent e) {
        EndGame.winner.dispose();
    }
}

class YesActionListener implements ActionListener{
    public void actionPerformed(ActionEvent e) {
        EndGame.winner.dispose();
        GameStarter.wordle.dispose();
        GameStarter gameStarter=new GameStarter();
    }
}