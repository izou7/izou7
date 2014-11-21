package cn.chinattclub.izou7.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import java.io.FileInputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Properties;

import javax.annotation.Resource;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Component;
import org.apache.pdfbox.pdfparser.PDFParser;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.util.PDFTextStripper;
import org.apache.poi.POIXMLDocument;
import org.apache.poi.POIXMLTextExtractor;
import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.xwpf.extractor.XWPFWordExtractor;
import org.apache.poi.hwpf.HWPFDocument;
import org.apache.poi.hwpf.extractor.WordExtractor;

import cn.chinattclub.izou7.entity.User;
import cn.chinattclub.izou7.service.UserService;



/**
 * TODO 通用工具类
 *
 * @author zhangying.
 *         Created 2014-4-18.
 */
@Component
public class CommonUtil {
	
	public static  DateFormat df = new SimpleDateFormat("yyyyMMdd");
	private static UserService userService;
	
	@Resource
	public void setUserService(UserService userService) {
		CommonUtil.userService = userService;
	}
	
	public static User getCurrentUser(){
		Subject currentUser = SecurityUtils.getSubject();
		String username = currentUser.getPrincipal().toString();
		return userService.findByUsername(username);
	}
	
	
	private static String getTextFromDocx(String fileName){
		String ret = null;
		POIXMLTextExtractor extractor = null;
		try{
			OPCPackage opcPackage = POIXMLDocument.openPackage(fileName);
			extractor = new XWPFWordExtractor(opcPackage); 
			ret = extractor.getText();
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try {
				extractor.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return ret;
	}
	
	private static String getTextFromDoc(String fileName){
		String ret = null;
		FileInputStream fileInputStream = null;
		WordExtractor wordExtractor = null;
		try{
			fileInputStream = new FileInputStream(new File(fileName));
			HWPFDocument doc = new HWPFDocument(fileInputStream);
			wordExtractor = new WordExtractor(doc);
			ret = wordExtractor.getText();
			
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try {
				wordExtractor.close();
				fileInputStream.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return ret;
	}
	
	private static String getTextFromTxt(String fileName){
		String ret = null;
		BufferedReader reader = null;
		try{
			File file = new File(fileName);
			reader = new BufferedReader(new FileReader(file));
			String tempString = null;
			String str = "";
			while((tempString = reader.readLine()) != null) {
				str += tempString+"\n";
			}
			ret = str;
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try {
				reader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return ret;
	}
	
	private static String getTextFromPdf(String fileName){
		String ret = null;
		FileInputStream fileInputStream = null;
		PDDocument document = null;
		try{
			fileInputStream = new FileInputStream (fileName);
			PDFParser parser = new PDFParser(fileInputStream);
			parser.parse();
			document = parser.getPDDocument();
			PDFTextStripper stripper = new PDFTextStripper();
			ret = stripper.getText(document);
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try {
				fileInputStream.close();
				document.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return ret;
	}
	
	public static String getTextFromFile(String fileName){
		String ext = fileName.substring(fileName.lastIndexOf('.'));
		
		switch(ext){
			case ".doc":
				return getTextFromDoc(fileName);
			case ".docx":
				return getTextFromDocx(fileName);
			case ".txt":
				return getTextFromTxt(fileName);
			case ".pdf":
				return getTextFromPdf(fileName);
			default:
				return null;
		}
	}
	
	public static void sendEmail(String title, String data, String reciever){
		String hostName = "smtp.exmail.qq.com";
		String sender = "limonan@videoworks.cn";
		String username = "limonan@videoworks.cn";
		String password = "teleport123@beta1";
		
		Properties props = System.getProperties();
		props.put("mail.smtp.host",hostName);
		
		Session session = Session.getDefaultInstance(props,null);
		MimeMessage mimeMsg = new MimeMessage(session);
		
		try{
			mimeMsg.setSubject(title); //设置标题
			mimeMsg.setFrom(new InternetAddress(sender)); //设置发信人
			mimeMsg.setRecipients(Message.RecipientType.TO,InternetAddress.parse(reciever)); // 设置收件人
			
			Multipart mp = new MimeMultipart();
			BodyPart bp = new MimeBodyPart();   
	        bp.setContent(data,"text/html;charset=GBK");   
	        mp.addBodyPart(bp);
	        
	        mimeMsg.setContent(mp);
	        mimeMsg.saveChanges();
	        
	        Session mailSession = Session.getInstance(props,null);
	        Transport transport = mailSession.getTransport("smtp");
	        transport.connect((String)props.get("mail.smtp.host"),username,password);
	        transport.sendMessage(mimeMsg,mimeMsg.getRecipients(Message.RecipientType.TO));
	        transport.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
}
