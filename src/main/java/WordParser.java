import java.util.ArrayList;

/**
 * Created by petersoa on 7/4/15.
 */
public class WordParser {



    private String word;

    public void parse(String record) {

        word = record.toLowerCase();
        for (String invalidChar: getExcludedCharacters()) {
            word =  word.replaceAll(invalidChar," ");
        }


    }

    /**
     * list of characters to exclude from map
     * @return list of invalidChars to not include in map
     */
    private ArrayList<String> getExcludedCharacters() {

        ArrayList<String> invalidChars = new ArrayList<String>();

        String nonWords = "\\W"; // get rid of punctuation
        String digits = "\\d"; // get rid of digits
        String underScore = "\\_"; // get rid of "-"

        invalidChars.add(nonWords);
        invalidChars.add(digits);
        invalidChars.add(underScore);

        return invalidChars;
    }

    public String getWord() {
        return word;
    }


}
