resources {
   // logback.configurationFile = 'src/test/resources/config/logback.xml'
}

environments {
    local {
         serverName = 'http://drupal.docker.localhost'
         serverPort = '8000'
    }
    dev {
        serverName = 'http://drupal.docker.localhost'
        serverPort = '8000'
    }

    test {
         serverName = 'http://www.testserver.com'
         serverPort = '5211'
    }

    prod {
         serverName = 'http://www.productionserver.com'
         serverPort = '80'
    }
}