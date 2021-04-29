/**
 * 
 */
package utils;

import org.apache.commons.lang3.StringUtils;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;

public class FileUtils {

	/**
	 * 从网络Url中下载文件
	 *
	 * @param urlStr
	 * @param fileName
	 * @param inputSavePath
	 * @throws IOException
	 */
	public static File getFileFormUrl(String urlStr, String fileName, String inputSavePath) throws IOException {
		return getFileFormUrl(urlStr, fileName, inputSavePath, null);
	}

	/**
	 * 从网络Url中下载文件
	 * 
	 * @param urlStr
	 * @param fileName
	 * @param inputSavePath
	 * @param suffix 后缀名，如果文件名称为null时，使用suffix作为后缀名
	 * @throws IOException
	 */
	public static File getFileFormUrl(String urlStr, String fileName, String inputSavePath, String suffix) throws IOException {

		if (StringUtils.isEmpty(urlStr)) {
			return null;
		}
		
//		RestTemplate template = new RestTemplate();
//		byte[] bytes = (byte[]) template.exchange(urlStr, HttpMethod.GET, null, byte[].class);

		String finalFileName = StringUtils.isEmpty(fileName) ? System.currentTimeMillis() + (null == suffix ? "" : "."+suffix) : fileName;


		String savePath = inputSavePath;
		if (StringUtils.isBlank(inputSavePath)) {
			savePath = getTmpDirPath();
		}

		URL url = new URL(urlStr);
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();

		// 设置超时间为5秒
		conn.setConnectTimeout(5000);
		conn.setReadTimeout(10000);
		conn.setDoInput(true);
		conn.setRequestMethod("GET");

		// 防止屏蔽程序抓取而返回403错误
		conn.setRequestProperty("User-Agent", "Mozilla/4.0 (compatible; MSIE 5.0; Windows NT; DigExt)");

		// 得到输入流
		InputStream inputStream = conn.getInputStream();
		// 获取自己数组
		byte[] getData = readInputStream(inputStream);

		// 文件保存位置
		File saveDir = new File(savePath);
		if (!saveDir.exists()) {
			saveDir.mkdirs();
		}

		File file = new File(saveDir + File.separator + finalFileName);
		FileOutputStream fos = new FileOutputStream(file);
		fos.write(getData);
		if (fos != null) {
			fos.close();
		}

		if (inputStream != null) {
			inputStream.close();
		}

		return file;
	}

	public static File getFileFormUrl(String urlStr, String fileName) throws IOException {
		return getFileFormUrl(urlStr, fileName, null, null);
	}

	/**
	 * 从输入流中获取字节数组
	 * 
	 * @param inputStream
	 * @return
	 * @throws IOException
	 */
	public static byte[] readInputStream(InputStream inputStream) throws IOException {
		byte[] buffer = new byte[1024];
		int len = 0;
		ByteArrayOutputStream bos = new ByteArrayOutputStream();
		while ((len = inputStream.read(buffer)) != -1) {
			bos.write(buffer, 0, len);
		}

		bos.close();

		return bos.toByteArray();
	}

	/**
	 * @Description: 根据路径和名称获取文件
	 *
	 * @version: v1.0.0
	 * @author: 黄明波
	 * @date: 2018年6月26日 下午2:34:13
	 *
	 */
	public static File createFile(String inputSavePath, String fileName) throws IOException {

		String savePath = inputSavePath;
		if (StringUtils.isBlank(inputSavePath)) {
			savePath = getTmpDirPath();
		}

		// 文件保存位置
		File saveDir = new File(savePath);
		if (!saveDir.exists()) {
			saveDir.mkdirs();
		}

		// 创建文件
		File file = new File(saveDir + File.separator + fileName);
		if (file.exists()) {
			file.delete();
		}

		file.createNewFile();
		return file;
	}

	/**
	 * 获取一个缓存目录
	 * 
	 * @return
	 */
	public static String getTmpDirPath() {

		StringBuffer tmpdirBuffer = new StringBuffer(System.getProperty("java.io.tmpdir"));
		Long currentMillisecond = System.currentTimeMillis();
		tmpdirBuffer.append(File.separator);
		tmpdirBuffer.append(currentMillisecond);

		// 附件目录
		File baseDir = new File(tmpdirBuffer.toString());
		if (!baseDir.exists()) {
			baseDir.mkdirs();
		}

		return tmpdirBuffer.toString();
	}
	
	

	 /** 
    * 获得指定文件的byte数组 
	 * @throws IOException 
    */  
	public static byte[] getBytes(File file) throws IOException {

		byte[] buffer = null;

		FileInputStream fis = new FileInputStream(file);

		ByteArrayOutputStream bos = new ByteArrayOutputStream();
		byte[] b = new byte[1000];
		int n;
		while ((n = fis.read(b)) != -1) {
			bos.write(b, 0, n);
		}

		fis.close();
		bos.close();

		buffer = bos.toByteArray();

		return buffer;
	}

	public static byte[] getBytes(String fileUrl) throws IOException {

		if (StringUtils.isEmpty(fileUrl)) {
			return null;
		}

		URL url = new URL(fileUrl);
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();

		// 设置超时间为5秒
		conn.setConnectTimeout(5000);
		conn.setReadTimeout(10000);
		conn.setDoInput(true);
		conn.setRequestMethod("GET");

		// 防止屏蔽程序抓取而返回403错误
		conn.setRequestProperty("User-Agent", "Mozilla/4.0 (compatible; MSIE 5.0; Windows NT; DigExt)");

		// 得到输入流
		InputStream inputStream = conn.getInputStream();

		byte[] ret = readInputStream(inputStream);

		if (inputStream != null) {
			inputStream.close();
		}

		// 获取自己数组
		return  ret;
	}

}
