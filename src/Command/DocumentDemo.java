package Command;

import java.util.ArrayList;

//Command interface
interface ActionListener{
    void execute();
}

//Receiver
class Document{
    public void open(){
        System.out.println("Document opened");
    }
    public void save(){
        System.out.println("Document Saved");
    }
}

//Concrete Command
class ActionOpen implements ActionListener{
    private Document doc;

    public ActionOpen (Document doc){
        this.doc = doc;
    }
    public void execute(){
        doc.open();
    }
}
//Concrete Command
class ActionSave implements ActionListener{
    private Document doc;

    public ActionSave(Document doc){
        this.doc = doc;
    }
    public void execute(){
        doc.save();
    }
}
//Invoker
class MenuOptions{
    private ArrayList<ActionListener> commands = new ArrayList<>();
    public void addCommands(ActionListener command){
        commands.add(command);
    }
    public void executeCommands(){
        for(ActionListener command : commands){
            command.execute();
        }
    }
}
public class DocumentDemo {
    public static void main(String[] args) {
        Document doc = new Document();

        ActionListener clickOpen = new ActionOpen(doc);
        ActionListener clickSave = new ActionSave(doc);

        MenuOptions menu = new MenuOptions();
        menu.addCommands(clickOpen);
        menu.addCommands(clickSave);

        menu.executeCommands();
    }
}
