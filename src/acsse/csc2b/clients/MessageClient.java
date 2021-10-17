/**
 * 
 */
package acsse.csc2b.clients;

import java.net.DatagramSocket;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * @author Thalukanyo
 *
 */
public class MessageClient extends Application {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		DatagramSocket client = new DatagramSocket();
		ClientHandler grid = new ClientHandler(primaryStage,client);
		Scene scene = new Scene(grid,700,700);
		primaryStage.setScene(scene);
		primaryStage.setTitle("Client");
		primaryStage.show();
		
	}

}
