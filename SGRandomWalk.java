import java.util.Random;

public class SGRandomWalk {
    public static void main(String[] args) {
        Rectangle canvas = new Rectangle(0, 0, 300, 300);
        canvas.setColor(Color.BLUE);
        canvas.fill();

        Ellipse RandomWalk = new Ellipse(150, 150, 10, 10);
        RandomWalk.setColor(Color.RED);
        RandomWalk.fill();

        Ellipse escape = new Ellipse(50, 50, 200, 200);
        escape.setColor(Color.BLACK);
        escape.fill();
        escape.draw();

        int deltaX;
        int deltaY;
        boolean insideCircle = true;
        int steps = 0;

        int totalX = 0;
        int totalY = 0;

        while (insideCircle) {
            deltaX = (int) (21 * Math.random()) - 10;
            deltaY = (int) (21 * Math.random()) - 10;
            
            RandomWalk.translate(deltaX, deltaY);
            steps++;
            try { Thread.sleep(100);}
            catch(Exception ex) {};

            totalX += deltaX;
            totalY += deltaY;

            if ((Math.pow(totalX, 2) + Math.pow(totalY, 2)) > (Math.pow(110, 2))) insideCircle = false;

            System.out.println(totalX + " " + totalY);
        }

        System.out.println("Escaped in " + steps + " steps.");

    }
}