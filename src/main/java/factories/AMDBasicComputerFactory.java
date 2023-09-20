package factories;

import components.*;

public class AMDBasicComputerFactory implements ComputerComponentFactory{
    @Override
    public ComputerCase selectCase() {
        return new BasicComputerCase();
    }

    @Override
    public PowerSupply selectPowerSupply() {
        return new BasicPowerSupply();
    }

    @Override
    public Processor selectProcessor() {
        return new BasicAMDPeocessor();
    }

    @Override
    public MotherBoard selectMotherBoard() {
        return new AMDMotherBoard();
    }

    @Override
    public Memory[] selectMemory() {
        Memory[] memory = {new FourGBRam(), new EightGBRam()};
        return memory;
    }

    @Override
    public GraphicsCard selectGraphicsCard() {
        return new AMDGraphicsCard();
    }

    @Override
    public Storage[] selectStorage(StorageType... type) {
        return new Storage[]{new SSD()};
    }
}
