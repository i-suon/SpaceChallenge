import java.util.ArrayList;

public class Main {
    public static void main(String [] args) throws Exception{

        Simulation simulation = new Simulation();
        ArrayList<Item> itemList = simulation.loadItems("Phase-1.txt");
        ArrayList<Item> itemList2 = simulation.loadItems("Phase-2.txt");

        ArrayList<Rocket> rocketList = simulation.loadU1(itemList);
        ArrayList<Rocket> rocketList2 = simulation.loadU2(itemList);
        ArrayList<Rocket> rocketList3 = simulation.loadU1(itemList2);
        ArrayList<Rocket> rocketList4 = simulation.loadU2(itemList2);

        int fullBudgetU1 = simulation.runSimulation(rocketList) + simulation.runSimulation(rocketList3);
        int fullBudgetU2 = simulation.runSimulation(rocketList2) + simulation.runSimulation(rocketList4);

        System.out.println("Full budget of U1 rockets is " + fullBudgetU1);
        System.out.println("Full budget of U2 rockets is " + fullBudgetU2);


    }
}
