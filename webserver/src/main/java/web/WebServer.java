package web;

import log.Log;

public class WebServer {

    private Thread thread;

    public WebServer() {
        this.thread = this.createThread();
    }

    private Thread createThread()  {

        Thread thread = new WebServerThread();

        thread.setUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler() {

            @Override
            public void uncaughtException(Thread thread, Throwable throwable) {
                Log.logger.error(throwable, throwable);
            }

        });

        thread.setDaemon(true);

        return thread;

    }
    public void start()
    {
        thread.start();
    }

    public void join() throws InterruptedException {
        thread.join();
    }

}
