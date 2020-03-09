## Film Query Application

### Overview
This is a Java Program that retrieves data from a large film database and displays it in a readable format to the user. It is menu-based, allowing the user to choose actions and submit query data.

### Running the Program
When the user launches the program, the will be presented with a menu that asks if the user would like to **1. Look Up a Film by its ID**, **2. Look Up a Film by Keyword**, or **3. Exit Film Query Application**.

If the user chooses the first option, **1. Look Up a Film by its ID**, then the user will be prompted to **Please Enter a Film ID**. The program will check the Film Query Database to see if the ID entered by the user matches a film in the database. If the ID matches a film in the database then the user will be displayed with the films title, year, rating, description, language, and a list of the actors in the film.

If the user chooses the second option, **2. Look Up a Film by Keyword**, then the user will be prompted to **Please Enter a Keyword**. The program will check the Film Query Database to see if the keyword entered by the user matches a film in the database. The user will displayed with a list of films for which the keyword search term was found anywhere in the title or description if it was found at all.

If the user chooses the third option, **3. Exit Film Query Application**, then the program exits.

### Technologies Used
- *Java*
- *SQL*
- *Maven*
- *MAMP*
- *JDBC*
- *Eclipse*
- *Git / GitHub*
- *Terminal*

### Lessons Learned

- Learned about the Java Database Connectivity API (JDBC) and how to use the JDBC to access Relational Database Management Systems (RDBMSs)

- Learned about connection management and to make sure that I properly close the connections I establish. Initially I was forgetting to close the ResultSet connections throughout my application, but once I fixed that issue the application ran smoothly
