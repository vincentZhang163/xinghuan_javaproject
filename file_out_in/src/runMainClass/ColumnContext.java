package runMainClass;

import rules.GetColumnRule;
import versionfour.ReadWriteContext;

import java.awt.*;

public class ColumnContext {

    public static void main(String[] args) {

        ReadWriteContext readWriteContext = new ReadWriteContext (
                "C:\\Users\\11024\\Desktop\\onedata_es_store.txt",
                "C:\\Users\\11024\\Desktop\\column2.txt",
                new GetColumnRule()
        );
        readWriteContext.readWrite();

    }
}
