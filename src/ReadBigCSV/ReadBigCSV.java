package ReadBigCSV;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

/*
    https://dzone.com/articles/how-to-read-a-big-csv-file-with-java-8-and-
    stream?edition=217193&utm_source=Daily%20Digest&utm_medium=email&utm_c
    ampaign=dd%202016-09-29
 */

public class ReadBigCSV {

    public static void main(String[] args) {
        List<String> strings = processInputFile("ReadBigCSV.txt");
        System.out.println(strings.toString());

    }

    private static List<String> processInputFile(String inputFilePath) {
        List<String> inputList = new ArrayList<>();
        try{
            File inputF = new File(inputFilePath);
            InputStream inputFS = new FileInputStream(inputF);
            BufferedReader br = new BufferedReader(new InputStreamReader(inputFS));
            // skip the header of the csv
            inputList = br.lines().skip(1).map(mapToItem).collect(Collectors.toList());
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return inputList ;
    }

    private static Function<String, String> mapToItem = (line) -> {
        String[] p = line.split(",");// a CSV has comma separated lines
        String item = new String();

        item = p[0];
        //item.setItemNumber(p[0]);//<-- this is the first column in the csv file

        //if (p[3] != null && p[3].trim().length() > 0) {
        //    item.setSomeProeprty(p[3]);
        //}
        //more initialization goes here
        return item;
    };
}
