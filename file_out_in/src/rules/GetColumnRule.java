package rules;

public class GetColumnRule implements Rules {

    private int count;
    @Override
    public String rule(String line) {
        String[] words = line.split("[\\s]+");
        line = words[5];
        switch (count) {
            case 0:
                line = "sum   "+getNumber(line);
                count++;
                return line;
            case 1:
                line = getNumber(line);
                return line;
        }
        return line;
    }

    public String getNumber(String line) {

        if (line.contains("gb")) {
            line = line.split("gb")[0];
        }else if(line.contains("mb")) {
            line = String.valueOf(Float.parseFloat(line.split("mb")[0])/1024);
        }else if(line.contains("kb")) {
            line = String.valueOf(Float.parseFloat(line.split("kb")[0])/1024/1024);
        }else if(line.contains("b")) {
            line = String.valueOf(Float.parseFloat(line.split("b")[0])/1024/1024/1024);
        }else {
            line = "0";
        }

        return line;
    }
}
