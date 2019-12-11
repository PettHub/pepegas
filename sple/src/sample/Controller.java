package sample;

import com.sun.security.auth.module.JndiLoginModule;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class Controller extends JPanel {
    public static void main(String[] args) throws IOException {
        Model world = new Model(new ImageDisplay());
        Controller cc = new Controller(world);
        world.addToView(world.im);
        world.addToView(cc);
        world.addAllViews();
    }

    public Controller(Model world) {
        this.world = world;
        startUp();
    }

    Model world;
    JButton back = new JButton("Back");
    JButton exit = new JButton("EXIT");
    JButton menu = new JButton("Choose class");
    JButton option1 = new JButton("Wizard");
    JButton option2 = new JButton("Tank");
    JButton option3 = new JButton("Warrior");
    JPanel advanced = new JPanel();
    JPanel start = new JPanel();

    void startUp () {
    this.setPreferredSize(new Dimension(800, 100));
    //this.setLayout(new FlowLayout(FlowLayout.LEFT, 0, 0));
        start.add(menu, 0);
        start.add(exit, 1);
        start.setPreferredSize(new Dimension(800, 100));
        start.setBackground(Color.GREEN);
        back.setPreferredSize(new Dimension(150, 100));
        option1.setPreferredSize(new Dimension(150, 100));
        option2.setPreferredSize(new Dimension(150, 100));
        option3.setPreferredSize(new Dimension(150, 100));
        advanced.add(back, 0);
        advanced.add(option1, 1);
        advanced.add(option2, 2);
        advanced.add(option3, 3);
        advanced.setPreferredSize(new Dimension(800, 100));
        advanced.setBackground(Color.GREEN);
        this.add(advanced);
        menu.setPreferredSize(new Dimension(200, 100));
        menu.setBackground(Color.LIGHT_GRAY);
        this.add(menu);
        exit.setPreferredSize(new Dimension(200, 100));
        exit.setBackground(Color.LIGHT_GRAY);
        this.add(exit);
        advanced.setVisible(false);
        start.setVisible(true);

        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                advanced.setVisible(false);
                start.setVisible(true);
            }
        });

        exit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                System.exit(0);
            }
        });

        menu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                advanced.setVisible(true);
                start.setVisible(false);
            }
        });

        option1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                advanced.setVisible(false);
                start.setVisible(true);
                try {
                    world.im.setImage("Wizard");
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });

        option2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                advanced.setVisible(false);
                start.setVisible(true);
                try {
                    world.im.setImage("Tank");
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });

        option3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                advanced.setVisible(false);
                start.setVisible(true);
                try {
                    world.im.setImage("Warrior");
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
        this.setDoubleBuffered(true);
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
        this.setVisible(true);

    }
}
