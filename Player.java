import java.util.LinkedList;

public class Player {
    private String color; // red, green, blue or yellow
    private LinkedList<DevCard> devCards;
    private LinkedList<ResCard> resCards;

    public Player(String color){
        this.color = color;
        this.devCards = new LinkedList<DevCard>();
        this.resCards = new LinkedList<ResCard>();
    }

    public String getColor(){
        return color;
    }
}
