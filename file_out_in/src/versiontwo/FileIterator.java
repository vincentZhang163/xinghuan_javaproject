package versiontwo;

import java.io.FileNotFoundException;
import java.io.IOException;

public interface FileIterator {

    public boolean hasNext() throws IOException;
    public Object next() throws IOException;

}
