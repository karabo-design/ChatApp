public class Login {
    // Variables to store registered user details
    private String storedUsername;
    private String storedPassword;
    private String storedCellNumber;
    private String firstName;
    private String lastName;

    // 1. Boolean: checkUserName()
    public boolean checkUserName(String username) {
        if (username == null) {
            return false;
        }

        String cleanedUsername = username.trim();
        // Must contain an underscore and be no more than five characters long
        return !cleanedUsername.isEmpty() && cleanedUsername.contains("_") && cleanedUsername.length() <= 5;
    }

    // 2. Boolean: checkPasswordComplexity()
    public boolean checkPasswordComplexity(String password) {
        if (password == null) {
            return false;
        }

        String cleanedPassword = password.trim();
        // At least 8 chars, 1 capital, 1 number, 1 special char
        boolean hasLength = cleanedPassword.length() >= 8;
        boolean hasCapital = cleanedPassword.matches(".*[A-Z].*");
        boolean hasNumber = cleanedPassword.matches(".*[0-9].*");
        boolean hasSpecial = cleanedPassword.matches(".*[^a-zA-Z0-9].*");

        return hasLength && hasCapital && hasNumber && hasSpecial;
    }

    // 3. Boolean: checkCellPhoneNumber()
    public boolean checkCellPhoneNumber(String cellNumber) {
        if (cellNumber == null) {
            return false;
        }

        // South African cell numbers use +27 followed by 9 digits, e.g. +27838968976
        return cellNumber.trim().matches("^\\+27[0-9]{9}$");
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

        String cleanedFirstName = fName == null ? "" : fName.trim();
        String cleanedLastName = lName == null ? "" : lName.trim();

        // If all checks pass, store the details
        this.storedUsername = username.trim();
        this.storedPassword = password.trim();
        this.storedCellNumber = cellNumber.trim();
        this.firstName = cleanedFirstName;
        this.lastName = cleanedLastName;

        return "Username successfully captured.\nPassword successfully captured.\nCell number successfully captured.\nUser registered successfully.";
    }

    // 5. Boolean: loginUser()
    public boolean loginUser(String username, String password) {
        if (username == null || password == null) {
            return false;
        }

        // Verify entered details match stored details
        return username.trim().equals(this.storedUsername) && password.trim().equals(this.storedPassword);
    }

    // 6. String: returnLoginStatus()
    public String returnLoginStatus(boolean isLoggedIn) {
        if (isLoggedIn) {
            String first = this.firstName == null ? "" : this.firstName.trim();
            String last = this.lastName == null ? "" : this.lastName.trim();

            if (first.isEmpty() && last.isEmpty()) {
                return "Welcome it is great to see you again.";
            }

            return "Welcome " + first + ", " + last + " it is great to see you again.";
        } else {
            return "Username or password incorrect, please try again.";
        }
    }
}