public class CoinLocation extends Location{
    private int orientation;

    public CoinLocation(int x,int y,int or){
        super(x, y);
        orientation=or;
    }
    public int getOr(){return orientation;}
}
