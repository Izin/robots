public class Cell {

  // Attributes
  private int state;
  private Robot robot;

  // Contructor
  public Cell(int state) {
    this.state = 0;
  }

  // Accessors
  private boolean _isClean() {
    return this.state == 0;
  }

  private boolean _isFree() {
    return this.robot !instanceof Robot;
  }

}
