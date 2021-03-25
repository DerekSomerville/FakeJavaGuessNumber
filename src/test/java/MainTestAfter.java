import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MainTestAfter {

    private Main getMainWithTestData(TestOutput testOutput){

        ReadFromFile readFromFile = new ReadFromFile();
        TestInput userTestInput = new TestInput();
        List<String> userTestData = readFromFile.readList("ConsoleInput.csv");
        userTestInput.setTestInputs(userTestData);
        TestInput randomTestInput = new TestInput();
        randomTestInput.setTestInputs(readFromFile.readList("RandomInput.csv"));
        Main main = new Main(testOutput,userTestInput,randomTestInput);
        return main;
    }

    @Test
    void play() {
        ReadFromFile readFromFile = new ReadFromFile();
        TestOutput testOutput = new TestOutput();
        List<String> recordedOutput = readFromFile.readList("ConsoleOutput.csv");
        Main main = getMainWithTestData(testOutput);
        main.play();
        System.out.println(recordedOutput);
        System.out.println(testOutput.getTestOutputs());
        assertEquals(recordedOutput,testOutput.getTestOutputs());
    }

    private List<String> convertToLIst(String listToConvert){
        return new ArrayList<String>(Arrays.asList(listToConvert.split(",")));
    }

    @Test
    void hardCodedFakePlay(){
        ReadFromFile readFromFile = new ReadFromFile();
        TestOutput testOutput = new TestOutput();
        String output = "Please guess a random number,enter a larger number to stop," +
                "Please guess a number from 0 to 5," +
                "Correct," +
                "Please guess a number from 0 to 5," +
                "Please guess a number from 0 to 5";
        String userInput = "1,5,9";
        String randomInputString = "1,2,4";
        TestInput userTestInput = new TestInput();
        userTestInput.setTestInputs(convertToLIst(userInput));
        TestInput randomInput = new TestInput();
        randomInput.setTestInputs(convertToLIst(randomInputString));
        Main main = new Main(testOutput,userTestInput,randomInput);
        main.play();
        assertEquals(convertToLIst(output).toString(),testOutput.getTestOutputs().toString());
    }


}