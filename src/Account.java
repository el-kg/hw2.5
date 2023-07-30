import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Account {
    private String login;
    private String password;
    private String confirmPassword;

    public Account(String login, String password, String confirmPassword) {
        checkAccount(login, password, confirmPassword);
        this.login = login;
        this.password = password;
        this.confirmPassword = confirmPassword;
        System.out.println("Вы успешно зарегестрированы!");
    }

    private static Pattern allowedSymbols = Pattern.compile("^[a-zA-Z0-9_]{0,20}$");

    private void checkAccount(String login, String password, String confirmPassword) {
        checkLogin(login);
        checkPassword(password);
        confirmPassword(confirmPassword, password);
    }

    private void checkLogin(String login) {
        Matcher checkLogin = allowedSymbols.matcher(login);
        if (!checkLogin.matches()) {
            throw new WrongLoginException("Login должен содержать только латинские буквы," +
                    " цифры и знак подчеркивания. login должен быть равен или меньше 20 символов.");
        }
    }

    private void checkPassword(String password) {
        Matcher checkPassword = allowedSymbols.matcher(password);
        if (!checkPassword.matches()) {
            throw new WrongPasswordException("Password должен содержать только латинские буквы," +
                    " цифры и знак подчеркивания. Password должен быть равен или меньше 20 символов.");
        }
    }

    private void confirmPassword(String confirmPassword, String password) {
        if (!confirmPassword.equals(password)) {
            throw new WrongPasswordException("Пароли не совпадают!");
        }
    }
}