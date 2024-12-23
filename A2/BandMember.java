/**
 * Holds a name and instrument for a band member.
 * CS312 - Assignment 2
 * @author Cyrus M.
 * @version 1.0 09/24/24
 */
public class BandMember {
    // Attributes
    protected String name;
    protected String instrument;

    // Constructor
    public BandMember(String name, String instrument){
        this.name = name;
        this.instrument = instrument;
    }

    /**
     * Returns information about the band member as a string.
     *
     * @return  band member's name and instrument
     */
    @Override
    public String toString(){
        return name + " (" + instrument + ")";
    }
}
