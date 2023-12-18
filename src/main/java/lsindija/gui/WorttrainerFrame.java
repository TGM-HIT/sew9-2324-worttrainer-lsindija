package lsindija.gui;

import lsindija.model.Rechtschreibtrainer;
import lsindija.persistenz.JSONSave;
import lsindija.persistenz.Persistence;
import lsindija.persistenz.PersistenceMethod;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Die Klasse der GUI Umsetzung
 * @author Leon Sindija
 * @version 2023-09-22
 */
public class WorttrainerFrame extends JFrame {
    private JTextField textField;
    private JLabel imageLabel;

    /**
     * Das Worttrainer Fenster wird erstellt
     * @param trainer Das Worttrainer Model welches mit dem Fenster verbunden ist
     */
    public WorttrainerFrame(Rechtschreibtrainer trainer) {
        super("Worttrainer");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 200);

        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());

        JPanel interactions = new JPanel();
        JPanel buttons = new JPanel();

        panel.add(interactions, BorderLayout.SOUTH);

        textField = new JTextField();
        interactions.add(textField);

        interactions.add(buttons);

        interactions.setLayout(new BoxLayout(interactions, BoxLayout.PAGE_AXIS));
        buttons.setLayout(new BoxLayout(buttons, BoxLayout.LINE_AXIS));

        ImageIcon imageIcon = new ImageIcon(""); // Ersetzen Sie "bild.png" durch Ihren Bildpfad
        imageLabel = new JLabel(imageIcon);
        panel.add(imageLabel, BorderLayout.CENTER);




        JButton submitButton = new JButton("Abschicken");
        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String userInput = textField.getText();
                boolean richtig = trainer.check(userInput);
                if(richtig) {
                    JOptionPane.showMessageDialog(null, "Richtig!");
                }
                else {
                    JOptionPane.showMessageDialog(null, "Falsch!");
                }
                JOptionPane.showMessageDialog(null,trainer.getStatistik());
                textField.setText("");
            }
        });

        JButton exitButton = new JButton("Beenden");
        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Persistence persistence = new Persistence();
                persistence.save(trainer);
                System.exit(0);

            }
        });


        buttons.add(submitButton);
        buttons.add(exitButton);


        this.add(panel);
        this.setVisible(true);
    }

    public void setImage(String image) {
        try {
            ImageIcon imageIcon = new ImageIcon( new URL(image));

            int originalWidth = imageIcon.getIconWidth();
            int originalHeight = imageIcon.getIconHeight();
            double widthRatio = (double) imageLabel.getWidth() / originalWidth;
            double heightRatio = (double) imageLabel.getHeight() / originalHeight;
            double scaleFactor = Math.min(widthRatio, heightRatio);

            int scaledWidth = (int) (originalWidth * scaleFactor);
            int scaledHeight = (int) (originalHeight * scaleFactor);

            imageLabel.setIcon(new ImageIcon(imageIcon.getImage().getScaledInstance(scaledWidth, scaledHeight, Image.SCALE_DEFAULT)));
        } catch (MalformedURLException e) {
            JOptionPane.showMessageDialog(null,"Das Bild kann nicht geladen werden. (Interner Fehler)");
            e.printStackTrace();
        }
    }
}