import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class URLReaderAnimeInfo {
    String url;
    Document html;
    String title;
    String[] infoHtml;

    public URLReaderAnimeInfo(String url) throws Exception {
        this.url = url;
        this.html = getHTML();
        this.title = getTitle();
        this.infoHtml = getInfoHTML();
    }

    private Document getHTML() throws Exception {
        Document doc = Jsoup.connect(this.url).get();
        Thread.sleep(600);
        return doc;
    }

    private String[] getInfoHTML() {
        Element info = this.html.select("div.js-scrollfix-bottom").first();
        return info.html().split("<br>");
    }

    private String getTitle() {
        return this.html.title().split(" - MyAnimeList.net")[0];
    }

    public Anime makeAnime() {
        Document doc = Jsoup.parse(this.infoHtml[this.infoHtml.length - 1].replaceAll(",", ""));
        Elements scoreEle = doc.select("[itemprop=ratingValue]");
        Elements votesEle = doc.select("[itemprop=ratingCount]");
        Elements synEle = this.html.select("[itemprop=description]");
        String docText = doc.text();

        float score = Float.parseFloat(scoreEle.text());
        int votes = Integer.parseInt(votesEle.text());
        String syn = synEle.text().replace(" [Written by MAL Rewrite]", "");
        String rank = docText.split("Ranked: ")[1].split(" ")[0];
        String pop = docText.split("Popularity: ")[1].split(" ")[0];
        int mem = Integer.parseInt(docText.split("Members: ")[1].split(" ")[0]);
        int fav = Integer.parseInt(docText.split("Favorites: ")[1].split(" ")[0]);

        doc = Jsoup.parse(this.infoHtml[2]);
        String parsedText = doc.text();
        String type = parsedText.split("Type: ")[1].split(" ")[0];
        String eps = parsedText.split("Episodes: ")[1].split(" ")[0];
        String gen = parsedText.split("Genres: | Duration:")[1];

        return new Anime(this.url, this.title, type, eps, gen, score, votes, rank, pop, mem, fav, syn);
    }

}
