package org.views;

import org.models.*;
import javax.swing.JFrame;
import java.awt.Graphics;

public class WorldView extends JFrame {

  public WorldView() {}

  public WorldView(World w, Grid g, int imgDim) {
    int width  = w.getWidth()  * imgDim + w.getWidth();
    int height = w.getHeight() * imgDim + w.getHeight() + 25;

    this.setTitle("Robots");
    this.setSize(width, height);
    this.setLocationRelativeTo(null);
    this.setResizable(false);
    this.setDefaultCloseOperation(WorldView.EXIT_ON_CLOSE);
    this.setContentPane(g);
    this.setVisible(true);
  }

}
