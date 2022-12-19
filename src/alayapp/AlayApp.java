package alayapp;

import java.awt.Color;
import java.awt.Font;
import java.awt.HeadlessException;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.concurrent.ThreadLocalRandom;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Andhika Prameswara <prameswaara@gmail.com>
 */
public class AlayApp extends JFrame implements ActionListener {

    private JButton mau, enggak, ulang;
    private JLabel jawabanMau, pertanyaan;
    private JPanel panelMau, panelMain;
    private ImageIcon sudahKuduga;
    private Image image;
    private Image secondImage;

    public AlayApp() {
        setTitle("WILL U BE MY GIRLFRIEND?");
        setSize(500, 500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        init();
        setVisible(true);
    }

    private void init() {
        panelMain = new JPanel();
        panelMain.setLayout(null);

        panelMau = new JPanel();
        panelMain.setSize(500, 520);
        panelMau.setLayout(null);

        mau = new JButton("Mau");
        mau.setBounds(100, 300, 80, 50);
        mau.addActionListener(this);

        enggak = new JButton("enggak");
        enggak.setBounds(300, 300, 80, 50);
        enggak.addActionListener(this);

        ulang = new JButton("ulang");
        ulang.setBounds(220, 300, 80, 50);
        ulang.addActionListener(this);

        pertanyaan = new JLabel("Mau jadi pacar gua ga?");
        pertanyaan.setFont(new Font("Sans Serif", Font.BOLD, 30));
        pertanyaan.setBounds(78, 25, 400, 200);

        sudahKuduga = new ImageIcon(AlayApp.class.getResource("/gambar/sudahkuduga.jpg"));
        image = sudahKuduga.getImage();
        secondImage = image.getScaledInstance(220, 200, java.awt.Image.SCALE_SMOOTH);
        sudahKuduga = new ImageIcon(secondImage);

        jawabanMau = new JLabel(sudahKuduga);
        jawabanMau.setFont(new Font("Sans Serif", Font.BOLD, 50));
        jawabanMau.setBounds(60, 80, 400, 200);
        jawabanMau.setVisible(false);

        panelMau.add(jawabanMau);
        panelMau.add(ulang);
        panelMau.setVisible(false);

        panelMain.add(enggak);
        panelMain.add(mau);
        panelMain.add(pertanyaan);

        this.add(panelMain);
        this.add(panelMau);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        int x, y, luck;
        x = ThreadLocalRandom.current().nextInt(200, 400 + 1);
        y = ThreadLocalRandom.current().nextInt(200, 400 + 1);
        luck = ThreadLocalRandom.current().nextInt(1, 8 + 1);
        if (e.getSource() == enggak) {
            enggak.setBounds(x, y, 80, 50);
        }
        if (e.getSource() == mau) {
            jawabanMau.setVisible(true);
            panelMau.setVisible(true);
            mau.setVisible(false);
            ulang.setVisible(true);
            enggak.setVisible(false);
            System.out.println("harusnya bisa");
        }
        if (e.getSource() == ulang) {
            panelMau.setVisible(false);
            mau.setVisible(true);
            enggak.setVisible(true);
            jawabanMau.setVisible(false);
        }
    }

    public static void main(String[] args) {
        AlayApp alayApp = new AlayApp();
    }

}
