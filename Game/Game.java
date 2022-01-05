package Game;

import java.util.ArrayList;
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
    private boolean firtsTo3Knight = false;
    private int LonguestRoad=0;
    private Player hasTheLonguestR;

    public Game(Player[] player) {
        this.devCards = addDevCards();
        this.resCards = addResCards();
        this.board = new Board();
        if (player.length < 5 && player.length > 2) {
            this.players = player;
        } else {
            System.out.println("Il doit y avoir au minimum 3 joueurs et au maximum 4.");
            throw new IllegalStateException();
        }
    }
    public boolean seeHasTheLonguest(Player p,int x,int y,String pos){
        int test=this.getBoard().longuestRoad(p, x, y, pos, "h&b");
        if (setLonguestRP(test, p)){
            return true;
        }
        return false;
    }
    public boolean setLonguestRP(int l,Player p){
        if (l > this.LonguestRoad){
            this.LonguestRoad=l;
            this.hasTheLonguestR=p;
            return true;
        } 
        return false;

    }

    public void setfirstTo3Knigths() {
        this.firtsTo3Knight = true;
    }

    public boolean getFirtsTo3Knight() {
        return this.firtsTo3Knight;
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
            resCards.add(new ResCard("blé"));
            resCards.add(new ResCard("bois"));
            resCards.add(new ResCard("argile"));
            resCards.add(new ResCard("minerais"));
            resCards.add(new ResCard("laine"));
        }
        return resCards;
    }

    public int throwDice() {
        Random r = new Random();
        int x = r.nextInt(12) + 2;// crée un nombre entre 2 et 12
        return x;
    }

    public int getRandom(int range) {
        Random r = new Random();
        int x = r.nextInt(range);
        return x;
    }

    public boolean endGame() {
        for (Player p : this.players) {
            int Vp=p.getV();
            if (p==this.hasTheLonguestR){
                Vp=Vp+2;
            }
            if (Vp >= 10) {
                return true;
            }
        }
        return false;
    }

    public boolean hasRessourcesToPlaceStructure(Player p) {
        // verifier que la personne à les ressources suffisante pour placer une
        // structure

        if (hasRessources(1, new ResCard("argile"), p) && hasRessources(1, new ResCard("bois"), p)
                && hasRessources(1, new ResCard("blé"), p) && hasRessources(1, new ResCard("laine"), p)) {
            return true;
        }
        return false;
    }

    public boolean hasRessourcesForRoad(Player p) {
        // verifier que la personne à les ressources suffisante pour placer une route

        if (hasRessources(1, new ResCard("argile"), p) && hasRessources(1, new ResCard("bois"), p)) {
            return true;
        }
        return false;
    }

    public boolean hasRessourcesToUpgrade(Player p) {
        // verifier que la personne à les ressources suffisante pour améliorer une
        // colonie
        if (hasRessources(2, new ResCard("blé"), p) && hasRessources(3, new ResCard("minerais"), p)) {
            return true;
        }
        return false;
    }

    public boolean hassRessourcesPickCard(Player p) {
        // verifier si la personne à les ressoureces pour piocher une carte

        if (hasRessources(1, new ResCard("blé"), p) && hasRessources(1, new ResCard("minerais"), p)
                && hasRessources(1, new ResCard("laine"), p)) {
            return true;
        }
        return false;
    }

    public boolean PrendrePaiement(Player p, ResCard[] resCardss) {
        // enlever les ressources de la liste au joueur et les remettres dans le paquet
        // commun
        for (int i = 0; i < resCardss.length; i++) {
            enleveRessources(resCardss[i], p);
        }
        return true;
    }

    public boolean hasRessources(int n, ResCard r, Player p) {
        int count = 0;
        for (ResCard card : p.getResC()) {
            if (card.getType().equals(r.getType())) {
                count++;
            }
        }
        if (count >= n) {
            return true;
        }
        return false;
    }

    public void enleveRessources(ResCard r, Player p) {
        for (int i = 0; i < p.getResC().size(); i++) {
            if (p.getResC().get(i).getType().equals(r.getType())) {
                p.getResC().remove(i);
                this.resCards.push(r);
                break;
            }
        }
    }

    public void giveRessources(ResCard r, Player p) {
        for (int i = 0; i < this.resCards.size(); i++) {
            if (this.resCards.get(i).getType().equals(r.getType())) {
                p.getResC().push(r);
                this.resCards.remove(i);
                break;
            }
        }
    }

    public boolean distribution(int x) {
        if (x < 13 && x > 1) {
            Tile[] temp = board.getTileByNumber(x);
            for (int i = 0; i < temp.length; i++) {
                if (temp[i] != null && !temp[i].hasThief()) {
                    Structure[] Stemp = board.getListColonies(temp[i]);
                    for (int j = 0; j < Stemp.length; j++) {
                        if (Stemp[j] != null) {
                            if (Stemp[j].getType() == 0) {
                                giveRessources(new ResCard(temp[i].getType()), Stemp[j].getOwner());
                            }
                            if (Stemp[j].getType() == 1) {
                                giveRessources(new ResCard(temp[i].getType()), Stemp[j].getOwner());
                                giveRessources(new ResCard(temp[i].getType()), Stemp[j].getOwner());
                            }
                        }
                    }
                }
            }
            return true;
        } else {
            return false;
        }
    }

    public void giveVictoryP(Player p) {
        p.setV(p.getV() + 1);
    }

    public void throwCard(Player p) {
        DevCard s = devCards.pop();
        p.getDevC().push(s);
        System.out.println("Vous avez piochez :" + s.getType());
    }

    public boolean structuresFull() {
        boolean noEmptySpot = true;
        for (int i = 1; i < 6; i++) {
            for (int j = 1; j < 6; j++) {
                if (board.caseValid(i, j)) {
                    Tile tile = board.getTiles()[i][j];
                    if (tile.getNo() != null || tile.getNe() != null || tile.getSe() != null || tile.getSo() != null) {
                        noEmptySpot = false;
                    }
                }
            }
        }
        if (noEmptySpot)
            System.out.println("Il n'y a plus d'emplacement vide pour placer une structure.");
        return noEmptySpot;
    }

    public boolean roadsFull() {
        boolean noEmptySpot = true;
        for (int i = 1; i < 6; i++) {
            for (int j = 1; j < 6; j++) {
                if (board.caseValid(i, j)) {
                    Tile tile = board.getTiles()[i][j];
                    if (tile.getN() != null || tile.getS() != null || tile.getE() != null || tile.getO() != null) {
                        noEmptySpot = false;
                    }
                }
            }
        }
        if (noEmptySpot)
            System.out.println("Il n'y a plus d'emplacement vide pour placer une road.");
        return noEmptySpot;
    }

    public void addAIStructure(Player player) {
        String[] pos = { "ne", "se", "no", "so" };
        int x, y, z;
        do {
            Random r = new Random();
            x = r.nextInt(6) + 1;
            y = r.nextInt(6) + 1;
            z = r.nextInt(4);
            Integer[] coordinates = { x, y, z };
            player.getStructures().add(coordinates);
        } while (!board.addStructure(x, y, new Structure(0, player), pos[z]));
    }

    public void addAIRoad(Player player) {
        int x, y, z;
        String[] pos = { "n", "s", "o", "e" };
        do {
            Random r = new Random();
            x = r.nextInt(6) + 1;
            y = r.nextInt(6) + 1;
            z = r.nextInt(4);
        } while (!board.addRoad(x, y, new Road(player), pos[z]));
        seeHasTheLonguest(player, x, y, pos[z]);
        this.getBoard().rebootList();
                            
    }

    public Integer[] getCoordinatesOfStructure(Player player) {
        if (!player.getStructures().isEmpty()) {
            return player.getStructures().removeFirst();
        }
        throw new IllegalStateException();
    }

    public void setAIThief() {
        Random r = new Random();
        int x = r.nextInt(6) + 1;
        int y = r.nextInt(6) + 1;
        if (!board.setThief(x, y)) {
            setAIThief();
        }
    }

    public Player[] getPlayers() {
        return this.players;
    }

    public Board getBoard() {
        return this.board;
    }

    public LinkedList<DevCard> getDevCards() {
        return this.devCards;
    }

    public LinkedList<ResCard> getResCards() {
        return this.resCards;
    }

    public boolean AcotéDunPort(Player p) {
        if(board.getTiles()[1][1].hasStructure(p, "no") || board.getTiles()[1][1].hasStructure(p, "ne")){return true;}
        if(board.getTiles()[1][3].hasStructure(p, "no") || board.getTiles()[1][3].hasStructure(p, "ne")){return true;}
        if(board.getTiles()[2][1].hasStructure(p, "no") || board.getTiles()[2][1].hasStructure(p, "so")){return true;}
        if(board.getTiles()[4][5].hasStructure(p, "se") || board.getTiles()[4][5].hasStructure(p, "ne")){return true;}
        if(board.getTiles()[5][3].hasStructure(p, "se") || board.getTiles()[5][3].hasStructure(p, "so")){return true;}
        if(board.getTiles()[5][5].hasStructure(p, "se") || board.getTiles()[5][5].hasStructure(p, "so")){return true;}

       
        return false;
        
    }
    public ArrayList<String> ListPortPlayer(Player p){
        ArrayList<String> fin=new ArrayList<String>();
        if(board.getTiles()[1][1].hasStructure(p, "no") || board.getTiles()[1][1].hasStructure(p, "ne")){fin.add(board.getTiles()[0][1].getType());}
        if(board.getTiles()[1][3].hasStructure(p, "no") || board.getTiles()[1][3].hasStructure(p, "ne")){fin.add(board.getTiles()[0][3].getType());}
        if(board.getTiles()[2][1].hasStructure(p, "no") || board.getTiles()[2][1].hasStructure(p, "so")){fin.add(board.getTiles()[2][0].getType());}
        if(board.getTiles()[4][5].hasStructure(p, "se") || board.getTiles()[4][5].hasStructure(p, "ne")){fin.add(board.getTiles()[4][6].getType());}
        if(board.getTiles()[5][3].hasStructure(p, "se") || board.getTiles()[5][3].hasStructure(p, "so")){fin.add(board.getTiles()[6][3].getType());}
        if(board.getTiles()[5][5].hasStructure(p, "se") || board.getTiles()[5][5].hasStructure(p, "so")){fin.add(board.getTiles()[6][5].getType());}
        
        return fin;
    }
    public String PlayerStat(Player p){
        
        int countLaine =0;
        int CountBle=0;
        int CountArgile=0;
        int CountBois=0;
        int CountMinerais=0;
        for (ResCard res : p.getResC()){
            switch(res.getType()){
                case "laine":
                    countLaine++;
                    break;
                case "blé":
                    CountBle++;
                    break;
                case "argile":
                    CountArgile++;
                    break;
                case "minerais":
                    CountMinerais++;
                    break;
                case "bois":
                    CountBois++;
                    break;
                default :
                break;
            }
        }
        return "Laine = "+countLaine+" | Blé = "+CountBle+" | Argile = "+CountArgile+" | Minerais = "+CountMinerais+" | Bois = "+CountBois+ " | Point de Victoire = "+p.getV();
    }

}
