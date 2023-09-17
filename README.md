# Software Developer Engineer in Test - Test Automation Engineer


### 1 - AUTOMATED TEST SUITE
Using your preferred language/framework, create a test suite that
automatically validates that [WordCounter](https://wordcounter.net/) correctly displays:

● # of words

● # of characters

● The 3 most repeated words with the number of repetitions (Keyword
Density section)

You're free to create as many scenarios as you think are necessary to cover
those three points. It's mandatory to generate a summary report showing how
many scenarios were executed, how many passed, and how many failed with it's
error description.
Requirements

● You don't need to modify any settings in the website, always use the
default settings.

● Ask as many questions you have in order to clarify the scope of your
tests. Feel free to contact us or be sure to detail any assumption you
made. (Limit your questions to a single mail please)
For 1st and 4rd points:

● Upload your project to a GitHub repo and share it with us. 

● Provide detailed instructions on how to run your project (preferably also in the repo).

#### 1.1 - AUTOMATED TEST SUITE - SOLUTION

Lumu Technologies is a project that developed the technical test presented in the previous paragraph.

In order to use best practices, the screemplay pattern was used, creating a single test scenario that encompasses all the test cases presented in the requirements.



#### 1.2 - INSTALLATION

The development should be focused on the use of **Linux** OS or **Unix** based systems, to make the installation of the dependencies effective and ensure the operation of the project in any **development**, **testing**, and **production** environment.

For **Windows** operating systems based on version **11**, the installation of the project is performed with these steps:

1. First install [Java 17](https://www.oracle.com/java/technologies/javase/jdk17-archive-downloads.html) as the base programming language of this repository, install [Maven 3.8.6](https://maven.apache.org/download.cgi) and create the environment variables for each of the above tools.
   To test the installation you should run the following commands in your preferred command terminal.
```sh
$ java --version
$ mvn --version
```

2. As this is an automation backend project developed with serenity bdd framework [Serenity](https://serenity-bdd.github.io/docs/tutorials/first_test), it is not necessary to install any extra tool, however, you should review the documentation to understand how it works.


## How to run the tests?

Following these steps, we can perform the execution of the test suite or a specific feature:
```sh
$ mvn clean test verify
$ mvn clean verify -Dcucumber.filter.tags=@nombreTag
```

The test results will be recorded in the **target/site/serenity/index.html** directory.

### 2 - FAILURE REPORT
You can not usually build automated testing for something that you have not done good manual testing before, so it is vital that our test engineers are able to transmit ideas, listen, and report defects/failures in a clear way.
Write a short report on any findings that you may consider a defect or worth of improvement for [WordCounter](https://wordcounter.net/).

### 4 - WORD FREQUENCY COUNTER
Knowing how often a word appears in a sentence or block of text is helpful for
several types of word analysis.
Using your preferred language/framework, create your own algorithm that reads
a text file and counts the frequency of words in the given text. Then it
counts words and characters, and also constructs a histogram displaying the
words and the frequency.
Example Output.
Given a file with the text below
lumu lumu lumu lumu lumu illuminates illuminates attacks and adversaries

#### 4.1 - WORD FREQUENCY COUNTER - SOLUTION

```python
import re
from collections import Counter
import matplotlib.pyplot as plt
```

```python
class ReadFile:
    
    def read(self) -> str:
        with open('LumuTechnologies.txt', 'r') as file:
            return file.read()
```

```python
data = ReadFile()
data.read()
```

```python
class CounterWordCharacter:
    data = ReadFile()
    top_n = 10

    def token(self):
        return re.findall(r'\b\w+\b', self.data.read().lower())

    def word_frequency(self) -> Counter[Any]:
        return Counter(self.token())

    def words(self):
        return len(self.token())

    def characters(self):
        return len(self.data.read())

    def common_words(self):
        return self.word_frequency().most_common(self.top_n)
```

```python
class CreateHistogram:

    word = CounterWordCharacter()

    def histogram(self):
        plt.figure(figsize=(10, 6))
        plt.xlabel('Word')
        plt.ylabel('Frequency ')
        plt.title('Word Frequency Histogram')
        plt.xticks(rotation=45)
        plt.tight_layout()
        plt.bar(*zip(*self.word.common_words()))
        plt.show()
```

```python
word = CounterWordCharacter()
print(word.words())
print(word.characters())
print(word.common_words())
print(word.token())
print(word.word_frequency())
print(word.common_words())
histogram = CreateHistogram()
histogram.histogram()
```
