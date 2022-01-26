package com.kordianDrygas;

import javax.swing.*;

public class Main {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable(){

            @Override
            public void run(){
                new KIKGUI();
            }
        });
    }
}
