/**
 * 
 */
package acsse.csc2b.server;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

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
public class ServerHandler extends GridPane{

	
	private Button btnListern = new Button("Start Listerning");
	private TextField receivedMessage = new TextField();
	private final Text actiontarget = new Text();
	private Text scenetitle = new Text("Text A Lot Kommunikation");
	private HBox hbBtn = new HBox(10);
	public ServerHandler() {}
	
	public ServerHandler(Stage stage/*,DatagramSocket server*/) {
		serverInterface();
		btnListern.setOnAction((e)->{
			
			actiontarget.setFill(Color.FIREBRICK);
			actiontarget.setText("Listerning...");
            listernForMessage(/*server*/);
		});
	}
	
	private void serverInterface() {
		setAlignment(Pos.TOP_CENTER);
	    setHgap(40);
	    setVgap(10);
	    setPadding(new Insets(5, 5, 5, 5));
	    
	    scenetitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
	    add(scenetitle, 0, 0, 2, 1);
	    
	    hbBtn.setAlignment(Pos.BOTTOM_LEFT);
	    hbBtn.getChildren().add(btnListern);
	    add(hbBtn, 0, 2);
	    add(actiontarget, 0, 3);
	    
	    Label IDtoRetrieve = new Label("The Client Says:");
	    add(IDtoRetrieve, 0, 10);   
	    add(receivedMessage, 0, 11);
	    

	}

	
	public void listernForMessage(/*DatagramSocket server*/) {
		try {
			DatagramSocket server =new DatagramSocket(9876);
		
		byte[] receiveMessage = new byte[1024];
		
		
		
		//while(true) {
		DatagramPacket messagepacket = new DatagramPacket(receiveMessage,receiveMessage.length);
			
			server.receive(messagepacket);
			String message = new String(messagepacket.getData());
			System.out.println("Client: " + message);
			
			receivedMessage.setText(message);
			
			if(message.equals("bye")) {
				System.out.println("Client: " + message + "\n" + "Server: Bye Bye Client");;
				//break;
			}
			receiveMessage = new byte[1024];
			//counter++;
		//}
		
		
		
		
		
		
	} catch (SocketException e) {
		System.err.println("Error on the Datagram Socket creation on Server");
		e.printStackTrace();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	}
}
