
package utils.download;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletResponse;
import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URLEncoder;

public class DownloadUtil {
    private static final Logger LOGGER = LoggerFactory.getLogger(DownloadUtil.class);

    public static HttpServletResponse download(ByteArrayOutputStream out, HttpServletResponse response) {
        return download(out, response, System.currentTimeMillis() + "");
    }

    public static HttpServletResponse download(ByteArrayOutputStream out, HttpServletResponse response, String fileName) {
        try {

            // 设置response的Header
            response.addHeader("Content-Disposition", "attachment;filename=" + URLEncoder.encode(fileName, "UTF-8").replaceAll("\\+", "%20")  + ".xlsx");
            OutputStream toClient = new BufferedOutputStream(response.getOutputStream());
            response.setContentType("application/msexcel");
            toClient.write(out.toByteArray());
            toClient.flush();
            toClient.close();

        } catch (IOException ex) {
            LOGGER.error(ex.getMessage());

        }
        return response;
    }

}
