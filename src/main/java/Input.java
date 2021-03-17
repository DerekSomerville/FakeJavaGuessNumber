import java.util.List;

public abstract class Input extends Display{

    public abstract String getInputString();

    public int getInputInt(){
        int result;
        String input;
        result = -1;
        do {
            try {
                input = this.getInputString();
                result = Integer.parseInt(input);
            } catch (NumberFormatException exception) {
                System.out.println("Please enter a integer");
            }
        } while (result < 0);

        return result;
    }

}
