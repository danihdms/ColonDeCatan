import java.util.Collections;
import java.util.LinkedList;

import Cards.DevCard;
import Cards.KnightCard;
import Cards.MonopolyCard;
import Cards.RoadBuildingCard;
import Cards.VictoryCard;
import Cards.YearOfPlentyCard;

public class Game {
    private LinkedList<DevCard> devCards;
    private Board board;

    public Game(){
        this.devCards = addCardsToGame(devCards);
        this.board = new Board();
    }

    public LinkedList<DevCard> addCardsToGame(LinkedList<DevCard> devCards){
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
}
