import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MainTestBefore {

    @Test
    void play() {
        ReadFromFile readFromFile = new ReadFromFile();
        TestOutput testOutput = new TestOutput();
        List<String> recordedOutput = readFromFile.readList("ConsoleOutput.csv");
        assertEquals(recordedOutput,testOutput.getTestOutputs());
    }
}