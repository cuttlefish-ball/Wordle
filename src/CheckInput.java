import java.io.*;

public class CheckInput {
//    check the input whether is a five-letter-word
    public static boolean checkValid(String guess){
        File wordSource=new File("word.txt");
        boolean checkOutcome=false;
        try{
            FileReader wordReader=new FileReader(wordSource);
            BufferedReader wordBuffer=new BufferedReader(wordReader);
            for(int i=1;i<=2000;i++)
                if(wordBuffer.readLine().equals(guess))
                {
                    checkOutcome=true;
                    break;
                }
            wordBuffer.close();
            wordReader.close();
        }
        catch (IOException e) {
            System.out.println("the wordlist is not found.");
        }
    return checkOutcome;
    }

    public boolean checkRight(String word){
       return word.equals(GameStarter.randomWord);
    }

}
