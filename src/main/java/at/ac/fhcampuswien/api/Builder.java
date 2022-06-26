package at.ac.fhcampuswien.api;

import at.ac.fhcampuswien.enums.*;
//Die Klasse stellt eine Schnittstelle, zwischen Parametern und NEWS API bereit,
// Parameter die wir in News API benötigen wird in Builder gespeichert
public  class Builder {
    private Endpoint endpoint;
    private String q;
    private String qInTitle;
    private Country sourceCountry;
    private Category sourceCategory;
    private String domains;
    private String excludeDomains;
    private String from;
    private String to;
    private Language language;
    private SortBy sortBy;
    private String pageSize;
    private String page;

    public Builder (String q, Endpoint endpoint){
        this.q=q;
        this.endpoint=endpoint;
    }

    public Builder endpoint(Endpoint endpoint) {
        this.endpoint=endpoint;
        return this;
    }

    public Builder country(Country country) {
        sourceCountry=country;
        return this;
    }

    public Builder sortBy(SortBy sortby) {
        this.sortBy = sortby;
        return this;
    }

    public Builder category(Category category) {
        this.sourceCategory = category;
        return this;
    }

    public Builder language(Language language) {
        this.language= language;
        return this;
    }

    public String getQ() {
        return q;
    }

    public String getqInTitle() {
        return qInTitle;
    }

    public Country getSourceCountry() {
        return sourceCountry;
    }

    public Category getSourceCategory() {
        return sourceCategory;
    }

    public String getDomains() {
        return domains;
    }

    public String getExcludeDomains() {
        return excludeDomains;
    }

    public String getFrom() {
        return from;
    }

    public String getTo() {
        return to;
    }

    public Language getLanguage() {
        return language;
    }

    public SortBy getSortBy() {
        return sortBy;
    }

    public String getPageSize() {
        return pageSize;
    }

    public String getPage() {
        return page;
    }

    public Endpoint getEndpoint() {
        return endpoint;
    }
}
