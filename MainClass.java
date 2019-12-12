
public class MainClass {

    public static void main(String[] args) {
        UserMenu.startUpMassege();
        Factory factory = new Factory();
        while (true) {
            Person user = factory.getFactorySystem().loginingIn();
            if (user instanceof Worker) {
                if (!factory.getFactorySystem().checkForUser((Worker) user)) {
                    factory.addWorker((Worker) user);
                }
            } else if (user instanceof SuperVisor) {
                if (!factory.getFactorySystem().checkForUser((SuperVisor) user)) {
                    factory.addSuperVisor((SuperVisor) user);
                }
            } else if (user instanceof SalesMan) {
                if (!factory.getFactorySystem().checkForUser((SalesMan) user)) {
                    factory.addSalesMan((SalesMan) user);
                }
            }
            if (user != null) {
                factory.userUtility(user);
            }
        }
    }
}
