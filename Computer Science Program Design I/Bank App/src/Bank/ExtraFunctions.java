package Bank;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;

public class ExtraFunctions {
    private final DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/uuuu");
    private final LocalDate localDate = LocalDate.now();
    public ArrayList<Character> SPECIAL_CHARACTERS = new ArrayList<Character>(Arrays.<Character>asList('!', '@', '#', '$', '%', '^', '&', '*'));

    public String getDate() {
        return dtf.format(localDate);
    }


}
