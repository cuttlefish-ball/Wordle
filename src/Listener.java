import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Listener extends KeyAdapter {
    private int guessTime =0;
    private int guessWordNumber=0;
    private char[] inputWord=new char[5];
//    listen the user's input on the keyboard.
    public void keyPressed(KeyEvent e){
        String inputLetter=String.valueOf((char)e.getKeyCode());
//        if user input letter from 'a' to 'z', get the input and put it on the label.
        if(e.getKeyCode()>=65&&e.getKeyCode()<=90&& guessTime !=5)
        {
            GameStarter.letter[guessTime +5*guessWordNumber].setText(inputLetter);
            inputWord[guessTime]=(char)(e.getKeyCode()+32);
            guessTime++;
        }
//        if the user input Backspace, delete the last input letter.
        if(e.getKeyCode()==KeyEvent.VK_BACK_SPACE&& guessTime >0)
        {
            GameStarter.letter[guessTime -1+5*guessWordNumber].setText(null);
            guessTime--;
        }
//        if the user input Enter, check the word.
        if(e.getKeyCode()==KeyEvent.VK_ENTER&&guessTime==5)
        {

             if(CheckInput.checkValid(String.valueOf(inputWord)))
                {
                    if(String.valueOf(inputWord).equals(GameStarter.randomWord))
                        EndGame.win();
                    else
                    {
                        checkWord(inputWord);
                        guessTime = 0;
                        guessWordNumber++;
                    }
                    if(guessWordNumber==6)
                        EndGame.lose();
                }
            else
                error();
            }
            }

//    when the user's word is not in the wordlist, error happens.
    public void error(){
        JFrame error=new JFrame("error");
        JLabel errorMessage=new JLabel("This word is not in our wordlist.");
        errorMessage.setFont(new Font("宋体", Font.PLAIN,16));
        error.add(errorMessage);
        error.setBounds(600,400,300,100);
        error.setVisible(true);
        error.setResizable(false);
    }

//    check the letter is whether in the answer word and in the right place or not.
    public void checkWord(char[] word){
        for(int i=0;i<5;i++)
        {
            if(GameStarter.randomWord.charAt(i)==word[i])
                GameStarter.letter[i+guessWordNumber*5].setForeground(new Color(0,153,0));
            else if(GameStarter.randomWord.contains(String.valueOf(word[i])))
                GameStarter.letter[i+guessWordNumber*5].setForeground(new Color(255,200,0));
            else
                GameStarter.letter[i+guessWordNumber*5].setForeground(new Color(150,150,150));
        }
    }
}