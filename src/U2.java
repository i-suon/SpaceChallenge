public class U2 extends Rocket {

    public U2() {
        rocketCost = 120000000;
        rocketWeight = 18000;
        maxWeight = 29000;
        explosionChance = 0.04;
        crashingChance = 0.08;
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