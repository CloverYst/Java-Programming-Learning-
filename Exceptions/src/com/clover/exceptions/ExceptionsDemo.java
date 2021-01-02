package com.clover.exceptions;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Locale;

public class ExceptionsDemo {
    public static void show() throws IOException {
        //FileReader reader = null;
        var account = new Account();
        /*try (
                var reader = new FileReader("file.txt");
                var writer = new FileWriter("...");
        ){
            //reader = new FileReader("file.txt");
            //System.out.println("File Opened!");
            var value = reader.read();
            new SimpleDateFormat().parse("");
        }
        //multiple catch blocks and the order matter because if the FileNotFoundException after IOException will have error
        //because FileNotFound extends from the IO
        catch(FileNotFoundException ex){
            System.out.println("File not found!");
            //System.out.println(ex.getMessage());
        }
        catch(IOException | ParseException e){
            System.out.println("Could not rea data");
        }*/
        /*catch (ParseException e) {
            e.printStackTrace();
        }*/
        /*//we must release the external resources because otherwise other cannot access it
        finally {
            if(reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }*/

        /*try {
            account.deposit(-1);
        } catch (IOException e) {
            //e.printStackTrace();
            System.out.println("Logging");
            throw e;
        }*/

        try {
            account.withdraw(10);
        } catch (AccountException e) {
            //e.printStackTrace();
            var cause = e.getCause();
            System.out.println(cause.getMessage());
        }

    }

    public static void sayHello(String name){
        System.out.println(name.toUpperCase());
    }


}
