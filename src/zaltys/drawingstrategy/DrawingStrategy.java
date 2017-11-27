package zaltys.drawingstrategy;

public interface DrawingStrategy {

    public boolean doesApply(int x, int y);

    public void draw();

}
