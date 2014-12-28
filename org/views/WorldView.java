package org.views;
import org.models.*;
import javax.swing.JFrame;
import java.awt.Graphics;


/**
 * A graphic window called WorldView
 *
 * @author  Malo Blanchard
 * @version 0.9
 */
public class WorldView extends JFrame {

  /**
   * Build a new instance of WorldView
   *
   * @param  w       Instance of World model
   * @param  g       Instance of Grid view
   * @param  imgDim  Image dimensions
   */
  public WorldView() {}
  public WorldView(World w, Grid g, int imgDim) {
    int width  = w.getWidth()  * imgDim + w.getWidth();
    int height = w.getHeight() * imgDim + w.getHeight() + 25;
    this._createWindow(width, height, g);
  }

  /**
   * Build a window for the appplication, with the right parameters
   *
   * @param  width  Number of x-pixels for the window
   * @param  height Number of y-pixels for the window
   * @param  g      Instance of Grid view
   */
  private void _createWindow(int width, int height, Grid g) {
    this.setTitle("Robots");
    this.setSize(width, height);
    this.setLocationRelativeTo(null);
    this.setResizable(false);
    this.setDefaultCloseOperation(WorldView.EXIT_ON_CLOSE);
    this.setContentPane(g);
    this.setVisible(true);
  }

}
