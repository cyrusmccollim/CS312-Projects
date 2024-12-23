# CS312 Assignment 2 - "Meet the Band" Design Plan

## Class Hierarchy 
### Band
- Holds a name and list of members for a band.
- addMember() adds a band member to the list of band members.
- toString() returns information about the band as a string.
### BandMember
- Holds a name and instrument for a band member.
- toString() returns information about the band member as a string.
### Driver
- Entrance into the program that allows members of a band to be looked up.
- main() verifies validity of arguments and passes them to the CLI.
### CLI
- Handles program output for the command-line interface.
- handleCommand() handles user request by accepting band along with the user's command.
- printMembersByName() searches the list of band members for matches containing the name (as long as the argument is part of the name).
- printMembersByInstrument() searches the list of band members for matches by instrument (as long as the argument is part of the instrument name).

## Test Cases
1. **java Driver -p**
<br> Expected: John..., Paul..., Ringo..., George... (list of all members and their instruments)
2. **java Driver -n**
<br> Expected: [Usage Message] (print list of valid arguments, program terminates)
3. **java Driver -i**
<br> Expected: [Usage Message] (print list of valid arguments, program terminates)
4. **java Driver -n a b c**
<br> Expected: Paul..., Ringo..., George... (list of members with a name containing "a")
5. **java Driver -n JoHn**
<br> Expected: John... (list of members with a name containing "john")
6. **java Driver -i guit**
<br> Expected: George... (list of members with an instrument name containing "guit")
7. **java Driver -i cal**
<br> Expected: John... (list of members with an instrument name containing "cal")
8. **java Driver -n vocal**
<br> Expected: N/A (list of members with a name containing "vocal")
9. **java Driver -i ringo**
<br> Expected: N/A (list of members with an instrument name containing "ringo")
10. **java Driver -n harrISON**
<br> Expected: George... (list of members with a name containing "harrison")
11. **java Driver**
<br> Expected: [Usage Message] (print list of valid arguments, program terminates)
