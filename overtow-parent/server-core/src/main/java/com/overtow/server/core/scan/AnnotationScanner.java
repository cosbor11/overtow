package com.overtow.server.core.scan;

import io.github.classgraph.ClassGraph;
import io.github.classgraph.ClassInfoList;
import io.github.classgraph.ScanResult;

/**
 * Created by cosborn on 12/29/18.
 */
public class AnnotationScanner
{

    private ScanResult scanResult;

    private String routeAnnotation = "javax.ws.rs.Path";

    public AnnotationScanner(String packageToScan)
    {
        scanResult = new ClassGraph()
                        .enableAllInfo()
                        .whitelistPackages(packageToScan)
                        .scan();

    }

    public ClassInfoList getRoutes()
    {
        return scanResult.getClassesWithAnnotation(routeAnnotation);
    }

}
