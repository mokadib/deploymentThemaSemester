package factories;

import components.*;


public class IntelBasicComputerComponentFactory implements ComputerComponentFactory {

    @Override
    public BasicComputerCase selectCase() {
        return new BasicComputerCase();
    }

    @Override
    public BasicPowerSupply selectPowerSupply() {
        return new BasicPowerSupply();
    }

    @Override
    public BasicIntelProcessor selectProcessor() {
        return new BasicIntelProcessor();

    }

    @Override
    public IntelMotherBoard selectMotherBoard() {
        return new IntelMotherBoard();
    }

    @Override
    public Memory[] selectMemory() {
        Memory[] memory = {new FourGBRam(), new EightGBRam()};
        return memory;
    }

    @Override
    public GraphicsCard selectGraphicsCard() {
        return null;
    }

    @Override
    public Storage[] selectStorage(components.StorageType... type) {
        return new Storage[]{new HardDrive()};
    }
}
