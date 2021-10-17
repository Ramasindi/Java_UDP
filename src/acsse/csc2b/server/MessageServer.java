/**
 * 
 */
package acsse.csc2b.server;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * @author Thalukanyo
 *
 */
public class MessageServer extends Application {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		
		ServerHandler grid = new ServerHandler(primaryStage);
		Scene scene = new Scene(grid,700,700);
		primaryStage.setScene(scene);
		primaryStage.setTitle("Server");
		primaryStage.show();
		
	}

}
