package zaltys.drawingstrategy;

import zaltys.GameMap;

public class WallDrawingStragey implements DrawingStrategy {

    private GameMap map;

    public WallDrawingStragey(GameMap map) {
        this.map = map;
    }

    @Override
    public boolean doesApply(int x, int y) {
        return map.isWall(x, y);
    }

    @Override
    public void draw() {
        System.out.print("#");
    }
}
