import javax.swing.*;
import java.awt.*;
import java.io.*;

public class GameStarter {
        private String randomWord;
        public JLabel[] letter=new JLabel[30];
//        build the game's GUI
        public void buildGUI(){
//                set the frame
                JFrame  wordle=new JFrame("Wordle");
                wordle.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
                wordle.setVisible(true);
                wordle.setSize(500,500);
                wordle.setLayout(null);
                wordle.setLocationRelativeTo(null);
//                set the game name and the letter box
                JLabel gameName=new JLabel("WORDLE");
                gameName.setBounds(200,25,200,50);
                gameName.setFont(new Font("宋体",1,36));
                JPanel guessWord=new JPanel(new GridLayout(6,5,10,10));
                guessWord.setBounds(100,100,300,300);
                for(int i=0;i<30;i++)
                {
                        letter[i]=new JLabel("",JLabel.CENTER);
                        letter[i].setFont(new Font("宋体",1,24));
                        letter[i].setBorder( BorderFactory.createLineBorder(Color.black));
                        guessWord.add(letter[i]);
                }
                wordle.add(guessWord);
                wordle.add(gameName);
        }

        //      choose a random five-letter-word from the wordlist.
        public void intiWord(){
                int range=10;
                File wordSource=new File("word.txt");
                int randomNumber=(int)(Math.random()*range);
                try{
                        FileReader wordReader=new FileReader(wordSource);
                        BufferedReader wordBuffer=new BufferedReader(wordReader);
                        for(int i=1;i<=range;i++)
                        {
                                this.randomWord=wordBuffer.readLine();
                                if(i==randomNumber)
                                        break;
                        }
                        wordBuffer.close();
                        wordReader.close();
                }
                catch (IOException e) {
                        System.out.println("the wordlist is not found.");
                }
        }
        public String getRandomWord(){
                return this.randomWord;
        }
}
