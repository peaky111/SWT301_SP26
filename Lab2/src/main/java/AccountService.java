//
//
//public class AccountService {
//
//    private String username;
//    private String password;
//    private String email;
//
//
//    public AccountService() {
//    }
//
//    // Constructor có tham số
//    public AccountService(String username, String password, String email) {
//        this.username = username;
//        this.password = password;
//        this.email = email;
//    }
//
//
//    public String getUsername() {
//        return username;
//    }
//
//    public void setUsername(String username) {
//        this.username = username;
//    }
//
//    public String getPassword() {
//        return password;
//    }
//
//    public void setPassword(String password) {
//        this.password = password;
//    }
//
//    public String getEmail() {
//        return email;
//    }
//
//    public void setEmail(String email) {
//        this.email = email;
//    }
//
//
//    public boolean registerAccount() {
//
//        // kiểm tra username
//        if (username == null || username.trim().isEmpty()) {
//            return false; // đăng ký không thành công
//        }
//
//        // kiểm tra password (> 6 ký tự)
//        if (password == null || password.length() <= 6) {
//            return false;
//        }
//
//
//
//        // kiểm tra email
//        if (!isValidEmail(email)) {
//            return false;
//        }
//
//        // hợp lệ tất cả
//        return true; // đăng ký thành công
//    }
//
//    // ===== Kiểm tra email hợp lệ =====
//    public boolean isValidEmail(String email) {
//        if (email == null || email.trim().isEmpty()) {
//            return false;
//        }
//        return email.matches("^[A-Za-z0-9+_.-]+@(.+)$");
//    }
//}

public class AccountService {

    private String username;
    private String password;
    private String email;

    // ===== Getter & Setter =====
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    // ===== Hàm đăng ký tài khoản =====
    public boolean registerAccount() {

        // 1. Username: ít nhất 3 ký tự
        if (username == null || username.trim().length() < 3) {
            return false;
        }

        // 2. Password: > 6 ký tự, có hoa, thường, đặc biệt
        if (!isValidPassword(password)) {
            return false;
        }

        // 3. Email hợp lệ
        if (!isValidEmail(email)) {
            return false;
        }

        return true; // đăng ký thành công
    }

    // ===== Kiểm tra password =====
    private boolean isValidPassword(String password) {
        if (password == null || password.length() <= 6) {
            return false;
        }

        boolean hasUpper = password.matches(".*[A-Z].*");
        boolean hasLower = password.matches(".*[a-z].*");
        boolean hasSpecial = password.matches(".*[^a-zA-Z0-9].*");

        return hasUpper && hasLower && hasSpecial;
    }

    // ===== Kiểm tra email =====
    public boolean isValidEmail(String email) {
        if (email == null || email.trim().isEmpty()) {
            return false;
        }

        return email.matches("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$");
    }
}
