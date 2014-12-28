package org.views;
import org.models.*;
import java.awt.Color;
import javax.swing.JPanel;
import javax.imageio.ImageIO;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;


/**
 * A graphic Grid
 *
 * @author  Malo Blanchard
 * @version 0.9
 */
public class Grid extends JPanel {

  private World w;
  private int imgDim;

  /**
   * Build a new instance of Grid
   *
   * @param  w       Instance of World model
   * @param  imgDim  Image dimensions
   */
  public Grid() {}
  public Grid(World w, int imgDim) {
    this.w      = w;
    this.imgDim = imgDim;
  }

  /**
   * Method used to refresh the graphic view
   *
   * @param  g  Object Graphics
   */
  @Override public void paintComponent(Graphics g) {
    super.paintComponent(g);
    this.drawCells(g);
  }

  /**
   * Draw the graphic cells of the current Grid
   *
   * @param  g  Object Graphics
   */
  public void drawCells(Graphics g) {
    for (int y = 0; y < w.getHeight(); ++y) {
      for (int x = 0; x < w.getWidth(); ++x) {
        String img = this.w.grid[y][x].show();
        this.drawElement(g, img, x, y);
      }
    }
  }

  /**
   * Draw a cell with a robot, a jewel or nothing, depending of image name
   *
   * @param  g    Object Graphics
   * @param  img  Image name
   * @param  x    First part of the targeted cell's coordinates
   * @param  y    Second part of the targeted cell's coordinates
   */
  public void drawElement(Graphics g, String img, int x, int y) {
    try {
      Image element = ImageIO.read(getClass().getResource("../../img/" + img + ".png"));
      g.drawImage(element, x * this.imgDim, y * this.imgDim, this.imgDim, this.imgDim, this);
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

}
