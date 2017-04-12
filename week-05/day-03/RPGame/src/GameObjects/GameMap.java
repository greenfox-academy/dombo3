package GameObjects;

import GameObjects.Floor;
import GameObjects.GameObject;
import GameObjects.Wall;

import java.util.ArrayList;
import java.util.List;

public class GameMap {
  public static int[][] gameBoard = new int[][]{
          {1, 1, 1, 0, 1, 0, 1, 1, 1, 1},
          {1, 1, 1, 0, 1, 0, 1, 0, 0, 1},
          {1, 0, 0, 0, 1, 0, 1, 0, 0, 1},
          {1, 1, 1, 1, 1, 0, 1, 1, 1, 1},
          {0, 0, 0, 0, 1, 0, 0, 0, 0, 1},
          {1, 0, 1, 0, 1, 1, 1, 1, 0, 1},
          {1, 0, 1, 0, 1, 0, 0, 1, 0, 1},
          {1, 1, 1, 1, 1, 0, 0, 1, 0, 1},
          {1, 0, 0, 0, 1, 1, 1, 1, 0, 1},
          {1, 1, 1, 0, 1, 0, 0, 1, 1, 1},
  };;
  private List<List<GameObject>> gameObjects;

  public GameMap() {
    this.gameObjects = new ArrayList<List<GameObject>>();
  }

  public void fillMap() {
    int row = gameBoard.length;
    int col = gameBoard[0].length;

    for (int i = 0; i < row; i++) {
      List<GameObject> tempArrayList = new ArrayList<>();
      gameObjects.add(tempArrayList);
      for (int j = 0; j < col; j++) {
        if (gameBoard[j][i] == 1) {
          tempArrayList.add(new Floor(i * 72, j * 72, "assets/floor.png"));
        } else if (gameBoard[j][i] == 0) {
          tempArrayList.add(new Wall(i * 72, j * 72, "assets/wall.png"));
        }
      }
    }
  }

  public List<List<GameObject>> getGameObjects() {
    return gameObjects;
  }

  public int[][] getGameBoard() {
    return gameBoard;
  }
}