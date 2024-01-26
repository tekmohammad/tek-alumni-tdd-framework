package tek.api.modal;

public class TokenResponse {
    private String username;
    private String fullName;
    private String token;
    public TokenResponse() {}

    public TokenResponse(String username, String fullName, String token) {
        this.username = username;
        this.fullName = fullName;
        this.token = token;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
