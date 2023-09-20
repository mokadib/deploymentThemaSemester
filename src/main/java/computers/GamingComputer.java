package computers;

import components.*;
import factories.ComputerComponentFactory;

public class GamingComputer extends Computer{
    public GamingComputer(ComputerComponentFactory factory) {
        super(factory);
        this.computerCase = factory.selectCase();
        this.processor = factory.selectProcessor();
        this.memory = factory.selectMemory();
        this.storage = factory.selectStorage(StorageType.HardDrive);
        this.graphicsCard = factory.selectGraphicsCard();
        this.motherBoard = factory.selectMotherBoard();
        this.powerSupply = factory.selectPowerSupply();
        if (this.motherBoard instanceof IntelMotherBoard){
            this.setName("Intel Gaming PC");
        } else if (this.motherBoard instanceof AMDMotherBoard) {
            this.setName("AMD Gaming Computer");
        }
    }

    @Override
    public void prepare() {
        if (super.motherBoard instanceof AMDMotherBoard){
            System.out.println("--- Making an AMD Gaming PC ---");
        }else if (super.motherBoard instanceof IntelMotherBoard){
            System.out.println("--- Making an Intel Gaming PC ---");
        }
    }
}
