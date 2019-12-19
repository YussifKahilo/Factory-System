///**
//* this class is where the program runs because it contains the main the entry
//* of the program.
//* 
//* @author Youssif Mohammed Salah.
//* @ID 220180497
//*/
public class MainClass {

	public static void main(String[] args) {
		UserMenu.startUpMassege();
		Factory factory = new Factory();
		while (true) {
			Person user = factory.getFactorySystem().loginingIn();
			if (user instanceof Worker) {
				if (!factory.checkForWorker((Worker) user)) {
					factory.addWorker((Worker) user);
				}
			}
			if (user != null) {
				factory.startUserInterface(user);
			}
		}
	}
}
