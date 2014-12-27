package org.views;

import javax.swing.JPanel;
import javax.imageio.ImageIO;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

public class SPanel extends JPanel {
  public void paintComponent(Graphics g){
    try {
      Image img = ImageIO.read(new File("img/robot.png"));
      g.drawImage(img, 0, 0, this);
      //Pour une image de fond
      //g.drawImage(img, 0, 0, this.getWidth(), this.getHeight(), this);
    } catch (IOException e) {
      e.printStackTrace();
    }

    System.out.println("Je suis exécutée !");
  }
}
