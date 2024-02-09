## Vending Machine :

- State pattern used.
- The Context (vendingMachine) stores instance of concrete classes of State Interface.
- The State Interface classes also stores the reference to the main vendingMachine instance.
- When we call the methods of vendingMachine, it calls subsequent methods of current State.
- they do their part of work and changes the state of vendingMachine instance and this process goes on.
- It's like an implementation of Finite State Machine of FLAT.