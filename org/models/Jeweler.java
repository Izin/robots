package org.models;
import org.models.Jewel;


/**
 * A Jeweler is a robot that drop a jewel on the current Cell.
 *
 * @author  Malo Blanchard
 * @version 0.9
 * @see     Robot
 */
public abstract class Jeweler extends Robot {

  /**
   * Build a new instance of Jeweler
   *
   * @param  ref   Robot #reference, like an id (eg: R2)
   * @param  name  name of the robot
   */
  public Jeweler() {}
  public Jeweler(String ref, String name) {
    super(ref, name);
  }

  /**
   * Drop a jewel in the current cell
   *
   * @param  x  First part of the targeted cell's coordinates
   * @param  y  Second part of the targeted cell's coordinates
   * @param  w  Instance of World model
   */
  public void dropAJewel(int x, int y, World w) {
    if (!w.grid[y][x].hasJewel()) {
      w.grid[y][x].setJewel(new Jewel());
      //System.out.print(" -> perd des bijoux");
    }
  }

  /**
   * Call the dropAJewel() method with arguments
   *
   * @param  x  First part of the targeted cell's coordinates
   * @param  y  Second part of the targeted cell's coordinates
   * @param  w  Instance of World model
   */
  @Override public void use(int x, int y, World w) {
    this.dropAJewel(x, y, w);
  }

}
