## About this Repo:
![Java](https://img.shields.io/badge/java-%23ED8B00.svg?style=for-the-badge&logo=java&logoColor=white)
![IntelliJ IDEA](https://img.shields.io/badge/IntelliJIDEA-000000.svg?style=for-the-badge&logo=intellij-idea&logoColor=white)
![Mac OS](https://img.shields.io/badge/mac%20os-000000?style=for-the-badge&logo=macos&logoColor=F0F0F0)
 ```java
 Programmer name = new Programmer("Xinyi Feng")
 
 Repo type = new Repo("LAB08")
 
 Task theme = new Task("Tic Tac Toe")
 
 System.out.println("Thank you for reviewing my work!")
 
 ```
 
 ### Questions and Answers:
 ```
 Q: Whose turn is it?
      In order to allow the client to find out whose turn it is, we also have several choices. One simple way is a boolean method
      or methods to ask if it is a particular player’s turn: Even within the above approach, we have a design choice: What
      should the methods do if called once the game is over? They could return false, or they could throw an exception; 
      either way, we ought to document this choice. Which do you prefer, and why?
      
      - Answer: The method should throws an IllegalStateException or return false when the game is over. 
      
      - I think return false is better, because we can expect that this case happens very commonly. 
        Some other handlings like try-catch could be written.
        And IllegalStateException is an unchecked Exception, which occurs at the runtime, it can lower the program efficiency. 
      
