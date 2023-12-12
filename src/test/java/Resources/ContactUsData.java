package Resources;

import org.testng.annotations.DataProvider;

public class ContactUsData {
    @DataProvider(name="ContactusData(name,email,subject,msg)")
    public static Object[][] Data()
    {
        return new Object[][]{
                {"abdo","abdoo"+95555+"@gmail.com","Help","I can't login to my mail"}//valid Data For Username and email

        };
    }
}
