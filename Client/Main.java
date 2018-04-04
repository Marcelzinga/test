package Client;

import Client.Controller.ClientController;
import Client.Model.ClientModel;
import Client.View.ClientView;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class Main extends Application {
    static Stage window;
    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Game Client");
        window = primaryStage;

        ClientModel model = new ClientModel();
        ClientController controller = new ClientController(model);
        ClientView view = new ClientView(controller, model);

        Scene s= new Scene(view);
        primaryStage.setScene(s);
        primaryStage.show();

    }
}
