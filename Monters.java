import java.io.*;
import java.util.*;

public class Monters {
    private String name;
    private int damage;
    private int hp;
    private int exp;

    public Monters(String name, int damage, int hp, int exp) {
        this.name = name;
        this.damage = damage;
        this.hp = hp;
        this.exp = exp;
    }

    public int getDamage() {
        return damage;
    }

    public int getHp() {
        return hp;
    }

    public int getExp() {
        return exp;
    }
}