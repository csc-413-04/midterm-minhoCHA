package midterm2018;

import java.util.*;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

public class Main {

    public static String getHost(String s) {
        String[] words = s.split("\n");
        String getHost = "";

        for (String parsedWords : words) {
            if (parsedWords.contains("local")) {
                String[] answerArray = parsedWords.split(" ");
                getHost = answerArray[1];
                return getHost;
            }
        }
        return getHost;

    }

    public static int getFirstTwoNumbersOfString2(String s) {
        StringBuilder sb = new StringBuilder(2); // Capacity of 2 chars.

        for (char c : s.toCharArray()) {
            if (Character.isDigit(c)) {
                sb.append(c);

                if (sb.length() == 2) {
                    break;
                }
            }
        }

        String num = sb.toString();
        int sum = 0;
        Integer result = Integer.valueOf(num);
        while (result > 0) {
            sum = sum + result % 10;
            result = result / 10;
        }

        return sum;
    }

    public static JsonObject jsonConversion(String input) {

        String changedInput = input.replace(" " , "");
        changedInput = changedInput.replace("\n", "");
        changedInput = changedInput.replace("“", "");
        changedInput = changedInput.replace("”", "");

        Gson gson = new Gson();
        JsonObject staff = new Gson().fromJson(changedInput, JsonObject.class);

        String something = jsonobj.get("num").getAsString();
        Integer addOne = Integer.parseInt(something) + 1;

        staff.addProperty("num", addOne);
        staff.get("task");

        return staff;
    }


    public static int countUniqueWords(String str) {
        Set<String> result = new LinkedHashSet<>(Arrays.asList(str.split("\\s+")));
        StringBuilder sb = new StringBuilder();
        int wordCount = 0;
        for (String s : result) {
            sb.append(s);
            sb.append(" ");
            wordCount++;
        }
        return wordCount;
    }

    static String secondMostCommonWord(Vector<String> seq)
    {
        // Store all the words with its occurrence
        HashMap<String, Integer> occ = new HashMap<String,Integer>(seq.size()){
            @Override
            public Integer get(Object key) {
                return containsKey(key) ? super.get(key) : 0;
            }
        };

        for (int i = 0; i < seq.size(); i++)
            occ.put(seq.get(i), occ.get(seq.get(i))+1);

        // find the second largest occurrence
        int first_max = Integer.MIN_VALUE, sec_max = Integer.MIN_VALUE;

        Iterator<Map.Entry<String, Integer>> itr = occ.entrySet().iterator();
        while (itr.hasNext())
        {
            Map.Entry<String, Integer> entry = itr.next();
            int v = entry.getValue();
            if( v > first_max) {
                sec_max = first_max;
                first_max = v;
            }

            else if (v > sec_max &&
                    v != first_max)
                sec_max = v;
        }

        // Return string with occurrence equals
        // to sec_max
        itr = occ.entrySet().iterator();
        while (itr.hasNext())
        {
            Map.Entry<String, Integer> entry = itr.next();
            int v = entry.getValue();
            if (v == sec_max)
                return entry.getKey();
        }

        return null;
    }


    public static void main(String[] args) {
        String question1and2 = "GET /add?a=3&b=4 HTTP/1.1\n"
            + "Host: localhost:1298\n"
            + "Connection: keep-alive\n"
            + "User-Agent: Mozilla/5.0 (Macintosh; Intel Mac OS X 10_12_6) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/68.0.3440.106 Safari/537.36\n"
            + "Accept: image/webp,image/apng,image/*,*/*;q=0.8\n"
            + "Referer: http://localhost:1298/\n"
            + "Accept-Encoding: gzip, deflate, br\n"
            + "Accept-Language: en-US,en;q=0.9,es;q=0.8\n";

        String question3 = "{\n"
            + "    “task” : “inc”,\n"
            + "    “num” : 3\n"
            + "}\n";

        String question4and5 = "To opt out, you’ll need to enter the Settings menu by clicking the three vertical dots, all the way in the upper right corner of the browser. From there, you’ll need to enter the Advanced settings at the very bottom and find the “Allow Chrome sign in” toggle, then turn it to off. Doing so lets you sign into Google services like Gmail and Maps without signing into the Chrome browser itself.";


        String arr[] = question4and5.split(" "); //Converting string to arr
        List<String> seq =  Arrays.asList(arr);
        String secondMostCommonWord = secondMostCommonWord(new Vector<>(seq));

        System.out.printf("1. " + getHost(question1and2) + "\n");
        System.out.printf("\n2. The sum of a and b : " + getFirstTwoNumbersOfString2(question1and2) + "\n");
        System.out.printf("3. " + jsonConversion(question3) + "\n");
        System.out.println("\n4. The number of unique words is : " + countUniqueWords(question4and5));
        System.out.printf("\n5. The Second most common word is : %s\n", secondMostCommonWord);
    }
}







