package Game;
import java.util.LinkedList;

import Cards.DevCard;
import Cards.ResCard;

public class Player {
    private String name;
    private String color; // red, green, blue or yellow
    private boolean human;
    private LinkedList<DevCard> devCards;
    private LinkedList<ResCard> resCards;
    private int nbSettelments = 5;
    private int nbCities = 4;
    private int nbRoads = 15;
    private int nbVictoryPoints = 0;

    public Player(String name, String color, boolean human){
        this.name = name;
        this.color = color;
        this.devCards = new LinkedList<DevCard>();
        this.resCards = new LinkedList<ResCard>();
        this.human = human;
    }

    public String getColor(){
        return color;
    }

    public String getName(){
        return this.name;
    }

    public boolean getHuman(){
        return this.human;
    }
    public int getV(){
        return this.nbVictoryPoints;
    }
    public LinkedList<DevCard> getDevC(){
        return this.devCards;
    }
    public LinkedList<ResCard> getResC(){
        return this.resCards;
    }
}
