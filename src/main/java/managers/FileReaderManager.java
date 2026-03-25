package managers;

import dataProvider.ConfigFileReader;

public class FileReaderManager {
    static ConfigFileReader configFileReader;

    public static ConfigFileReader getConfigFileReader() {
        return (configFileReader == null) ? new ConfigFileReader() : configFileReader;
    }
}
