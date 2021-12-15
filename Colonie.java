public class Colonie extends Structure{
    public Colonie(int x,int y,int or){
        setLocation(new CoinLocation(x, y, or));
        setType(0);
    }

    public void giveRessources(String resType){
        //getOwner().setNumberResourcesType(resType,getOwner().getNumberResourecesType(resType)+1);
    }
}
