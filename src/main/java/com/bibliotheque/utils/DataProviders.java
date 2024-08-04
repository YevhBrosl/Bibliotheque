package com.bibliotheque.utils;

import com.bibliotheque.models.Library;
import com.bibliotheque.models.User;
import org.testng.annotations.DataProvider;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class DataProviders {

    @DataProvider
    public Iterator<Object[]> addNewUserFromCsv() throws IOException {
        List<Object[]> userData = new ArrayList<>();

        BufferedReader reader = new BufferedReader(new FileReader(new File("src/test/resources/user.csv")));

        String line = reader.readLine();

        while (line != null) {
            String[] split = line.split(",");

            userData.add(new Object[]{new User().setEmail(split[0]).setPassword(split[1]).setConfirmPassword(split[2])});
            line = reader.readLine();
        }
        reader.close();

        return userData.iterator();
    }

    @DataProvider
    public Iterator<Object[]> registrationLoginWithShortPasswordFromCsv() throws IOException {
        List<Object[]> userData = new ArrayList<>();

        BufferedReader reader = new BufferedReader(new FileReader(new File("src/test/resources/shortPassword.csv")));

        String line = reader.readLine();

        while (line != null) {
            String[] split = line.split(",");

            userData.add(new Object[]{new User().setEmail(split[0]).setPassword(split[1]).setConfirmPassword(split[2])});
            line = reader.readLine();
        }
        reader.close();

        return userData.iterator();
    }

    @DataProvider
    public Iterator<Object[]> registrationLoginWithInvalidEmailFromCsv() throws IOException {
        List<Object[]> userData = new ArrayList<>();

        BufferedReader reader = new BufferedReader(new FileReader(new File("src/test/resources/invalidEmail.csv")));

        String line = reader.readLine();

        while (line != null) {
            String[] split = line.split(",");

            userData.add(new Object[]{new User().setEmail(split[0]).setPassword(split[1]).setConfirmPassword(split[2])});
            line = reader.readLine();
        }
        reader.close();

        return userData.iterator();
    }

    @DataProvider
    public Iterator<Object[]> registrationLoginWithNoUppercasePasswordFromCsv() throws IOException {
        List<Object[]> userData = new ArrayList<>();

        BufferedReader reader = new BufferedReader(new FileReader(new File("src/test/resources/noUppercasePassword.csv")));

        String line = reader.readLine();

        while (line != null) {
            String[] split = line.split(",");

            userData.add(new Object[]{new User().setEmail(split[0]).setPassword(split[1]).setConfirmPassword(split[2])});
            line = reader.readLine();
        }
        reader.close();

        return userData.iterator();
    }

    @DataProvider
    public Iterator<Object[]> registrationLoginWithNoLowercasePasswordFromCsv() throws IOException {
        List<Object[]> userData = new ArrayList<>();

        BufferedReader reader = new BufferedReader(new FileReader(new File("src/test/resources/noLowercasePassword.csv")));

        String line = reader.readLine();

        while (line != null) {
            String[] split = line.split(",");

            userData.add(new Object[]{new User().setEmail(split[0]).setPassword(split[1]).setConfirmPassword(split[2])});
            line = reader.readLine();
        }
        reader.close();

        return userData.iterator();
    }

    @DataProvider
    public Iterator<Object[]> registrationLoginWithNoDigitsPasswordFromCsv() throws IOException {
        List<Object[]> userData = new ArrayList<>();

        BufferedReader reader = new BufferedReader(new FileReader(new File("src/test/resources/noDigitsPassword.csv")));

        String line = reader.readLine();

        while (line != null) {
            String[] split = line.split(",");

            userData.add(new Object[]{new User().setEmail(split[0]).setPassword(split[1]).setConfirmPassword(split[2])});
            line = reader.readLine();
        }
        reader.close();

        return userData.iterator();
    }

    @DataProvider
    public Iterator<Object[]> registrationLoginWithNoSpecSymbolsPasswordFromCsv() throws IOException {
        List<Object[]> userData = new ArrayList<>();

        BufferedReader reader = new BufferedReader(new FileReader(new File("src/test/resources/noSpecSymbolsPassword.csv")));

        String line = reader.readLine();

        while (line != null) {
            String[] split = line.split(",");

            userData.add(new Object[]{new User().setEmail(split[0]).setPassword(split[1]).setConfirmPassword(split[2])});
            line = reader.readLine();
        }
        reader.close();

        return userData.iterator();
    }

    @DataProvider
    public Iterator<Object[]> registrationWithNonMatchingPasswordsFromCsv() throws IOException {
        List<Object[]> userData = new ArrayList<>();

        BufferedReader reader = new BufferedReader(new FileReader(new File("src/test/resources/nonMatchingPasswords.csv")));

        String line = reader.readLine();

        while (line != null) {
            String[] split = line.split(",");

            userData.add(new Object[]{new User().setEmail(split[0]).setPassword(split[1]).setConfirmPassword(split[2])});
            line = reader.readLine();
        }
        reader.close();

        return userData.iterator();
    }

    @DataProvider
    public Iterator<Object[]> registrationWithEmptyEmailFromCsv() throws IOException {
        List<Object[]> userData = new ArrayList<>();

        BufferedReader reader = new BufferedReader(new FileReader(new File("src/test/resources/emptyEmail.csv")));

        String line = reader.readLine();

        while (line != null) {
            String[] split = line.split(",");

            userData.add(new Object[]{new User().setEmail(split[0]).setPassword(split[1]).setConfirmPassword(split[2])});
            line = reader.readLine();
        }
        reader.close();

        return userData.iterator();
    }

    @DataProvider
    public Iterator<Object[]> registrationWithEmptyPasswordFromCsv() throws IOException {
        List<Object[]> userData = new ArrayList<>();

        BufferedReader reader = new BufferedReader(new FileReader(new File("src/test/resources/emptyPassword.csv")));

        String line = reader.readLine();

        while (line != null) {
            String[] split = line.split(",");

            userData.add(new Object[]{new User().setEmail(split[0]).setPassword(split[1]).setConfirmPassword(split[2])});
            line = reader.readLine();
        }
        reader.close();

        return userData.iterator();
    }

    @DataProvider
    public Iterator<Object[]> loginWithoutRegistrationFromCsv() throws IOException {
        List<Object[]> userData = new ArrayList<>();

        BufferedReader reader = new BufferedReader(new FileReader(new File("src/test/resources/unregisteredLogin.csv")));

        String line = reader.readLine();

        while (line != null) {
            String[] split = line.split(",");

            userData.add(new Object[]{new User().setEmail(split[0]).setPassword(split[1])});
            line = reader.readLine();
        }
        reader.close();

        return userData.iterator();
    }

    @DataProvider
    public Iterator<Object[]> addNewLibraryFromCsv() throws IOException {
        List<Object[]> libraryData = new ArrayList<>();

        BufferedReader reader = new BufferedReader(new FileReader(new File("src/test/resources/library.csv")));

        String line = reader.readLine();

        while (line != null) {
            String[] split = line.split(",");

            libraryData.add(new Object[]{new Library().setEmail(split[0]).setPassword(split[1]).setConfirmPassword(split[2])});
            line = reader.readLine();
        }
        reader.close();

        return libraryData.iterator();
    }


}
