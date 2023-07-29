import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CreateAccount {
    String login;
    String password;
    String confirmPassword;

    public CreateAccount(String login, String password, String confirmPassword) {
        checkAccount(login, password, confirmPassword);
        this.login = login;
        this.password = password;
        this.confirmPassword = confirmPassword;
    }

    private static Pattern allowedSymbols = Pattern.compile("^[a-zA-Z0-9_]{0,20}$");

    public static void checkAccount(String login, String password, String confirmPassword) {
        checkLogin(login);
        checkPassword(password);
        confirmPassword(confirmPassword, password);
    }

    private static void checkLogin(String login) {
        Matcher checkLogin = allowedSymbols.matcher(login);
        if (!checkLogin.matches()) {
            throw new WrongLoginException("Login должен содержать только латинские буквы," +
                    " цифры и знак подчеркивания. login должен быть равен или меньше 20 символов.");
        }
    }

    private static void checkPassword(String password) {
        Matcher checkPassword = allowedSymbols.matcher(password);
        if (!checkPassword.matches()) {
            throw new WrongPasswordException("Password должен содержать только латинские буквы," +
                    " цифры и знак подчеркивания. Password должен быть равен или меньше 20 символов.");
        }
    }

    private static void confirmPassword(String confirmPassword, String password) {
        if (confirmPassword.equals(password)) {
            System.out.println("Вы успешно зарегестрированы!");
        } else {
            throw new WrongPasswordException("Пароли не совпадают!");
        }
    }
}