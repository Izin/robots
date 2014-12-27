package org.views;

import org.models.*;

import java.awt.Color;
import javax.swing.JPanel;
import javax.imageio.ImageIO;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

public class Grid extends JPanel {

  private World w;
  private int imgDim;

  public Grid() {}
  public Grid(World w, int imgDim) {
    this.w  = w;
    this.imgDim = imgDim;
  }

  @Override public void paintComponent(Graphics g) {
    super.paintComponent(g);
    this.drawGrid(g);
    this.drawElements(g);
  }

  public void drawGrid(Graphics g) {
    for (int y = 0; y <= w.getHeight() * this.imgDim; y += this.imgDim) {
      g.drawLine(0, y, w.getWidth() * this.imgDim, y);
    }

    for (int x = 0; x <= w.getWidth() * this.imgDim; x += this.imgDim) {
      g.drawLine(x, w.getHeight() * this.imgDim, x, 0);
    }
  }

  public void drawElements(Graphics g) {
    for (int y = 0; y < w.getHeight(); ++y) {
      for (int x = 0; x < w.getWidth(); ++x) {
        String img = this.w.map[y][x].show();
        //System.out.println("img: " + img);
        this.drawElement(g, img, x, y);
      }
    }
  }

  public void drawElement(Graphics g, String img, int x, int y) {
    try {
      Image element = ImageIO.read(getClass().getResource("../../img/" + img + ".png"));
      g.drawImage(element, x * this.imgDim, y * this.imgDim, this.imgDim, this.imgDim, this);
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

}
