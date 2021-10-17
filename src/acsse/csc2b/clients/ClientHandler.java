/**
 * 
 */
package acsse.csc2b.clients;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.Scanner;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * @author Thalukanyo
 *
 */
public class ClientHandler extends GridPane {
	
	private Button btnSend = new Button("Send Message To Server");
	private final Text actiontarget = new Text();
	private TextField input = new TextField();
	private TextField sentMessage = new TextField();
	private Text scenetitle = new Text("Text A Lot Kommunikation");
	
	private HBox hbBtn = new HBox(10);
	public ClientHandler() {}
	
	public ClientHandler(Stage stage,DatagramSocket client) {
		clientInterface();
		btnSend.setOnAction((e)->{
			actiontarget.setFill(Color.FIREBRICK);
			try {
				sendMessage(client,input.getText());
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
            actiontarget.setText("Message sent...");
                                    
		});
	}

	public void clientInterface() {
		setAlignment(Pos.TOP_CENTER);
	    setHgap(40);
	    setVgap(10);
	    setPadding(new Insets(5, 5, 5, 5));
	    
	    scenetitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
	    add(scenetitle, 0, 0, 2, 1);
	    
	    hbBtn.setAlignment(Pos.BOTTOM_LEFT);
	    hbBtn.getChildren().add(btnSend);
	    add(hbBtn, 0, 2);
	    add(actiontarget, 0, 3);
	    
	    Label messageStatus = new Label("Client status:");
	    Label writeMsg = new Label("Enter Message to send:");
	    add(messageStatus, 0, 10);   
	    add(sentMessage, 0, 11);
	    add(writeMsg, 0, 12);
	    add(input, 0, 13);
	}
	
	public void sendMessage(DatagramSocket client,String message) throws IOException  {
		//try {
			InetAddress IPadd = InetAddress.getByName("localhost");
			byte[] sendMessage = null;
			//while (true) {
				String userInput = message;
				sendMessage = userInput.getBytes();
				DatagramPacket messagepacket = new DatagramPacket(sendMessage,sendMessage.length,IPadd,9876);

				client.send(messagepacket);
				sentMessage.setText("SENT");
				if(userInput.equals("bye")) {
					sentMessage.setText("SENT...closing");
					//break;
					
				}
			//}
	
		/*} catch (SocketException e) {
			System.err.println("Error on the Datagram Socket creation");
			e.printStackTrace();
		}catch (UnknownHostException e) {
			System.err.println("The specified host cannot be found");
			e.printStackTrace();
		} catch (IOException e) {
			System.err.println("Error on the input or output");
			e.printStackTrace();
		}*/
	}
}
