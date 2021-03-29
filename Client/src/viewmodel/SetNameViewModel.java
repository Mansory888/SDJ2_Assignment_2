package viewmodel;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import model.Model;


public class SetNameViewModel {
    private Model model;
    private StringProperty inputField;


    public SetNameViewModel(Model model){
        this.model = model;
        inputField = new SimpleStringProperty();
    }

    public void setName(){
        model.setName(inputField.get());
    }

    public StringProperty getInputField(){return inputField;}
}
