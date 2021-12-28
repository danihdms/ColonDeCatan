package Game;

import java.util.Collections;
import java.util.LinkedList;
import java.util.Random;

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
    private Player[] players;

    public Game(Player[] player) {
        this.devCards = addDevCards();
        this.resCards = addResCards();
        this.board = new Board();
        if (player.length < 5 && player.length > 2) {
            this.players = player;
        } else {
            System.out.println("Il doit y avoir au minimum 2 joueurs et au maximum 4.");
            throw new IllegalStateException();
        }
    }

    public LinkedList<DevCard> addDevCards() {
        this.devCards = new LinkedList<>();
        for (int i = 0; i < 14; i++) {
            devCards.add(new KnightCard());
        }
        for (int i = 0; i < 5; i++) {
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

    public LinkedList<ResCard> addResCards() {
        this.resCards = new LinkedList<>();
        for (int i = 0; i < 19; i++) {
            resCards.add(new ResCard("ble"));
            resCards.add(new ResCard("bois"));
            resCards.add(new ResCard("argile"));
            resCards.add(new ResCard("minerais"));
            resCards.add(new ResCard("laine"));
        }
        return resCards;
    }
    public int throwDice(){
        Random r=new Random();
        int x=r.nextInt(11)+2;//crée un nombre entre 2 et 12
        return x;
    }
    public boolean endGame(){
        for (Player p : this.players){
            if (p.getV() >= 10){
                return true;
            }
        }
        return false;
    }
    public boolean hasRessourcesToPlaceStructure(Player p){
        //todo :dois verifier que la personne à les ressources suffisante pour placer une structure
        return true;
    }
    public boolean hasRessourcesForRoad(Player p){
        //todo :dois verifier que la personne à les ressources suffisante pour placer une route
        return true;
    }
    public boolean hasRessourcesToUpgrade(Player p){
        //todo :dois verifier que la personne à les ressources suffisante pour améliorer une colonie
        return true;
    }
    public boolean hassRessourcesPickCard(Player p){
        //todo :verifier si la personne à les ressoureces pour piocher une carte
        return true;
    }
    public boolean PrendrePaiement(Player p,ResCard [] resCards){
        //todo :enlever les ressources de la liste au joueur et les remettres dans le paquet commun
        return true;
    }
    public Player[] getPlayers(){
        return this.players;
    }

    public Board getBoard(){
        return this.board;
    }

    public LinkedList<DevCard> getDevCards(){
        return this.devCards;
    }

    public LinkedList<ResCard> getResCards(){
        return this.resCards;
    }
}
