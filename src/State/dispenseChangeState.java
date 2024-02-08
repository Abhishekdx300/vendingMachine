package State;
import vendingMachine.vendingMachine;
public class dispenseChangeState implements State{

    vendingMachine vender;

    public dispenseChangeState(vendingMachine machine){
        this.vender = machine;
    }
    @Override
    public void collectCash(int amount) {
throw new RuntimeException("The ongoing transaction should end first.");
    }

    @Override
    public void dispenseChange() {
        System.out.println("The change remaining is "+this.vender.calculateChange());
        this.vender.setState(new dispenseItemState(vender));
        this.vender.dispenseItem();
    }

    @Override
    public void dispenseItem() {
        throw new RuntimeException("Item will be dispenced after the change dispension.");

    }

    @Override
    public void cancelTransaction() {
        throw new RuntimeException("Cant cancel transaction. The change is already being dispenced");

    }

    @Override
    public void userInput() {
        throw new RuntimeException("You have already selected your item.");
    }
}
