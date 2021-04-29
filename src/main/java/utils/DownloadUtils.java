package utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class DownloadUtils {

    private static final Logger LOGGER = LoggerFactory.getLogger(DownloadUtils.class);

    public static HttpServletResponse download(ByteArrayOutputStream out, HttpServletResponse response) {
        try {
            // 清空response
            //response.reset();
            // 设置response的Header
            response.addHeader("Content-Disposition", "attachment;filename=" + System.currentTimeMillis()+".xlsx");
            //response.addHeader("Content-Length", "" + out.);
            OutputStream toClient = new BufferedOutputStream(response.getOutputStream());
            response.setContentType("application/octet-stream");
            toClient.write(out.toByteArray());
            toClient.flush();
            toClient.close();

        } catch (IOException ex) {
            LOGGER.error(ex.getMessage());
        }
        return response;
    }

    public static HttpServletResponse downloadXls(ByteArrayOutputStream out, HttpServletResponse response) {
        try {
            // 清空response
            //response.reset();
            // 设置response的Header
            response.addHeader("Content-Disposition", "attachment;filename=" + System.currentTimeMillis()+".xls");
            //response.addHeader("Content-Length", "" + out.);
            OutputStream toClient = new BufferedOutputStream(response.getOutputStream());
            response.setContentType("application/octet-stream");
            toClient.write(out.toByteArray());
            toClient.flush();
            toClient.close();

        } catch (IOException ex) {
            LOGGER.error(ex.getMessage());
        }
        return response;
    }

    public static HttpServletResponse download(ByteArrayOutputStream out, HttpServletResponse response, String fileName) {
        OutputStream toClient = null;

        try {
            toClient = new BufferedOutputStream(response.getOutputStream());
            // 清空response
            //response.reset();
            // 设置response的Header
            response.addHeader("Content-Disposition", "attachment;filename=" + new String(fileName.getBytes("gbk"), "iso8859-1")+".xlsx");
            //response.addHeader("Content-Length", "" + out.);
            response.setContentType("application/octet-stream");
            toClient.write(out.toByteArray());
            toClient.flush();

        } catch (IOException ex) {
            LOGGER.error(ex.getMessage());
        } finally {
            try {
                if (toClient != null) {
                    toClient.close();
                }
            } catch (IOException e) {
                LOGGER.error(e.getMessage());
            }

        }
        return response;
    }



    public static HttpServletResponse download(ByteArrayOutputStream out, HttpServletResponse response, String fileName,String charSet) {
        OutputStream toClient = null;

        try {
            toClient = new BufferedOutputStream(response.getOutputStream());
            // 清空response
            //response.reset();
            // 设置response的Header
            response.addHeader("Content-Disposition", "attachment;filename=" + new String(fileName.getBytes(), charSet)+".xlsx");
            //response.addHeader("Content-Length", "" + out.);
            response.setContentType("application/octet-stream");
            toClient.write(out.toByteArray());
            toClient.flush();

        } catch (IOException ex) {
            LOGGER.error(ex.getMessage());
        } finally {
            try {
                if (toClient != null) {
                    toClient.close();
                }
            } catch (IOException e) {
                LOGGER.error(e.getMessage());
            }

        }
        return response;
    }



    public static String writeZip(List<String> files, String zipName) {
        try {
            OutputStream os = new BufferedOutputStream( new FileOutputStream(zipName) );
            ZipOutputStream zos = new ZipOutputStream( os );
            byte[] buf = new byte[8192];
            int len;
            for ( String filename : files ) {
                File file = new File(filename);
                if ( !file.isFile() ) {
                    LOGGER.info("filename:{} is not a file", filename);
                    continue;
                }
                ZipEntry ze = new ZipEntry( file.getName() );
                zos.putNextEntry( ze );
                BufferedInputStream bis = new BufferedInputStream( new FileInputStream( file ) );
                while ( ( len = bis.read( buf ) ) > 0 ) {
                    zos.write( buf, 0, len );
                }
                zos.closeEntry();
                bis.close();
                // 读取完成删除文件
                if (file.isFile() && file.exists()) {
                    file.delete();
                }
            }
            zos.close();

            return zipName;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;

    }

}
