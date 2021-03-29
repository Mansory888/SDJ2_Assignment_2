package view;

import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.Region;
import viewmodel.ChatViewModel;
import javafx.scene.control.Label;



public class ChatController {
    @FXML private ListView<String> logList;
    @FXML private TextField inputField;
    @FXML private Label ServerLabel;
    @FXML private Label UserLabel;
    private ChatViewModel chatViewModel;
    private Region root;
    private ViewHandler viewHandler;


    public void init(ViewHandler viewHandler, ChatViewModel chatViewModel, Region root)
    {
        this.viewHandler = viewHandler;
        this.chatViewModel = chatViewModel;
        this.root = root;
        logList.setItems(chatViewModel.getLogs());
        ServerLabel.textProperty().bind(chatViewModel.getServerLabel());
        UserLabel.textProperty().bind(chatViewModel.getUserLabel());
        inputField.textProperty().bindBidirectional(chatViewModel.getMessage());
    }

    public void reset()
    {
        // empty
    }

    public Region getRoot()
    {
        return root;
    }

    @FXML private void onEnter(){
        chatViewModel.send();
        inputField.setText("");
    }
}
