package State;

import vendingMachine.vendingMachine;

public class cancelledTransactionState implements State{
    private vendingMachine vender;
    public cancelledTransactionState(vendingMachine vender) {
        this.vender=vender;
    }

    @Override
    public void collectCash(int amount) {
throw new RuntimeException("The ongoing transaction is already being cancelled.");
    }

    @Override
    public void dispenseChange() {
        throw new RuntimeException("The ongoing transaction is already being cancelled.");

    }

    @Override
    public void dispenseItem() {
        throw new RuntimeException("The ongoing transaction is already being cancelled.");
    }

    @Override
    public void cancelTransaction() {
        System.out.println("The collected cash of amount"+this.vender.getCollectedCash()+" is being returned.");
        this.vender.setCollectedCash(0);
        this.vender.setState(new readyState(vender));
    }

    @Override
    public void userInput() {
        throw new RuntimeException("The ongoing transaction is already being cancelled.");

    }
}
