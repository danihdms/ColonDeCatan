import java.util.ArrayList;
import java.util.Collections;

public class Board {
    private Tile[][] tiles;
    // private Structure[][] structures;
    // private Road[][] roads;
    private int thiefCoordX;
    private int thiefCoordY;
    private Road endpoint = null;

    public Board() {
        tiles = new Tile[7][7];

        // structures = new Structure[6][];
        // structures[0] = new Structure[4];
        // structures[1] = new Structure[5];
        // structures[2] = new Structure[6];
        // structures[3] = new Structure[6];
        // structures[4] = new Structure[5];
        // structures[5] = new Structure[4];

        // roads = new Road[11][];
        // roads[0] = new Road[3];
        // roads[1] = new Road[4];
        // roads[2] = new Road[4];
        // roads[3] = new Road[5];
        // roads[4] = new Road[5];
        // roads[5] = new Road[6];
        // roads[6] = new Road[5];
        // roads[7] = new Road[5];
        // roads[8] = new Road[4];
        // roads[9] = new Road[4];
        // roads[10] = new Road[3];

        // création d'une listes pour mettre les tiles de façon aléatoire sur le
        // plateau

        ArrayList<Tile> tileList = new ArrayList<Tile>();
        tileList.add(new Tile("foret"));
        tileList.add(new Tile("foret"));
        tileList.add(new Tile("foret"));
        tileList.add(new Tile("foret"));
        tileList.add(new Tile("colline"));
        tileList.add(new Tile("colline"));
        tileList.add(new Tile("colline"));
        tileList.add(new Tile("champ"));
        tileList.add(new Tile("champ"));
        tileList.add(new Tile("champ"));
        tileList.add(new Tile("champ"));
        tileList.add(new Tile("montagne"));
        tileList.add(new Tile("montagne"));
        tileList.add(new Tile("montagne"));
        tileList.add(new Tile("plaine"));
        tileList.add(new Tile("plaine"));
        tileList.add(new Tile("plaine"));
        tileList.add(new Tile("plaine"));
        tileList.add(new Tile("desert", true));

        // Melange de la liste
        Collections.shuffle(tileList);

        // Placement des tuiles et de leur numero
        placeTiles(tileList);
        placeNumbers();

    }

    // voleurLocation = desert.getLocation();

    public void placeTiles(ArrayList<Tile> tileList) {
        // Nous avons decide de ne pas faire un plateau carre mais ressemblant plus a
        // une ile
        int count = 0;
        for (int row = 1; row < 6; row++) {
            switch (row) {
                case 1:
                    for (int col = 1; col < 4; col++) {
                        tiles[col][row] = tileList.get(count);
                        count++;
                    }
                    break;
                case 2:
                    for (int col = 1; col < 5; col++) {
                        tiles[col][row] = tileList.get(count);
                        count++;
                    }
                    break;
                case 3:
                    for (int col = 1; col < 6; col++) {
                        tiles[col][row] = tileList.get(count);
                        count++;
                    }
                    break;
                case 4:
                    for (int col = 2; col < 6; col++) {
                        tiles[col][row] = tileList.get(count);
                        count++;
                    }
                    break;
                case 5:
                    for (int col = 3; col < 6; col++) {
                        tiles[col][row] = tileList.get(count);
                        count++;
                    }
                    break;
            }
        }
    }

    public void placeNumbers() {
        // Ces deux tableaux permettent de placer les numeros sur les tuiles en spirale.
        // Ces numeros ne changent pas, tandis que la place des tuiles change a chaque
        // partie (placées au hasard)
        int[] numberOrder = { 5, 2, 6, 3, 8, 10, 9, 12, 11, 4, 8, 10, 9, 4, 5, 6, 3, 11 }; // ordre des nombres
        int numberTile = 0;
        int[] tileOrder = { 3, 5, 2, 4, 1, 3, 1, 2, 1, 1, 2, 1, 3, 1, 4, 2, 5, 3, 5, 4, 5, 5, 4, 5, 3, 4, 2, 3, 2, 2, 3,
                2, 4, 3, 4, 4, 3, 3 }; // coordonées x et y assignées aux tuiles
        // on assigne les numero à leurs tiles
        for (int s = 0; s < tileOrder.length - 2; s += 2) {

            if (tiles[tileOrder[s]][tileOrder[s + 1]].getType().equals("DESERT")) {
                s = s - 2;
            } else {
                tiles[tileOrder[s]][tileOrder[s + 1]].setNumber(numberOrder[numberTile]);
                numberTile++;
            }
        }
    }

    // Placer une nouvelle structure sur la plateau
    public boolean addStructure(int x, int y, Structure o, String s) {
        if (tiles[x][y].getStructure(s) != null) {
            System.out.println("case déjà occupée");
            return false;
        }
        while (true) {
            switch (s) {
                case "nw":
                    tiles[x][y].setStructure(o, s);
                    if (caseValid(x - 1, y - 1)) {
                        tiles[x - 1][y - 1].setStructure(o, "se");
                    }
                    if (caseValid(x - 1, y)) {
                        tiles[x - 1][y].setStructure(o, "sw");
                    }
                    if (caseValid(x, y - 1)) {
                        tiles[x][y - 1].setStructure(o, "ne");
                    }

                case "ne":
                    tiles[x][y].setStructure(o, s);
                    if (caseValid(x - 1, y)) {
                        tiles[x - 1][y].setStructure(o, "se");
                    }
                    if (caseValid(x - 1, y + 1)) {
                        tiles[x - 1][y + 1].setStructure(o, "sw");
                    }
                    if (caseValid(x, y + 1)) {
                        tiles[x][y + 1].setStructure(o, "nw");
                    }
                case "sw":
                    tiles[x][y].setStructure(o, s);
                    if (caseValid(x + 1, y)) {
                        tiles[x + 1][y].setStructure(o, "nw");
                    }
                    if (caseValid(x, y - 1)) {
                        tiles[x][y - 1].setStructure(o, "se");
                    }
                    if (caseValid(x + 1, y - 1)) {
                        tiles[x + 1][y - 1].setStructure(o, "ne");
                    }
                case "se":
                    tiles[x][y].setStructure(o, s);
                    if (caseValid(x + 1, y + 1)) {
                        tiles[x + 1][y + 1].setStructure(o, "nw");
                    }
                    if (caseValid(x, y + 1)) {
                        tiles[x][y + 1].setStructure(o, "sw");
                    }
                    if (caseValid(x + 1, y)) {
                        tiles[x + 1][y].setStructure(o, "ne");
                    }
            }
            break;
        }
        return true;
    }

    // Placer une nouvelle route sur le plateau
    public boolean addRoad(int x, int y, Road r, String roadPos) {
        if (tiles[x][y].getRoad(roadPos) != null) {
            System.out.println("case déjà occupée");
            return false;
        }
        while (true) {
            switch (roadPos) {
                case "n":
                    tiles[x][y].setRoadOnTile(r, roadPos);
                    if (caseValid(x - 1, y)) {
                        tiles[x - 1][y].setRoadOnTile(r, "s");;
                    }
                case "s":
                    tiles[x][y].setRoadOnTile(r, roadPos);;
                    if (caseValid(x - 1, y)) {
                        tiles[x - 1][y].setRoadOnTile(r, "n");;
                    }
                case "w":
                    tiles[x][y].setRoadOnTile(r, roadPos);;
                    if (caseValid(x, y - 1)) {
                        tiles[x][y - 1].setRoadOnTile(r, "e");;
                    }
                case "e":
                    tiles[x][y].setRoadOnTile(r, roadPos);;
                    if (caseValid(x, y + 1)) {
                        tiles[x][y + 1].setRoadOnTile(r, "w");;
                    }
            }
            break;
        }
        return true;
    }


    public boolean caseValid(int x, int y) {
        switch (x) {
            case 0:
                return false;
            case 1:
                if (y == 0 || y == 4 || y == 5 || y == 6) {
                    return false;
                }
            case 2:
                if (y == 0 || y == 5 || y == 6) {
                    return false;
                }
            case 3:
                if (y == 0 || y == 6) {
                    return false;
                }
            case 4:
                if (y == 0 || y == 1 || y == 6) {
                    return false;
                }
            case 5:
                if (y == 0 || y == 1 || y == 2 || y == 6) {
                    return false;
                }
        }
        return true;
    }


    public Tile[][] getTiles(){
        return this.tiles;
    }
    
    // public Road[][] getRoads(){
    //     return this.roads;
    // }

    // public Structure[][] getStructures(){
    //     return this.structures;
    // }

    // placer les routes
    // distribuer les ressources
    // rechercher sur le plateau les tiles avec le numéro fournie
    // getter setter structure ,routes,voleur
    // placer une colonies meme sans route avec vérification des espaces entre 2
    // colonies d'une même équipe
    // checker et assigner si bon la colonie au joueur
    // checker et assigner si bon la route au joueur
    // regarder si la localisation est corretcte puis upgrade en city
    // verifier la localisation puis deplacer le voleur
    // donner la liste de structure autour du voleur
    // getter pour une tile precise
    // avoir les structures adjacentes autour d'une certain point
    // trouver la plus longue route(optionnel)
    // trouver les routes adjacentes et connecter à une route donné(optionnel)
    // verifier si une localisation est un port

}
