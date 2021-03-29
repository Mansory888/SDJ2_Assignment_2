package model;

import mediator.ChatClinet;
import mediator.ServerModel;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class ModelManager implements Model{
    private String name;
    private PropertyChangeSupport property;
    private ServerModel serverModel;

    public ModelManager(){
        this.name = "";
        property = new PropertyChangeSupport(this);
        serverModel = new ChatClinet("localhost", 6789, this);
    }



    @Override public void addMessage(String s) {
        property.firePropertyChange("add", null, s);
    }

    @Override public void setServerLabel(String s){
        property.firePropertyChange("ServerLabel", null, s);
    }


    @Override public void SendM(String s){
        serverModel.Send(s);
    }

    @Override public void setName(String s){
        serverModel.Login(s);
        name = "User: " + s;
    }

    @Override public String getName(){
        return name;
    }

    @Override public void addListener(PropertyChangeListener listener)
    {
        property.addPropertyChangeListener(listener);
    }

    @Override public void removeListener(PropertyChangeListener listener)
    {
        property.removePropertyChangeListener(listener);
    }



}
