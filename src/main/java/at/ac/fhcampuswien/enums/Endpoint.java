package at.ac.fhcampuswien.enums;

public enum Endpoint {
    TOP_HEADLINES("top-headlines"),

    EVERYTHING("everything");

    private final String endPoint;

    Endpoint(String endPoint){
        this.endPoint = endPoint;
    }

    public String getValue() {
        return endPoint;
    }
    // everything kein county, kein q , kein category
    // top-headlines: alles erlaubt
}
