package selenium;

public enum Urls {
    MAIN("https://www.epam.com/"), POLSKA("https://careers.epam-poland.pl/"),
    CONTACT_US("https://www.epam.com/about/who-we-are/contact"),
    EVENT_PAGE("https://www.epam.com/about/who-we-are/events"),
    SECURITY_PAGE("https://www.epam.com/services/consult-and-design/enterprise-technology-and-operations-transformation/cybersecurity"),
    POLICY("https://www.epam.com/privacy-policy"), FAQ("https://investors.epam.com/investors/faq"),
    BY_CAREERS("https://careers.epam.by/");

    private String url;

    Urls(String url) {
        this.url = url;
    }


    @Override
    public String toString() {
        return this.url;
    }
}
