import java.util.ArrayList;

public class Main {
    public static void main(String [] args) throws Exception{

        Simulation simulation = new Simulation();
        ArrayList<Item> itemList = simulation.loadItems("Phase-1.txt");
        ArrayList<Item> itemList2 = simulation.loadItems("Phase-2.txt");


/*        for (int i = 0; i < itemList.size(); i++) {
            Item item = itemList.get(i);
            System.out.println(item.name + " " + item.weight);
        }

        for (int i = 0; i < itemList2.size(); i++) {
            Item item = itemList2.get(i);
            System.out.println(item.name + " " + item.weight);
        }
*/

        ArrayList<Rocket> rocketList = simulation.loadU1(itemList);
        ArrayList<Rocket> rocketList2 = simulation.loadU2(itemList);
        ArrayList<Rocket> rocketList3 = simulation.loadU1(itemList2);
        ArrayList<Rocket> rocketList4 = simulation.loadU2(itemList2);

/*      for (Rocket i : rocketList) {
            System.out.println("Rocket " + (i+1) + ":\n" + rocketList.get(i).currentWeight);
        }
        System.out.println("\n");
        for (int i = 0; i < rocketList2.size(); i++) {
            System.out.println("Rocket " + (i+1) + ":\n" + rocketList2.get(i).currentWeight);
        }
*/

        int fullBudgetU1 = simulation.runSimulation(rocketList) + simulation.runSimulation(rocketList3);
        int fullBudgetU2 = simulation.runSimulation(rocketList2) + simulation.runSimulation(rocketList4);

        System.out.println("Full budget of U1 rockets is " + fullBudgetU1);
        System.out.println("Full budget of U2 rockets is " + fullBudgetU2);


    }
}