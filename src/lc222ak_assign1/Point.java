package lc222ak_assign1;

public class Point {
    private int x;
    private int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Point() {
        this.x = 0;
        this.y = 0;
    }

    public String toString() {
        return "(" + x + "," + y + ")";
    }

    public boolean isEqualTo(Point point) {
        return (this.x == point.x && this.y == point.y);
    }

    public double distanceTo(Point point) {
        return (Math.sqrt(Math.pow((this.x-point.x), 2) + Math.pow((this.y-point.y), 2)));
    }

    public void move(int x, int y) {
        this.x += x;
        this.y += y;
    }

    public void moveToXY(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
