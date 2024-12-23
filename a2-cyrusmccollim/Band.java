/**
 * Holds a name and list of members for a band.
 * CS312 - Assignment 2
 * @author Cyrus M.
 * @version 1.0 09/24/24
 */

import java.util.List;
import java.util.ArrayList;

public class Band {
    // Attributes
    protected String name;
    protected List<BandMember> members = new ArrayList<>();

    // Constructor
    public Band (String name){
        this.name = name;
    }

    /**
     * Adds a band member to the list of band members.
     *
     * @param  name  the name for the new band member
     * @param  instrument  the instrument the new band member plays
     */
    public void addMember(String name, String instrument){
        members.add(new BandMember(name, instrument));
    }

    /**
     * Returns information about the band as a string.
     *
     * @return  all band member names and instruments
     */
    @Override
    public String toString(){
        String s = name + ":";
        for (BandMember member : members){
            s += "\n\t- " + member.name + " (" + member.instrument + ")";
        }
        return s;
    }
}
