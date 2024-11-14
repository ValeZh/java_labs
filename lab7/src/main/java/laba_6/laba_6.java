package laba_6;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.effect.DropShadow;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.ScrollEvent;
import javafx.scene.paint.Color;
import javafx.scene.paint.LinearGradient;
import javafx.scene.paint.CycleMethod;
import javafx.scene.paint.Stop;
import javafx.stage.Stage;

public class laba_6 extends Application {
    private Canvas canvas = new Canvas(300, 300);
    private GraphicsContext gc = canvas.getGraphicsContext2D();
    private Group root = new Group();
    private double brushSize = 20; // Размер пензля по умолчанию

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Drawing Triangle with Erase and Brush Size Control");

        // Рисуем треугольник и применяем градиенты
        drawTriangle();
        drawLinearGradient(Color.LIGHTBLUE, Color.DARKBLUE);
        drawDropShadow(Color.LIME, Color.CYAN, Color.MAGENTA);

        // Добавляем обработчики событий
        canvas.addEventHandler(MouseEvent.MOUSE_DRAGGED, this::eraseDrawing);
        canvas.addEventHandler(MouseEvent.MOUSE_CLICKED, this::handleTripleClick);
        canvas.addEventHandler(ScrollEvent.SCROLL, this::changeBrushSize);

        root.getChildren().add(canvas);
        primaryStage.setScene(new Scene(root, 300, 300));
        primaryStage.show();
        updateTitle(primaryStage);
    }

    /**
     * Рисуем равносторонний треугольник
     */
    private void drawTriangle() {
        gc.beginPath();
        gc.moveTo(150, 50); // Вершина треугольника
        gc.lineTo(50, 250); // Левая нижняя вершина
        gc.lineTo(250, 250); // Правая нижняя вершина
        gc.closePath();
    }

    /**
     * Линейный градиент
     */
    private void drawLinearGradient(Color firstColor, Color secondColor) {
        LinearGradient lg = new LinearGradient(0, 0, 1, 1, true,
                CycleMethod.REFLECT,
                new Stop(0.0, firstColor),
                new Stop(1.0, secondColor));
        gc.setFill(lg);
        gc.fill();
    }

    /**
     * Добавляем тень с тремя цветами
     */
    private void drawDropShadow(Color firstColor, Color secondColor, Color thirdColor) {
        gc.applyEffect(new DropShadow(15, 15, 15, firstColor));
        gc.applyEffect(new DropShadow(10, -15, 15, secondColor));
        gc.applyEffect(new DropShadow(20, 0, -15, thirdColor));
    }

    /**
     * Стираем рисунок при проведении мышью
     */
    private void eraseDrawing(MouseEvent event) {
        double x = event.getX();
        double y = event.getY();
        gc.clearRect(x - brushSize / 2, y - brushSize / 2, brushSize, brushSize);
    }

    /**
     * Восстанавливаем рисунок при тройном клике
     */
    private void handleTripleClick(MouseEvent event) {
        if (event.getClickCount() == 3) {
            clearCanvas();
            drawTriangle();
            drawLinearGradient(Color.LIGHTBLUE, Color.DARKBLUE);
            drawDropShadow(Color.LIME, Color.CYAN, Color.MAGENTA);
        }
    }

    /**
     * Меняем размер пензля при прокрутке колесика мыши
     */
    private void changeBrushSize(ScrollEvent event) {
        if (event.getDeltaY() > 0) {
            brushSize += 5;
        } else {
            brushSize = Math.max(5, brushSize - 5); // Минимальный размер пензля — 5
        }
        updateTitle((Stage) canvas.getScene().getWindow());
    }

    /**
     * Обновляем заголовок окна с текущим размером пензля
     */
    private void updateTitle(Stage stage) {
        stage.setTitle("Brush Size: " + (int) brushSize);
    }

    /**
     * Очищаем полотно
     */
    private void clearCanvas() {
        gc.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());
    }
}
