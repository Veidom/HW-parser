import java.io.*;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashSet;

public class ColorsSearcher {
    private HashSet<String> colors;

    ColorsSearcher() {
        colors = new HashSet<>();
        try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("resources/colors.txt")))) {
            br.lines().forEach(colors::add);
        } catch (FileNotFoundException e){
            e.printStackTrace();
            System.out.println("Resources file is failed");
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Something is broken");
        }
    }

    public ArrayList<String> parse (URL url){
        ArrayList<String> list = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new InputStreamReader(url.openStream()))) {
            String t;
            while ((t = br.readLine()) != null)
                for (String tmp : t.split("\\W+"))
                    if(colors.contains(tmp.toLowerCase())) list.add(tmp.toLowerCase());

        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Something is broken");
        }
        return list;
    }
}
