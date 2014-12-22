package models;

public class ThiefDrunked extends Thief {

  // Attributes
  private boolean steal = true;

  // Constructor
  public ThiefDrunked(String ref, String name) {
    super(ref, name);
    System.out.println("Création du robot voleur saoul " + name + " (" + ref + ")");
  }

  @Override public void stealJewels(int x, int y, World w) {
    if (w.map[y][x].getState() == 1) {
      if (this.steal) {
        w.map[y][x].setState(0);
        this.steal = false;
        //System.out.println(" -> vole les bijoux");
      } else {
        this.steal = true;
        //System.out.println(" -> ne vole pas les bijoux");
      }
    } else {
      //System.out.print(" -> rien à voler");
    }
  }

}
