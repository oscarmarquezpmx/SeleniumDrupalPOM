package com.utilities;


import org.yaml.snakeyaml.Yaml;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.LinkedHashMap;
import java.util.Map;

public class Utilities{


    private LinkedHashMap lhm;

    public void readORFile() throws IOException {
        File yamlFile = new File("src/test/resources/objectrepository.yml").getAbsoluteFile();
        String is = Files.readString(yamlFile.toPath());
        //YAMLToObject yamlToObject = new YAMLToObject();
        //InputStream is = yamlFile.getName();
        Yaml yaml = new Yaml();

        lhm = (LinkedHashMap) yaml.load(is);
    }

    public LinkedHashMap getORInfo(String page, String webobject){
        LinkedHashMap o = (LinkedHashMap) lhm.get(page);
        LinkedHashMap webobjectinfo = (LinkedHashMap) o.get(webobject);
        return(webobjectinfo);
    }
}