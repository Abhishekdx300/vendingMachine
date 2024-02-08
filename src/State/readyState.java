package State;
import vendingMachine.vendingMachine;

public class readyState implements State{

    private vendingMachine vender;

    public readyState(vendingMachine machine){
        this.vender = machine;
        System.out.println("The Machine is Ready to make a purchace.");
    }
    @Override
    public void collectCash(int amount) {
        vender.setCollectedCash(amount);
        // user chooses the code of product
vender.setState(new userInputState(vender));
vender.inputCode();
    }

    @Override
    public void dispenseChange() {
        throw  new RuntimeException("Please wait for the processing of entered amount.");
    }

    @Override
    public void dispenseItem() {
        throw  new RuntimeException("Please wait for the processing of entered amount.");
    }

    // havent even given money, how will user cancel??
    @Override
    public void cancelTransaction() {
throw new RuntimeException("The transaction hasnt started yet");
    }

    @Override
    public void userInput() {
        throw  new RuntimeException("Please wait for the processing of entered amount.");
    }
}
