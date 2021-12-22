import java.util.Collections;
import java.util.LinkedList;

import Cards.DevCard;
import Cards.KnightCard;
import Cards.MonopolyCard;
import Cards.ResCard;
import Cards.RoadBuildingCard;
import Cards.VictoryCard;
import Cards.YearOfPlentyCard;

public class Game {
    private LinkedList<DevCard> devCards;
    private LinkedList<ResCard> resCards;
    private Board board;

    public Game(){
        this.devCards = addDevCards();
        this.resCards = addResCards();
        this.board = new Board();
    }

    public LinkedList<DevCard> addDevCards(){
        this.devCards = new LinkedList<>();
        for(int i = 0; i < 14; i++){
            devCards.add(new KnightCard());
        }
        for(int i = 0; i < 5; i++){
            devCards.add(new VictoryCard());
        }
        devCards.add(new RoadBuildingCard());
        devCards.add(new RoadBuildingCard());
        devCards.add(new MonopolyCard());
        devCards.add(new MonopolyCard());
        devCards.add(new YearOfPlentyCard());
        devCards.add(new YearOfPlentyCard());

        Collections.shuffle(devCards);
        return devCards;
    }

    public LinkedList<ResCard> addResCards(){
        this.resCards = new LinkedList<>();
        for(int i = 0; i < 19; i++){
            resCards.add(new ResCard("ble"));
            resCards.add(new ResCard("bois"));
            resCards.add(new ResCard("argile"));
            resCards.add(new ResCard("minerais"));
            resCards.add(new ResCard("laine"));
        }
        return resCards;
    }
}
