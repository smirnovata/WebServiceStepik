//Задание на запуск сервера
//Описание задания в task.txt

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;

public class Main {
    public static void main(String[] args) throws Exception {

        Frontend firstFrontend = new Frontend();
        Server server = new Server(8080);

        ServletContextHandler context = new ServletContextHandler(ServletContextHandler.SESSIONS);
        server.setHandler(context);
        context.addServlet(new ServletHolder(firstFrontend), "/mirror");

        server.start();
        //java.util.logging.Logger.getGlobal().info("Server started");
        System.out.println("Server started");
        server.join();


    }


}

//как прибить сервер
//ps -e | grep java -- посмотри pid и kill pid.

//https://github.com/vitaly-chibrikov/stepic_java_webserver
