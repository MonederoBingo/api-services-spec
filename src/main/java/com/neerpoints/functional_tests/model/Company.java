package com.neerpoints.functional_tests.model;

public class Company {
    private long _companyId;
    private String _name;
    private String _urlImageLogo;

    public long getCompanyId() {
        return _companyId;
    }

    public void setCompanyId(long companyId) {
        _companyId = companyId;
    }

    public String getName() {
        return _name;
    }

    public void setName(String name) {
        _name = name;
    }

    public String getUrlImageLogo() {
        return _urlImageLogo;
    }

    public void setUrlImageLogo(String urlImageLogo) {
        _urlImageLogo = urlImageLogo;
    }
}
