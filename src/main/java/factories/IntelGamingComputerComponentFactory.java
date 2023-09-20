package factories;

import components.*;


public class IntelGamingComputerComponentFactory implements ComputerComponentFactory {



    @Override
    public ComputerCase selectCase() {
        return new GamingComputerCase();
    }

    @Override
    public PowerSupply selectPowerSupply() {
        return new GamingPowerSupply();
    }

    @Override
    public Processor selectProcessor() {
        return new IntelFastProcessor();
    }

    @Override
    public MotherBoard selectMotherBoard() {
        return new IntelMotherBoard();
    }

    @Override
    public Memory[] selectMemory() {
        Memory[] memory = {new EightGBRam(), new SixteenGBRam(), new ThirtyTwoGbRam(), new SixtyFourGBRam()};
        return memory;
    }

    @Override
    public GraphicsCard selectGraphicsCard() {
        return new NVidiaGraphicsCard();
    }

    @Override
    public Storage[] selectStorage(StorageType... type) {
        return new Storage[]{new SSD(), new HardDrive()};
    }
}
