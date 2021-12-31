package Game;

public class Tile {
    private int number = 0;
    private boolean hasThief = false;
    private Road n, s, e, w;
    private Structure nw, ne, se, sw;
    private final String typeTile; // desert, colline, plaine, foret, champ, montagne
    private final String type;
    private boolean isAport = false;

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

    public void isApoert() {
        this.isAport = true;
        this.number = 0;
    }
    public String getTypeTile(){return typeTile;}
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
            case "w":
                return w;
        }
        System.out.println("You have to choose between n, s, e, and w.");
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
            case "w":
                w = r;
                return;
        }
        System.out.println("You have to choose between n, s, e, and w.");
    }

    public Structure getStructure(String structurePos) {
        switch (structurePos) {
            case "nw":
                return nw;
            case "sw":
                return sw;
            case "ne":
                return ne;
            case "se":
                return se;
        }
        System.out.println("You have to choose between nw, sw, ne, and se.");
        return null;
    }

    public void setStructure(Structure s, String structurePos) {
        switch (structurePos) {
            case "nw":
                nw = s;
                return;
            case "sw":
                sw = s;
                return;
            case "se":
                se = s;
                return;
            case "ne":
                ne = s;
                return;
        }
        
    }
}
