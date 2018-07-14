//Задача:
//Часть первая (аналогично заданию 2)
//Часть вторая (работа с базой)
//Описание задания в task.txt

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;

public class Main {
    public static void main(String[] args) throws Exception {

        DBService dbService = new DBService();

        AccountService accountService = new AccountService(dbService);
        accountService.addNewUser(new UserProfile("admin"));
        accountService.addNewUser(new UserProfile("test"));

        Server server = new Server(8080);
        ServletContextHandler context = new ServletContextHandler(ServletContextHandler.SESSIONS);
        server.setHandler(context);

        context.addServlet(new ServletHolder(new SignUpServlet(accountService)), "/signup");
        context.addServlet(new ServletHolder(new SignInServlet(accountService)), "/signin");

        server.start();
        System.out.println("Server started");
        server.join();
    }

}

//как прибить сервер
//ps -e | grep java -- посмотри pid и kill pid.

//https://github.com/vitaly-chibrikov/stepic_java_webserver
