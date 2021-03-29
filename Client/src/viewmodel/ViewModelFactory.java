package viewmodel;

import model.Model;

public class ViewModelFactory
{
  private SetNameViewModel setNameViewModel;
  private ChatViewModel chatViewModel;

  public ViewModelFactory(Model model)
  {
    setNameViewModel = new SetNameViewModel(model);
    chatViewModel = new ChatViewModel(model);
  }


  public SetNameViewModel getSetNameViewModel() { return setNameViewModel;}

  public ChatViewModel getChatViewModel(){return chatViewModel;}
}
