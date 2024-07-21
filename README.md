# Gilded Rose Refactoring Project - Java

## Overview
This project is a Java-based application for managing the quality and sell-in values of items in the "Gilded Rose" inventory.
The initial codebase was cloned from the public repository [GildedRose-Refactoring-Kata](https://github.com/emilybache/GildedRose-Refactoring-Kata).
You'll want to look at the "Gilded Rose Requirements" which explains what the code is for.

This project is a refactoring exercise to improve the design of the Gilded Rose inventory management system.
What have I done to improve the design? 
1.  Utilized the Strategy design pattern to implement different quality update algorithms for different types of items. 
2.  Improved the readability of the code by refactoring the updateQuality method into smaller methods.
3.  Added unit tests to ensure the correctness of the code.
4.  Added comments to explain the purpose of the code and the logic behind it.
5.  Improved the structure of the code to make it more maintainable and extensible.


## Getting Started

### Building the Project
To build the project, run the following command in the root directory:

```bash
./gradlew clean build 
```
### Running TextTest fixture that comes with this project from Command-Line
```bash
./gradlew -q text
```

### Use below command to run the test for a specific number of days
For e.g. 10 days:

```bash
./gradlew -q text --args 10
```

### Running the tests on the console
```bash
./start_texttest.bat
```

There are instructions in [TextTestReadMe](https://github.com/emilybache/GildedRose-Refactoring-Kata/blob/main/texttests/README.md) for setting up TextTest.