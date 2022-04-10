import java.io.*;
import java.util.*;

public class IPReader {
    private BitSet ipSet;
    private File file;
    private String filePath;

    public IPReader() {
        ipSet = new BitSet();
    }

    public IPReader(BitSet ipSet, File file, String filePath) {
        this.ipSet = ipSet;
        this.file = file;
        this.filePath = filePath;
    }

    public boolean checkFileExistOrIsNotDirectory() {
        if (!getFile().exists()) {
            write("The file with the entered path doesn't exist.");
            return false;
        } else if (getFile().isDirectory()) {
            write("The entered path is a directory.");
            return false;
        }
        return true;
    }

    public void readFromFile() throws IOException {
        try(FileInputStream inputStream = new FileInputStream(getFilePath());
            Scanner sc = new Scanner(inputStream)) {
            while (sc.hasNextLine()) {
                int ip = ipToInt(sc.nextLine());
                if (ipSet.get(ip)) {
                    ipSet.clear(ip);
                } else {
                    ipSet.set(ip);
                }
            }
            write("The number of unique IP addresses is equal to " + ipSet.cardinality());
            if (sc.ioException() != null) {
                throw sc.ioException();
            }
        }
    }

    public void generateFile() {
        write("Please, enter the full path to the file with IP addresses:");
        Scanner console = new Scanner(System.in);
        String enteredPath = console.nextLine();
        setFile(new File(enteredPath));
        setFilePath(enteredPath);
    }

    public int ipToInt(String ipAddress) {
        //168.1.2
        //168 x (256)^2 + 1 x (256)^1 + 2 (256)^0 = ?
        //11010048 + 256 + 2 = 11010306
        String[] ipAddressInArray = ipAddress.split("\\.");
        int result = 0;
        for (int i = 0; i < ipAddressInArray.length; i++) {
            int power = 2 - i;
            int ip = Integer.parseInt(ipAddressInArray[i]);
            result += ip * Math.pow(256, power);
        }
        return result;
    }

    public String intToIp(long i) {
        return ((i >> 16) & 0xFF) +
                "." + ((i >> 8) & 0xFF) +
                "." + (i & 0xFF);
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public String getFilePath() {
        return filePath;
    }

    static void write(String text) {
        System.out.println(text);
    }

    public File getFile() {
        return file;
    }

    public void setFile(File file) {
        this.file = file;
    }
}
