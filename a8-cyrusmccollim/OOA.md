# Initial OOA

***

## Iteration 1

### Classes
- Driver
- CLI
- SearchEngine
- Document

### Attributes
- Driver: None
- CLI: arguments
- Document: name, contents, words
- SearchEngine: index, documents

### Delegation
- SearchEngine has a list of Documents
- SearchEngine has a map to sets of Documents 

### Services
- Driver: None
- CLI:
    - Construct
    - Start 
    - Verify Usage
- SearchEngine:
    - Construct
    - Search
- Document: 
    - Construct

## Iteration 2

### Classes
- Driver
- CLI
- SearchEngine
- Document

### Attributes
- Driver: None
- CLI: arguments (list of command-line arguments)
- Document: name (file name), contents (string representation of document), words (set of words in the document)
- SearchEngine: index (maps words to sets of documents containing them), documents (list of Documents to create index from)

### Delegation
- SearchEngine has a list of Documents
- SearchEngine has a map to sets of Documents

### Services
- Driver: None
- CLI:
    - Construct (accepts : list of command-line arguments)
    - Start (accepts : N/A | creates SearchEngine if arguments are valid, reads queries from standard in, outputting documents found)
    - Verify Usage (accepts : N/A | returns: true if there is proper usage of arguments)
- SearchEngine:
    - Construct (accepts : a stop list map, list of Documents | creates index from the list of Documents, ignoring words in stop list)
    - Search (accepts : string of words, verbose flag | returns : list of Documents containing the words and optionally their contents)
- Document:
    - Construct (accepts : file name | stores document as a string and creates set of words from document)
    - To String (accepts : include contents flag | returns : name of the document and optionally its contents)