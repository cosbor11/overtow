package com.overtow.server;

import io.undertow.Handlers;
import io.undertow.Undertow;
import org.jboss.resteasy.plugins.server.undertow.UndertowJaxrsServer;

import java.util.logging.Level;
import java.util.logging.Logger;

public class RestServer
{
    private static UndertowJaxrsServer server;

    public RestServer()
    {
    }

    public void start()
    {
        try
        {
            server = new UndertowJaxrsServer().start(buildServer());

        } catch (Exception e)
        {
            e.printStackTrace();
        }

        server.deploy(RestApplication.class, "/");

        Logger.getLogger(RestServer.class.getName()).log(Level.INFO, String.format("=============== Server started"));
    }

    public void stop()
    {
        if (server != null)
        {
            server.stop();
        }
    }

    protected  Undertow.Builder buildServer() throws Exception
    {
        return Undertow.builder()
                .addHttpListener(4443, "127.0.0.1")
                .addHttpListener(8888, "127.0.0.1")
                .setHandler(Handlers.gracefulShutdown(Handlers.path()));
    }

}