import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class Frontend extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.getWriter().println(req.getParameter("key"));
        //При получении GET запроса с параметром key=value сервлет должен вернуть в response строку содержащую value.
        //Например, при GET запросе /mirror?key=hello сервер должен вернуть страницу, на которой есть слово "hello".
    }
}


//Написать сервлет, который будет обрабатывать запросы на /mirror
//При получении GET запроса с параметром key=value сервлет должен вернуть в response строку содержащую value.
//Например, при GET запросе /mirror?key=hello сервер должен вернуть страницу, на которой есть слово "hello".
//Инструкция подготовки к автоматической проверке:
//Добавьте в лог сообщение "Server started". По появлению в логе этого сообщения тестирующая система пойдет,
//что к вашему серверу можно обращаться.
//Соберите server.jar содержащий все библиотеки.

/*
Cкачайте тестируюущее приложение (HW01) по ссылке.

Задача:
Написать сервлет, который будет обрабатывать запросы на /mirror
При получении GET запроса с параметром key=value сервлет должен вернуть в response строку содержащую value.
Например, при GET запросе /mirror?key=hello сервер должен вернуть страницу, на которой есть слово "hello".

Инструкция подготовки к локальной проверке:
Соберите сервер со всеми зависимостями на библиотеки в server.jar
Для этого запустите Maven projects/<Project name>/Plugins/assembly/assembly:single
либо assembly.sh (assembly.bat)

Запустите start.(sh/bat)
java -jar server.jar

В логах консоли вы должны увидеть сообщения о старте сервера.
Проверьте, что сервер отвечает на запросы браузера.

Инструкция подготовки к автоматической проверке:
Добавьте в лог сообщение "Server started". По появлению в логе этого сообщения тестирующая система пойдет,
 что к вашему серверу можно обращаться.
Соберите server.jar содержащий все библиотеки.

Во время проверки тестовая система запускает ваш сервер, ждет пока "Server started", посылает GET запрос на
http://localhost:8080/mirror?key=value
и проверяет, что в ответ пришла страница содержащая только
value
*/