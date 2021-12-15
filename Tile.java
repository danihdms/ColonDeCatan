public class Tile {
    private int number = 0;
    private int x, y;
    private boolean hasThief = false;
    private Road n, s, e, o;
    private Structure no, ne, se, so;
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
}
