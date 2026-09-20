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