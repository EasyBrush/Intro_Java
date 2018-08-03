/* This program creates a contact list using a Map class. The contact 
 * information includes: first name, last name, company name, phone number
 * and e-mail address. The list allows user to add a contact to a list 
 * and delete a contact from the list.  
 * 
 */
import java.util.ArrayList;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.TreeMap;
import java.io.*;
public class Contacts
{
    //read txt file, put into ArrayList, use TreeMap or HashMap {string, ArrayList} 
    //use methods to add and remove contacts
    //display entire contact list using special for loop

    public static void main(String[] args)
    {
        ContactInfo Info = new ContactInfo();
        
        Scanner str = new Scanner(System.in);
        Scanner nums = new Scanner(System.in);
        
        //ArrayList<String> contacts = new ArrayList<String>();
        TreeMap<String, String> contactMap = new TreeMap<String, String> ();  
        
        //System.out.println("Enter file path");
        //String contactsFile = str.nextLine();
        
        String ContactFile = "src/ContactSample.txt";
        
        int option = -1;
        try
        {
            BufferedReader inFile = new BufferedReader(new FileReader(ContactFile));
            String newLine = "";
            
            
            
            
            while((newLine = inFile.readLine()) != null)
            {
                
                String info[] = newLine.split("\\s+");
                
                Info.setFirstName(info[0]);
                Info.setLastName(info[1]);
                Info.setCompanyName(info[2]);
                Info.setPhoneNumber(info[3]);
                Info.setEmailAddress(info[4]);
                
                contactMap.put(Info.getFullName(), Info.toString());
                
                /*String FirstN = info[0];
                String LastN = info[1];
                String CompanyName = info[2];
                String PhoneNum = info[3];
                String email = info[4];
                
                String FullN = LastN + " " + FirstN;
                            
                contactMap.put(FullN, CompanyName + " " + PhoneNum + " " + email);*/
            }


            while (option != 0)
            {
                System.out.println();
                System.out.println("Enter 1 to view contacts");
                System.out.println("Enter 2 to add a contact");
                System.out.println("Enter 3 to remove a contact");
                System.out.println("Hit any other key to exit");
                option = nums.nextInt();
                
                switch(option)
                {
                case 1:
                    for (Entry<String, String> mapentry : contactMap.entrySet())
                    {
                        System.out.println(Info.getFullName() + " " + Info.toString());
                    //    System.out.println(contacts.get(i));
                    }
                    break;
                case 2:
                   /* System.out.println("Enter First Name");
                    String Fn = (str.nextLine());
                    System.out.println("Enter Last Name");
                    String Ln = (str.nextLine());
                    System.out.println("Enter company name");
                    String CompN = (str.nextLine());
                    System.out.println("Enter Phone Number");
                    String Phone = (str.nextLine());
                    System.out.println("Enter Email Address");
                    String email = (str.nextLine());
                    
                    String Key = Ln + " " + Fn;
                    contactMap.put(Key, CompN + " " + Phone + " " + email);*/
                    
                    System.out.println("Enter First Name");
                    Info.setFirstName(str.nextLine());
                    
                    System.out.println("Enter Last Name");
                    Info.setLastName(str.nextLine());
                    
                    System.out.println("Enter company name");
                    Info.setCompanyName(str.nextLine());
                    
                    System.out.println("Enter Phone Number");
                    Info.setPhoneNumber(str.nextLine());
                    
                    System.out.println("Enter Email Address");
                    Info.setEmailAddress(str.nextLine());
                    
                    contactMap.put(Info.getFullName(), Info.toString());
                    
                    break;
                case 3: 
                    System.out.println("Enter First Name");
                    Info.setFirstName(str.nextLine());
                    System.out.println("Enter Last Name");
                    Info.setLastName(str.nextLine());
                    //String FullN = Ln2 + " " + Fn2;
                    contactMap.remove(Info.getFullName());
                    break;
                default:
                    System.out.println("bye");
                }
                
            }
            inFile.close();
            str.close();
            nums.close();
                
        }
        catch(FileNotFoundException e)
        {
            System.out.println("File Not Found");
        } catch (IOException e)
        {
            e.printStackTrace();
        }
                

    }
    
    public void addContact(ArrayList<String> arrylist, String Info)
    {
        arrylist.add(Info);
    }
    
    public void removeContact(ArrayList<String> arrylist, int index)
    {
        arrylist.remove(index);
    }

}
