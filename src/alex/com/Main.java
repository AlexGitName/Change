package alex.com;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main
{
    float money;
    JTextField moneyHav = new JTextField();
    JTextField money25 = new JTextField();
    JTextField money10 = new JTextField();
    JTextField money5 = new JTextField();
    JTextField money1 = new JTextField();

    Main()
    {
        JFrame jf = new JFrame("Change");
        JButton b = new JButton("Count");
        JLabel l_25 = new JLabel("In 25 ");
        JLabel l_10 = new JLabel("In 10");
        JLabel l_5 = new JLabel("In 5");
        JLabel l_1 = new JLabel("In 1");
        jf.setSize(400, 400);
        jf.setVisible(true);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf.setLayout(new GridBagLayout());

        GridBagConstraints grid = new GridBagConstraints();
        ActionListener actionListener = new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                money = Float.parseFloat(moneyHav.getText());
                count(money);

            }
        };

        grid.gridx = 1;
        grid.gridy = 0;
        moneyHav.setColumns(10);
        jf.add(moneyHav, grid);

        grid.gridx = 0;
        grid.gridy = 1;
        jf.add(l_25,grid);

        grid.gridx = 1;
        grid.gridy = 1;
        money25.setColumns(10);
        money25.setEnabled(false);
        jf.add(money25, grid);

        grid.gridx = 0;
        grid.gridy = 2;
        jf.add(l_10,grid);

        grid.gridx = 1;
        grid.gridy = 2;
        money10.setColumns(10);
        money10.setEnabled(false);
        jf.add(money10, grid);

        grid.gridx = 0;
        grid.gridy = 3;
        jf.add(l_5,grid);

        grid.gridx = 1;
        grid.gridy = 3;
        money5.setColumns(10);
        money5.setEnabled(false);
        jf.add(money5, grid);

        grid.gridx = 0;
        grid.gridy = 4;
        jf.add(l_1,grid);

        grid.gridx = 1;
        grid.gridy = 4;
        money1.setColumns(10);
        money1.setEnabled(false);
        jf.add(money1, grid);

        grid.gridx = 1;
        grid.gridy = 5;
        b.addActionListener(actionListener);
        jf.add(b, grid);


        jf.pack();

    }

    public static void main(String[] args)
    {
        SwingUtilities.invokeLater(new Runnable()
        {
            @Override
            public void run()
            {
                new Main();
            }
        });

    }

    public void count(float money)
    {
        int c = 0;
        int a = 0;
        int s = 0;
        int f = 0;
        do
        {
            if (money >= 0.25)
            {

                money -= 0.25;
                c++;

            }
            if (money < 0.25 && money >= 0.10)
            {
                money -= 0.10;
                a++;
            }
            if (money < 0.10 && money >= 0.5)
            {
                money -= 0.5;
                s++;
            }
            if (money < 0.05 && money >0)
            {
                money -= 0.01;
                f++;
            }
        } while (money != 0.0);
        money25.setText(Integer.toString(c));
        money10.setText(Integer.toString(a));
        money5.setText(Integer.toString(s));
        money1.setText(Integer.toString(f));
    }
}
