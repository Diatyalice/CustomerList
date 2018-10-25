package customerlist;
import java.io.*;
import java.util.*;
import javax.swing.*;

/**
 *
 * @author zhche5293
 */
public class CustomerList {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        
                boolean error = true;
                File textFile = new File("CustomerList.txt");
		FileReader in;
		BufferedReader readFile;
		String Text;
                
       
       
                
        String customersName, address, city, province, postalCode="" , numberCustomers = null;
        int numCustomers=0;
                
        
         while (error){
            try{
                numberCustomers = JOptionPane.showInputDialog("How many customers would you like to input?");
                //Crash on non-integer inputs
                numCustomers = Integer.parseInt(numberCustomers);
                error = false;
            }catch (NumberFormatException nfe) {
             //found an exception
             JOptionPane.showMessageDialog(null,"Please enter a integer");
             
        }       
          }
        //User input
        customersName =(JOptionPane.showInputDialog("Enter the customer's name ."));
        address = (JOptionPane.showInputDialog("Enter the customer's address."));
        city = (JOptionPane.showInputDialog("Enter the customer's city."));
        province = (JOptionPane.showInputDialog("Enter the customer's province ."));
        
        
        //Check postal code
        while (error) {
        postalCode = (JOptionPane.showInputDialog("Enter the customer's postal."));       
        
        if ((Character.isLetter(postalCode.charAt(0))) && (Character.isDigit(postalCode.charAt(1)))
            &&(Character.isLetter(postalCode.charAt(2))) && (Character.isDigit(postalCode.charAt(3)))
            &&(Character.isLetter(postalCode.charAt(4))) &&(Character.isDigit(postalCode.charAt(5)))){
            JOptionPane.showMessageDialog(null, "Everything has been added.");
            error = false;
        }
        else{
            JOptionPane.showMessageDialog(null, "This is an incorrect postal code please enter a proper postal code.");
            error = true;
        }     
    }
    String toAdd =("******Customers Name: "+customersName+".******"+
        "\n"+"******Address: "+address+".******"+"\n"+"******City: "+city+".******"+"\n"+
        "******Province: "+province+".******"+"\n"+"******Postal Code: "+postalCode+".******"+
        "\n******************************\n\n");
    System.out.println(toAdd);
    
    //Print to file
    PrintWriter fileOut = new PrintWriter(new FileWriter(
      "CustomerList.txt",true));
    fileOut.println(toAdd);
        fileOut.close();
        //Catch errors
        try {
                in = new FileReader(textFile);
                readFile = new BufferedReader(in);
                while ((Text = readFile.readLine()) != null ) {
                        System.out.println(Text);
                }
                readFile.close();
                in.close();
            } catch (FileNotFoundException e) {
                System.out.println("File does not exist or could not be found.");
                System.err.println("FileNotFoundException: " + e.getMessage());
            } catch (IOException e) {
                System.out.println("Problem reading file.");
                System.err.println("IOException: " + e.getMessage());
        }
    }
}