package State;
import vendingMachine.vendingMachine;

public class dispenseItemState implements State{

    vendingMachine vender;

    public dispenseItemState(vendingMachine machine){
        this.vender = machine;
    }
    @Override
    public void collectCash(int amount) {
throw new RuntimeException("The ongoing transaction need to finish before starting a new one");
    }

    @Override
    public void dispenseChange() {
throw new RuntimeException("The change (if ) has already been dispensed");
    }

    @Override
    public void dispenseItem() {
        System.out.println("The "+this.vender.getItem()+ " is being dispensed" );
        this.vender.setState(new readyState(vender));
        // the initialisation call will be done in main class --- readyState --> collectCash()
    }

    @Override
    public void cancelTransaction() {
throw new RuntimeException("The selected Item is already being dispensed.");
    }

    @Override
    public void userInput() {
        throw new RuntimeException("The selected Item is already being dispensed.");

    }
}
