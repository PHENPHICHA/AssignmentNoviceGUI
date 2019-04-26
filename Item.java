public class Item {
    private String name;
    private int hp;
    private int number;

    public Item(String name, int hp, int number) {
        this.name = name;
        this.hp = hp;
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public int getHp() {
        return hp;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number += number;
    }
}