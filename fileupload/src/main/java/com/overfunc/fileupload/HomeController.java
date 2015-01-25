package com.overfunc.fileupload;

import java.io.File;
import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "home";
	}
	
	@RequestMapping(value = "/file", method = RequestMethod.GET)
	public String fileUploadRedirect(Locale locale, Model model) {
		return "home";
	}
	
	@RequestMapping(value = "/file/upload.htm", method = RequestMethod.POST)
	public String fileUpload( HttpServletRequest req , HttpServletResponse res ) {
		logger.info("FILE UPLOAD START");
		
		MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) req;
		//MultipartHttpServletRequest multipart = (MultipartHttpServletRequest) req;
		
		try {
			String dirPath = "/home/local/apache-tomcat-7.0.54/webapps/ssamsong/";
			MultipartFile file = multipartRequest.getFile("img_file");
			
//			logger.info("HTML에서 넘어온 파일 이름은 : {}",file.getName());
//			logger.info("사진 파일 이름은 : {}",file.getOriginalFilename());
//			logger.info("사진 파일 크기는 : {}",file.getSize());
			
			logger.info( "file size ==> ", file.getSize() );
			
			if (file != null) {			
				String FilePath = dirPath +"/"+file.getOriginalFilename();
				File f = new File(FilePath);
				file.transferTo(f);
				//res.sendRedirect("/");
				
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		
		
		return "home";
	}
	
}
