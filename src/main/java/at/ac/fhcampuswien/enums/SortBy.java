package at.ac.fhcampuswien.enums;

public enum SortBy {
    RELEVANCY("relevancy"), POPULARITY("popularity"), PUBLISHED("publishedAt");

    //relevancy = articles more closely related to q come first.
    //popularity = articles from popular sources and publishers come first.
    //publishedAt = newest articles come first.

    private final String sortBy;

    SortBy(String sortBy) {
        this.sortBy = sortBy;
    }

    public String getValue() {
        return sortBy;
    }
}