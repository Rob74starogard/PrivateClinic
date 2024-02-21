public class UserInterface {
    public void mainMenu(){
        System.out.println("(D)octor or (P)atient ?");
    }
    public void chosePatient(){
        System.out.println("Mark who You are");
    }
    public void actionsMenudoctor(){
        System.out.println("1. Add visit date.");
        System.out.println("2. Delete visit.");
        System.out.println("3. Cancel visit.");
        System.out.println("4. Review all visits");
    }
    public void actionsMenupatient(){
        System.out.println("1. Review possible dates of visit");
        System.out.println("2. Reserve a visit");
        System.out.println("3. Search for possible visit dates");
    }
}
