import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class SignUpServlet extends HttpServlet {
    private final AccountService accountService;

    public SignUpServlet(AccountService accountService) {
        this.accountService = accountService;
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String login = req.getParameter("login");
        String password = req.getParameter("password");
        accountService.addNewUser(new UserProfile(login,password));
    }
}
//Сервлеты должны слушать POST запросы с параметрами
//login
//password
//
//При получении POST запроса на signup сервлет SignUpServlet должн запомнить логин и пароль в AccountService.
//После этого польователь с таким логином считается зарегистрированным.
// Пароль проверять не обязательно, GETы писать не обязательно,
// страницы не нужны, email в UserProfile не нужен (можно добавить конструктор с дефолтным).
// Ответ на SignIn POST должен быть вида "Authorized: логин_пользователя", после двоеточия пробел.