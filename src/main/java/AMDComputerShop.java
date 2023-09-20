import computers.BasicComputer;
import computers.Computer;
import computers.ComputerTypes;
import computers.GamingComputer;
import factories.AMDBasicComputerFactory;
import factories.AMDGamingComputerFactory;

public class AMDComputerShop extends ComputerShop {
    @Override
    protected Computer buildComputer(String computerType) {
        Computer computer;
        if (computerType.equals(ComputerTypes.BASIC_COMPUTER)) {
            computer = new BasicComputer(new AMDBasicComputerFactory());
            return computer;
        } else if (computerType.equals(ComputerTypes.GAMING_COMPUTER)) {
            computer = new GamingComputer(new AMDGamingComputerFactory());
            return computer;
        }

        return null;
    }
}
