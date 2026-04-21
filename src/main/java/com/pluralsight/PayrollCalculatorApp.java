package com.pluralsight;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Arrays;

public class PayrollCalculatorApp {
    public static void main(String[] args) {

        try {
            FileReader fileReader = new FileReader("src/main/resources/employees.csv");
            BufferedReader theFile = new BufferedReader(fileReader);

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
                theFile.readLine();

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
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }
}
