package GameObject;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Board extends JComponent implements KeyListener {

 private int HeroX;
 private int HeroY;
 private int HeroDirection;
 public static final int TILESIZE = 72;
 public static final int SIZEX = 10;
 public static final int SIZEY = 10;
 private final int BOARDDIMENSIONX = TILESIZE * SIZEX;
 private final int BOARDIMENSIONY = TILESIZE * SIZEY;


  public Board() {
    HeroX = 0;
    HeroY = 0;
    setPreferredSize(new Dimension(BOARDDIMENSIONX, BOARDIMENSIONY));
    setVisible(true);
  }

  public static void BoardMain() {
    JFrame frame = new JFrame("RPG Game");
    Board board = new Board();
    frame.add(board);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setVisible(true);
    frame.pack();
    frame.addKeyListener(board);
  }


  public static int[][] gameBoard = new int[][] {
          { 1, 1, 1, 0, 1, 0, 1, 1, 1, 1 },
          { 1, 1, 1, 0, 1, 0, 1, 0, 0, 1 },
          { 1, 0, 0, 0, 1, 0, 1, 0, 0, 1 },
          { 1, 1, 1, 1, 1, 0, 1, 1, 1, 1 },
          { 0, 0, 0, 0, 1, 0, 0, 0, 0, 1 },
          { 1, 0, 1, 0, 1, 1, 1, 1, 0, 1 },
          { 1, 0, 1, 0, 1, 0, 0, 1, 0, 1 },
          { 1, 1, 1, 1, 1, 0, 0, 1, 0, 1 },
          { 1, 0, 0, 0, 1, 1, 1, 1, 0, 1 },
          { 1, 1, 1, 0, 1, 0, 0, 1, 1, 1 },
  };

  public int[][] getGameBoard() {
    return gameBoard;
  }

  public int getSIZEX() {
    return SIZEX;
  }

  public int getSIZEY() {
    return SIZEY;
  }

  @Override
  public void paint(Graphics graphics) {
    super.paint(graphics);

    int row = gameBoard.length;
    int col = gameBoard[0].length;

    for (int i = 0; i < row; i++) {
      for (int j = 0; j < col; j++) {
        if (gameBoard[j][i] == 1) {
          PositionedImage floor = new PositionedImage("assets/floor.png", i * TILESIZE, j *
                  TILESIZE);
          floor.draw(graphics);
        } else if (gameBoard[j][i] == 0) {
          PositionedImage wall = new PositionedImage("assets/wall.png",i * TILESIZE, j * TILESIZE);
          wall.draw(graphics);
        }
      }
    }

    String heroFile;
    switch (HeroDirection) {
      case 0: heroFile = "assets/hero-up.png";
      break;
      case 1: heroFile = "assets/hero-left.png";;
      break;
      case 2: heroFile = "assets/hero-down.png";;
      break;
      case 3: heroFile = "assets/hero-right.png";;
      break;
      default: heroFile = "assets/hero-down.png";
    }

    PositionedImage hero = new PositionedImage(heroFile,HeroX,HeroY);
    hero.draw(graphics);

    PositionedImage skeletonA = new PositionedImage("assets/skeleton.png",skeleton1.getPosX(),
            skeleton1.getPosY());
    skeletonA.draw(graphics);
    PositionedImage skeletonB = new PositionedImage("assets/skeleton.png",skeleton2.getPosX(),
            skeleton2.getPosY());
    skeletonB.draw(graphics);
    PositionedImage skeletonC = new PositionedImage("assets/skeleton.png",skeleton3.getPosX(),
            skeleton3.getPosY());
    skeletonC.draw(graphics);
  }

  Monster skeleton1 = new Skeleton();
  Monster skeleton2 = new Skeleton();
  Monster skeleton3 = new Skeleton();

  @Override
  public void keyTyped(KeyEvent e) {
  }

  @Override
  public void keyPressed(KeyEvent e) {
  }

  @Override
  public void keyReleased(KeyEvent e) {
    if (e.getKeyCode() == KeyEvent.VK_UP && (HeroY - 72) >= 0 && (gameBoard[HeroY/72 - 1][HeroX/72] != 0)) {
      HeroY -= 72;
      HeroDirection = 0;
    } else if(e.getKeyCode() == KeyEvent.VK_DOWN && (HeroY + 72) < 720 && gameBoard[HeroY/72 +
            1][HeroX/72] != 0) {
      HeroY += 72;
      HeroDirection = 2;
    } else if(e.getKeyCode() == KeyEvent.VK_RIGHT && (HeroX + 72) < 720 &&
            gameBoard[HeroY/72][HeroX/72 + 1] != 0) {
      HeroX += 72;
      HeroDirection = 3;
    } else if(e.getKeyCode() == KeyEvent.VK_LEFT && (HeroX - 72) >= 0 &&
    gameBoard[HeroY/72][HeroX/72-1] != 0) {
      HeroX -= 72;
      HeroDirection = 1;
    }
    repaint();
  }
}