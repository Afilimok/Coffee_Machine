package machine;

public class Coffee {
    private int water;
    private int milk;
    private int coffee;
    private int cost;

    public Coffee (int w, int m, int c){
        water = w;
        milk = m;
        coffee = c;
        setCost(0);
    }
    public Coffee (int w, int m, int c, int costs){
        water = w;
        milk = m;
        coffee = c;
        setCost(costs);

    }

    public int getWater() {
        return water;
    }

    public void setWater(int water) {
        this.water = water;
    }

    public int getMilk() {
        return milk;
    }

    public void setMilk(int milk) {
        this.milk = milk;
    }

    public int getCoffee() {
        return coffee;
    }

    public void setCoffee(int coffee) {
        this.coffee = coffee;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }
}
