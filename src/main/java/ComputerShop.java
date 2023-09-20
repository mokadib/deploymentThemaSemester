import computers.Computer;

public abstract class ComputerShop {
    /**
     * For our purposes we will have only two types.  Each type requires a specific
     * configuration.  The configuration need to be understood by viewing
     * the tests.
     *
     * @param computerType BASIC_COMPUTER, GAMING_COMPUTER
     * @return
     */
    protected abstract Computer buildComputer(String computerType);

    protected Computer prepareComputer(String computerType) {
        Computer computer = buildComputer(computerType);
        System.out.println("--- Making an " + computer.getName() + " ---");
        String tt = computer.getName();
        computer.prepare();
        computer.bootUpTest();
        computer.burnInTest();
        computer.box();
        return computer;
    }


}
