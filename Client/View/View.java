package Client.View;

import Client.Controller.ClientController;
import Client.Model.ClientModel;
import Client.Model.Model;
import Client.Controller.Controller;

abstract public class View<C extends Controller, M extends Model> {
    protected C controller;
    protected M model;

    abstract public void updateView();

    public View(C controller, M model){
        this.controller =controller;
        this.model = model;
    }
}
