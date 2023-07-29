

public class Main {
    public static void main(String[] args) {
        try {
            CreateAccount createAccount = new CreateAccount("login", "password", "password");
        } catch (WrongLoginException ex) {
            System.out.println(ex.getMessage());
        } catch (WrongPasswordException ex) {
            System.out.println(ex.getMessage());
        } finally {
            System.out.println("");
        }
    }
}