package krzysek.amao.webconnector.example;

import krzysek.amao.webconnector.WebConnector;

import java.net.MalformedURLException;
import java.net.URL;

public class Example {

    protected static WebConnector webcon;

    public static void main(String[] args) {
        try {
            webcon = new WebConnector(new URL("https://raw.githubusercontent.com/loonypl/ExParkour/master/src/io/github/krzysek/expk/ExParkour.java"));
            webcon.connect();
            System.out.println("Example class has returned value:\n" + webcon.read());
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

    }

}
