# OOD 
*(based on corrected OOA)*
## Iteration 1
### Classes
- Driver
- CLI
- SearchEngine
- Document
- StopList

### Attributes
- Driver: 
- CLI: arguments (String[])
- Document: fileName (String), contents (String)
- SearchEngine: stopList (StopList), index (HashMap<String, Set\<Document\>>)
- StopWord: stopWords (HashSet\<String\>)

### Delegation
- SearchEngine has a map to sets of Documents
- SearchEngine has a StopList

### Services
- Driver: 
  - main() : void : Entry into the program.
- CLI:
  - start() -> void : Checks for usage, prompts user for queries, and performs the search.
  - hasValidUsage() -> boolean : Returns whether the arguments have proper usage.
- SearchEngine:
  - construct() -> void : Constructs the inverted index.
  - search() -> void : Prints the list of documents found containing all words in the query.
  - display() -> void : Prints the inverted index in a human-readable format.
- Document:
  - display() -> String : Returns the name/contents of the document.
  - iterator() -> Iterator\<String\> : Returns an Iterator allowing traversal of the document's words.
- StopList:
  - isStopWord() -> boolean : Returns true if the String is a stop word.

## Iteration 2
### Language
- Java

### Classes
- Driver (concrete)
- CLI (concrete)
- SearchEngine (concrete)
- Document (concrete)
- StopList (concrete)

### Attributes
- Driver:
- CLI: arguments (String[] - flags and file names provided by the user)
- Document: fileName (String - name of the file), contents (String - the entire raw document)
- SearchEngine: stopList (StopList - object containing set of stop words), index (HashMap<String, Set\<Document\>> - maps words to sets of documents)
- StopWord: stopWords (HashSet\<String\>)

### Delegation
- SearchEngine has a HashMap that relates a String word to a HashSet of Documents
- SearchEngine has a StopList

### Services
- Driver:
  - main() : void : Entry into the program.
- CLI:
  - start() -> void : Checks for usage, prompts user for queries, and performs the search.
  - hasValidUsage() -> boolean : Returns whether the arguments have proper usage.
- SearchEngine:
  - construct(StopList, List\<Document\>) -> void : Constructs the inverted index.
  - search(String, boolean) -> void : Prints the list of documents found containing all words in the query.
  - display() -> void : Prints the inverted index in a human-readable format.
- Document:
  - display() -> String : Returns the name/contents of the document.
  - iterator() -> Iterator\<String\> : Returns an Iterator allowing traversal of the document's words.
- StopList:
  - isStopWord(String) -> boolean : Returns true if the String is a stop word.

***

# Corrected OOA

### Classes
- Driver
- CLI
- SearchEngine
- Document
- StopList

### Attributes
- Driver: None
- CLI: arguments
- Document: fileName, contents
- SearchEngine: stopList, index
- StopWord: stopWords

### Delegation
- SearchEngine has a map to sets of Documents
- SearchEngine has a StopList

### Services
- Driver: None
- CLI:
    - start
    - hasValidUsage
- SearchEngine:
    - construct
    - search
    - display
- Document:
    - display
    - iterator
- StopList:
    - isStopWord

