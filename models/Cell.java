package models;

public class Cell {

  // Attributes
  private int state   = 0;
  private Robot robot = null;

  // Contructor
  public Cell() {
  }

  // Accessors
  private boolean _isClean() {
    return this.state == 0;
  }

  public boolean isFree() {
    return this.robot instanceof Robot == false;
  }

  public void release() {
    this.robot = null;
  }

  public String show() {
    String content = this.state == 1 ? " $" : "--";
    return !this.isFree() ? this.robot.getRef() : content;
  }

  public void setRobot(Robot robot) {
    this.robot = robot instanceof Robot ? robot : null;
  }

  public void setState(int state) {
    this.state = state;
  }

  public int getState() { return this.state; }
}
