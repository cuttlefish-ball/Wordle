import javax.swing.*;
import java.awt.*;
import java.io.*;

public class GameStarter {
        public static String randomWord;
        public static JLabel[]letter=new JLabel[30];
        public static JFrame  wordle=new JFrame("Wordle");
        public GameStarter(){
                buildGUI();
                intiWord();
        }
//        build the game's GUI
        public void buildGUI(){
//                build the frame

                wordle.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
                wordle.setVisible(true);
                wordle.setSize(500,500);
                wordle.setLayout(null);
                wordle.setLocationRelativeTo(null);
                wordle.setResizable(false);
                wordle.addKeyListener(new Listener());
//                set the game name and the letter box
                JLabel gameName=new JLabel("WORDLE");
                gameName.setBounds(200,25,200,50);
                gameName.setFont(new Font("宋体",Font.BOLD,36));
                JPanel guessWord=new JPanel(new GridLayout(6,5,10,10));
                guessWord.setBounds(100,100,300,300);
                wordle.add(guessWord);
                wordle.add(gameName);
//                build the letter sheet
                for(int i=0;i<30;i++)
                {
                        letter[i]=new JLabel("",JLabel.CENTER);
                        letter[i].setFont(new Font("宋体",Font.BOLD,24));
                        letter[i].setBorder( BorderFactory.createLineBorder(Color.black));
                        guessWord.add(letter[i]);
                }
        }

        //      choose a random five-letter-word from the wordlist.
        public void intiWord(){
                int range=1;
                File wordSource=new File("word.txt");
                int randomNumber=(int)(Math.random()*range);
                try{
                        FileReader wordReader=new FileReader(wordSource);
                        BufferedReader wordBuffer=new BufferedReader(wordReader);
                        for(int i=1;i<=range;i++)
                        {
                                randomWord=wordBuffer.readLine();
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
}