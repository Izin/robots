package org.views;

import javax.swing.JFrame;
import java.awt.Graphics;

public class SWindow extends JFrame {

  public SWindow(String title, int width, int height, SPanel panel) {
    this.setTitle(title);
    this.setSize(width * 50, height * 50);
    this.setLocationRelativeTo(null);
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.setContentPane(panel);
    this.setVisible(true);
  }

}
