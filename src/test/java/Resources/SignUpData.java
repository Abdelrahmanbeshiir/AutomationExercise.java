package Resources;

import org.testng.annotations.DataProvider;

public class SignUpData {

    @DataProvider(name="SignUpData(name,gender,email,password,day,month,year)")
    public static Object[][] Data()
    {
        return new Object[][]{
                {"abdo","male","abdoo"+1244+"@gmail.com","A12345","26","12","1996"}//valid Data For Username and email

        };
    }
    @DataProvider(name = "InValidLoginData(email,password)")
    public static Object[][] Data1()
    {
        return new Object[][]{
                {"abdo888@gmail.com","45666562a"},

                //InValid Data For email and password
        };
    }
}
