import java.util.ArrayList;

/**
 * Created by neel on 02/12/15 at 9:44 AM.
 */
public class Trainer {

    static ArrayList<String> wordsList = new ArrayList<>();
    static ArrayList<Integer> wordCount = new ArrayList<>();

    public static void train(String text) {
        String w = "";
        text = text.trim() + " ";
        for (int i = 0; i < text.length(); i++) {
            char x = text.charAt(i);
            if (x != ' ') {
                if (x != '.' && x != ',' && x != '?' && x != '!') {
                    w += x;
                }
            } else {
                if (!w.equals("")) {
                    if (wordsList.contains(w)) {
                        int count = wordCount.get(wordsList.indexOf(w)) + 1;
                        wordCount.remove(wordsList.indexOf(w));
                        wordCount.add(count, wordsList.indexOf(w));
                    } else {
                        wordCount.add(1);
                        wordsList.add(w);
                    }
                    w = "";
                }
            }
        }
    }

    public static String generate(int length) {
        String solution = "";
        ArrayList<Double> evaluated = new ArrayList<>();
        long sum = 0;
        for (Integer aWordCount : wordCount) {
            sum += aWordCount;
        }
        long minorSum = 0;
        for (Integer aWordCount : wordCount) {
            minorSum += aWordCount;
            evaluated.add(minorSum / (sum * 1.0));
        }

        for (int i = 0; i < length; i++) {
            double random = Math.random();
            for (int j = 0; j < evaluated.size(); j++) {
                if (random < evaluated.get(j)) {
                    solution += (wordsList.get(j) + " ");
                    break;
                }
            }
        }

        return solution;
    }
}
