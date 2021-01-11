package com.fm.accela;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.fm.accela.exception.PersonNotFoundException;
import com.fm.accela.model.Person;
import com.fm.accela.service.PersonService;

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

@SpringBootApplication
public class AccelaApplication {

    private static PersonService personService;
  

    @Autowired
    public AccelaApplication(PersonService personService) {
        this.personService = personService;
    }

    public static void main(String[] args) {

        SpringApplication.run(AccelaApplication.class, args);

        // declare a variable that will store the user input
        String userInput;

        //declare a scanner object to read the command line input by user
        Scanner scanner = new Scanner(System.in);

        //loop the utility in loop until the user makes the choice to exit
        while(true){
            System.out.println();
            System.out.println("*****Select your choice:*****");
            System.out.println();
            //Print the options for the user to choose from
            System.out.println("* Press 1 to Add Person (id, firstName, lastName)");
            System.out.println("* Press 2 to Edit Person (firstName, lastName)");
            System.out.println("* Press 3 to Delete Person (id)");
            System.out.println("* Press 4 to Count Number of Persons");
            System.out.println("* Press 5 to List Persons");
            System.out.println("* Press 0 to exit");
            System.out.println();
            // Prompt the use to make a choice
            System.out.println("Enter your choice:");

            //Capture the user input in scanner object and store it in a pre-declared variable
            userInput = scanner.next();

            //Check the user input
            switch(userInput){
                case "1":
                    //do the job number 1
                    System.out.println();
                    System.out.println("* 1. Add Person : ");
                    System.out.println();
                    System.out.println("Enter First Name - ");
                    String firstName = scanner.next();
                    System.out.println("Enter Last Name - ");
                    String lastName = scanner.next();
                    personService.addPerson(new Person(firstName, lastName));
                    System.out.println();
                    System.out.println("A new Person has been added!");
                    break;
                case "2":
                    //do the job number 2
                    System.out.println();
                    System.out.println("* 1. Edit Person : ");
                    System.out.println();
                    System.out.println("We need person id * - ");

                    long personId = scanner.nextLong();

                    System.out.println("Edit First Name ( * Enter na to keep same )- ");
                    String newFirstName = scanner.next();
                    System.out.println("Edit Last Name ( * Enter na to keep same ) - ");
                    String newLastName = scanner.next();

                    try{
                        personService.editPerson(personId, new Person(newFirstName,newLastName));
                        System.out.println();
                        System.out.println("A Person has been edited!");
                    }catch (PersonNotFoundException personNotFound){
                        System.out.println();
                        System.out.println("PersonNotFoundException: " +personNotFound.getMessage());
                    }
                    break;
                case "3":
                    //do the job number 3
                    System.out.println();
                    System.out.println("* 3. Delete Person : ");
                    System.out.println();
                    System.out.println("We need person id to Delete - ");
                    long personIdToDelete = scanner.nextLong();
                    try{
                        personService.deletePerson(personIdToDelete);
                        System.out.println();
                        System.out.println("A Person is successfully Deleted!");
                    }catch (PersonNotFoundException personNotFound){
                        System.out.println();
                        System.out.println("Exception found: " + personNotFound.getMessage());
                    }
                    break;
              
                case "4":
                    //do the job number 4
                    System.out.println();
                    System.out.println("* 4. Total Number of Persons are : ");
                    System.out.println(personService.getTotalNumberOfPersons());
                    System.out.println();
                    System.out.println("Now you know the total number of person.");
                    break;
                case "5":
                    //do the job number 5
                    System.out.println();
                    System.out.println("* List of Person : ");
                    System.out.println();
                    System.out.println(Arrays.toString(personService.getListOfPersons().toArray()));
                    System.out.println();
                    System.out.println("Persons List has been retrieved!");
                    break;
                case "0":
                    //exit from the program
                    System.out.println("Thanks for using our Accela Console Application!");
                    System.out.println("Now exiting...!");

                    System.exit(0);
                default:
                    //inform user in case of invalid choice.
                    System.out.println("Invalid choice. Read the options carefully...");
            }
        }
    }
}
