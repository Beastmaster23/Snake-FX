package application;

import application.game.Collider2D;
import application.game.Game;
import application.game.PowerUp;
import application.game.Snake;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Label;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;

public class Main extends Application {
	
	private Canvas mainCanvas;
	private GraphicsContext context;
	private Scene scene;
	private Label label;
	private Snake player;
	private PowerUp powerUp;
	private AnimationTimer loop;
	private double playerSpeed = 30, score=0;

	@Override
	public void start(Stage primaryStage) {
		try {

			BorderPane root = FXMLLoader.load(getClass().getResource("/Main.fxml"));
			label=(Label)root.getTop();
			mainCanvas = (Canvas) root.getCenter();
			context = mainCanvas.getGraphicsContext2D();
			Game.width = 800;
			Game.height = 600;
			scene = new Scene(root);
			setupGame();
			runGame();
			
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void setupGame() {
		player = new Snake();
		player.getPhysics().setSpeedX(playerSpeed);
		player.getPhysics().setSpeedY(playerSpeed);
		player.setWidth(30);
		player.setHeight(30);
		Collider2D collider = new Collider2D();
		collider.setPossitionX(player.getPossitionX());
		collider.setPossitionY(player.getPossitionY());
		collider.setWidth(player.getWidth());
		collider.setHeight(player.getHeight());

		player.setCollider(collider);
		powerUp = new PowerUp();
		powerUp.setPossitionX(0);
		powerUp.setPossitionY(0);
		powerUp.setWidth(20);
		powerUp.setHeight(20);
		Collider2D powerCollider = new Collider2D();
		powerCollider.setPossitionX(powerUp.getPossitionX());
		powerCollider.setPossitionY(powerUp.getPossitionY());
		powerCollider.setWidth(powerUp.getWidth());
		powerCollider.setHeight(powerUp.getHeight());

		powerUp.setCollider(powerCollider);
		powerUp.spawn();
		scene.setOnKeyPressed(new EventHandler<KeyEvent>() {

			@Override
			public void handle(KeyEvent event) {
				// TODO Auto-generated method stub
				if (event.getCode() == player.getInput().getLeft()) {
					player.setDirectionX(-1);
					player.setDirectionY(0);
				}
				if (event.getCode() == player.getInput().getRight()) {
					player.setDirectionX(1);
					player.setDirectionY(0);
				}
				if (event.getCode() == player.getInput().getUp()) {
					player.setDirectionY(-1);
					player.setDirectionX(0);
				}
				if (event.getCode() == player.getInput().getDown()) {
					player.setDirectionY(1);
					player.setDirectionX(0);
				}
			}

		});
		score=0;
	}

	public void runGame() {

		loop = new AnimationTimer() {
			long prevNano = 0;
			int frames = 0;

			@Override
			public void handle(long currentNano) {
				if (prevNano == 0) {
					prevNano = currentNano;
					return;
				}
				if (frames % 10 == 0) {
					float elapsedNano = (currentNano - prevNano) / 1e9f;
					prevNano = currentNano;

					context.setFill(Color.GHOSTWHITE);
					context.clearRect(0, 0, Game.width, Game.height);

					player.update(1);
					powerUp.setEaten(player.getCollider().collide(powerUp.getCollider()));
					if (powerUp.isEaten()) {
						powerUp.spawn();
						player.setGrow(true);
						score++;
						label.setText("Score : "+score+"");
					}
					if (player.getPossitionX() + player.getWidth() > Game.width) {
						player.setPossitionX(0);
					}
					if (player.getPossitionX() < 0) {
						player.setPossitionX(Game.width - player.getWidth());
					}
					if (player.getPossitionY() + player.getHeight() > Game.height) {
						player.setPossitionY(0);
					}
					if (player.getPossitionY() < 0) {
						player.setPossitionY(Game.height - player.getHeight());
					}

					player.draw(context);
					powerUp.draw(context);
				}
				frames++;
			}
		};

		loop.start();
	}

	public static void main(String[] args) {
		launch(args);
	}
}
