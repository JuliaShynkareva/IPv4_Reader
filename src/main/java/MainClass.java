import java.io.*;

public class MainClass {

    public static void main(String[] args) throws IOException {
        IPReader ipReader = new IPReader();
        ipReader.generateFile();
        if (ipReader.checkFileExistOrIsNotDirectory())
            ipReader.readFromFile();
    }
}
