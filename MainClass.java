
public class MainClass {

    public static void main(String[] args) {
        UserMenu.startUpMassege();
        Factory factory = new Factory();
        while (true) {
            Person user = factory.getFactorySystem().loginingIn();
            if (user instanceof Worker) {
                if (!factory.getWorkers().contains((Worker) user)) {
                    factory.addWorker((Worker) user);
                }
            } else if (user instanceof SuperVisor) {
                if (!factory.getSuperVisors().contains((SuperVisor) user)) {
                    factory.addSuperVisor((SuperVisor) user);
                }
            } else if (user instanceof SalesMan) {
                if (!factory.getSalesMen().contains((SalesMan) user)) {
                    factory.addSalesMan((SalesMan) user);
                }
            }
            if (user != null) {
                factory.userUtility(user);
            } 
        }
    }
}
