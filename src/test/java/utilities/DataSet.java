package utilities;

import org.testng.annotations.DataProvider;

public class DataSet {
    //Object type method that return Object.....
    @DataProvider(name = "invalidCredentials")
    public static Object invalidCredentialsDataSet(){
        //Java Type Specific..Int for int, string for string.
        //Object niyer karon je kono type data use kora jbe
        //Multi-dimensioanl arrey and a variable dataset

        Object[][] dataset = {
                {"","","Epic sadface: Username is required"},
                {"standard_user","","Epic sadface: Password is required"},
                {"","secret_sauce","Epic sadface: Username is required"},
                {"password","name","Epic sadface: Username and password do not match any user in this service"}
        };
        return dataset;

    }
}
