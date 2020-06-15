package Project.pojo;

public class Publish {
    public String urlname;
    public String purl;

    public Publish() {}

    public Publish(String urlname, String purl) {
        this.urlname = urlname;
        this.purl = purl;
    }

    public void setUrlname(String urlname) {
        this.urlname = urlname;
    }

    public void setPurl(String purl) {
        this.purl = purl;
    }

    public String getUrlname() {
        return urlname;
    }

    public String getPurl() {
        return purl;
    }

    @Override
    public String toString() {
        return "Publish{" +
                "urlname='" + urlname + '\'' +
                ", purl='" + purl + '\'' +
                '}';
    }
}
