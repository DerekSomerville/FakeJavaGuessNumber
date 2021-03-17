import org.junit.jupiter.api.Test;

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
}