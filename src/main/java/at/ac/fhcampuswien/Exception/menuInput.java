package at.ac.fhcampuswien.Exception;

import java.util.*;


public class menuInput {
   String input;


    public menuInput(String input) throws NewsAPIException {
        if (Arrays.asList("a", "b", "c", "d", "e", "f", "g", "q", "y").contains(input))
        {
            this.input = input;
        }
        else {
            throw new NewsAPIException("Wtf, choose a Character between a-f OR q OR y, that's not hard!");
        }
    }

}
