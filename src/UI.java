import java.util.Scanner;

interface IButton{
    void press();
}
interface ITextBox{
    void settext();
}

class MacButton implements IButton{
    public void press(){
        System.out.println("Mac Button is Pressed");
    }
}
class WinButton implements IButton{
    public void press(){
        System.out.println("Windows Button is pressed");
    }
}

class MacTextBox implements ITextBox{
    public void settext(){
        System.out.println("Setting text in mac textbox");
    }
}
class WinTextBox implements ITextBox{
    public void settext(){
        System.out.println("Setting text in windows textbox");
    }
}

interface IFactory{
    IButton createButton();
    ITextBox createTextBox();
}
class WinFactory implements IFactory{
    public IButton createButton(){
        return new WinButton();
    }
    public ITextBox createTextBox() {
        return new WinTextBox();
    }
}
class MacFactory implements IFactory{
    public IButton createButton(){
        return new MacButton();
    }
    public ITextBox createTextBox(){
        return new MacTextBox();
    }
}

class GUIAbstractFactory{
    public static IFactory createFactory(String osType){
        if(osType.equals("windows")){
            return new WinFactory();
        }else if (osType.equals("mac")){
            return new MacFactory();
        }
        return null;
    }
}
public class UI {
    public static void main(String[] args) {
        System.out.println("Enter machine os: ");
        Scanner inp = new Scanner(System.in);
        String osType = inp.nextLine();

        IFactory factory = GUIAbstractFactory.createFactory(osType);

        if(factory != null){
            IButton button = factory.createButton();
            button.press();

            ITextBox textBox = factory.createTextBox();
            textBox.settext();
        }else {
            System.out.println("Invalid os type");
        }
    }
}
