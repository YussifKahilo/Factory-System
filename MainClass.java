
public class MainClass {

    public static void checkForClose(String line) {
        if (line.equalsIgnoreCase("q")) {
            System.exit(0);
        }
    }

    public static boolean ifNumber(String input) {
        for (int i = 0; i < input.length(); i++) {
            if (!((input.charAt(i) >= '0' && input.charAt(i) <= '9'))) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        UserMenu.startUpMassege();
        Factory factory = new Factory();
        FactorySystem factroySystem = factory.getFactorySystem();
        while (true) {
            Person user = factroySystem.loginingIn();
            factory.userUtility(user);
        }
    }
}
