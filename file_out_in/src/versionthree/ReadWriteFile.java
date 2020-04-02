package versionthree;

import java.io.*;

public class ReadWriteFile {
    private String line;
    private FileReader fileReader;
    private BufferedReader bufferedReader;
    private FileWriter fileWriter;
    private BufferedWriter bufferedWriter;


    public String read(String path) throws IOException {

        fileReader = new FileReader(new File(path));

        bufferedReader = new BufferedReader(fileReader);

        if((line=bufferedReader.readLine())!=null) {
            return line;
        }
       return null;
    }

    public void write(String path) throws IOException {
        fileWriter = new FileWriter(new File(path));

        bufferedWriter = new BufferedWriter(fileWriter);

        bufferedWriter.write(line);
        bufferedWriter.newLine();
        bufferedWriter.flush();
    }

    public void end () {
        try {
            bufferedWriter.close();
            bufferedReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
