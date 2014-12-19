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

  public void addRobot(Robot robot) {
    //robot.setPosition(x, y);
    this.robot = robot;
  }

  public String show() {
    return !this.isFree() ? this.robot.getRef() : "--";
  }
}
