package user;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;
//we use this packages to generate the QR codes needed for authentication of transactions
import net.glxn.qrgen.QRCode;
import net.glxn.qrgen.image.ImageType;
/**
 * Developed with help from https://youtu.be/yFpkdkibvfg
 */

/**
 * @author Ralph
 *Function to 
 */
public class CodeGen {

	/**
	 * @param args
	 * Generates the QRcode based on the child user and the authorized patent guarding who is the admin of the system.
	 */
	public static String QRgenerator(String userName, String childID) throws Exception{
		// TODO Auto-generated method stub
		//get date and time
		SimpleDateFormat crtDate = new SimpleDateFormat("HH:mm:ss"+"_"+"yyyy-MM-dd");
		Date current = new Date();
		String strCurDate = crtDate.format(current);
		//encode the given code into QRcode
		//QR generation
		ByteArrayOutputStream outcode = QRCode.from(userName + "_" + childID + " on " + strCurDate.toString()).to(ImageType.PNG).stream();
		//get random int
		int Min = 1111;
		int Max = 9999;
		int RandomInt = Min + (int)(Math.random() * ((Max - Min) + 1));
		File CodeFile = new File("C:\\Users\\Ralph\\Desktop\\final\\Bits\\FinTech\\FinTechProject\\src\\QRcodes\\" + (Integer.toString(RandomInt)) + userName + childID + ".png");
		FileOutputStream CodeFileGen = new FileOutputStream(CodeFile);
		
		CodeFileGen.write(outcode.toByteArray());
		CodeFileGen.flush();
		
		return "C:\\Users\\Ralph\\Desktop\\final\\Bits\\FinTech\\FinTechProject\\src\\QRcodes\\" + (Integer.toString(RandomInt)) + userName + childID + ".png" ;

	}
	public static void main(String[] args) throws Exception{
//		String retailID = "7685ot567";
//		String userName = "SamsonLal10";
//		String childID = "RalphSamsonLal13";
//		
//		CodeGen QR = new CodeGen();
//		QR.QRgenerator(retailID, userName, childID);
//		System.out.println("QR created");
		
		
	}

}
