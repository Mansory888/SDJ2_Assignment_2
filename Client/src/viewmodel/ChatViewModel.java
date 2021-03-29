package viewmodel;

import javafx.application.Platform;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.Model;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class ChatViewModel implements PropertyChangeListener {
    private Model model;
    private ObservableList<String> chatLogs;
    private StringProperty message;
    private StringProperty serverLabel;
    private StringProperty UserLabel;

    public ChatViewModel(Model model){
        this.model = model;
        chatLogs = FXCollections.observableArrayList();
        message = new SimpleStringProperty();
        serverLabel = new SimpleStringProperty();
        UserLabel = new SimpleStringProperty();
        model.addListener(this);
        chatLogs.add("Type !commands to see commands");
    }

    public ObservableList<String> getLogs()
    {
        return chatLogs;
    }

    public StringProperty getMessage(){ return  message;}

    public StringProperty getServerLabel(){return serverLabel;}

    public StringProperty getUserLabel(){
        UserLabel.set(model.getName());
        return UserLabel;
    }

    public void send(){
        try {
            if(!message.get().equals("")){
                model.SendM(message.get());
            }

        } catch (Exception e){
            //
        }
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt)
    {

        Platform.runLater(() -> {
            switch (evt.getPropertyName()){
                case "add":
                    chatLogs.add( evt.getNewValue() + "");
                    break;
                case "ServerLabel":
                    serverLabel.set((String) evt.getNewValue());
                    break;

            }

        });
    }


}
