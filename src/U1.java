public class U1 extends Rocket {

    public U1() {
        rocketCost = 100000000;
        rocketWeight = 10000;
        maxWeight = 18000;
        explosionChance = 0.05;
        crashingChance = 0.01;
        currentWeight = 0;
    }

    public boolean launch() {
        int randomNum = (int)(Math.floor(Math.random() * 101));
        double explosionPercent;
        explosionPercent = explosionChance * ((double)currentWeight/(double)maxWeight) * 100;
        return explosionPercent <= randomNum;
    }

    public boolean land() {
        int randomNum = (int)(Math.floor(Math.random() * 101));
        double crashingPercent;
        crashingPercent = crashingChance * ((double)currentWeight/(double)maxWeight) * 100;
        return crashingPercent <= randomNum;
    }
}