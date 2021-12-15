public class Tile {
    private int number = 0;
    private int x, y;
    private boolean hasThief = false;
    private Road n, s, e, w;
    private Structure nw, ne, se, sw;
    private final String type;

    /*
     * Values:
     * DESERT,BRICK,BOIS,PIERRE,BLE,MOUTON
     */
    public Tile(int x, int y, int n, String str) {
        this.x = x;
        this.y = y;
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

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
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
        System.out.println("You have to choose between n, s, e, and w.");
        return null;
    }

    public void setRoad(Road r, String roadPos) {
        switch (roadPos) {
            case "n":
                n = r;
                break;
            case "s":
                s = r;
                break;
            case "e":
                e = r;
                break;
            case "w":
                w = r;
                break;
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
                break;
            case "sw":
                sw = s;
                break;
            case "se":
                se = s;
                break;
            case "w":
                ne = s;
                break;
        }
        System.out.println("You have to choose between nw, sw, ne, and se.");
    }
}
