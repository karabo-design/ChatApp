public class Login {
    // Variables to store registered user details
    private String storedUsername;
    private String storedPassword;
    private String storedCellNumber;
    private String firstName;
    private String lastName;

    // 1. Boolean: checkUserName()
    public boolean checkUserName(String username) {
        // Must contain an underscore and be no more than five characters long
        return username.contains("_") && username.length() <= 5;
    }

    // 2. Boolean: checkPasswordComplexity()
    public boolean checkPasswordComplexity(String password) {
        // At least 8 chars, 1 capital, 1 number, 1 special char
        boolean hasLength = password.length() >= 8;
        boolean hasCapital = password.matches(".*[A-Z].*");
        boolean hasNumber = password.matches(".*[0-9].*");
        boolean hasSpecial = password.matches(".*[^a-zA-Z0-9].*");

        return hasLength && hasCapital && hasNumber && hasSpecial;
    }

    // 3. Boolean: checkCellPhoneNumber()
    public boolean checkCellPhoneNumber(String cellNumber) {
        // South African cell numbers use +27 followed by 9 digits, e.g. +27838968976
        return cellNumber.matches("^\\+27[0-9]{9}$");
    }

    // 4. String: registerUser()
    public String registerUser(String username, String password, String cellNumber, String fName, String lName) {
        if (!checkUserName(username)) {
            return "Username is not correctly formatted; please ensure that your username contains an underscore and is no more than five characters in length.";
        }

        if (!checkPasswordComplexity(password)) {
            return "Password is not correctly formatted; please ensure that the password contains at least eight characters, a capital letter, a number, and a special character.";
        }

        if (!checkCellPhoneNumber(cellNumber)) {
            return "Cell number is incorrectly formatted or does not contain an international code; please correct the number and try again.";
        }

        // If all checks pass, store the details
        this.storedUsername = username;
        this.storedPassword = password;
        this.storedCellNumber = cellNumber;
        this.firstName = fName;
        this.lastName = lName;

        return "Username successfully captured.\nPassword successfully captured.\nCell number successfully captured.\nUser registered successfully.";
    }