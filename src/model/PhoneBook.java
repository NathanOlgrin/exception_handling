package model;

import java.io.*;
import java.nio.file.FileSystemException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class PhoneBook {
    String lastName;
    String firstName;
    String middleName;
    Date birthdate;

    int numberPhone;
    String sex;

    public PhoneBook() {

    }

    public boolean add(String text) throws Exception {
        try {
            addHuman(text);
            return true;
        } catch (FileSystemException e){
            System.out.println(e.getMessage());
        }
        return false;
    }
    public void addHuman(String text) throws Exception {
        /*try(BufferedReader bf = new BufferedReader(new StringReader(text))){

        } catch (IOException){
            throw new Exception("Произошла ошибка при работе с консолью")
        }*/

        String[] array = text.split(" ");
        if(array.length != 6){
            throw new IllegalAccessException("Введено неверное количество параметров");
        }

        lastName = array[0];
        firstName = array[1];
        middleName = array[2];

        SimpleDateFormat format = new SimpleDateFormat("d.MM.y");
        try{
            birthdate = format.parse(array[3]);
        } catch (ParseException e){
            throw new ParseException("Неверный формат даты рождения", e.getErrorOffset());
        }

        try {
            numberPhone = Integer.parseInt(array[4]);
        } catch (NumberFormatException e) {
            throw new NumberFormatException("Неверный формат телефона");
        }

        sex = array[5];

        if(!sex.toLowerCase().equals("m") && !sex.toLowerCase().equals("f")){
            throw new RuntimeException("Неверно введен пол");
        }

        String fileName = lastName + ".txt";
        File file = new File(fileName);
        try(FileWriter fileWriter = new FileWriter(file, true)){
            if(file.length() > 0){
                fileWriter.write("\n");
            }
            fileWriter.write(String.format("%s %s %s %s %s %s", lastName, firstName, middleName, format.format(birthdate), numberPhone, sex));
        } catch (IOException e){
            throw new FileSystemException("Возникла ошибка при работе с файлом");
        }
    }
}
