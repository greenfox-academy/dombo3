import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;

import static javax.swing.JFrame.EXIT_ON_CLOSE;

public class RainbowBox {

  public static final int WIDTH = 500;
  public static final int HEIGHT = 500;

  public static void mainDraw(Graphics graphics) {
    for (int i = 10; i >= 0; i--) {
      centerBox(30*i, getRainbowColor(), graphics);
    }
  }

  public static void centerBox(int size, int color, Graphics graphics) {
    graphics.setColor(new Color(color));
    graphics.fillRect(WIDTH/2 - size/2,HEIGHT/2 - size/2, size, size);
  }

  public static int getRainbowColor() {
    int numToSeven = (int) (Math.random()*8);
    int color = 0x000000;
    switch (numToSeven) {
      case 1:
        return color = 0xFF0000;
      case 2:
        return color = 0xFF7F00;
      case 3:
        return color = 0xFFFF00;
      case 4:
        return color = 0x00FF00;
      case 5:
        return color = 0x0000FF;
      case 6:
        return color = 0x4B0082;
      case 7:
        return color = 0x9400D3;
      default:
        return color = 0xFF0000;
    }
  }

  public static void main(String[] args) {
    JFrame jFrame = new JFrame("Drawing");
    jFrame.setSize(new Dimension(WIDTH, HEIGHT));
    jFrame.setDefaultCloseOperation(EXIT_ON_CLOSE);
    jFrame.add(new ImagePanel());
    jFrame.setLocationRelativeTo(null);
    jFrame.setVisible(true);
    SavePaint(jFrame);
  }

  static class ImagePanel extends JPanel {
    @Override
    protected void paintComponent(Graphics graphics) {
      super.paintComponent(graphics);
      mainDraw(graphics);
    }
  }

  public static void SavePaint(JFrame jFrame) {
    try {
      BufferedImage image = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);
      Graphics2D graphics2D = image.createGraphics();
      jFrame.paint(graphics2D);
      ImageIO.write(image,"jpeg", new File("RainbowBox.jpeg"));
    } catch(Exception exception) {
      System.out.println("Exception occured: " + exception.getClass());
    }
  }

}