public class Road {
    private Player owner;

    public Road(Player owner) {
        this.owner = owner;
    }

    public Player getOwner(){
        return this.owner;
    }
}