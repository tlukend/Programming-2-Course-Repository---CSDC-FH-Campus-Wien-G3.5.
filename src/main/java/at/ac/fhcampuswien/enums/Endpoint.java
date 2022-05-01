package at.ac.fhcampuswien.enums;

public enum Endpoint {
    EVERYTHING("https://newsapi.org/v2/everything"),
    TOP_HEADLINES("https://newsapi.org/v2/top-headlines");

    private String url;
    public String getUrl() { return url; }

    Endpoint(String url)
    {
        this.url = url;
    }
}
