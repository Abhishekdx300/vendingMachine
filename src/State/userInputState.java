package State;

import vendingMachine.vendingMachine;

import java.util.Scanner;

public class userInputState implements State{
    private vendingMachine vender;

    public userInputState(vendingMachine machine){
        this.vender = machine;
    }
    @Override
    public void collectCash(int amount) {
throw new RuntimeException("Please choose your before proceeding to next transaction.");
    }

    @Override
    public void dispenseChange() {
        throw new RuntimeException("Please choose your before proceeding to next transaction.");

    }

    @Override
    public void dispenseItem() {
        throw new RuntimeException("Please choose your before proceeding to next transaction.");

    }

    @Override
    public void cancelTransaction() {
        this.vender.setState(new cancelledTransactionState(vender));
vender.cancelTransaction();

    }

    @Override
    public void userInput() {

        Scanner scanner = new Scanner(System.in);
        String code = scanner.nextLine();
        scanner.close();
        // give limited option for user - if less amount
        this.vender.setSelectedItemPrice(code);
        this.vender.setCurrentItemCode(code);

        this.vender.setState(new dispenseChangeState(vender));
        this.vender.dispenseChange();
    }
}
