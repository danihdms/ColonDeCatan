package Game;

import java.util.ArrayList;
import java.util.Collections;

public class Board {
    private Tile[][] tiles;
    private ArrayList<Integer> idList = new ArrayList<Integer>();

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
        // tuile pour port
        ArrayList<Tile> tilePort = new ArrayList<Tile>();
        tilePort.add(new Tile("foret"));
        tilePort.add(new Tile("colline"));
        tilePort.add(new Tile("champ"));
        tilePort.add(new Tile("montagne"));
        tilePort.add(new Tile("plaine"));
        Collections.shuffle(tilePort);
        // ajoute un port random
        tilePort.add(new Tile(tilePort.get(0).getTypeTile()));

        // Melange de la liste
        Collections.shuffle(tileList);

        // Placement des tuiles et de leur numero
        placeTiles(tileList);
        placeNumbers();
        // Placement des ports

        placePort(tilePort);
    }

    // voleurLocation = desert.getLocation();
    public void placePort(ArrayList<Tile> tilPort) {
        for (int i = 0; i < 6; i++) {
            switch (i) {
                case 0:
                    tiles[0][1] = tilPort.get(i); // 01 46 63 20 03 65
                    tiles[0][1].isAPort();

                    break;
                case 1:
                    tiles[4][6] = tilPort.get(i);
                    tiles[4][6].isAPort();
                    break;
                case 2:
                    tiles[6][3] = tilPort.get(i);
                    tiles[6][3].isAPort();
                    break;
                case 3:
                    tiles[2][0] = tilPort.get(i);
                    tiles[2][0].isAPort();
                    break;
                case 4:
                    tiles[0][3] = tilPort.get(i);
                    tiles[0][3].isAPort();
                    break;
                case 5:
                    tiles[6][5] = tilPort.get(i);
                    tiles[6][5].isAPort();
                    break;

            }
        }
    }

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
        // The order of the numbers to be assigned to the tiles, followed by an int to
        // be used as an index
        int[] numberOrder = { 5, 2, 6, 3, 8, 10, 9, 12, 11, 4, 8, 10, 9, 4, 5, 6, 3, 11 };
        int numberTile = 0;

        // The x y pairs to proceed in a spiral
        int[] tileOrder = { 3, 5, 2, 4, 1, 3, 1, 2, 1, 1, 2, 1, 3, 1, 4, 2, 5, 3, 5, 4, 5, 5, 4, 5, 3, 4, 2, 3, 2, 2, 3,
                2, 4, 3, 4, 4, 3, 3 };

        // Assigning all values from numberOrder to the Tiles in the board, proceeding
        // in a spiral
        for (int n = 0; n < tileOrder.length - 1; n += 2) {
            if (numberTile == 18) {
                break;
            }

            if (tiles[tileOrder[n]][tileOrder[n + 1]].getTypeTile().equals("desert")) {
                tiles[tileOrder[n]][tileOrder[n + 1]].setNumber(7);
            } else {
                tiles[tileOrder[n]][tileOrder[n + 1]].setNumber(numberOrder[numberTile]);
                numberTile++;
            }
        }

    }

    // Placer une nouvelle structure sur la plateau
    public boolean addStructure(int x, int y, Structure struct, String structurePos) {
        if (caseValid(x, y)) {
            if (tiles[x][y].getStructure(structurePos) != null) {
                System.out.println("case déjà occupée");
                return false;
            }
            // verifier la regle des deux cases d'écart entre ces colonies
            if (suisLaregleColonie(x, y, structurePos)) {

                switch (structurePos) {
                    case "no":
                        tiles[x][y].setStructure(struct, structurePos);
                        if (caseValid(x - 1, y - 1)) {
                            tiles[x - 1][y - 1].setStructure(struct, "se");
                        }
                        if (caseValid(x - 1, y)) {
                            tiles[x - 1][y].setStructure(struct, "so");
                        }
                        if (caseValid(x, y - 1)) {
                            tiles[x][y - 1].setStructure(struct, "ne");
                        }
                        break;

                    case "ne":
                        tiles[x][y].setStructure(struct, structurePos);
                        if (caseValid(x - 1, y)) {
                            tiles[x - 1][y].setStructure(struct, "se");
                        }
                        if (caseValid(x - 1, y + 1)) {
                            tiles[x - 1][y + 1].setStructure(struct, "so");
                        }
                        if (caseValid(x, y + 1)) {
                            tiles[x][y + 1].setStructure(struct, "no");
                        }
                        break;
                    case "so":
                        tiles[x][y].setStructure(struct, structurePos);
                        if (caseValid(x + 1, y)) {
                            tiles[x + 1][y].setStructure(struct, "no");
                        }
                        if (caseValid(x, y - 1)) {
                            tiles[x][y - 1].setStructure(struct, "se");
                        }
                        if (caseValid(x + 1, y - 1)) {
                            tiles[x + 1][y - 1].setStructure(struct, "ne");
                        }
                        break;
                    case "se":
                        tiles[x][y].setStructure(struct, structurePos);
                        if (caseValid(x + 1, y + 1)) {
                            tiles[x + 1][y + 1].setStructure(struct, "no");
                        }
                        if (caseValid(x, y + 1)) {
                            tiles[x][y + 1].setStructure(struct, "so");
                        }
                        if (caseValid(x + 1, y)) {
                            tiles[x + 1][y].setStructure(struct, "ne");
                        }
                        break;
                }
                return true;
            }
            return false;
        }
        return false;
    }

    // Placer une nouvelle route sur le plateau
    public boolean addRoad(int x, int y, Road r, String roadPos) {
        if (caseValid(x, y)) {

            if (suisLaregleRoute(x, y, roadPos, r.getOwner())) {
                if (tiles[x][y].getRoad(roadPos) != null) {
                    System.out.println(tiles[x][y].getRoad(roadPos).getOwner().getColor());
                    System.out.println("La case de coordonnées " + x + ", " + y + " est déjà occupée.");
                    return false;
                }
                // rajouter la condition de si il y a une route au joueur autour
                switch (roadPos) {
                    case "n":
                        tiles[x][y].setRoadOnTile(r, roadPos);
                        if (caseValid(x - 1, y)) {
                            tiles[x - 1][y].setRoadOnTile(r, "s");
                        }
                        break;
                    case "s":
                        tiles[x][y].setRoadOnTile(r, roadPos);
                        if (caseValid(x + 1, y)) {
                            tiles[x + 1][y].setRoadOnTile(r, "n");
                        }
                        break;
                    case "o":
                        tiles[x][y].setRoadOnTile(r, roadPos);
                        if (caseValid(x, y - 1)) {
                            tiles[x][y - 1].setRoadOnTile(r, "e");
                        }
                        break;
                    case "e":
                        tiles[x][y].setRoadOnTile(r, roadPos);
                        if (caseValid(x, y + 1)) {
                            tiles[x][y + 1].setRoadOnTile(r, "o");
                        }
                        break;
                }
                return true;
            }
        }
        return false;
    }

    public boolean caseValid(int x, int y) {
        switch (x) {
            case 0:
                return false;
            case 1:
                if (y == 0 || y == 4 || y == 5 || y == 6) {
                    return false;
                }
                break;
            case 2:
                if (y == 0 || y == 5 || y == 6) {
                    return false;
                }
                break;
            case 3:
                if (y == 0 || y == 6) {
                    return false;
                }
                break;
            case 4:
                if (y == 0 || y == 1 || y == 6) {
                    return false;
                }
                break;
            case 5:
                if (y == 0 || y == 1 || y == 2 || y == 6) {
                    return false;
                }
                break;
            case 6:
                return false;
        }
        return true;
    }

    public boolean suisLaregleColonie(int x, int y, String pos) {
        switch (pos) {
            case "no":
                if ((caseValid(x - 1, y) || caseValid(x, y) || caseValid(x, y - 1)) &&
                        (isEmptyS(x - 1, y, "no") && isEmptyS(x, y, "so") && isEmptyS(x, y, "ne")
                                && isEmptyS(x, y - 1, "no"))) {
                    return true;
                }
                break;
            case "ne":
                if ((caseValid(x - 1, y) || caseValid(x, y) || caseValid(x, y + 1)) &&
                        (isEmptyS(x, y, "se") && isEmptyS(x, y, "no") && isEmptyS(x, y + 1, "ne")
                                && isEmptyS(x - 1, y, "ne"))) {
                    return true;
                }
                break;
            case "se":
                if ((caseValid(x + 1, y) || caseValid(x, y) || caseValid(x, y + 1)) &&
                        (isEmptyS(x, y, "so") && isEmptyS(x, y, "ne") && isEmptyS(x + 1, y, "se")
                                && isEmptyS(x, y + 1, "se"))) {
                    return true;
                }
                break;
            case "so":
                if ((caseValid(x + 1, y) || caseValid(x, y) || caseValid(x, y - 1)) &&
                        (isEmptyS(x, y, "se") && isEmptyS(x, y, "no") && isEmptyS(x + 1, y, "so")
                                && isEmptyS(x, y - 1, "so"))) {
                    return true;
                }
                break;

        }
        return false;
    }

    public boolean suisLaregleRoute(int x, int y, String pos, Player owner) {
        switch (pos) {
            case "s":
                if ((hasSameOwnerR(x, y + 1, pos, owner) || hasSameOwnerR(x, y - 1, pos, owner)
                        || hasSameOwnerR(x, y, "e", owner) || hasSameOwnerR(x, y, "o", owner)
                        || hasSameOwnerR(x + 1, y, "e", owner) || hasSameOwnerR(x + 1, y, "o", owner))
                        || (hasSameOwnerS(x, y, "se", owner)
                                || hasSameOwnerS(x, y, "so", owner))) {
                    return true;
                }
                break;

            case "o":
                if ((hasSameOwnerR(x, y, "n", owner) || hasSameOwnerR(x + 1, y, pos, owner)
                        || hasSameOwnerR(x - 1, y, pos, owner) || hasSameOwnerR(x, y, "s", owner)
                        || hasSameOwnerR(x, y - 1, "n", owner) || hasSameOwnerR(x, y - 1, "s", owner))
                        || (hasSameOwnerS(x, y, "no", owner)
                                || hasSameOwnerS(x, y, "so", owner))) {
                    return true;
                }
                break;
            case "e":
                if ((hasSameOwnerR(x + 1, y, pos, owner) || hasSameOwnerR(x - 1, y, pos, owner)
                        || hasSameOwnerR(x, y, "n", owner) || hasSameOwnerR(x, y, "s", owner)
                        || hasSameOwnerR(x, y + 1, "n", owner) || hasSameOwnerR(x, y + 1, "s", owner))
                        || (hasSameOwnerS(x, y, "ne", owner) || hasSameOwnerS(x, y, "se", owner))) {
                    return true;
                }
                break;
            case "n":
                if ((hasSameOwnerR(x, y, "e", owner) || hasSameOwnerR(x, y, "o", owner)
                        || hasSameOwnerR(x - 1, y, "e", owner) || hasSameOwnerR(x - 1, y, "o", owner)
                        || hasSameOwnerR(x, y - 1, pos, owner) || hasSameOwnerR(x, y + 1, pos, owner))
                        || (hasSameOwnerS(x, y, "ne", owner)
                                || hasSameOwnerS(x, y, "no", owner))) {
                    return true;
                }
                break;
        }
        return false;
    }

    public boolean hasSameOwnerS(int x, int y, String pos, Player owner) {
        if (tiles[x][y].getStructure(pos) != null) {
            if (tiles[x][y].getStructure(pos).getOwner() == owner) {
                return true;
            }
            return false;
        }
        return false;
    }

    public boolean isEmptyS(int x, int y, String pos) {
        if (caseValid(x, y))
            return this.tiles[x][y].getStructure(pos) == null;
        return true;
    }

    public boolean hasSameOwnerR(int x, int y, String pos, Player owner) {
        if (caseValid(x, y))
            if (this.tiles[x][y].getRoad(pos) != null) {

                return this.tiles[x][y].getRoad(pos).getOwner() == owner && this.tiles[x][y] != null;
            }
        return false;
    }

    // rechercher sur le plateau les tiles avec le numéro fournie
    public Tile[] getTileByNumber(int x) {
        if (x > 1 && x < 13) {
            if (x == 2 || x == 12) {
                Tile[] t = new Tile[1];

                for (int i = 1; i < 6; i++) {
                    for (int j = 1; j < 6; j++) {
                        if (tiles[i][j] != null) {
                            if (!tiles[i][j].getTypeTile().equals("desert") && tiles[i][j].getNumber() == x) {
                                t[0] = tiles[i][j];
                            }
                        }
                    }
                }
                return t;
            } else {
                Tile[] t = new Tile[2];
                int count = 0;
                for (int i = 1; i < 6; i++) {
                    for (int j = 1; j < 6; j++) {
                        if (tiles[i][j] != null) {
                            if (!tiles[i][j].getTypeTile().equals("desert") && tiles[i][j].getNumber() == x) {
                                if (count <= 1) {
                                    t[count] = tiles[i][j];
                                    count++;
                                }
                            }
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

    // place le voleurs sur les coordonnées mis en argument si elles sont
    // différentes
    // des coordonnées actuelles du voleur
    public boolean setThief(int x, int y) {
        if (caseValid(x, y)) {
            if (tiles[x][y].hasThief()) {
                System.out.println("le voleur est déjà sur cette case");
                return false;
            } else {
                this.tiles[getThief()[0]][getThief()[1]].setThief(false);
                this.tiles[x][y].setThief(true);
                return true;
            }
        }
        return false;

    }

    // donner la liste de structure autour du voleur
    public Structure[] getThiefColonies() {

        Tile temp = tiles[getThief()[0]][getThief()[1]];
        String[] t = { "no", "ne", "se", "so" };
        int count = 0;
        for (int i = 0; i < 4; i++) {
            if (temp.getStructure(t[i]) != null) {
                count++;
            }
        }
        Structure[] list = new Structure[count];
        count = 0;
        for (int i = 0; i < 4; i++) {
            if (temp.getStructure(t[i]) != null) {
                list[count] = temp.getStructure(t[i]);
                count++;
                if (count == list.length) {
                    break;
                }
            }
        }
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

    // upgrade une colonie
    public boolean getUpgrade(int x, int y, String pos) {
        if (this.tiles[x][y].getStructure(pos) != null && this.tiles[x][y].getStructure(pos).getType() == 0) {
            this.tiles[x][y].getStructure(pos).setType(1);
            return true;
        }
        return false;
    }

    // distribuer les ressources

    public Tile[][] getTiles() {
        return this.tiles;
    }

    public int longuestRoad(Player p, int x, int y, String or, String dir) { // or equivaut à n/s/e/o pour la route et
                                                                             // dir represente la direction dans
                                                                             // laquelle le parcours va se faire on
                                                                             // commencera en ""
        // verification si tuile vide
        int b = 0;
        int h = 0;
        if (tiles[x][y] == null) {
            return 0;
        }
        // verification si route vide
        if (tiles[x][y].getRoad(or) == null) {
            return 0;
        }
        // verification si id dans la liste
        if (this.idList.contains(tiles[x][y].getRoad(or).getId())) {
            return 0;
        } else {
            this.idList.add(tiles[x][y].getRoad(or).getId());
        }
        switch (or) {
            case "e":
                if (dir.equals("h&b")) {

                } else {
                    if (dir.equals("h")) {
                        if (tiles[x][y].hasStructure(p, "ne") || tiles[x][y].getStructure("ne") == null) {
                            h = 1 + MaxOf3(longuestRoad(p, x, y, "n", "h"), longuestRoad(p, x, y + 1, "n", "h"),
                                    longuestRoad(p, x - 1, y, "e", "h"));
                        } else {
                            return 0;
                        }
                    } else {
                        if (tiles[x][y].hasStructure(p, "se") || tiles[x][y].getStructure("se") == null) {
                            b = 1 + MaxOf3(longuestRoad(p, x, y, "s", "b"), longuestRoad(p, x, y + 1, "s", "b"),
                                    longuestRoad(p, x + 1, y, "e", "b"));
                        } else {
                            return 0;
                        }
                    }
                    break;
                }

            case "o":
                if (dir.equals("h&b")) {
                    if (tiles[x][y].hasStructure(p, "ne") || tiles[x][y].getStructure("ne") == null) {
                        h = 1 + MaxOf3(longuestRoad(p, x, y, "n", "h"), longuestRoad(p, x, y + 1, "n", "h"),
                                longuestRoad(p, x - 1, y, "e", "h"));
                    } else {
                        return 0;
                    }

                    if (tiles[x][y].hasStructure(p, "se") || tiles[x][y].getStructure("se") == null) {
                        b = 1 + MaxOf3(longuestRoad(p, x, y, "s", "b"), longuestRoad(p, x, y + 1, "s", "b"),
                                longuestRoad(p, x + 1, y, "e", "b"));
                    } else {
                        return 0;
                    }
                } else {
                    if (dir.equals("h")) {
                        if (tiles[x][y].hasStructure(p, "ne") || tiles[x][y].getStructure("ne") == null) {
                            h = 1 + MaxOf3(longuestRoad(p, x, y, "n", "h"), longuestRoad(p, x, y + 1, "n", "h"),
                                    longuestRoad(p, x - 1, y, "e", "h"));
                        } else {
                            return 0;
                        }
                    } else {
                        if (tiles[x][y].hasStructure(p, "se") || tiles[x][y].getStructure("se") == null) {
                            b = 1 + MaxOf3(longuestRoad(p, x, y, "s", "b"), longuestRoad(p, x, y + 1, "s", "b"),
                                    longuestRoad(p, x + 1, y, "e", "b"));
                        } else {
                            return 0;
                        }
                    }
                    break;
                }
            case "n":
            case "s":
            default:

        }
        return h + b;
    }

    public int MaxOf3(int x, int y, int z) {
        if (x > y && x > z) {
            return x;
        }
        if (y > x && y > z) {
            return y;
        }
        return z;
    }

    // trouver la plus longue route(optionnel)
    // mettre leurs ressources en random

}
