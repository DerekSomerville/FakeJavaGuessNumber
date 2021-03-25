import java.util.Scanner;

public class ConsoleInput extends Input{

    private String className = ConsoleInput.class.getName();

    public ConsoleInput(){
        if (writeToFile) {
            fileWritter = new WriteToFile(className + ".csv");
        }
    }

    public String getInputString(){
        Scanner userInput = new Scanner(System.in);
        String result = userInput.nextLine();
        this.store(result);
        return result;
    }
}
