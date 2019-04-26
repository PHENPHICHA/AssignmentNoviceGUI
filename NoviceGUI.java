import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Scanner;
import javax.swing.*;
import java.awt.Color;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EtchedBorder;
import javax.swing.JButton;
import java.awt.GridLayout;
import java.awt.BorderLayout;
import java.awt.Dimension;
import javax.swing.JTextField;

public class NoviceGUI {
    private JFrame screen;
    private JPanel status;
    private Container c;
    private Novice novice;
    private MontersList montersList;
    private String name;

    public NoviceGUI() {
        montersList = new MontersList();
        screen = new JFrame();
        JFrame frame = new JFrame();
        screen.setTitle("Novice Game");
        screen.setSize(400, 350);
        screen.setLocationRelativeTo(null);
        screen.setResizable(false);
        screen.setVisible(true);
        screen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        c = screen.getContentPane();
        c.setLayout(new GridLayout(0,3));
        
       
    }

    public void gui() {
        JButton s = new JButton("Status");
        s.addActionListener(new ActionListener() {
            

            
            @Override
            public void actionPerformed(ActionEvent e) {
                showStatus();
            }
        });
        JButton showItem = new JButton("Show Item");
        showItem.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                showItems();
            }
        });
        JButton useWeapon = new JButton("Weapon");
        useWeapon.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                useWeapon();
            }
        });
        JButton useItem = new JButton("Item");
        useItem.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                useItems();
            }
        });
        JButton a = new JButton("Attack");
        a.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                attack();
            }
        });
        status = new JPanel();
        status.setLayout(new FlowLayout());
        FlowLayout layout = new FlowLayout();
        status.add(s);
        status.add(showItem);
        status.add(useWeapon);
        status.add(useItem);
        status.add(a);
        c.add(status, BorderLayout.CENTER);
        layout.setAlignment(FlowLayout.CENTER);
        screen.setVisible(true);
    }

    public void checkDead() {
        if (novice.getDead()) {
            JOptionPane.showMessageDialog(null, " Game Over ");
            System.exit(0);
        }
    }

    public void setName() {
        name = JOptionPane.showInputDialog("Enter your name :");
    }

    public void setType() {
        Object[] options = { "Novice1", "Novice2" };
        int n = JOptionPane.showOptionDialog(null, "Choose your charector :", "Charector", JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
        if (n == 0) {
            novice = new Noviceone(name);
        } else if (n == 1) {
            novice = new Novicetwo(name);
        }
    }

    public void showItems() {
        JOptionPane jstatus = new JOptionPane();
        String statusText = novice.getBag().apple.getName() + " : "
                + novice.getBag().apple.getNumber() + "\n" + novice.getBag().orange.getName() + " : " 
                + novice.getBag().orange.getNumber() + "\n"
                + novice.getBag().mango.getName() + " : "
                + novice.getBag().mango.getNumber() + "\n" + novice.getBag().dagger.getName() + " : "
                + novice.getBag().dagger.getNumber() + "\n" + novice.getBag().staff.getName() + " : "
                 + novice.getBag().staff.getNumber() + "\n"
                + novice.getBag().bow.getName() + " : "
                + novice.getBag().bow.getNumber();
     JOptionPane.showMessageDialog(jstatus, statusText, "Status", JOptionPane.INFORMATION_MESSAGE);
    }

    public void showStatus() {
        JOptionPane jstatus = new JOptionPane();
        String statusText = "Name : " + novice.getName() + "\n" + "Type : " + novice.getType() + "\n" + "Level : "
                + novice.getLevel() + "\n" + "Exp : " + novice.getExp() + "/" + novice.getMaxExp() + "\n" + "HP : "
                + novice.getHp() + "/" + novice.getMaxHp() + "\n" + "Kill Monsters : " + novice.getKillMon();
        JOptionPane.showMessageDialog(jstatus, statusText, "Status", JOptionPane.INFORMATION_MESSAGE);
    }

    public void useWeapon() {
        Object[] options = { "Dagger", "Staff", "Bow" };
        String n = (String) JOptionPane.showInputDialog(null, "Choose your weapon :", "Weapon", JOptionPane.PLAIN_MESSAGE,
                null, options, "Dagger");
        if (n == "Dagger") {
            if (novice.increaseHP(novice.getBag().dagger.getHp())) {
                novice.getBag().dagger.setNumber(-1);
            }
        } else if (n == "Staff") {
            if (novice.increaseHP(novice.getBag().staff.getHp())) {
                novice.getBag().staff.setNumber(-1);
            }
        } else if (n == "Bow") {
            if (novice.increaseHP(novice.getBag().bow.getHp())) {
                novice.getBag().bow.setNumber(-1);
            }
        }
    }

    public void useItems() {
        Object[] options = { "Apple", "Orange", "Mango" };
        String n = (String) JOptionPane.showInputDialog(null, "Choose your items :", "Items", JOptionPane.PLAIN_MESSAGE,
                null, options, "Apple");
        if (n == "Apple") {
            if (novice.increaseHP(novice.getBag().apple.getHp())) {
                novice.getBag().apple.setNumber(-1);
            }
        } else if (n == "Orange") {
            if (novice.increaseHP(novice.getBag().orange.getHp())) {
                novice.getBag().orange.setNumber(-1);
            }
        } else if (n == "Mango") {
            if (novice.increaseHP(novice.getBag().mango.getHp())) {
                novice.getBag().mango.setNumber(-1);
            }
        }
    }

    public void attack() {
        Object[] options = { "Poring", "Lunatic", "Smokie" };
        String n = (String) JOptionPane.showInputDialog(null, "Choose monsters :", "Monsters",
                JOptionPane.PLAIN_MESSAGE, null, options, "Poring");
        if (n == "Poring") {
            novice.decreaseHP(montersList.getMonters(0).getDamage());
            novice.increaseEXP(montersList.getMonters(0).getExp());
            novice.getBag().apple.setNumber(1);
        } else if (n == "Lunatic") {
            novice.decreaseHP(montersList.getMonters(1).getDamage());
            novice.increaseEXP(montersList.getMonters(1).getExp());
            novice.getBag().orange.setNumber(1);
        } else if (n == "Smokie") {
            novice.decreaseHP(montersList.getMonters(2).getDamage());
            novice.increaseEXP(montersList.getMonters(2).getExp());
            novice.getBag().mango.setNumber(1);
        }
        checkDead();
        novice.setKillMon();
    }

    public static void main(String[] args) {
        NoviceGUI gc = new NoviceGUI();
        gc.setName();
        gc.setType();
        gc.gui();
    }
}