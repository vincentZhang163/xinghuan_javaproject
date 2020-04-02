package versionfour;

import rules.Rules;

import java.io.*;

public class ReadWriteContext {

    private String line;
    private String inpath;
    private String outpath;
    private BufferedReader bufferedReader;
    private BufferedWriter bufferedWriter;
    private Rules rule;

    public ReadWriteContext (String inpath, String outpath, Rules rule) {
        this.inpath = inpath;
        this.outpath = outpath;
        this.rule = rule;
    }

    public void readWrite (String...outpaths) {
        try {
            bufferedReader = new BufferedReader(new FileReader(new File(inpath)));

            bufferedWriter = new BufferedWriter(new FileWriter(new File(outpath)));
            line=bufferedReader.readLine();
            line=rule.rule(line);
            switch (line.split("[\\s]+")[0].toLowerCase()){
                case "sum":
                    float sum = Float.parseFloat(line.split("[\\s]+")[1]);
                    while ((line=bufferedReader.readLine())!=null){
                        sum +=Float.parseFloat(rule.rule(line));
                    }
                    bufferedWriter.write(String.valueOf(sum));
                    bufferedWriter.newLine();
                    bufferedWriter.flush();
                    break;
                default:
                    while ((line=bufferedReader.readLine())!=null) {
                        bufferedWriter.write(rule.rule(line));
                        bufferedWriter.newLine();
                        bufferedWriter.flush();
                    }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                bufferedWriter.close();
                bufferedReader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
