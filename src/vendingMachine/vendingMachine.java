package vendingMachine;

import State.*;

import java.util.HashMap;

public class vendingMachine {
    private int collectedCash;
    private int selectedItemPrice;
    private String currentItemCode;
    private State state;
    private HashMap<String,String> codeToItemMap;
    private HashMap<String,Integer> codeToPriceMap;


    public vendingMachine(HashMap<String, String> codeToItemMap, HashMap<String, Integer> codeToPriceMap){
        this.codeToItemMap = codeToItemMap;
        this.codeToPriceMap = codeToPriceMap;
        this.state = new readyState(this);
    }
    public void setState(State state) {
        this.state = state;
    }


    public void  setCurrentItemCode(String code){
        this.currentItemCode = code;
    }
    public int getCollectedCash(){
        return this.collectedCash;
    }
    public void setCollectedCash(int amount){
        this.collectedCash=0;
    }

    public void cancelTransaction(){
        this.state.cancelTransaction();
    }

    public void dispenseItem(){
        this.state.dispenseItem();
    }

    // possibly lesser than price ---- give limited access to user to choose
    public void dispenseChange(){
        this.state.dispenseChange();
    }
    public int calculateChange(){
        return this.collectedCash - this.selectedItemPrice;
    }
    //user calls it
    public void inputCode(){
        this.state.userInput();
    }

    public void setSelectedItemPrice(String code){
        this.selectedItemPrice = this.codeToPriceMap.get(code);
    }

    public String getItem(){
        return this.codeToItemMap.get(currentItemCode);
    }

}
