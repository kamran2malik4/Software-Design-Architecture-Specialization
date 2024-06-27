// ***** PROBLEM STATEMENT *****//

/*  You are working in an office with an old coffee machine that dispenses two different coffee flavours. 
    However, the new boss wants to add a new coffee machine with a touchscreen that can also connect to the old coffee machine. 
    Complete the provided code to add an adapter so that the new touchscreen will  to work with the old coffee machine. 
    Use the following UML class diagram for a guide: */


// Here is old coffee machine
class OldCoffeeMachine{
    public void selectA(){
        System.out.println("A Selected");
    }
    public void selectB(){
        System.out.println("B Selected");
    }
}

// Interface of New Coffee Machine
interface ICoffeeMachine{
    public void chooseFirstSelection();
    public void chooseSecondSelection();
}

// Here is new coffee machine
class NewCoffeeMachine implements ICoffeeMachine{
    @Override
    public void chooseFirstSelection() {
        System.out.println("Choose first coffee");
    }

    @Override
    public void chooseSecondSelection() {
        System.out.println("Choose second coffee");
    }
}

// This class will adapt old coffee machine so that new coffee machine can also work with old coffee machine
class CoffeeTouchScreenAdapter implements ICoffeeMachine{
    private OldCoffeeMachine machine;
    public CoffeeTouchScreenAdapter(OldCoffeeMachine machine){
        this.machine = machine;
    }

    @Override
    public void chooseFirstSelection() {
        machine.selectA();
    }

    @Override
    public void chooseSecondSelection() {
        machine.selectB();
    }

}


// Client class
public class Main {
    public static void main(String[] args) {
        // Our old coffee machine
        OldCoffeeMachine machine = new OldCoffeeMachine();

        // Now we have connected old coffee machine to new one using adapter
        CoffeeTouchScreenAdapter adapter = new CoffeeTouchScreenAdapter(machine);

        // Now we can use old coffee machine through the adapter of new machine
        adapter.chooseFirstSelection();
    }
}
