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
        // The order of the numbers to be assigned to the tiles, followed by an int to be used as an index
		int[] numberOrder = {5,2,6,3,8,10,9,12,11,4,8,10,9,4,5,6,3,11};
		int numberTile = 0;

		// The x y pairs to proceed in a spiral
		int[] tileOrder = {3,5, 2,4, 1,3, 1,2, 1,1, 2,1, 3,1, 4,2, 5,3, 5,4, 5,5, 4,5, 3,4, 2,3, 2,2, 3,2, 4,3, 4,4, 3,3};
        

		// Assigning all values from numberOrder to the Tiles in the board, proceeding in a spiral
		for (int n = 0; n < tileOrder.length - 1; n+=2) {
			if (numberTile == 18){
				break;
			}
			
			if (tiles[tileOrder[n]][tileOrder[n+1]].getType().equals("desert")) {
                tiles[tileOrder[n]][tileOrder[n+1]].setNumber(7);
			}
			else {
				tiles[tileOrder[n]][tileOrder[n+1]].setNumber(numberOrder[numberTile]);
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
        //verifier la regle des deux cases d'écart entre ces colonies
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
        //rajouter la condition de si il y a une route au joueur autour
        while (true) {
            switch (roadPos) {
                case "n":
                    tiles[x][y].setRoadOnTile(r, roadPos);
                    if (caseValid(x - 1, y)) {
                        tiles[x - 1][y].setRoadOnTile(r, "s");
                        ;
                    }
                case "s":
                    tiles[x][y].setRoadOnTile(r, roadPos);
                    ;
                    if (caseValid(x - 1, y)) {
                        tiles[x - 1][y].setRoadOnTile(r, "n");
                        ;
                    }
                case "w":
                    tiles[x][y].setRoadOnTile(r, roadPos);
                    ;
                    if (caseValid(x, y - 1)) {
                        tiles[x][y - 1].setRoadOnTile(r, "e");
                        ;
                    }
                case "e":
                    tiles[x][y].setRoadOnTile(r, roadPos);
                    ;
                    if (caseValid(x, y + 1)) {
                        tiles[x][y + 1].setRoadOnTile(r, "w");
                        ;
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

    // rechercher sur le plateau les tiles avec le numéro fournie
    public Tile[] getTileByNumber(int x) {
        if (x > 1 && x < 13) {
            if (x == 2 || x == 12) {
                Tile[] t = new Tile[1];

                for (int i = 1; i < 6; i++) {
                    for (int j = 1; j < 6; j++) {
                        if (tiles[i][j].getNumber() == x) {
                            t[0] = tiles[i][j];

                        }
                    }
                }
                return t;
            } else {
                Tile[] t = new Tile[1];
                int count = 0;
                for (int i = 1; i < 6; i++) {
                    for (int j = 1; j < 6; j++) {
                        if (tiles[i][j].getNumber() == x) {
                            t[count] = tiles[i][j];
                            count++;

                        }
                    }
                }
                return t;

            }
        } else {
            return null;
        }

    }

    // retourne les coordonnées ou se trouve le voleur
    public int[] getThief() {
        int[] t = new int[2];
        for (int i = 1; i < 6; i++) {
            for (int j = 1; j < 6; j++) {
                if (tiles[i][j] != null) {
                    if (tiles[i][j].hasThief()) {
                        t[0] = i;
                        t[1] = j;
                        break;

                    }
                }
            }
        }
        return t;
    }

    // place le voleurs sur les coordonnées mis en argument si ils sont différents
    // des coordonnées actuel du voleur
    public boolean setThief(int x, int y) {
        if (tiles[x][y].hasThief()) {
            System.out.println("le voleur est déjà sur cette case");
            return false;
        } else {
            this.tiles[getThief()[0]][getThief()[1]].setThief(false);
            this.tiles[x][y].setThief(true);
            return true;
        }

    }

    // donner la liste de structure autour du voleur
    public Structure[] getThiefColonies() {

        Structure[] list = new Structure[4];
        Tile temp = tiles[getThief()[0]][getThief()[1]];
        list[0] = temp.getStructure("ne");
        list[1] = temp.getStructure("no");
        list[2] = temp.getStructure("se");
        list[3] = temp.getStructure("so");
        return list;

    }

    // donner la liste de Structure autour d'une case dont on a les coordonnées
    public Structure[] getListColonies(Tile t) {

        Structure[] list = new Structure[4];

        list[0] = t.getStructure("ne");
        list[1] = t.getStructure("no");
        list[2] = t.getStructure("se");
        list[3] = t.getStructure("so");
        return list;

    }

    // distribuer les ressources
    public boolean Distribution(int x) {
        if (x < 13 && x > 1) {
            Tile[] temp = getTileByNumber(x);
            for (int i = 0; i < temp.length; i++) {
                if (temp[i] != null && !temp[i].hasThief()) {
                    Structure[] Stemp = getListColonies(temp[i]);
                    for (int j = 0; j < Stemp.length; j++) {
                        if (Stemp[j] != null) {
                            Stemp[j].giveRessources(temp[i].getType());
                        }
                    }
                }
            }
            return true;
        } else {
            return false;
        }
    }

    public Tile[][] getTiles() {
        return this.tiles;
    }

    // public Road[][] getRoads(){
    // return this.roads;
    // }

    // public Structure[][] getStructures(){
    // return this.structures;
    // }

    // placer une colonies meme sans route avec vérification des espaces entre 2
    // colonies d'une même équipe
    // checker et assigner si bon la colonie au joueur
    // checker et assigner si bon la route au joueur
    // regarder si la localisation est corretcte puis upgrade en city

    // getter pour une tile precise
    // avoir les structures adjacentes autour d'une certain point
    // trouver la plus longue route(optionnel)
    // trouver les routes adjacentes et connecter à une route donné(optionnel)
    // verifier si une localisation est un port

}
