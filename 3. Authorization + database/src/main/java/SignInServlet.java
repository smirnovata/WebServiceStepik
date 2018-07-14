import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class SignInServlet extends HttpServlet {

    private final AccountService accountService;

    public SignInServlet(AccountService accountService) {
        this.accountService = accountService;
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String login = req.getParameter("login");
        String password = req.getParameter("password");

        UserProfile profile = null;
        try {
            profile = accountService.getUserByLogin(login);
        } catch (DBException e) {
            e.printStackTrace();
        }

        if (profile == null || !profile.getPassword().equals(password)) {
            resp.getWriter().println("Unauthorized");
            resp.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            return;
        }

        accountService.addSession(req.getSession().getId(), profile);

        resp.getWriter().println("Authorized: " + login);
        resp.setStatus(HttpServletResponse.SC_OK);
    }

}
//Сервлеты должны слушать POST запросы с параметрами
//login
//password

//При получении POST запроса на signin, после регистрации, SignInServlet проверяет,
//логин/пароль пользователя. Если пользователь уже зарегистрирован, север отвечает
//
//Status code (200)
//и текст страницы:
//Authorized
//
//если нет:
//Status code (401)
//текст страницы:
//Unauthorized
