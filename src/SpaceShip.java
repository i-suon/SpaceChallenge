public interface SpaceShip {
    //method for if rocket has launched
    boolean launch();
    //method for is rocket has landed
    boolean land();
    //method for is rocket can carry item
    boolean canCarry(Item item);
    //method for updating current weight
    int carry(Item item);
}