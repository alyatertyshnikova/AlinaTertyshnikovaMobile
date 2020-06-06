# AlinaTertyshnikovaMobile
Token is passed as a command line argument. Also not to pass token value every test run, it can be set as environment variable. 

To launch web Android tests: mvn clean test -PwebCloudAndroid -Dtoken=$TOKEN

To launch native Android tests: mvn clean test -PnativeCloudAndroid -Dtoken=$TOKEN

To launch web iOS tests: mvn clean test -PwebCloudIOS -Dtoken=$TOKEN

To launch web Android tests: mvn clean test -PnativeCloudIOS -Dtoken=$TOKEN 
