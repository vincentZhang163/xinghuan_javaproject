package version;

import java.io.*;
import java.util.concurrent.*;
import java.util.function.Supplier;

public class File_in_out {

    public static void main(String[] args) throws IOException {

        in_out("C:\\Users\\11024\\Desktop\\result.txt", "C:\\Users\\11024\\Desktop\\c.txt");


    }

    public static void in_out(String in_path, String out_path) throws IOException {

        FileReader fileReader = new FileReader(new File(in_path));
        FileWriter fileWriter = new FileWriter(new File(out_path));

        BufferedReader bufferedReader = new BufferedReader(fileReader);
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

        String line = "";


        while ((line = bufferedReader.readLine()) != null) {

            String[] columns = line.split("[\\s]+");
            bufferedWriter.write(columns[1]);
            bufferedWriter.newLine();
            bufferedWriter.flush();
        }

        bufferedWriter.close();
        bufferedReader.close();
    }

}
