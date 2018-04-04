package Client.Controller;

import Client.Model.Model;

abstract public class Controller<M extends Model> {

    protected M model;

    public Controller(M model) {
        this.model = model;
    }
}