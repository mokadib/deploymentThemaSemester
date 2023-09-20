import computers.BasicComputer;
import computers.Computer;
import computers.ComputerTypes;
import computers.GamingComputer;
import factories.IntelBasicComputerComponentFactory;
import factories.IntelGamingComputerComponentFactory;

public class IntelComputerShop extends ComputerShop {


    @Override
    protected Computer buildComputer(String computerType) {

        Computer computer;
        if (computerType.equals(ComputerTypes.BASIC_COMPUTER)) {
            computer = new BasicComputer(new IntelBasicComputerComponentFactory());
            return computer;
        } else if (computerType.equals(ComputerTypes.GAMING_COMPUTER)) {
            computer = new GamingComputer(new IntelGamingComputerComponentFactory());
            return computer;
        }
        return null;

    }
}
