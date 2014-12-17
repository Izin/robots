public class Robots {

  public static void main(String[] args) {
    World asci = new World(2, 10);
    Jeweler JeanRemy = new Jeweler(1, 1, 1);

    asci.display();
    JeanRemy.move(1, 2, asci);
  }

}
