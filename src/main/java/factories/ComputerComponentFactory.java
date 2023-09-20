package factories;

import components.*;

public interface ComputerComponentFactory {
        ComputerCase selectCase();
        PowerSupply selectPowerSupply();
        Processor selectProcessor();
        MotherBoard selectMotherBoard();

        /**
         * A computer always has memory in multiples of 2.  Examples might be 2 x 4 GB Ram for a basic PC
         * or 4 x 8 GB Ram for a high powered machine.
         * @return the memory as an array of size 2.
         */
        Memory[] selectMemory();
        /**
         *  Select a GraphicsCard for this computer.  Some basic computers
         *  do not have a separate graphics card, they use the onboard graphics card of the motherboard.
         */
        GraphicsCard selectGraphicsCard();
        /**
         * This allows the configuration of a computer with variable storage options.
         * @param type
         * @return the storage types configured for this computer.  An example might be one SSD and one HardDrive
         */
        Storage[] selectStorage(StorageType...type);


}
