# CSCI 3236 – Assignment 5

## Regular Expression Language Generator

This Java program generates and prints all binary strings up to a specified length that belong to a language defined by a **regular expression**.

The program uses Java's `Pattern` class to evaluate strings against the regular expression and a **Breadth-First Search (BFS)** approach using a queue to systematically generate possible binary strings.

## 📌 Assignment Information

* **Course:** CSCI 3236
* **Assignment:** Assignment 5
* **Language:** Java
* **Package:** `csci3236.assignment5`
* **Author:** Tyrone Darby

## 📝 Description

The program's primary method is:

```java
printRegEx(String regex, int n)
```

It takes two parameters:

* `regex` – The regular expression defining the language.
* `n` – The maximum length of strings to generate.

The program generates binary strings using the alphabet:

```text
{0, 1}
```

Each generated string is tested against the provided regular expression. If the string matches, it is printed as a member of the language.

The empty string is represented using the Greek letter:

```text
ε
```

## 🔍 Regular Expression Used

The `main()` method uses:

```java
printRegEx("01*|(10)*", 5);
```

The regular expression:

```text
01* | (10)*
```

represents strings that match either:

### `01*`

A `0` followed by zero or more `1`s.

Examples:

```text
0
01
011
0111
01111
```

### `(10)*`

Zero or more repetitions of `10`.

Examples:

```text
ε
10
1010
101010
...
```

Since the maximum length is set to `5`, only strings with a length of 5 or less are generated and tested.

## ⚙️ How the Program Works

The program uses a queue to perform a **Breadth-First Search** over possible binary strings.

### 1. Create the Regular Expression

The regex is compiled using Java's `Pattern` class:

```java
Pattern pattern = Pattern.compile(regex);
```

### 2. Initialize the Queue

An empty string is placed into the queue:

```java
Queue<String> queue = new ArrayDeque<>();
queue.add("");
```

This allows the program to consider the empty string as a possible member of the language.

### 3. Process Each String

The program removes one string from the front of the queue:

```java
String current = queue.poll();
```

It then checks whether the string matches the regular expression:

```java
if (pattern.matcher(current).matches())
```

If it matches, the string is printed.

### 4. Generate New Strings

As long as the current string has not reached the maximum length, the program generates two additional strings:

```java
queue.add(current + "0");
queue.add(current + "1");
```

For example:

```text
""
├── "0"
│   ├── "00"
│   └── "01"
└── "1"
    ├── "10"
    └── "11"
```

This process continues until all binary strings of length up to `n` have been considered.

## 🚀 How to Run

### Prerequisites

You will need:

* Java JDK 8 or later
* An IDE such as IntelliJ IDEA, Eclipse, or VS Code, or a Java-compatible terminal environment

### Run from an IDE

1. Open the project in your Java IDE.
2. Make sure the file is located in the package:

   ```text
   csci3236.assignment5
   ```
3. Run the `Assignment5` class.
4. The results will be displayed in the console.

### Run from the Command Line

Compile the Java file:

```bash
javac Assignment5.java
```

Then run:

```bash
java csci3236.assignment5.Assignment5
```

The exact command may vary depending on the project's directory structure.

## 💻 Example

The program is currently configured with:

```java
printRegEx("01*|(10)*", 5);
```

The output begins with strings such as:

```text
------- Strings in the language -------
ε
0
01
10
011
1010
0111
...
```

The exact ordering follows the queue-based breadth-first generation of binary strings.

## 🧠 Algorithm

The program uses **Breadth-First Search (BFS)**.

Each string represents a node in a search tree. From each node, two new strings are generated:

```text
current + "0"
current + "1"
```

The queue ensures that shorter strings are processed before longer strings.

### Search Structure

For example:

```text
                    ""
                  /    \
                "0"    "1"
               /  \    /  \
            "00" "01" "10" "11"
             ...
```

Every binary string up to length `n` is eventually checked against the regular expression.

## ⏱️ Complexity

For a maximum string length of `n`, there are:

```text
1 + 2 + 4 + ... + 2^n
```

possible binary strings.

This gives a total of:

```text
2^(n+1) - 1
```

strings that may need to be examined.

Therefore, the number of generated strings grows exponentially with `n`.

The program is practical for relatively small values of `n`, which is appropriate for demonstrating regular-language generation.

## 📂 Project Structure

```text
Assignment5/
└── src/
    └── csci3236/
        └── assignment5/
            └── Assignment5.java
```

## 🛠️ Technologies Used

* **Java**
* `java.util.ArrayDeque`
* `java.util.Queue`
* `java.util.regex.Pattern`

## 🎯 Learning Objectives

This assignment demonstrates:

* Regular expressions
* Regular languages
* Binary string generation
* Breadth-First Search
* Queues and data structures
* Java regular expression matching
* Algorithmic complexity

## 👤 Author

**Tyrone Darby**

CSCI 3236 – Assignment 5
