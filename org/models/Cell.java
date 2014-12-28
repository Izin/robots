package org.models;


/**
 * A cell in a grid, with a robot, a jewel or nothing
 *
 * @author  Malo Blanchard
 * @version 0.9
 */
public class Cell {

  private Jewel  jewel = null;
  private Robot  robot = null;
  private String image = "cell";

  /**
   * Build a new instance of Cell
   */
  public Cell() {}

  /**
   * Return a String corresponding to the state of the cell.
   * It can be the robot's type ("madman", "jumper", ...) or
   * "jewel", or just "cell" if there is nothing on it.
   *
   * @return  name  without extention
   */
  public String show() {
    if (this.robot instanceof Robot) {
      return robot.getImage();
    }
    if (this.jewel instanceof Jewel) {
      return jewel.getImage();
    }
    return this.image;
  }

  /**
   * Check if the cell contains a robot
   *
   * @return  true if there is NOTHING
   */
  public boolean isFree() {
    return this.robot instanceof Robot == false;
  }

  /**
   * Check if the cell contains a jewel
   *
   * @return  true if there is a jewel
   */
  public boolean hasJewel() {
    return this.jewel instanceof Jewel;
  }

  /**
   * Return the jewel instance
   *
   * @return  Instance of Jewel model
   */
  public Jewel getJewel() {
    return this.jewel;
  }

  /**
   * Destroy the cell's Robot instance
   */
  public void release() {
    this.robot = null;
  }

  /**
   * Destroy the cell's Jewel instance
   */
  public void steal() {
    this.jewel = null;
  }

  /**
   * Set the Jewel instance
   */
  public void setJewel(Jewel jewel) {
    this.jewel = jewel;
  }

  /**
   * Set the Robot instance
   */
  public void setRobot(Robot robot) {
    this.robot = robot;
  }

}
