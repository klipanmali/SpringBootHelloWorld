package my.springboot.hello.fileupload;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.mime.MultipartEntity;
import org.apache.http.entity.mime.content.InputStreamBody;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.util.EntityUtils;

// https://javatutorial.net/java-file-upload-rest-service
public class FileUploadClient {

	public static void main(String[] args) {

		File inFile = new File("C:\\temp\\wct2B06.tmp");
		FileInputStream fis = null;
		try {
			fis = new FileInputStream(inFile);
			DefaultHttpClient httpClient = new DefaultHttpClient(new BasicHttpParams());

			HttpPost httpPost = new HttpPost("http://localhost:8080/file/upload");
			MultipartEntity entity = new MultipartEntity();
			entity.addPart("file", new InputStreamBody(fis, inFile.getName()));
			httpPost.setEntity(entity);

			System.out.println("Uploading file ...");
			HttpResponse response = httpClient.execute(httpPost);

			int statusCode = response.getStatusLine().getStatusCode();
			HttpEntity responseEntity = response.getEntity();
			String responseString = EntityUtils.toString(responseEntity, "UTF-8");
			System.out.println("[" + statusCode + "] " + responseString);
		} catch (ClientProtocolException e) {
			System.err.println("Unable to make connection");
			e.printStackTrace();
		} catch (IOException e) {
			System.err.println("Unable to read file");
			e.printStackTrace();
		} finally {
			try {
				if (fis != null)
					fis.close();
			} catch (IOException e) {

			}
		}

	}

}
