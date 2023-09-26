package dto;

public class UserDTOWith {

    String name;
    String lastName;
    String email;
    String password;

    public String getName() {
        return name;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }


    //------------------------


//    public void setName(String name) {
//        this.name = name;
//    }

    public UserDTOWith withName(String name) { // like setter
        this.name = name;
        return this;
    }

    public UserDTOWith withLastName(String lastName) { // like setter
        this.lastName = lastName;
        return this;
    }

    public UserDTOWith withEmail(String email) { // like setter
        this.email = email;
        return this;
    }

    public UserDTOWith withPassword(String password) { // like setter
        this.password = password;
        return this;
    }
}
