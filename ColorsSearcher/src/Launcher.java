import java.net.MalformedURLException;
import java.net.URL;

public class Launcher {
    public static void main(String[] args) throws MalformedURLException {
        ColorsSearcher t = new ColorsSearcher();
        URL url = new URL("http://lib.ru/MILN/pooh.txt");
        for(String f : t.parse(url)) System.out.println(f);
    }
}
