import log.Log;
import web.WebServer;

import java.io.IOException;

public class Main {

    public static void main(String args[]) throws IOException {

        try {

            WebServer server = new WebServer();
            server.start();

            // Espera a finalização da thread do web.WebServer (mantém a aplicação rodando)
            server.join();

        } catch (Exception e) {
            Log.logger.error(e, e);
        }

    }

}
