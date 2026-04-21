package com.pluralsight;
import java.util.*;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;

public class PayrollCalculatorApp {
    static Scanner myScanner = new Scanner(System.in);
    public static void main(String[] args) {

        //prompting the user for file name to input into the filWriter
        System.out.println("Enter the name of the file employee file to process: ");
        String userFile = myScanner.nextLine();
        System.out.println("Enter the name of the payroll file to create: ");
        String userPrFile = myScanner.nextLine();

        try {
            //file reader for userFile
            FileReader fileReader = new FileReader("src/main/resources/" + userFile);
            BufferedReader theFile = new BufferedReader(fileReader);

            //file writer for userFile
            FileWriter fileWriter = new FileWriter("src/main/resources/" + userPrFile, true);
            BufferedWriter bufWriter = new BufferedWriter(fileWriter);


            String line;
            //initialized line number at 0
            int lineNum = 0;
            while((line = theFile.readLine()) != null){

                //to move past header row
                //we to find a way to move past the header row
                lineNum++;
                if (lineNum == 1) {
                    continue;
                }
                //theFile.readLine();

                //process the other rows
                //split the row on the |
                String[] employeeParts = line.split("\\|");
                int id = Integer.parseInt(employeeParts[0]);
                String name = employeeParts[1];
                double hoursWorked = Double.parseDouble(employeeParts[2]);
                double payRate = Double.parseDouble((employeeParts[3]));

                //Checking to see what employee parts looks like
                //System.out.println(Arrays.toString(employeeParts));

                //create an employee from the employee class and use the setters
                //to set the properties from the row in the file

                Employee employee = new Employee(id, name, hoursWorked, payRate);

                //prints out to see if I store the employee properties properly
//                System.out.println(employee.getEmployeeID()
//                        + " " + employee.getName()
//                        + " " + employee.getHoursWorked()
//                        + " " + employee.getPayRate()
//                );

                //call the gross pay method on the employees to print out their gross pay
                //System.out.println(line);

                System.out.printf("ID: %d | %s's gross pay: %.2f\n", employee.getEmployeeID(), employee.getName(), employee.getGrossPay());

                bufWriter.write(employee.getEmployeeID() + " | " + employee.getName() + " | " + employee.getGrossPay() + "\n");
            }
            fileWriter.close();
            bufWriter.close();

        } catch (Exception e) {
            System.out.println("File not found.");
        }

    }
}
