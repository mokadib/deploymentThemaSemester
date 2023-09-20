package computers;

import components.*;
import factories.ComputerComponentFactory;

public class BasicComputer extends Computer {
    public BasicComputer(ComputerComponentFactory factory) {
        super(factory);
        this.computerCase = factory.selectCase();
        this.processor = factory.selectProcessor();
        this.memory = factory.selectMemory();
        this.storage = factory.selectStorage(StorageType.HardDrive);
        this.graphicsCard = factory.selectGraphicsCard();
        this.motherBoard = factory.selectMotherBoard();
        this.powerSupply = factory.selectPowerSupply();
        if (this.motherBoard instanceof IntelMotherBoard) {
            this.setName("Intel Basic PC");
        } else if (this.motherBoard instanceof AMDMotherBoard) {
            this.setName("AMD Basic PC");
        }

    }

    @Override
    public void prepare() {

        if (this.motherBoard instanceof IntelMotherBoard) {
            System.out.println("Building Intel Basic PC");
        } else if (motherBoard instanceof AMDMotherBoard) {
            System.out.println("Building AMD Basic PC");
        }

    }
}
