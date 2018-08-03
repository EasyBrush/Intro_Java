
public class ContactInfo
{
    private String FirstName;
    private String LastName;
    private String CompanyName;
    private String phoneNumber;
    private String emailAddress;
    
    public ContactInfo()
    { 
        /*String FirstN, String LastN, String CompanyName, String phoneNumber, String emailAddress
        this.FirstName = FirstN;
        this.LastName = LastN;
        this.CompanyName = CompanyName;
        this.phoneNumber = phoneNumber;
        this.emailAddress = emailAddress;*/
        FirstName = "";
        LastName ="";
        CompanyName = "";
        phoneNumber = "";
        emailAddress = "";
    }
    
    public String toString()
    {
        return CompanyName + " " + phoneNumber + " " + emailAddress;
    }
    
    public String getFullName()
    {
        return LastName + " " + FirstName;
    }
    
    public String getFirstName()
    {
        return FirstName;
    }

    public void setFirstName(String firstName)
    {
        FirstName = firstName;
    }

    public String getLastName()
    {
        return LastName;
    }

    public void setLastName(String lastName)
    {
        LastName = lastName;
    }

    public String getCompanyName()
    {
        return CompanyName;
    }

    public void setCompanyName(String companyName)
    {
        CompanyName = companyName;
    }

    public String getPhoneNumber()
    {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber)
    {
        this.phoneNumber = phoneNumber;
    }

    public String getEmailAddress()
    {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress)
    {
        this.emailAddress = emailAddress;
    }

}

