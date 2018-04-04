package Client.View;

//import Client.SendAndReceive;
import Client.Controller.ClientController;
import Client.Model.ClientModel;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


public class ClientView extends View<ClientController, ClientModel> {

    Button sendBtn, reversiBtn, tttBtn, connectBtn;
    Stage window;
    Scene mainScene, reversiScene, tttScene;
    TextField input;
    Label label;

    public ClientView(ClientController controller, ClientModel model) {
        super(controller, model);
        //window = primaryStage;   // Michien moeten we dit hier houden.
        label = new Label("Placeholder label");
        input = new TextField();

        sendBtn = new Button("Send String to server");
        sendBtn.setOnAction((ActionEvent e) -> {
            controller.sendBtn();

        });
        reversiBtn = new Button("Play Reversi");
        reversiBtn.setOnAction(e -> controller.reversiBtn());

        tttBtn = new Button("Play Tic Tac Toe");
        tttBtn.setOnAction(e-> controller.tttBtn());

        connectBtn = new Button("Establish connection");
        connectBtn.setOnAction(e-> controller.connectBtn());


        StackPane layout = new StackPane();
        VBox vbox = new VBox(5);
        vbox.getChildren().addAll(label, input, connectBtn, sendBtn, reversiBtn, tttBtn);
        layout.getChildren().add(vbox);
        mainScene = new Scene(layout, 500, 500);


        Button backButton = new Button("Back to start");
        backButton.setOnAction(e -> controller.backButton());

        Button backButton2 = new Button("Back to start");
        backButton2.setOnAction(e -> controller.backButtton2());

        VBox vbox2 = new VBox(5);
        vbox2.getChildren().addAll(backButton);
        StackPane layoutReversi = new StackPane();
        layoutReversi.getChildren().add(vbox2);
        reversiScene = new Scene(layoutReversi, 500, 500);


        VBox vbox3 = new VBox(5);
        vbox3.getChildren().addAll(backButton2);
        StackPane layoutTTT = new StackPane();
        layoutTTT.getChildren().add(vbox3);
        tttScene = new Scene(layoutTTT, 500, 500);

        window.setScene(mainScene);
    }


    @Override
    public void updateView() {


    }
}
