import java.util.List;

public class TestInput extends Input{

    private List<String> testInputs;

    public void setTestInputs(List<String> inputs){
        testInputs = inputs;
    }

    public String getInputString(){

        String result = testInputs.remove(0);
        return result;
    }

}