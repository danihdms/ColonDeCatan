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
    public int nbSettelments = 5;
    public int nbCities = 4;
    public int nbRoads = 15;
    private int nbVictoryPoints = 0;

    private LinkedList<Integer[]> structures;
    // Only useful for AI since it makes random moves.

    public Player(String name, String color, boolean human){
        this.name = name;
        this.color = color;
        this.devCards = new LinkedList<DevCard>();
        this.resCards = new LinkedList<ResCard>();
        this.human = human;

        this.structures = new LinkedList<>();
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
    public void setV(int n){
        this.nbVictoryPoints=n;
    }
    public LinkedList<DevCard> getDevC(){
        return this.devCards;
    }
    public LinkedList<ResCard> getResC(){
        return this.resCards;
    }

    public int getNbSettlements(){
        return nbSettelments;
    }

    public int getNbCities(){
        return nbSettelments;
    }

    public int getNbRoads(){
        return this.nbRoads;
    }

    public LinkedList<Integer[]> getStructures(){
        return this.structures;
    }
}
