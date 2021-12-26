package Cards;
public abstract class DevCard {
    private String type;

    public DevCard(String type){
        this.type = type;
    }

    public abstract void useCard();

}
