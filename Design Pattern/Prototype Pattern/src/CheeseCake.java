public class CheeseCake implements Cake {

    private String sugar;
    private String butter;
    private String cheese;
    private String name;

    public Cake prepareCake() {
        Cake cake = null;
        try {
            cake = (Cake) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return cake;
    }

    void addSugar(String sugar) {
        this.sugar = sugar;
    }

    void addButter(String butter) {
        this.butter = butter;
    }

    public void addCheese(String cheese) {
        this.cheese = cheese;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Sugar:" + sugar + ", Butter:" + butter + ", Name:" + name
                + ", Cheese:" + cheese;
    }
}