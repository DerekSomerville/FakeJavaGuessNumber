import java.util.Random;

public class RandomInput extends Input{

    private String className = RandomInput.class.getName();

    public RandomInput(){
        if (writeToFile) {
            fileWritter = new WriteToFile(className + ".csv");
        }
    }

    private int maxNumber;

    RandomInput(int maxNumber){
        this();
        this.maxNumber = maxNumber;
    }

    public void setMaxNumber(int maxNumber) {

        this.maxNumber = maxNumber;
    }

    public int getMaxNumber() {
        return maxNumber;
    }

    @Override
    public String getInputString() {
        return String.valueOf(getInputInt());
    }

    @Override
    public int getInputInt() {
        Random rand = new Random();
        int result;
        result = rand.nextInt(maxNumber);
        this.store(Integer.toString(result));
        return result;
    }
}
