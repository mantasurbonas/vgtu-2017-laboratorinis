package zaltys.drawingstrategy;

import zaltys.GameMap;

public class AppleDrawingStrategy implements DrawingStrategy {

    private GameMap map;

    public AppleDrawingStrategy(GameMap map) {
        this.map = map;
    }

    @Override
    public boolean doesApply(int x, int y) {
        return map.isApple(x, y);
    }

    @Override
    public void draw() {
        System.out.print("o");
    }
}
