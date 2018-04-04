package Client.Controller;

import Client.Model.ClientModel;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class ClientController extends Controller<ClientModel> {
    Button sendBtn, reversiBtn, tttBtn, connectBtn;
    Stage window;
    Scene mainScene, reversiScene, tttScene;
    TextField input;
    Label label;

    public ClientController(ClientModel model) {
        super(model);
    }

    public void sendBtn(){
        model.sendBtn();

    }

    public void reversiBtn(){
        window.setScene(reversiScene);
    }


    public void tttBtn(){
        window.setScene(tttScene);
    }

    public void connectBtn(){
        new ClientModel();

    }

    public void backButton(){
        window.setScene(mainScene);
    }

    public void backButtton2(){
        window.setScene(mainScene);
    }
}
