package factories;

import components.*;

public class AMDGamingComputerFactory implements ComputerComponentFactory{
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
        return new AMDFastProcessor();
    }

    @Override
    public MotherBoard selectMotherBoard() {
        return new AMDMotherBoard();
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
