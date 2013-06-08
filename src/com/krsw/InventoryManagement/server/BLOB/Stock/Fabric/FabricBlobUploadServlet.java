package com.krsw.InventoryManagement.server.BLOB.Stock.Fabric;
import java.io.IOException;
import java.util.Date;
import java.util.Map;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.google.appengine.api.blobstore.BlobKey;
import com.google.appengine.api.blobstore.BlobstoreService;
import com.google.appengine.api.blobstore.BlobstoreServiceFactory;
import com.google.appengine.api.datastore.DatastoreService;
import com.google.appengine.api.datastore.DatastoreServiceFactory;
import com.google.appengine.api.datastore.Entity;
import com.google.appengine.api.images.ImagesService;
import com.google.appengine.api.images.ImagesServiceFactory;

@SuppressWarnings("serial")
public class FabricBlobUploadServlet extends HttpServlet{
	private static final Logger log = Logger.getLogger(FabricBlobUploadServlet.class.getName());
	private BlobstoreService blobstoreService = BlobstoreServiceFactory.getBlobstoreService();
//	final DateTimeFormat formati18 = DateTimeFormat.getFormat("yyyy年MM月dd日 hh時mm分ss秒");
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{
		@SuppressWarnings("rawtypes")
		Map blobs = blobstoreService.getUploadedBlobs(req);
		BlobKey blobkey = (BlobKey) blobs.get("image");


		if(blobkey == null){

		}else{
			ImagesService imagesService = ImagesServiceFactory.getImagesService();
			String imageUrl = imagesService.getServingUrl(blobkey);

			Entity uploadedImage = new Entity("FabricBlobUploadedImage");
			uploadedImage.setProperty("blobkey", blobkey);
			uploadedImage.setProperty("createdAt", new Date());


			uploadedImage.setUnindexedProperty("servingUrl", imageUrl);
			DatastoreService datastore = DatastoreServiceFactory.getDatastoreService();
			datastore.put(uploadedImage);
			res.sendRedirect("/FabricUpload?imageUrl=" + imageUrl);
		}
	}
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String imageUrl = req.getParameter("imageUrl");
		resp.setHeader("Content-Type", "text/html");
		resp.getWriter().println(imageUrl);
	}
}
