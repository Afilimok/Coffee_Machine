package machine;

import java.util.Scanner;

public class CoffeeMachine {
    public int water;
    public int milk;
    public int coffee;
    public int cups;
    public int money;

    public CoffeeMachine(int _water, int _milk, int _coffee, int _cups, int _money) {
        water = _water;
        milk = _milk;
        coffee = _coffee;
        cups = _cups;
        money = _money;
    }

    public void printCoffeeMachine() {
        System.out.format("The coffee machine has:\n" +
                "%d of water\n" +
                "%d of milk\n" +
                "%d of coffee beans\n" +
                "%d of disposable cups\n" +
                "%d of money\n\n", this.water, this.milk, this.coffee, this.cups, this.money);
    }

    public void Take (){
        System.out.format("I gave you $%d\n", this.money);
        this.money = 0;
    }
    public void fillCoffeeMachine(int _water, int _milk, int _coffee, int _cups) {
        this.water += _water;
        this.milk += _milk;
        this.coffee += _coffee;
        this.cups += _cups;
    }
    public boolean Buy (Coffee coffee){

        this.water -= coffee.getWater();
        this.milk -= coffee.getMilk();
        this.coffee -= coffee.getCoffee();
        this.cups--;
        boolean res = true;
        if (this.water <0 ){
            System.out.println("Sorry, not enough water!");
            res = false;
        }
        if (this.milk <0 ){
            System.out.println("Sorry, not enough milk!");
            res = false;
        }
        if (this.coffee <0 ){
            System.out.println("Sorry, not enough coffee!");
            res = false;
        }
        if (this.cups <0 ){
            System.out.println("Sorry, not enough disposable cup!");
            res = false;
        }
        if (res == true){
            this.money += coffee.getCost();
        } else{
            this.water += coffee.getWater();
            this.milk += coffee.getMilk();
            this.coffee += coffee.getCoffee();
            this.cups++;
        }
        return res;
    }

    public  void Fill() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Write how many ml of water do you want to add:");
        int water = scanner.nextInt();
        System.out.println("Write how many ml of milk do you want to add:");
        int milk = scanner.nextInt();
        System.out.println("Write how many grams of coffee beans do you want to add:");
        int coffee = scanner.nextInt();
        System.out.println("Write how many disposable cups of coffee do you want to add:");
        int cups = scanner.nextInt();
        //?&&&
        fillCoffeeMachine(water,milk, coffee, cups);
        //printCoffeeMachine();
    }

    public void Buy (){
        System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu: ");
        Scanner scanner = new Scanner(System.in);
        String c = scanner.nextLine();
        Coffee coffee = new Espresso();
        if (c.equals("back"))
            return;
        if (c.equals("1"))
            coffee = new Espresso();
        if (c.equals("2"))
            coffee = new Latte();
        if (c.equals("3"))
            coffee = new Cappuccino();



        if (this.Buy(coffee)){
            System.out.println("I have enough resources, making you a coffee!");
        }
    }

    public static void main(String[] args) {
        CoffeeMachine coffeeMachine = new CoffeeMachine(400, 540, 120, 9, 550);
        Scanner scanner = new Scanner(System.in);
        System.out.println("Write action (buy, fill, take, remaining, exit): ");
        while (scanner.hasNext()) {
            String command = scanner.nextLine();
            if (command.equals("fill")) {
                coffeeMachine.Fill();
            } else if (command.equals("buy")) {
                coffeeMachine.Buy();
            } else if (command.equals("take")) {
                coffeeMachine.Take();
            } else if (command.equals("remaining")) {
                coffeeMachine.printCoffeeMachine();
            } else if (command.equals("exit")) {
                break;
            }
            System.out.println("Write action (buy, fill, take, remaining, exit): ");

        }
    }
}
