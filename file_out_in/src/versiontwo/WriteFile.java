package versiontwo;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class WriteFile {

    private String path;
    private FileWriter fileWriter;
    private BufferedWriter bufferedWriter;
    private String sum;

    public WriteFile (String path) {
        this.path = path;
    }

    public void setLine(String line) throws IOException {
        fileWriter = new FileWriter(new File(path));

        bufferedWriter = new BufferedWriter(fileWriter);

        bufferedWriter.write(line);
        bufferedWriter.newLine();
        bufferedWriter.flush();
    }

    public void end () {
        try {
            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
