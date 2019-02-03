import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Simulation {
    //load list of items
    public ArrayList<Item> loadItems(String filename) throws FileNotFoundException{

            File file = new File(filename);
            Scanner scanner = new Scanner(file);
            ArrayList<Item> items = new ArrayList<>();

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] itemProperties = line.split("=");
                int itemWeight = Integer.parseInt(itemProperties[1]);
                Item item = new Item(itemProperties[0], itemWeight);
                items.add(item);
            }
        return items;
    }

    //load a list of U1 rockets
    public ArrayList<Rocket> loadU1(ArrayList<Item> loadedItems) {
        ArrayList<Rocket> rockets = new ArrayList<>();
        U1 u1rocket = new U1();
        rockets.add(u1rocket);
        int y = 0;
        System.out.println("New rocket created: Rocket " + (y+1));
        for (Item item : loadedItems) {
            if(u1rocket.canCarry(item)) {
                u1rocket.carry(item);
                System.out.println("Rocket " + (y+1) + " loaded with: " + item.name + " " + item.weight);
                System.out.println("Current weight:" + u1rocket.currentWeight);
            } else {
                y++;
                u1rocket = new U1();
                rockets.add(u1rocket);
                u1rocket.carry(item);
                System.out.println("Another new rocket created: Rocket " + (y+1));
                System.out.println("Rocket " + (y+1) + " loaded with: " + item.name + " " + item.weight);
                System.out.println("Current weight:" + u1rocket.currentWeight);
            }
        }
        return rockets;
    }
    //load a list of U2 rockets
    public ArrayList<Rocket> loadU2(ArrayList<Item> loadedItems) {
        ArrayList<Rocket> rockets = new ArrayList<>();
        U2 u2rocket = new U2();
        rockets.add(u2rocket);
        int y = 0;
        System.out.println("New rocket created: Rocket " + (y+1));
        for (Item item : loadedItems) {
            if(u2rocket.canCarry(item)) {
                u2rocket.carry(item);
                System.out.println("Rocket " + (y+1) + " loaded with: " + item.name + " " + item.weight);
                System.out.println("Current weight:" + u2rocket.currentWeight);
            } else {
                y++;
                u2rocket = new U2();
                rockets.add(u2rocket);
                u2rocket.carry(item);
                System.out.println("Another new rocket created: Rocket " + (y+1));
                System.out.println("Rocket " + (y+1) + " loaded with: " + item.name + " " + item.weight);
                System.out.println("Current weight:" + u2rocket.currentWeight);
            }
        }
        return rockets;
    }
    //run simulation method
    public int runSimulation (ArrayList<Rocket> rockets) {
        int budget = 0;
        for (Rocket rocket : rockets) {
            System.out.println("Launching rocket...");
            budget += rocket.rocketCost;
            while(!rocket.launch()) {
                System.out.println("Rocket exploded during launching");
                budget += rocket.rocketCost;
                System.out.println("Launching another rocket...");
            }
            while(!rocket.land()) {
                System.out.println("Rocket crashed during landing");
                budget += rocket.rocketCost;
                System.out.println("Launching another rocket...");
            }
            System.out.println("Rocket landed successfully");
        }

        System.out.println("\nBudget for rockets: " + budget + "\n");
        return budget;
    }
}