package cm;

import java.io.FileOutputStream;
import java.io.OutputStream;
import java.net.URI;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static <T> URI  getJarPath(Class<T> m ) throws Exception{
        String url=m.getResource("").toString();
        Pattern p=Pattern.compile("(?<=file:).*?((?=[^/]+\\.jar)|(?=/$)|$)");
        Matcher matcher=p.matcher(url);
        if(matcher.find()){
            List<String> segmentations=new ArrayList<String>( Arrays.asList(matcher.group().split("/")) );
            int existsClasses=segmentations.lastIndexOf("classes");
            if(existsClasses>=0)segmentations=segmentations.subList(0,existsClasses);
            String result=String.join("/",segmentations);
            int resultLength=result.length();
            if(!result.substring(resultLength-1,resultLength).equals("/"))result+="/";
            return new URI(result);
        }
        return null;
    }

    public static void main(String[] args)throws Exception{
        URI jarPath=getJarPath(new Main().getClass());

        OutputStream outputStream= new FileOutputStream(jarPath.resolve("1.xml").toString());
        System.out.println(outputStream);
    }
}
