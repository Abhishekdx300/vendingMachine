package State;
public interface State {

    public void collectCash(int amount);
    public void dispenseChange();
    public void dispenseItem();
    public void cancelTransaction();

    public void userInput();
}
