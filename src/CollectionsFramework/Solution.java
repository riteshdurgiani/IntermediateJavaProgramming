import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

class Result{

    /*
     * Complete the 'cookies' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER k
     *  2. INTEGER_ARRAY A
     */

    public static int cookies(int k, List<Integer> A) {
        // Write your code here
        List<Integer> A1 = new ArrayList<Integer>();
        A1 = A;
        int numberOfOperations = 0;
        long counter = A1.stream().filter(a->a<k).count();
        if(counter == 0){
            numberOfOperations = -1;
        }else{

            for(int i=0;i<A1.size();i++){
                long count = A1.stream().filter(a->a<k).count();
                if(count > 0){
                    numberOfOperations++;
                    Collections.sort(A1);
                    int newSweetness = (1 * A1.get(0)) + 2 * (A1.get(1));
                    A1.set(0,newSweetness);
                    A1.remove(1);


                }

            }
        }
        return numberOfOperations;

    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(firstMultipleInput[0]);

        int k = Integer.parseInt(firstMultipleInput[1]);

        List<Integer> A = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        int result = Result.cookies(k, A);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}

