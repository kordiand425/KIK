package com.kordianDrygas;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class KIKGUI extends JFrame {
    private Container pane;
    private String biezacyGracz;
    private JButton[][] stol;
    private boolean jestZwyciezca;
    private JMenuBar pasekMenu;
    private JMenu menu;
    private JMenuItem wyjscie;
    private JMenuItem nowaGra;

    public KIKGUI() {
        super();
        pane = getContentPane();
        pane.setLayout(new GridLayout(3, 3));
        setTitle("Kółko i Krzyżyk");
        setSize(500, 500);
        setResizable(false);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setVisible(true);
        biezacyGracz = "X";
        stol = new JButton[3][3];
        jestZwyciezca = false;
        wlaczStol();
        wlaczPasekMenu();
    }

    private void wlaczPasekMenu() {
        pasekMenu = new JMenuBar();
        menu = new JMenu("Opcje");
        nowaGra = new JMenuItem("Nowa Gra");
        nowaGra.addActionListener(new ActionListener(){
                                      @Override
                                      public void actionPerformed(ActionEvent e) {
                                          zresetujStol();
                                      }
                                  });
        wyjscie = new JMenuItem("Wyjście");
        wyjscie.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        menu.add(nowaGra);
        menu.add(wyjscie);
        pasekMenu.add(menu);
        setJMenuBar(pasekMenu);
    }

    private void zresetujStol() {
        biezacyGracz = "X";
        jestZwyciezca = false;
        for(int i = 0;i< 3; i++){
            for(int j = 0; j < 3;j++){
                stol[i][j].setText("");
            }
        }
    }

    private void wlaczStol() {
        for(int i = 0; i < 3; i++){
            for(int j= 0; j < 3; j++) {
                JButton przycisk = new JButton();
                przycisk.setFont(new Font(Font.SANS_SERIF,Font.BOLD,100));
                stol[i][j] = przycisk;
                przycisk.addActionListener(new ActionListener(){
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        if(((JButton)e.getSource()).getText().equals("") &&
                                jestZwyciezca == false){
                            przycisk.setText(biezacyGracz);
                            jestZwyciezca();
                            przelaczGracza();
                        }
                    }

                    });
                pane.add(przycisk);
            }

        }
    }

    private void przelaczGracza() {
        if(biezacyGracz.equals("X"))
            biezacyGracz = "O";
        else
            biezacyGracz = "X";
    }


    private void jestZwyciezca() {
        if (stol[0][0].getText().equals(biezacyGracz) && stol[1][0].getText().equals(biezacyGracz) && stol[2][0].getText().equals(biezacyGracz)) {
            JOptionPane.showMessageDialog(null, "Gracz " + biezacyGracz + " zwyciężył");
            jestZwyciezca = true;
        } else if (stol[0][1].getText().equals(biezacyGracz) && stol[1][1].getText().equals(biezacyGracz) && stol[2][1].getText().equals(biezacyGracz)) {
            JOptionPane.showMessageDialog(null, "Gracz " + biezacyGracz + " zwyciężył");
            jestZwyciezca = true;
        } else if (stol[0][2].getText().equals(biezacyGracz) && stol[1][2].getText().equals(biezacyGracz) && stol[2][2].getText().equals(biezacyGracz)) {
            JOptionPane.showMessageDialog(null, "Gracz " + biezacyGracz + " zwyciężył");
            jestZwyciezca = true;
        } else if (stol[0][0].getText().equals(biezacyGracz) && stol[1][1].getText().equals(biezacyGracz) && stol[2][2].getText().equals(biezacyGracz)) {
            JOptionPane.showMessageDialog(null, "Gracz " + biezacyGracz + " zwyciężył");
            jestZwyciezca = true;
        } else if (stol[0][2].getText().equals(biezacyGracz) && stol[1][1].getText().equals(biezacyGracz) && stol[2][0].getText().equals(biezacyGracz)) {
            JOptionPane.showMessageDialog(null, "Gracz " + biezacyGracz + " zwyciężył");
            jestZwyciezca = true;
        } else if (stol[0][0].getText().equals(biezacyGracz) && stol[0][1].getText().equals(biezacyGracz) && stol[0][2].getText().equals(biezacyGracz)) {
            JOptionPane.showMessageDialog(null, "Gracz " + biezacyGracz + " zwyciężył");
            jestZwyciezca = true;
        } else if (stol[1][0].getText().equals(biezacyGracz) && stol[1][1].getText().equals(biezacyGracz) && stol[1][2].getText().equals(biezacyGracz)) {
            JOptionPane.showMessageDialog(null, "Gracz " + biezacyGracz + " zwyciężył");
            jestZwyciezca = true;
        } else if (stol[2][0].getText().equals(biezacyGracz) && stol[2][1].getText().equals(biezacyGracz) && stol[2][2].getText().equals(biezacyGracz)) {
            JOptionPane.showMessageDialog(null, "Gracz " + biezacyGracz + " zwyciężył");
            jestZwyciezca = true;
        }
        else if (!stol[0][0].getText().isBlank() && !stol[0][1].getText().isBlank()
                && !stol[0][2].getText().isBlank() && !stol[1][0].getText().isBlank()
                && !stol[1][1].getText().isBlank() && !stol[1][2].getText().isBlank()
                && !stol[2][0].getText().isBlank() && !stol[2][1].getText().isBlank()
                && !stol[2][2].getText().isBlank() && jestZwyciezca == false)

            JOptionPane.showMessageDialog(null, "Remis! \nZagraj ponownie :)");
    }
}

