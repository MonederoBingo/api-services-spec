package com.neerpoints.functional_tests.model;

public class CompanyRegistration {
    private String _companyName;
    private String _urlImageLogo;
    private String _userName;
    private String _email;
    private String _password;

    public String getCompanyName() {
        return _companyName;
    }

    public void setCompanyName(String companyName) {
        _companyName = companyName;
    }

    public String getUrlImageLogo() {
        return _urlImageLogo;
    }

    public void setUrlImageLogo(String urlImageLogo) {
        _urlImageLogo = urlImageLogo;
    }

    public String getUserName() {
        return _userName;
    }

    public void setUserName(String userName) {
        _userName = userName;
    }

    public String getEmail() {
        return _email;
    }

    public void setEmail(String email) {
        _email = email;
    }

    public String getPassword() {
        return _password;
    }

    public void setPassword(String password) {
        _password = password;
    }
}
