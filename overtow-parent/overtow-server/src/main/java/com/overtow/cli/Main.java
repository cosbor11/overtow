package com.overtow.cli;

import com.overtow.server.RestServer;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by cosborn on 12/29/18.
 */
public class Main
{
    private static RestServer server;

    public static void main(String[] args) throws Exception
    {
        server = new RestServer();

        server.start();

        Runtime.getRuntime().addShutdownHook(new Thread(() ->
        {
            Logger.getLogger(Main.class.getName()).log(Level.INFO, String.format("=============== Shutting down..."));

            server.stop();
            server = null;

            Logger.getLogger(Main.class.getName()).log(Level.INFO, String.format("=============== Server shutdown complete..."));
        }));
    }
}
