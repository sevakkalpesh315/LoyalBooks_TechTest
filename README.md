# LoyalBooks_TechTest
App outputs the individual words that appear in the book and number of times each word appears is a prime number
# Tech_Test
App outputs the individual words that appear in the book and number of times each word appears is a prime number

# Approach:
1. Load File
2. Read each line and split by space and punction mark String[] splitWords = getFile.readWords("Railway-Children-by-E-Nesbit.txt");
3. getOccurrences(String[] splitWords) loop thorught the list of words and count the occurrence of the word and append to HashMap
4. sortList(Map<String, Integer> occurrences) sort occurrence of the word to low to high to improve console visiblity
5. printOccurrences method is called to display results.

   # Instrctions to run app- Android API</br>
- minimum API: 15</br>
- target API: 26 </br>
- buildToolsVersion "26.0.1" (Replace with your own installed version or download while import project)
In Android Studio, click in File menu, then import project, browse to code location and then ok</br>

    # Future Improvements<b></br>
1 Include more unit test/ have maximum (80%) test code coverage </br>
2 Add more automated UI testing using espresso/calabash and cucumber </br>

 # Technologies Used<b></br>
1 Mockito: Unit testing the logic, Test presenters/interactions in MVP design pattern</br>
2 Dependency injection: Used dagger to inject presenters into the activity
3 MVP Design pattern: Divided the application into at least three different layers, which let us test them independently. With MVP we are able to take most of logic out from the activities so that we can test it without using instrumentation tests.</br> 

# Output for the Application
Requirement 1: Outputs the individual words that appear in the book, and how many times that word appears in the text file.
Requirement 2: Output whether the number of times each word appears is a prime number.
![image](http://i.imgur.com/5g6IHr7.png)
