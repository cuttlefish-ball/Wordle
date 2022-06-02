import javax.swing.*;
import java.awt.*;
import java.io.*;

public class GameStarter {
        private String randomWord;

//        build the game's GUI
        public void buildGUI(){
//                set the frame
                JFrame  wordle=new JFrame("Wordle");
                wordle.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
                wordle.setVisible(true);
                wordle.setSize(500,500);
                wordle.setLayout(null);
                wordle.setLocationRelativeTo(null);
                wordle.setResizable(false);
//                set the game name and the letter box
                JLabel gameName=new JLabel("WORDLE");
                gameName.setBounds(200,25,200,50);
                gameName.setFont(new Font("宋体",Font.BOLD,36));
                JPanel guessWord=new JPanel(new GridLayout(6,5,10,10));
                guessWord.setBounds(100,100,300,300);
                wordle.add(guessWord);
                wordle.add(gameName);
                Letter l=new Letter();
                for(int i=0;i<30;i++)
                {
                        guessWord.add(l.letter[i]);
                }
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
