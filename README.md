# DDCTExercise
DDCT Dev Exercise

# Project Structure

```
+--project/                  Contains build properties for the project
+--src/                      All sources.
   +---/main/scala           Main scala directory with classes and objects
   +---/test/scala           Unit test directory
+--.gitignore/               Git ignore file, removing IDE and bin items
+--build.sbt                 Scala build tool config
```

# Overview
## Main
Contains:
**InitMenu** - Creates the base menu with the 4 predefined items on
**GetBill** - Is passed a list of ordered items and returns the total price of them plus service
## MItem
The menu item object with 4 properties: name, price, drink and hot

## TestMain
Unit tests for the different parts of code, mostly checking total returns or object creation


