/**
 * Handles program output for the command-line interface.
 * CS312 - Assignment 2
 * @author Cyrus M.
 * @version 1.0 09/24/24
 */
public class CLI {
    /**
     * Handles user request by accepting band along with the user's command.
     *
     * @param  band  the band to lookup from
     * @param  command  a list of arguments from the user's input
     */
    public static void handleCommand(Band band, String[] command){
        switch (command[0]){
            case "-p":
                System.out.println("\n" + band + "\n");
                break;
            case "-n":
                String searchName = (command.length >= 2)? command[1] : "";
                printMembersByName(band, searchName);
                break;
            case "-i":
                String searchInstrument = (command.length >= 2)? command[1] : "";
                printMembersByInstrument(band, searchInstrument);
                break;
        }
    }

    /**
     * Searches the list of band members for a match by name.
     *
     * @param  band  the band to search
     * @param  searchName  the name to search by
     */
    private static void printMembersByName(Band band, String searchName){
        String membersFound = "\nMember(s) Found:";
        for (BandMember member : band.members){
            if (member.name.toLowerCase().contains(searchName.toLowerCase())){
                membersFound += "\n\t" + member;
            }
        }
        System.out.println(membersFound + "\n");
    }

    /**
     * Searches the list of band members for a match by instrument.
     *
     * @param  band  the band to search
     * @param  searchInstrument  the instrument to search by
     */
    private static void printMembersByInstrument(Band band, String searchInstrument){
        String membersFound = "\nMember(s) Found:";
        for (BandMember member : band.members){
            if (member.instrument.toLowerCase().contains(searchInstrument.toLowerCase())){
                membersFound += "\n\t" + member;
            }
        }
        System.out.println(membersFound + "\n");
    }

}
