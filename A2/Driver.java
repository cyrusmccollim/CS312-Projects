/**
 * This program will allow members of a band to be looked up.
 * CS312 - Assignment 2
 * @author Cyrus M.
 * @version 1.0 09/24/24
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Driver {
    /**
     * Entrance into the program. Verifies validity of arguments and passes them to the CLI.
     *
     * @param  args  command-line command options
     */
    public static void main(String[] args){
        List<String> acceptedArguments = new ArrayList<>(Arrays.asList("-p", "-n", "-i"));

        boolean invalidArguments = args.length < 1 || !acceptedArguments.contains(args[0]);
        boolean insufficientArguments = args.length < 1 || (!args[0].equals("-p") && args.length < 2);
        if (invalidArguments || insufficientArguments) {
            System.out.println("\nUsage: java Driver [-p|-n|-i] <options>" +
                               "\n-p \t\t(print band)" +
                               "\n-n name \t(lookup member by name)" +
                               "\n-i instrument \t(lookup member by instrument)" +
                               "\n");
            return;
        }

        Band TheBeatles = new Band("The Beatles");
        TheBeatles.addMember("John Lennon", "vocals");
        TheBeatles.addMember("Paul McCartney", "bass");
        TheBeatles.addMember("Ringo Starr", "drums");
        TheBeatles.addMember("George Harrison", "guitar");

        CLI.handleCommand(TheBeatles, args);
    }
}
