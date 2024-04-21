import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class CircleAnimation extends Application {

    private static final int WIDTH = 600;
    private static final int HEIGHT = 400;
    private static final int CIRCLE_RADIUS = 20;

    private double x = WIDTH / 2;
    private double y = HEIGHT / 2;
    private double dx = 1.5;
    private double dy = 1.5;

    @Override
    public void start(Stage primaryStage) {
        Canvas canvas = new Canvas(WIDTH, HEIGHT);
        GraphicsContext gc = canvas.getGraphicsContext2D();

        StackPane root = new StackPane();
        root.getChildren().add(canvas);

        Scene scene = new Scene(root, WIDTH, HEIGHT);

        new AnimationTimer() {
            @Override
            public void handle(long now) {
                gc.clearRect(0, 0, WIDTH, HEIGHT);

                // Desenarea cercului
                gc.setFill(Color.BLUE);
                gc.fillOval(x - CIRCLE_RADIUS, y - CIRCLE_RADIUS, CIRCLE_RADIUS * 2, CIRCLE_RADIUS * 2);

                // Actualizarea poziției cercului
                x += dx;
                y += dy;

                // Verificarea coliziunii cu marginile ecranului
                if (x - CIRCLE_RADIUS < 0 || x + CIRCLE_RADIUS > WIDTH) {
                    dx = -dx;
                }
                if (y - CIRCLE_RADIUS < 0 || y + CIRCLE_RADIUS > HEIGHT) {
                    dy = -dy;
                }
            }
        }.start();

        primaryStage.setTitle("Circle Animation");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
