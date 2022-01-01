package Game;
public class Tile {
    private int number = 0;
    private boolean hasThief = false;
    private Road n, s, e, w;
    private Structure nw, ne, se, sw;
    private final String type; // desert, colline, plaine, foret, champ, montagne

    public Tile(int n, String str) {
        type = str;
        number = n;
    }

    public Tile(String str) {
        type = str;
    }

    public Tile(String str, boolean b) {
        type = str;
        hasThief = b;

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
            case "w":
                return w;
        }
        System.out.println("You have to choose between n, s, e, and w to get the road.");
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
        System.out.println("You have to choose between nw, sw, ne, and se to get the structure.");
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
        System.out.println("You have to choose between nw, sw, ne, and se.");
    }
}
