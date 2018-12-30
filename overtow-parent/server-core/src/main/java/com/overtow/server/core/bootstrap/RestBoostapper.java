package com.overtow.server.core.bootstrap;

import com.overtow.server.core.scan.AnnotationScanner;
import io.github.classgraph.ClassInfo;

import java.util.Set;

/**
 * Created by cosborn on 12/29/18.
 */
public class RestBoostapper
{
    public static void addRoutes(String packageToScan, Set<Object> singletons)
    {
        AnnotationScanner annotationScanner = new AnnotationScanner(packageToScan);

        for (ClassInfo classInfo : annotationScanner.getRoutes())
        {
            //@TODO use logger
            System.out.println(classInfo.getName() + " is annotated with @Path ");

            try
            {
                Class<?> obj = Class.forName(classInfo.getName());
                singletons.add(obj.newInstance());
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }
        }
    }
}
