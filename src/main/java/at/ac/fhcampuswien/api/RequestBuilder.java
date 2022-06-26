package at.ac.fhcampuswien.api;

import at.ac.fhcampuswien.enums.*;
import io.github.cdimascio.dotenv.Dotenv;
import okhttp3.Request;

//Die Klasse stellt eine Schnittstelle, zwischen Parametern und NEWS API bereit,
// Parameter die wir in News API benötigen wird in Builder gespeichert
public class RequestBuilder {
    public static final String DELIMITER = "&";
    private static final String DEFAULT_API_URL = "https://newsapi.org/v2/%s?q=%s&apiKey=%s";
    private static final String DEFAULT_API_KEY = Dotenv.load().get("API_TOKEN");   // read token from .env file -> add .env to .gitignore!!!
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
    private String url;
    private String apiKey;

    public RequestBuilder(String q, Endpoint endpoint){
        this.q=q;
        this.endpoint=endpoint;
        this.url = DEFAULT_API_URL;
        this.apiKey = DEFAULT_API_KEY;
    }

    public RequestBuilder apiKey(String key) {
        this.apiKey = key;
        return this;
    }

    public RequestBuilder url(String url) {
        this.url = url;
        return this;
    }

    public RequestBuilder qInTitle(String qInTitle) {
        this.qInTitle = qInTitle;
        return this;
    }

    public RequestBuilder from(String from) {
        this.from = from;
        return this;
    }

    public RequestBuilder domains(String domains) {
        this.domains = domains;
        return this;
    }

    public RequestBuilder excludeDomains(String excludedDomains) {
        this.excludeDomains = excludedDomains;
        return this;
    }

    public RequestBuilder to(String to) {
        this.to = to;
        return this;
    }

    public RequestBuilder page(String page) {
        this.page = page;
        return this;
    }

    public RequestBuilder pageSize(String pageSize) {
        this.pageSize = pageSize;
        return this;
    }

    public RequestBuilder endpoint(Endpoint endpoint) {
        this.endpoint=endpoint;
        return this;
    }

    public RequestBuilder country(Country country) {
        sourceCountry=country;
        return this;
    }

    public RequestBuilder sortBy(SortBy sortby) {
        this.sortBy = sortby;
        return this;
    }

    public RequestBuilder category(Category category) {
        this.sourceCategory = category;
        return this;
    }

    public RequestBuilder language(Language language) {
        this.language= language;
        return this;
    }

    public String getURL() { return url; }
    public String getQ() { return q; }
    public String getqInTitle() { return qInTitle; }
    public Country getSourceCountry() { return sourceCountry; }
    public Category getSourceCategory() { return sourceCategory; }
    public String getDomains() { return domains; }
    public String getExcludeDomains() { return excludeDomains; }
    public String getFrom() { return from; }
    public String getTo() { return to; }
    public Language getLanguage() { return language; }
    public SortBy getSortBy() { return sortBy; }
    public String getPageSize() { return pageSize; }
    public String getPage() { return page; }

    public Endpoint getEndpoint() {
        return endpoint;
    }

    private String buildUrl() {
        String baseurl = String.format(url, getEndpoint().getValue(), getQ(), apiKey);

        StringBuilder sb = new StringBuilder(baseurl);

        if (getFrom() != null) {
            sb.append(DELIMITER).append("from=").append(getFrom());
        }
        if (getTo() != null) {
            sb.append(DELIMITER).append("to=").append(getTo());
        }
        if (getPage() != null) {
            sb.append(DELIMITER).append("page=").append(getPage());
        }
        if (getPageSize() != null) {
            sb.append(DELIMITER).append("pageSize=").append(getPageSize());
        }
        if (getLanguage() != null) {
            sb.append(DELIMITER).append("language=").append(getLanguage());
        }
        if (getSourceCountry() != null) {
            sb.append(DELIMITER).append("country=").append(getSourceCountry());
        }
        if (getSourceCategory() != null) {
            sb.append(DELIMITER).append("category=").append(getSourceCategory());
        }
        if (getDomains() != null) {
            sb.append(DELIMITER).append("domains=").append(getDomains());
        }
        if (getExcludeDomains() != null) {
            sb.append(DELIMITER).append("excludeDomains=").append(getExcludeDomains());
        }
        if (getqInTitle() != null) {
            sb.append(DELIMITER).append("qInTitle=").append(getqInTitle());
        }
        if (getSortBy() != null) {
            sb.append(DELIMITER).append("sortBy=").append(getSortBy().getValue());
        }

        return sb.toString();
    }

    public Request build() {
        return new Request.Builder()
                .url(buildUrl())
                .build();
    }
}
