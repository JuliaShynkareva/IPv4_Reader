import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.util.BitSet;

import static org.junit.jupiter.api.Assertions.*;

class IPReaderTest {

    String filePath;
    File file;
    String newFilePath;
    File newFile;
    IPReader ipReader;

    @BeforeEach
    void prepareData() {
        filePath = "D:\\addresses.txt";
        file = new File(filePath);
        newFilePath = "D:\\addresses1.txt";
        newFile = new File(newFilePath);
        ipReader = new IPReader(new BitSet(), file, filePath);
    }

    @Test
    void checkFileExistOrIsNotDirectory() {
    }

    @Test
    void readFromFile() {
    }

    @Test
    void generateFile() {
    }

    @Test
    void ipToInt() {
    }

    @Test
    void intToIp() {
    }

    @Test
    void setFilePath() {
        ipReader.setFilePath(newFilePath);
        assertEquals(newFilePath, ipReader.getFilePath());
    }

    @Test
    void getFilePath() {
        assertEquals(filePath, ipReader.getFilePath());
    }

    @Test
    void write() {
    }

    @Test
    void getFile() {
        assertEquals(file, ipReader.getFile());
    }

    @Test
    void setFile() {
        ipReader.setFile(newFile);
        assertEquals(newFile, ipReader.getFile());
    }
}