package com.java.Parametrization;

import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import org.testng.IAlterSuiteListener;
import org.testng.xml.XmlSuite;

public class PropertyInjectorListener implements IAlterSuiteListener{

	public void alter(List<XmlSuite> suites) {
        XmlSuite suite = suites.get(0);
        Properties properties = new Properties();
        try {
            properties.load(new FileReader("application.properties"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        Map<String, String> params = new HashMap<>();
        for (Map.Entry<Object, Object> each : properties.entrySet()) {
            params.put(each.getKey().toString(), each.getValue().toString());

        }
        suite.setParameters(params);
    }
}
