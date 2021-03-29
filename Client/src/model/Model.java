package model;

public interface Model extends UnnamedPropertySubject{
    public void setName(String s);
    public void addMessage(String s);
    public void SendM(String s);
    public void setServerLabel(String s);
    public String getName();
}
