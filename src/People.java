
public abstract class People
{
    //field-variables
    private String userName; //Primary Key
    private String password;
    private String userType; //0 = librarian; 1 = patron
    private String firstName;
    private String lastName;

    //constructors
    public People(String userName,String password, String userType,String firstName, String lastName)
    {
        this.userName = userName;
        this.password = password;
        this.userType = userType;
        this.firstName = firstName;
        this.lastName = lastName;

    }
    //class-methods
    public String getUserName()
    {
        return userName;
    }
    public String getPassword()
    {
        return password;
    }
    public String getUserType()
    {
        return userType;
    }
    public String getFirstName()
    {
        return firstName;
    }
    public String getLastName()
    {
        return lastName;
    }
    /*don't need because we set the userID in the constructor
    void int setUserID(int userID)
    {
        this.userID=userID;
    }*/
    public void setPassword( String password ) //we need this in change person wants to change their password or they are initializing their password for the first time
    {
        this.password = password;
    }
    public void setUserType( String userType ) //we need this in case someone needs to change role
    {
        this.userType = userType;
    }
    public void setFirstName( String firstName ) //we need this because a person may want to change their name later
    {
        this.firstName = firstName;
    }
    public void setLastName( String lastName )
    {
        this.lastName = lastName;
    }

    /* this might be the same job as viewBook()
    public int viewBookStatus() {}*/
}