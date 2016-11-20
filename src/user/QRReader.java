package user;
// These packages will be used to read the QR codes created by our system, for authentication purposes
import java.io.FileInputStream;
import javax.imageio.ImageIO;
 
import com.google.zxing.BinaryBitmap;
import com.google.zxing.MultiFormatReader;
import com.google.zxing.Result;
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
import com.google.zxing.common.HybridBinarizer;
 
//QRs are being used at this segment to show a proof of concept for dual factor authentication of purchases
//and a way of notifying the QwickTran system of transactions that need to be sent as a text to the user
public class QRReader {
 
public static String QRread(String QR_path){

	Result result = null;
	BinaryBitmap binaryBitmap;

	try{

		binaryBitmap = new BinaryBitmap(new HybridBinarizer(new BufferedImageLuminanceSource(ImageIO.read(new FileInputStream(QR_path)))));
		result = new MultiFormatReader().decode(binaryBitmap);
		System.out.println("QR Code : "+result.getText());
		//return result.getText();
	}catch(Exception ex){
		ex.printStackTrace();
	}
	return result.getText();
}
}