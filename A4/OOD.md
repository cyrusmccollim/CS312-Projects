# OOD

*** 

## Iteration 1

### Programming Language
- Java

### Classes
- Inventory
- Item (abstract)
    - Disk (abstract)
        - DVD
        - CD
    - Book (abstract)
        - PrintBook
        - AudioBook

### Attributes
- Inventory: items (ArrayList)
- Item: title (String), price (double), quality (enum)
    - Disk: releaseYear (int)
        - DVD: studio (String)
        - CD: band (String)
    - Book: author (String)
        - PrintBook: genre (String)
        - AudioBook: reader (String)

### Inheritance
- Disk and Book are an Item
- DVD and CD are a Disk
- PrintBook and AudioBook are a Book

### Delegation
- Inventory has an ArrayList of items

### Services
- Add item to inventory 
    - accepts: Item
- Lookup inventory 
    - accepts: String for key | searchType -- enum for all/title/author | formatChoice -- true for datafile, false for human-readable
    - returns: all matching items as String
- Sell items from inventory 
    - accepts: String for key | searchType -- enum for all/title/author | formatChoice -- true for datafile, false for human-readable

***

## Iteration 2

### Programming Language
- Java

### Classes
- Inventory (concrete)
- Item (abstract)
    - Disk (abstract)
        - DVD (concrete)
        - CD (concrete)
    - Book (abstract)
        - PrintBook (concrete)
        - AudioBook (concrete)
- Driver (concrete)
- CLI (concrete)

### Attributes
- Inventory: items (ArrayList)
- Item: title (String), cost (double), Condition (enum: USED or NEW)
    - Disk: releaseYear (int)
        - DVD: studio (String), condition (Condition)
        - CD: band (String), condition (Condition)
    - Book: author (String)
        - PrintBook: genre (String), condition (Condition)
        - AudioBook: reader (String), condition (Condition)
- CLI: inventory (Inventory)
- Driver: n/a 


### Inheritance
- Disk and Book are subclasses of Item
- DVD and CD are subclasses of Disk
- PrintBook and AudioBook are subclasses of Book

### Delegation
- Inventory has an ArrayList of items
- CLI has an Inventory

### Services
Inventory:
- addItem() - adds item to inventory
    - accepts: Item
- lookupItems() - returns items matching a key for an attribute
    - accepts: String for key | searchType -- enum: ALL or TITLE or AUTHOR | formatChoice -- true for datafile, false for human-readable
    - returns: all matching items as String
- sellItems() - removes items matching a key for an attribute
    - accepts: String for key | searchType -- enum: ALL or TITLE or AUTHOR | formatChoice -- true for datafile, false for human-readable
- populateItems() - fills ArrayList of items with existing inventory data from a file

Item:
- hasTitle() - returns true if the key passed in matches the item's title
    - accepts: String for key
    - returns: boolean
- toString() - returns the attributes of the item in the data file format.
    - returns: String of attributes
- toReadableString() - returns the attributes of the item in a human-readable format.
    - returns: String of attributes

Book:
- hasAuthor() - returns true if the key passed in matches the book's author
    - returns: boolean

Disk:
- hasAuthor() - returns false
    - returns: false
