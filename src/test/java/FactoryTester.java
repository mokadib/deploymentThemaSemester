import components.*;
import computers.Computer;
import computers.ComputerTypes;
import factories.ComputerComponentFactory;
import factories.IntelBasicComputerComponentFactory;
import factories.IntelGamingComputerComponentFactory;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class FactoryTester {
    ComputerShop intelShop;
    ComputerShop amdShop;
    private final PrintStream standardOut = System.out;
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
    private final String ls = System.lineSeparator();

    @BeforeEach
    void setUp(){
        System.setOut(new PrintStream(outputStreamCaptor));
        intelShop = new IntelComputerShop();
        amdShop = new AMDComputerShop();
    }
    @AfterEach
    public void tearDown() {
        System.setOut(standardOut);
    }

    @Test
    void shopsCanBeCreated(){
        assert (intelShop instanceof IntelComputerShop);
        assert (amdShop instanceof AMDComputerShop);
    }
    @Test
    void basicIntelfactorieExistsAndWorksCorrectly(){
        IntelBasicComputerComponentFactory intelBasicComputerComponentFactory = new IntelBasicComputerComponentFactory();
        assert (intelBasicComputerComponentFactory instanceof ComputerComponentFactory);
        assert (intelBasicComputerComponentFactory.selectCase() instanceof BasicComputerCase);
        assert (intelBasicComputerComponentFactory.selectPowerSupply() instanceof  BasicPowerSupply);
        assert (intelBasicComputerComponentFactory.selectMotherBoard() instanceof IntelMotherBoard);
        Memory[] ram = intelBasicComputerComponentFactory.selectMemory();
        assert (ram instanceof Memory[]);
        assert (ram.length == 2);
        assert (ram[0] instanceof FourGBRam);
        assertNull (intelBasicComputerComponentFactory.selectGraphicsCard());
        assert (intelBasicComputerComponentFactory.selectProcessor() instanceof BasicIntelProcessor);
        assert (intelBasicComputerComponentFactory.selectStorage(StorageType.HardDrive)[0] instanceof HardDrive);
    }
    @Test
    void gamingIntelfactorieExistsAndWorksCorrectly(){
        IntelGamingComputerComponentFactory intelGamingComputerComponentFactory = new IntelGamingComputerComponentFactory();
        assert (intelGamingComputerComponentFactory instanceof ComputerComponentFactory);
        assert (intelGamingComputerComponentFactory.selectCase() instanceof GamingComputerCase);
        assert (intelGamingComputerComponentFactory.selectPowerSupply() instanceof  GamingPowerSupply);
        assert (intelGamingComputerComponentFactory.selectMotherBoard() instanceof IntelMotherBoard);
        Memory[] ram = intelGamingComputerComponentFactory.selectMemory();
        assert (ram instanceof Memory[]);
        assert (ram.length == 4);
        assert (ram[0] instanceof EightGBRam);
        assert  (intelGamingComputerComponentFactory.selectGraphicsCard() instanceof NVidiaGraphicsCard);
        assert (intelGamingComputerComponentFactory.selectProcessor() instanceof IntelFastProcessor);
         Storage[] storage = intelGamingComputerComponentFactory.selectStorage(StorageType.SolidStateDrive, StorageType.HardDrive);
         assert (storage[0] instanceof SSD);
         assert (storage[1] instanceof HardDrive);
    }
   @Test
   void shopsAreComputerShop(){
       assert (intelShop instanceof ComputerShop);
       assert (amdShop instanceof ComputerShop);
   }

   @Test
   void basicIntelComputerCanBeBuilt(){
       Computer intelPC = intelShop.prepareComputer(ComputerTypes.BASIC_COMPUTER);
       assert (intelPC instanceof Computer);
       assert (intelPC.getComputerCase() instanceof BasicComputerCase);
       assert intelPC.getProcessor() instanceof BasicIntelProcessor;
       assert intelPC.getPowerSupply() instanceof BasicPowerSupply;
       assert (intelPC.getStorage()[0] instanceof HardDrive);
       assert (intelPC.getMemory()[0] instanceof FourGBRam);
       assertNull(intelPC.getGraphicsCard());

   }
    @Test
    void basicAMDComputerCanBeBuilt(){
        Computer amdPC = amdShop.prepareComputer(ComputerTypes.BASIC_COMPUTER);
        assert (amdPC instanceof Computer);

    }

    @Test
    void basicIntelComputerCanBeBuilt1(){
        Computer amdPC = intelShop.prepareComputer(ComputerTypes.BASIC_COMPUTER);
        assert (amdPC instanceof Computer);

    }
    @Test
    void gamingIntelComputerCanBeBuilt(){
        Computer intelGamingPC = intelShop.prepareComputer(ComputerTypes.GAMING_COMPUTER);
        assert (intelGamingPC instanceof Computer);
        assert (intelGamingPC.getComputerCase() instanceof GamingComputerCase);
        assert (intelGamingPC.getPowerSupply() instanceof  GamingPowerSupply);
        assert (intelGamingPC.getGraphicsCard() instanceof GraphicsCard);
        assert (intelGamingPC.getStorage()[0] instanceof SSD);
        assert (intelGamingPC.getStorage()[1] instanceof HardDrive);
        assertEquals(4, intelGamingPC.getMemory().length);

    }

    @Test
    void computerIsPreparedCorrectly(){
        Computer intelPC = intelShop.prepareComputer(ComputerTypes.BASIC_COMPUTER);
        assertEquals("--- Making an Intel Basic PC ---" +ls+
                "Building Intel Basic PC" +ls+
                "Boot up test" + ls+
                "Running the computer for 60 minutes" + ls+
                "Place computer in computer shop box", outputStreamCaptor.toString().trim());

    }

}
