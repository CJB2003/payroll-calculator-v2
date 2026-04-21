package com.pluralsight;
import java.io.BufferedReader;
import java.io.FileReader;

public class PayrollCalculatorApp {
    public static void main(String[] args) {

        try {
            FileReader fileReader = new FileReader("src/main/resources/employees.csv");
            BufferedReader theFile = new BufferedReader(fileReader);

            String line;
            while((line = theFile.readLine()) != null){

                //we to find a way to move past the header row

                //process the other rows
                //split the row on the |

                //create an employee from the employee class and user the setters
                //to set the properties from the row in the file

                //call the gross pay method on the employees to print out their gross pay
                System.out.println(line);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }
}
