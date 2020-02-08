package web;

import log.Log;
import org.takes.facets.fork.FkRegex;
import org.takes.facets.fork.Fork;
import org.takes.facets.fork.TkFork;
import org.takes.http.Exit;
import org.takes.http.FtBasic;
import org.takes.tk.TkCors;
import web.actions.ConsultaSat;

import java.io.IOException;

public class WebServerThread extends Thread {

    @Override
    public void run() {

        String[] allowedDomains = {"http://localhost:8080"};

        Fork[] forks = {
                new FkRegex("/sat/(?<device>[a-zA-Z]+?)/consultar", new ConsultaSat())
        };

        TkFork tkFork = new TkFork(forks);
        TkCors tkCors = new TkCors(tkFork, allowedDomains);

        try {
            FtBasic ftBasic = new FtBasic(tkCors, 8999);
            Log.logger.info("Starting webserver");
            ftBasic.start(Exit.NEVER);
        } catch (IOException e) {
            Log.logger.error(e, e);
        }

    }

}
