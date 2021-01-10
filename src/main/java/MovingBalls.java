import processing.core.PApplet;

class Ball {
    private float diameter;
    private int y;
    private int x;

    public Ball(int x, int y, int diameter) {
        this.x = x;
        this.y = y;
        this.diameter = diameter;
    }

    void moveBy(int dx, int dy) {
        x += dx;
        y += dy;
    }

    void draw(PApplet pApplet) {
        pApplet.ellipse(x, y, diameter, diameter);
    }
}

public class MovingBalls extends PApplet {
    final int WIDTH = 480;
    final int HEIGHT = 650;
    final int DIAMETER = 20;
    Ball[] ball;


    public static void main(String[] args) {
        PApplet.main("MovingBalls", args);
    }

    @Override
    public void settings() {
        size(WIDTH, HEIGHT);
    }

    @Override
    public void setup() {
        ball = new Ball[4];
        for (int i = 0; i < 4; i++) {
            ball[i] = new Ball(0, HEIGHT / 5 * (i + 1), DIAMETER);
        }

    }

    @Override
    public void draw() {
        for (int i = 0; i < 4; i++) {
            ball[i].draw(this);
            ball[i].moveBy(i + 1, 0);
        }
    }
}