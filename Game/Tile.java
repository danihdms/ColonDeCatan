package Game;

public class Tile {
    private int number = 0;
    private boolean hasThief = false;
    private Road n, s, e, o;
    private Structure no, ne, se, so;
    private final String typeTile; // desert, colline, plaine, foret, champ, montagne
    private final String type;
    private boolean isAPort = false;

    public Tile(int n, String str) {
        typeTile = str;
        number = n;
        type = setType(str);
    }

    public Tile(String str) {
        typeTile = str;
        type = setType(str);
    }

    public Tile(String str, boolean b) {
        typeTile = str;
        hasThief = b;
        type = setType(str);

    }

    public String setType(String s) {
        switch (s) {

            case "colline":
                return "argile";

            case "plaine":
                return "mouton";

            case "foret":
                return "bois";

            case "champ":
                return "mouton";

            case "montagne":
                return "minerais";

            default:
                return "";

        }
    }

    public void isAPort() {
        this.isAPort = true;
        this.number = 0;
    }

    public String getTypeTile() {
        return typeTile;
    }

    public boolean hasThief() {
        return hasThief;
    }

    public void setThief(boolean n) {
        hasThief = n;
    }

    public void setNumber(int n) {
        number = n;
    }

    public int getNumber() {
        return number;
    }

    public String getType() {
        return type;
    }

    public Road getRoad(String roadPos) {
        switch (roadPos) {
            case "n":
                return n;
            case "s":
                return s;
            case "e":
                return e;
            case "o":
                return o;
        }
        System.out.println("You have to choose between n, s, e, and o to get the road.");
        return null;
    }

    public void setRoadOnTile(Road r, String roadPos) {
        switch (roadPos) {
            case "n":
                n = r;
                return;
            case "s":
                s = r;
                return;
            case "e":
                e = r;
                return;
            case "o":
                o = r;
                return;
        }
        System.out.println("You have to choose between n, s, e, and o.");
    }

    public Structure getStructure(String structurePos) {
        switch (structurePos) {
            case "no":
                return no;
            case "so":
                return so;
            case "ne":
                return ne;
            case "se":
                return se;
        }
        System.out.println("You have to choose between no, so, ne, and se to get the structure.");
        return null;
    }

    public void setStructure(Structure s, String structurePos) {
        switch (structurePos) {
            case "no":
                no = s;
                return;
            case "so":
                so = s;
                return;
            case "se":
                se = s;
                return;
            case "ne":
                ne = s;
                return;
        }

    }

    public boolean getIsAPort() {
        return isAPort;
    }

    public Structure getNe() {
        return ne;
    }

    public Structure getSo() {
        return so;
    }

    public Structure getSe() {
        return se;
    }

    public Structure getNo() {
        return no;
    }

    public Road getN() {
        return n;
    }

    public Road getS() {
        return s;
    }

    public Road getE() {
        return e;
    }

    public Road getO() {
        return o;
    }
}
