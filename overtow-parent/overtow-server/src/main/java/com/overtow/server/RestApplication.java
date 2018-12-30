package com.overtow.server;

import com.overtow.server.core.bootstrap.RestBoostapper;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by cosborn on 12/29/18.
 */
@ApplicationPath("")
public class RestApplication extends Application
{

    @Override
    public Set<Class<?>> getClasses()
    {
        return Collections.emptySet();
    }

    @Override
    public Set<Object> getSingletons()
    {

        Set<Object> singletons = new HashSet<>();

        //singletons.add(new CorsFilter());
       // singletons.add(new RestExceptionMapper());

        RestBoostapper.addRoutes("com.overtow.route", singletons);

        return singletons;
    }
}