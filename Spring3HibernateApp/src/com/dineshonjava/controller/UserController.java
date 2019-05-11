package com.dineshonjava.controller;

import java.awt.image.BufferedImage;
import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.sql.Blob;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.imageio.ImageIO;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.dineshonjava.bean.EmployeeBean;
import com.dineshonjava.bean.User;
import com.dineshonjava.model.Employee;
import com.dineshonjava.model.LoginBean;
import com.dineshonjava.model.UserDetail;
import com.dineshonjava.service.UserDataDetailService;
import com.dineshonjava.service.UserService;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author Dinesh Rajput
 *
 */
@Controller
public class UserController {
	 @Autowired
	 private UserService userService;
	 
	 @Autowired
	 private UserDataDetailService userdataService;
	 private ServletContext servletContext;
	@RequestMapping(value="/loginPage", method = RequestMethod.GET)
	public ModelAndView login(@ModelAttribute("loginBean")LoginBean loginBean, 
			   BindingResult result) {
		Map<String, Object> model = new HashMap<String, Object>();
		//model.put("employees",  prepareListofBean(employeeService.listEmployeess()));
		return new ModelAndView("loginPage", model);
	}
	
	
	@RequestMapping(value="/validateUser", method = RequestMethod.POST)
	  public ModelAndView submit(@ModelAttribute("loginBean")LoginBean loginBean, 
			   BindingResult result) {
	  
		LoginBean loginBeanPersistance= userService.ValidateUser(loginBean);
	    UserDetail ud= new UserDetail();
	    ud.setLoginBean(loginBeanPersistance.getUserName());
		if (loginBeanPersistance!=null) {
	    	  Map<String, Object> model = new HashMap<String, Object>();
	    	model.put("msg", loginBean.getUserName());
	    	if(loginBeanPersistance.getUserRole().equals("guest")){
	    	model.put("userDetail", userdataService.getUser(ud)); 
	        return new ModelAndView("GuestPage", model);
	    	}
	    	else{
	    	model.put("msg", loginBean.getUserName());
	    	List<UserDetail> userdetail=userdataService.getUser();
	    	model.put("userdetail", userdetail);
	    	return new ModelAndView("adminPage", model);
	    	}
	      } else {
	    	  Map<String, Object> model = new HashMap<String, Object>();
	        model.put("error", "Invalid Details or user does not exist");
	        return new ModelAndView("loginPage", model);
	      }
	    
	  }
	@RequestMapping(value="savefile",method=RequestMethod.POST)  
    public ModelAndView saveimage( @RequestParam CommonsMultipartFile file,  
           HttpSession session,HttpServletRequest req, HttpServletResponse res) throws Exception{  
  
	String user	=req.getParameter("user");
	String text	=req.getParameter("textdata");
    System.out.println("text======="+text);
    Map<String, Object> model = new HashMap<String, Object>();
    UserDetail userDetail= new UserDetail();
    
   
    userDetail.setLoginBean(user);
    if(text!=null&&!text.isEmpty()){
    	userDetail.setTextmessage(text);
		 model.put("filesuccess", "Message submitted successfully");
	}
    else {
    	userDetail.setFileName(file.getOriginalFilename());
        userDetail.setFileType(file.getContentType());
        byte[] bytes = file.getBytes();  
        userDetail.setData(bytes);
		model.put("filesuccess", "File uploaded successfully");
	}
    
    
    userdataService.addUserDetail(userDetail);
  
    //userdataService.getUser(userDetail);
   
	//model.put("userDetail", userdataService.getUser(userDetail));
   UserDetail ud= new UserDetail();
   ud.setLoginBean(userDetail.getLoginBean());
	model.put("userDetail", userdataService.getUser(ud)); 
	
	
    return new ModelAndView("GuestPage",model);  
    }   	
	
	@RequestMapping(value="/approve",method=RequestMethod.GET)  
    public ModelAndView approve( HttpSession session,HttpServletRequest req, HttpServletResponse res) throws Exception{ 
		 Map<String, Object> model = new HashMap<String, Object>();
		 userdataService.update(Integer.parseInt(req.getParameter("id")));
		 List<UserDetail> userdetail=userdataService.getUser();
	    	model.put("userdetail", userdetail);
		 return new ModelAndView("adminPage", model);
	}
	@RequestMapping(value="/delete",method=RequestMethod.GET)  
    public ModelAndView delete( HttpSession session,HttpServletRequest req, HttpServletResponse res) throws Exception{ 
		 Map<String, Object> model = new HashMap<String, Object>();
		 
		 userdataService.deleteByID(req.getParameter("id"));
		 List<UserDetail> userdetail=userdataService.getUser();
	    	model.put("userdetail", userdetail);
		 return new ModelAndView("adminPage", model);
	}
	
	@RequestMapping(value = "/getStudentPhoto")
	public void getStudentPhoto(HttpServletRequest req,HttpServletResponse response) throws Exception {
		response.setContentType("image/jpeg");
		System.out.println("getstudent");
		byte[] bytes = userdataService.getUserdetailasByID(Integer.parseInt(req.getParameter("id")));

		//byte[] bytes = ph.getBytes(1, (int) ph.length());
		InputStream inputStream = new ByteArrayInputStream(bytes);
		IOUtils.copy(inputStream, response.getOutputStream());
	}
	@RequestMapping(value="/logout",method=RequestMethod.GET)  
	public ModelAndView logout(@ModelAttribute("loginBean")LoginBean loginBean, 
			   BindingResult result) {
		Map<String, Object> model = new HashMap<String, Object>();
		//model.put("employees",  prepareListofBean(employeeService.listEmployeess()));
		return new ModelAndView("loginPage", model);
	}
}
