package bankaccountgui3;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.time.LocalDateTime;
import java.util.Random;

public class BankingAppGUI extends JFrame {

    private JTextArea textArea;
    private Color currentGreenColor;

    public BankingAppGUI() {

        setTitle("Banking Application");
        setSize(700, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        textArea = new JTextArea();
        add(new JScrollPane(textArea), BorderLayout.CENTER);

        JMenuBar menuBar = new JMenuBar();
        menuBar.setBackground(Color.BLUE);

        JMenu menu = new JMenu("Options");
        menu.setForeground(Color.WHITE);

        JMenuItem dateTimeItem =
                new JMenuItem("Display Date & Time");

        JMenuItem saveItem =
                new JMenuItem("Save Log");

        JMenuItem colorItem =
                new JMenuItem("Change Background");

        JMenuItem exitItem =
                new JMenuItem("Exit");

        dateTimeItem.setBackground(Color.GREEN);
        saveItem.setBackground(new Color(128, 0, 128));
        saveItem.setForeground(Color.WHITE);

        colorItem.setBackground(
                new Color(0, 100, 0));
        colorItem.setForeground(Color.WHITE);

        exitItem.setBackground(Color.RED);
        exitItem.setForeground(Color.WHITE);

        menu.add(dateTimeItem);
        menu.add(saveItem);
        menu.add(colorItem);
        menu.add(exitItem);

        menuBar.add(menu);
        setJMenuBar(menuBar);

        Random random = new Random();
        currentGreenColor =
                new Color(0,
                        100 + random.nextInt(156),
                        0);

        dateTimeItem.addActionListener(
                new ActionListener() {
                    public void actionPerformed(
                            ActionEvent e) {

                        textArea.append(
                                "Date and Time: "
                                + LocalDateTime.now()
                                + "\n");
                    }
                });

        saveItem.addActionListener(
                new ActionListener() {
                    public void actionPerformed(
                            ActionEvent e) {

                        try {

                            FileWriter writer =
                                    new FileWriter(
                                            "log.txt");

                            writer.write(
                                    textArea.getText());

                            writer.close();

                            JOptionPane
                                    .showMessageDialog(
                                            null,
                                            "Saved to log.txt");

                        } catch (IOException ex) {

                            JOptionPane
                                    .showMessageDialog(
                                            null,
                                            "Error saving file");
                        }
                    }
                });

        colorItem.addActionListener(
                new ActionListener() {
                    public void actionPerformed(
                            ActionEvent e) {

                        getContentPane()
                                .setBackground(
                                        currentGreenColor);
                    }
                });

        exitItem.addActionListener(
                new ActionListener() {
                    public void actionPerformed(
                            ActionEvent e) {

                        System.exit(0);
                    }
                });

        setVisible(true);
    }

    public static void main(String[] args) {

        new BankingAppGUI();

    }
}