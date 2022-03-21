package ch.hslu.ad.Balls;

public final class BallDemo {

    public static final int WIDTH = 600;
    public static final int HEIGHT = 400;

    public static void main(String[] args) throws InterruptedException {
        Canvas canvas = Canvas.getCanvas();
        Ball ball = new Ball();

        while(true) {

            Thread thread = new Thread(ball,"ball");
            thread.start();
            Thread.sleep(500);
        }
    }
}