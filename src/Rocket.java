public class Rocket implements SpaceShip {
    int rocketCost;
    int rocketWeight;
    int maxWeight;
    double explosionChance;
    double crashingChance;
    int currentWeight;

    public boolean launch() {
        return true;
    }
    public boolean land() {
        return true;
    }
    public boolean canCarry (Item item) {
        //code for checking if item fits
        if(currentWeight + item.weight <= maxWeight - rocketWeight) {
            return true;
        } else {
            return false;
        }
    }
    public int carry (Item item) {
        //code for updating weight
        currentWeight += item.weight;
        return currentWeight;
    }
}