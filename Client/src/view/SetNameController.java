package view;

import javafx.fxml.FXML;

import javafx.scene.control.TextField;
import viewmodel.SetNameViewModel;

import javafx.scene.layout.Region;

public class SetNameController {

    @FXML private TextField InputField;
    private SetNameViewModel setNameViewModel;
    private Region root;
    private ViewHandler viewHandler;


    public void init(ViewHandler viewHandler, SetNameViewModel setNameViewModel, Region root){
        this.viewHandler = viewHandler;
        this.setNameViewModel = setNameViewModel;
        this.root = root;
        InputField.textProperty().bindBidirectional(setNameViewModel.getInputField());
    }

    public void reset(){

    }

    public Region getRoot(){
        return root;
    }

    @FXML public void submit(){
        setNameViewModel.setName();
        viewHandler.openView("Chat");
    }






}
