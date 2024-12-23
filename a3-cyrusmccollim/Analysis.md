# OOA

*** 

## Iteration 1

### Classes
- Inventory
- Item
  - Disk
    - DVD
    - CD
  - Book
    - PrintBook
    - AudioBook

### Attributes
- Inventory: item collection
- Item: title, price, quality
  - Disk: release year
    - DVD: studio
    - CD: band
  - Book: author
    - PrintBook: genre
    - AudioBook: reader

### Inheritance
- Disk and Book are an Item
- DVD and CD are a Disk
- PrintBook and AudioBook are a Book

### Services
- Add item to inventory 
- Lookup inventory
- Sell items from inventory

***

## Iteration 2

### Classes
- Inventory
- Item - represents a generic item in the inventory
  - Disk - represents a generic disk
    - DVD - represents a DVD (specific disk)
    - CD - represents a CD (specific disk)
  - Book - represents a generic book
    - PrintBook - represents a physical book (specific book)
    - AudioBook - represents an audiobook (specific book)

### Attributes
- Inventory: item collection (a database of all items in the inventory)
- Item: title (name of the item), price (cost of item), quality (new or used)
  - Disk: release year (the year of Disk's release)
    - DVD: studio (studio that produced DVD)
    - CD: band (band that produced DVD)
  - Book: author (first and last name of the book's author)
    - PrintBook: genre (genre of the book)
    - AudioBook: reader (voice actor who reads the book)

### Inheritance
- Disk and Book are an Item
- DVD and CD are a Disk
- PrintBook and AudioBook are a Book

### Services
- Add item to inventory (client can add a DVD, CD, PrintBook, or AudioBook to the inventory along with its data)
- Lookup inventory (client can look up the inventory for all items or matches by title or author)
- Sell items from inventory (client can sell all inventory items with a matching title or author)
