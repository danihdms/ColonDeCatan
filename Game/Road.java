package Game;
public class Road {
    private Player owner;
    private int id;
    private static int idchange=0;


    public Road(Player owner) {
        this.owner = owner;
        this.id=idchange;
        idchange++;
    }

    public Player getOwner(){
        return this.owner;
    }
    public int getId(){return this.id;}
}