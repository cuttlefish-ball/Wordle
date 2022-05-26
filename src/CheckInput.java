import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class CheckInput {
//    check the input whether is a five-letter-word
    public boolean checkValid(String guess){
        File wordSource=new File("src/word.txt");
        boolean check=false;
        if(guess.length()!=5)
            return false;
        try{
            FileReader wordReader=new FileReader(wordSource);
            BufferedReader wordBuffer=new BufferedReader(wordReader);
            for(int i=1;i<=2000;i++)
                if(wordBuffer.readLine().equals(guess))
                {
                    check=true;
                    break;
                }
            wordBuffer.close();
            wordReader.close();
        }
        catch (IOException e) {
            System.out.println("the wordlist is not found.");
        }
    return check;
    }

    public boolean checkRight(){
    return true;
    }

}
