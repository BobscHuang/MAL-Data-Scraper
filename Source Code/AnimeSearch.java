import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import java.io.IOException;

public class AnimeSearch {

    public static String animeLinkSearch(String title) throws IOException {
        String searchURL = "https://www.google.com/search?q=site:https://myanimelist.net/anime " + title;
        Document doc = Jsoup.connect(searchURL).userAgent("Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/70.0.3538.77 Safari/537.36").referrer("http://www.google.com").get();
        Element links = doc.getElementsByClass("r").select("a[href]").first();
        return links.attr("href");
    }

    public static Anime animeSearch(String title) throws Exception {
        String url = animeLinkSearch(title);
        String[] extra = new String[] {"/reviews", "/characters", "/stats", "/forum", "/videos", "/userrecs"};
        for (String h: extra) {
            url = url.replace(h, "");
        }
        URLReaderAnimeInfo info = new URLReaderAnimeInfo(url);
        return info.makeAnime();
    }
}
