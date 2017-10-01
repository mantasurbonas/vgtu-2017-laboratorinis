package zaltys;

import java.util.LinkedList;

public class Snake {

	Direction movementDirection = Direction.RIGHT;

	LinkedList<Coord> elements = new LinkedList<>();

	public Snake(Direction initialDirection, Coord ... coords) {
		this.movementDirection = initialDirection;
		for (Coord coord: coords)
			elements.add(coord);
	}

	public boolean isMe(int x, int y) {
		for (Coord coord: elements)
			if (coord.x==x && coord.y == y)
				return true;
		
		return false;
	}

	public Coord getHead() {
		return elements.get(0);
	}

	public void addHead(Coord newHead) {
		elements.push(newHead);
	}

	public void trimTail() {
		elements.pollLast();
	}

	public Direction getDirection() {
		return movementDirection;
	}

	public void setDirection(Direction direction) {
		this.movementDirection = direction;
	}


}
