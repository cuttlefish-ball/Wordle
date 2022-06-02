import javax.swing.*;
import java.awt.*;

public class Letter {
    public JLabel[]letter=new JLabel[30];
    public Letter(){
        for(int i=0;i<30;i++)
        {
            letter[i]=new JLabel("",JLabel.CENTER);
            letter[i].setFont(new Font("宋体",Font.PLAIN,24));
            letter[i].setBorder( BorderFactory.createLineBorder(Color.black));
        }
    }
}
