package Desktop;

class Desktop{
    String motherboard;
    String processor;
    String memory;
    String storage;
    String graphicsCard;

    void Display(){
        System.out.println("Desktop specs : ");
        System.out.println("Motherboard: " +motherboard);
        System.out.println("Processor: " +processor);
        System.out.println("Memory: " +memory);
        System.out.println("Storage: " +storage);
        System.out.println("Graphics Card: " +graphicsCard);
    }
}

abstract class DesktopBuilder{
    protected Desktop desktop;
    abstract DesktopBuilder buildMotherboard();
    abstract DesktopBuilder buildProcessor();
    abstract DesktopBuilder buildMemory();
    abstract DesktopBuilder buildStorage();
    abstract DesktopBuilder buildGraphicsCard();

    Desktop build(){
        return desktop;
    }
}

class DellDesktopBuilder extends DesktopBuilder{
    DellDesktopBuilder(){
        desktop = new Desktop();
    }
    DesktopBuilder buildMotherboard(){
        desktop.motherboard = "Dell Motherboard";
        return this;
    }
    DesktopBuilder buildProcessor(){
        desktop.processor = "Dell Processor";
        return this;
    }
    DesktopBuilder buildMemory(){
        desktop.memory = "32 GB DDR RAM";
        return this;
    }
    DesktopBuilder buildStorage(){
        desktop.storage = "1 TB SSD";
        return this;
    }
    DesktopBuilder buildGraphicsCard(){
        desktop.graphicsCard = "NVIDIA RTX 3080";
        return this;
    }
}

class HpDesktopBuilder extends DesktopBuilder{
    HpDesktopBuilder(){
        desktop = new Desktop();
    }
    DesktopBuilder buildMotherboard(){
        desktop.motherboard = "HP Motherboard";
        return this;
    }
    DesktopBuilder buildProcessor(){
        desktop.processor = "RYZEN 3 7000 Series";
        return this;
    }
    DesktopBuilder buildMemory(){
        desktop.memory = "16 GB DDR RAM";
        return this;
    }
    DesktopBuilder buildStorage(){
        desktop.storage = "2TB SSD";
        return this;
    }
    DesktopBuilder buildGraphicsCard(){
        desktop.graphicsCard = "NVIDIA RTX 2040";
        return this;
    }
}

class DesktopDirector{
    Desktop buildDesktop(DesktopBuilder builder){
        return builder.buildMotherboard().buildProcessor().buildMemory().buildStorage().buildGraphicsCard().build();
    }
}
public class DesktopBuilderDemo {
    public static void main(String[] args) {
        DesktopDirector director = new DesktopDirector();

        DellDesktopBuilder DellBuilder = new DellDesktopBuilder();
        Desktop DellDesktop = director.buildDesktop(DellBuilder);

        HpDesktopBuilder HpBuilder = new HpDesktopBuilder();
        Desktop HpDesktop = director.buildDesktop(HpBuilder);

        DellDesktop.Display();
        HpDesktop.Display();
    }
}
