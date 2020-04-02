package versiontwo;

import java.io.*;

public class ReadFile implements FileIterator {

    private String path;
    private String line;
    private FileReader fileReader;
    private BufferedReader bufferedReader;

    public ReadFile (String path) {

        this.path = path;

    }
    @Override
    public boolean hasNext() throws IOException {
        fileReader = new FileReader(new File(path));

        bufferedReader = new BufferedReader(fileReader);

        if ((this.line = bufferedReader.readLine()) != null) {
            return true;
        }
        return false;
    }

    @Override
    public Object next() throws IOException {

            return line;
    }
}
