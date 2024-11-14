package com.example.studentapp.model;

import javafx.beans.property.*;
import java.time.LocalDate;

public class Person {
    private final StringProperty firstName;
    private final StringProperty lastName;
    private final IntegerProperty groupCode;
    private final ObjectProperty<LocalDate> birthday;

    // Новые поля
    private final StringProperty email;
    private final IntegerProperty age;
    private final DoubleProperty gpa;

    public Person() {
        this(null, null);
    }

    public Person(String firstName, String lastName) {
        this.firstName = new SimpleStringProperty(firstName);
        this.lastName = new SimpleStringProperty(lastName);
        this.groupCode = new SimpleIntegerProperty(0);
        this.birthday = new SimpleObjectProperty<>(LocalDate.now());
        this.email = new SimpleStringProperty("example@mail.com");
        this.age = new SimpleIntegerProperty(18);
        this.gpa = new SimpleDoubleProperty(3.0);
    }

    // Геттеры и сеттеры для firstName
    public String getFirstName() { return firstName.get(); }
    public void setFirstName(String firstName) { this.firstName.set(firstName); }
    public StringProperty firstNameProperty() { return firstName; }

    // Геттеры и сеттеры для lastName
    public String getLastName() { return lastName.get(); }
    public void setLastName(String lastName) { this.lastName.set(lastName); }
    public StringProperty lastNameProperty() { return lastName; }

    // Геттеры и сеттеры для groupCode
    public int getGroupCode() { return groupCode.get(); }
    public void setGroupCode(int groupCode) { this.groupCode.set(groupCode); }
    public IntegerProperty groupCodeProperty() { return groupCode; }

    // Геттеры и сеттеры для birthday
    public LocalDate getBirthday() { return birthday.get(); }
    public void setBirthday(LocalDate birthday) { this.birthday.set(birthday); }
    public ObjectProperty<LocalDate> birthdayProperty() { return birthday; }

    // Геттеры и сеттеры для email
    public String getEmail() { return email.get(); }
    public void setEmail(String email) { this.email.set(email); }
    public StringProperty emailProperty() { return email; }

    // Геттеры и сеттеры для age
    public int getAge() { return age.get(); }
    public void setAge(int age) { this.age.set(age); }
    public IntegerProperty ageProperty() { return age; }

    // Геттеры и сеттеры для gpa
    public double getGpa() { return gpa.get(); }
    public void setGpa(double gpa) { this.gpa.set(gpa); }
    public DoubleProperty gpaProperty() { return gpa; }
}
