package csci3236.assignment5;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.regex.Pattern;
/**
 *
 * @author Tyrone Darby
 */
public class Assignment5 {

    public static void printRegEx(String regex, int n) {
        Pattern pattern = Pattern.compile(regex);
        Queue<String> queue = new ArrayDeque<>();

        queue.add("");

        while (!queue.isEmpty()){
            String current = queue.poll();

            if (pattern.matcher(current).matches()){
                if (current.isEmpty()){
                    System.out.println("\u03B5");
                } else {
                    System.out.println(current);
                }
            }

            if (current.length() < n){
                queue.add(current + "0");
                queue.add(current + "1");
            }
        }
    }

    public static void main(String[] args) {
        printRegEx("01*|(10)*", 5);
    }
}