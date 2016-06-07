package org.gumball.machine;

public class GumballMachine {
    public static final int STATE_SOLD_OUT = 0;
    public static final int STATE_NO_QUARTER = 1;
    public static final int STATE_HAS_QUARTER = 2;
    public static final int STATE_SOLD = 3;

    private int currentState;
    private int remainingGumball;

    public GumballMachine(int remainingGumball) {
        this.remainingGumball = remainingGumball;
        this.currentState = this.remainingGumball > 0 ? STATE_NO_QUARTER : STATE_SOLD_OUT;
    }

    public void insertQuarter() {
        switch(this.currentState) {
            case STATE_HAS_QUARTER:
                System.out.println("You can't insert another quarter");
            break;
            case STATE_NO_QUARTER:
                this.currentState = STATE_HAS_QUARTER;
                System.out.println("You inserted a quarter");
            break;
            case STATE_SOLD_OUT:
                System.out.println("You can't insert a quarter, the machine is sold out");
            break;
            case STATE_SOLD:
                System.out.println("Please wait, we're already giving you a gumball");
            break;
        }
    }

    public void ejectQuarter() {
        switch(this.currentState) {
            case STATE_HAS_QUARTER:
                System.out.println("Quarter returned");
                this.currentState = STATE_NO_QUARTER;
            break;
            case STATE_NO_QUARTER:
                System.out.println("You haven't inserted a quarter");
            break;
            case STATE_SOLD_OUT:
                System.out.println("You can't eject, you haven't a quarter");
            break;
            case STATE_SOLD:
                System.out.println("Sorry, you already turned the crank");
            break;
        }
    }

    public void turnCrank() {
        switch(this.currentState) {
            case STATE_HAS_QUARTER:
                System.out.println("You turned...");
                this.currentState = STATE_SOLD;
                dispense();
            break;
            case STATE_NO_QUARTER:
                System.out.println("You turned, but there is no quarter");
            break;
            case STATE_SOLD_OUT:
                System.out.println("There is no gumball anymore, sorry...");
            break;
            case STATE_SOLD:
                System.out.println("Turnning twice doesn't give you another gumball");
            break;
        }
    }

    public void dispense() {
        switch(this.currentState) {
            case STATE_HAS_QUARTER:
                System.out.println("No gumball dispensed");
            break;
            case STATE_NO_QUARTER:
                System.out.println("Quarter first...");
            break;
            case STATE_SOLD_OUT:
                System.out.println("No more gumball for you...");
            break;
            case STATE_SOLD:
                System.out.println("Gumball comes rolling out the slot");
                this.remainingGumball--;

                if(this.remainingGumball == 0) {
                    System.out.println("Oops, out of gumballs now!!!");
                    this.currentState = STATE_SOLD_OUT;
                } else {
                    this.currentState = STATE_NO_QUARTER;
                }
            break;
        }   
    }

    @Override
    public String toString() {
        return "Gumball Machine" + "\n" + 
                "Inventory: " + this.remainingGumball + "\n" + 
                "Machine is " + this.getStringMachineState() + "\n\n";
    }

    private String getStringMachineState() {
        switch(this.currentState) {
            case STATE_SOLD_OUT:
                return "sold out";
            case STATE_SOLD:
                return "sold";
            case STATE_NO_QUARTER:
                return "waiting for quarter";
            case STATE_HAS_QUARTER:
                return "ready to crank";
        }

        throw new UnsupportedOperationException("The current state is undefined: " + this.currentState);
    }

}