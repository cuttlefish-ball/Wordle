import javax.swing.*;
import java.awt.*;
import java.io.*;

public class GameStarter {
        private String randomWord;
        public void buildGUI(){
                JFrame  wordle=new JFrame("Wordle");
                wordle.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
                wordle.setVisible(true);
                wordle.setBounds(500,250,500,500);
                wordle.setLayout(new FlowLayout());
                JLabel gameName=new JLabel("WORDLE",SwingConstants.CENTER);

                wordle.add(gameName);
        }

        //      choose a random five-letter-word from the wordlist.
        public void intiWord(){
                int range=10;
                File wordSource=new File("src/word.txt");
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
