import java.io.*;

public class FileHandler {

    public static void appendLine(String fileName, String data) {
        // write text to end of the file
        boolean append = true;
        try (PrintWriter pr = new PrintWriter(new FileWriter(fileName, append))) {
            pr.println(data);
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String readLineAt(String fileName, int startPoint) {
        // grab the line from position "start" in the file
        try (RandomAccessFile rf = new RandomAccessFile(fileName, "rws")) {
            rf.seek(startPoint);
            return rf.readLine();
        }
        catch (IOException e) {
            System.out.println("read error");
            e.printStackTrace();
        }
        return null;
    }


    public static void writeLineAt(String fileName, String data, int start) {
        // overwrite a line from position "start" in the file
        try (RandomAccessFile rf = new RandomAccessFile(fileName, "rws")) {
            rf.seek(start);
            rf.writeBytes(data);
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

}
