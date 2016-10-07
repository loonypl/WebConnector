package krzysek.amao.webconnector;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

public class WebConnector {

    protected URL url;
    protected URLConnection urlConnection;

    public WebConnector(final URL url) {
        this.url = url;
    }

    public final void connect() {
        try {
            urlConnection = this.url.openConnection();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public final String read() {
        try {
            InputStream in = urlConnection.getInputStream();
            String encode = urlConnection.getContentEncoding();
            encode = encode == null ? "UTF-8" : encode;
            ByteArrayOutputStream out = new ByteArrayOutputStream();
            byte[] buf = new byte[8192];
            int len = 0;
            while((len = in.read(buf)) != -1)
                out.write(buf, 0, len);
            return new String(out.toByteArray(), encode);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

}
