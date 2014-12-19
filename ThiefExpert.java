public class ThiefExpert extends Thief {

  // Attributes

  // Constructor
  public ThiefExpert(String ref, String name) {
    super(ref, name);
    System.out.println("Création du robot voleur expert " + name + " (" + ref + ")");
  }

  @Override public void stealJewels(int x, int y, World w) {
    if (w.map[y][x].getState() == 1) {
      w.map[y][x].setState(0);
      //System.out.println(" -> vole les bijoux");
    } else {
      //System.out.print(" -> rien à voler");
    }
  }

}
