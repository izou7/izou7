package cn.chinattclub.izou7.web;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.text.Collator;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Random;

import javax.annotation.Resource;
import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.ExcessiveAttemptsException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.chinattclub.izou7.dto.ActivityListDto;
import cn.chinattclub.izou7.dto.ActivityQueryDto;
import cn.chinattclub.izou7.dto.RegistDto;
import cn.chinattclub.izou7.dto.RegistSecondDto;
import cn.chinattclub.izou7.dto.RegistUserDto;
import cn.chinattclub.izou7.entity.Activity;
import cn.chinattclub.izou7.entity.Agency;
import cn.chinattclub.izou7.entity.City;
import cn.chinattclub.izou7.entity.Contact;
import cn.chinattclub.izou7.entity.Customer;
import cn.chinattclub.izou7.entity.Province;
import cn.chinattclub.izou7.entity.User;
import cn.chinattclub.izou7.entity.UserInfo;
import cn.chinattclub.izou7.service.ActivityService;
import cn.chinattclub.izou7.service.AgencyService;
import cn.chinattclub.izou7.service.CityService;
import cn.chinattclub.izou7.service.ContactService;
import cn.chinattclub.izou7.service.CustomerService;
import cn.chinattclub.izou7.service.ProvinceService;
import cn.chinattclub.izou7.service.UserInfoService;
import cn.chinattclub.izou7.service.UserService;
import cn.chinattclub.izou7.util.CommonUtil;
import cn.zy.commons.webdev.constant.ResponseStatusCode;
import cn.zy.commons.webdev.http.RestResponse;
import cn.zy.commons.webdev.vo.Page;

/**
 * 
 * @ClassName: MainController
 * @Description:系統主頁控制类
 * @author: zy
 * @date: 2014-11-9 下午8:00:36
 * 
 */
@Controller
public class MainController {

	private static final Logger logger = LoggerFactory
			.getLogger(MainController.class);

	@Resource
	private UserService userServiceImpl;
	
	@Resource
	private ActivityService activityServiceImpl;
	
	@Resource
	private ContactService contactServiceImpl;
	
	@Resource
	private AgencyService agencyServiceImpl;
	
	@Resource
	private CustomerService customerServiceImpl;
	
	@Resource
	private CityService cityServiceImpl;
	
	@Resource
	private ProvinceService provinceServiceImpl;
	
	@Resource
	private UserInfoService userInfoServiceImpl;
	
	@Resource
	private HttpServletRequest request;
	
	/**
	 * 生成验证码
	 */
	private int width = 152;// 定义图片的width
	private int height = 39;// 定义图片的height
	private int codeCount = 4;// 定义图片上显示验证码的个数
	private int xx = 25;
	private int fontHeight = 22;
	private int codeY = 20;
	char[] codeSequence = { 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J',
			'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W',
			'X', 'Y', 'Z', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9' };
	
	@RequestMapping(value = {"/index","/"}, method = RequestMethod.GET)
	public String indexPage(Model model,Page page,ActivityQueryDto query) {
		return "site.community.index";
	}

	
	
	@RequestMapping(value = "error", method = RequestMethod.GET)
	public String errorPage() {
		return "site.main.error";
	}

	/**
	 * 
	 * 注册页面
	 * 
	 * @return
	 */
	@RequestMapping(value = "regist", method = RequestMethod.GET)
	public String registPage() {
		return "site.main.regist";
	}
	
	
	@RequestMapping(value = "registSecondPage", method = RequestMethod.POST)
	public String registSecondPage(Model model,Integer id) {
		List<Province> provinces = provinceServiceImpl.findAll();
		model.addAttribute("provinces",provinces);
		model.addAttribute("id",id);
		return "site.main.registSecond";
	}
	
	@RequestMapping(value = "registSecond", method = RequestMethod.POST)
	@ResponseBody
	public RestResponse registSecond(@RequestBody @Valid RegistSecondDto dto,BindingResult br) throws SecurityException, ClassNotFoundException {
		RestResponse response = new RestResponse();
		int statusCode = ResponseStatusCode.OK;
		String message = "添加用户信息成功！";
		if(!CommonUtil.validateDto(response,br,dto.getClass().getName().toString())){
			statusCode = ResponseStatusCode.INTERNAL_SERVER_ERROR;
		}else{
			List<Province> provinces = provinceServiceImpl.findAll();
			User user = userServiceImpl.get(dto.getId());
			UserInfo userInfo = user.getUserInfo();
			userInfo.setCompany(dto.getCompany());
			userInfo.setPosition(dto.getPosition());
			City city = cityServiceImpl.getCity(dto.getCity());
			userInfo.setCity(city);
			userInfo.setRealName(dto.getRealName());
			userInfo.setSex(dto.getSex());
			userInfoServiceImpl.update(userInfo);
			response.setStatusCode(statusCode);
		}
		return response;
	}
	
	@RequestMapping(value = "regist", method = RequestMethod.POST)
	@ResponseBody
	public RestResponse regist(@RequestBody @Valid RegistDto user,BindingResult br) throws SecurityException, ClassNotFoundException {
		RestResponse response = new RestResponse();
		int statusCode = ResponseStatusCode.OK;
		String message = "注册成功！";
		if(!CommonUtil.validateDto(response,br,user.getClass().getName().toString())){
			statusCode = ResponseStatusCode.INTERNAL_SERVER_ERROR;
		}else{
			String code = (String) request.getSession().getAttribute("code");   
			if(!user.getPassword().equals(user.getcPassword())){
				response.setStatusCode(ResponseStatusCode.FORBIDDEN);
				response.setMessage("密码和确认密码输入不一致，请重新输入！");
				return response;
			}else if(userServiceImpl.exists(user.getPhone())){
				response.setStatusCode(ResponseStatusCode.FORBIDDEN);
				response.setMessage("该手机号已被注册，请重新输入！");
				return response;
			}else if(!code.equalsIgnoreCase(user.getCaptcha())){
				response.setStatusCode(ResponseStatusCode.FORBIDDEN);
				response.setMessage("验证码输入错误，请重新输入！");
				return response;
			}else{
				UserInfo userInfo = new UserInfo();
				userInfo.setPhone(user.getPhone());
				userInfo.setCreateTime(new Date());
				userInfoServiceImpl.add(userInfo);
				User newUser = new User();
				newUser.setUsername(user.getPhone());
				newUser.setPassword(user.getPassword());
				newUser.setUserInfo(userInfo);
				userServiceImpl.createUser(newUser);
				response.getBody().put("id",newUser.getId());
			}
		}
		response.setStatusCode(statusCode);
		return response;
	}

	/**
	 * 
	 * 注册
	 * 
	 * @return
	 
	@RequestMapping(value = "regist", method = RequestMethod.POST)
	public String regist(Model model, @Valid RegistUserDto dto, BindingResult br) {
		String modelPage = "site.main.regist";
		String error = "";
		if (br.hasErrors()) {
			error = br.getAllErrors().get(0).getDefaultMessage();
		} else {
			if (!dto.getPassword().equals(dto.getPassword2())) {
				error = "密码两次输入不一致";
			} else {
				if (userServiceImpl.exists(dto.getUsername())) {
					error = "该邮箱已经被注册";
				} else {
					User user = new User();
					user.setUsername(dto.getUsername());
					user.setPassword(dto.getPassword());
					userServiceImpl.createUser(user);
					UserInfo userInfo = new UserInfo();
					userInfo.setEmail(dto.getUsername());
					
					User loginUser = new User();
					loginUser.setUsername(dto.getUsername());
					loginUser.setPassword(dto.getPassword());
					RestResponse response = login(loginUser);
					if(response.getStatusCode()!=ResponseStatusCode.OK){
						error = response.getMessage();
					}
					modelPage = "redirect:/index";
				}
			}
		}
		model.addAttribute("error", error);
		return modelPage;
	}
*/
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	@ResponseBody
	public RestResponse login(@RequestBody User user) {
		RestResponse response = new RestResponse();
		int statusCode = ResponseStatusCode.OK;
		String msg = "登录成功！";
		Subject currentUser = SecurityUtils.getSubject();
		UsernamePasswordToken token = new UsernamePasswordToken(
				user.getUsername(), user.getPassword());
		try {
			currentUser.login(token);
		} catch (UnknownAccountException uae) {
			msg = "用户名不存在！";
			logger.error("用户名【" + user.getUsername() + "】不存在！", uae);
			statusCode = ResponseStatusCode.UNAUTHORIZED;
		} catch (IncorrectCredentialsException ice) {
			msg = "密码错误！";
			logger.error("用户【" + user.getUsername() + "】密码错误！", ice);
			statusCode = ResponseStatusCode.UNAUTHORIZED;
		} catch (LockedAccountException lae) {
			msg = "用户已经被锁定不能登录，请与管理员联系！";
			logger.error("用户【" + user.getUsername() + "】被锁定！", lae);
			statusCode = ResponseStatusCode.UNAUTHORIZED;
		} catch (ExcessiveAttemptsException eae) {
			msg = "错误次数过多！";
			logger.error("用户【" + user.getUsername() + "】错误次数过多！", eae);
			statusCode = ResponseStatusCode.UNAUTHORIZED;
		} catch (AuthenticationException ae) {
			logger.error("用户【" + user.getUsername() + "】其他登陆错误！", ae);
			msg = "其他的登录错误！";
			statusCode = ResponseStatusCode.UNAUTHORIZED;
		}
		response.setMessage(msg);
		response.setStatusCode(statusCode);
		return response;
	}
	
	/**
	 * 
	 * 联系我们
	 *
	 * @return
	 */
	@RequestMapping(value = "contact", method = RequestMethod.GET)
	public String contactUsPage() {
		return "site.main.contact";
	}
	
	
	@RequestMapping(value = "contact", method = RequestMethod.POST)
	@ResponseBody
	public RestResponse addContactUs(@RequestBody @Valid Contact contact,BindingResult br) throws SecurityException, ClassNotFoundException {
		RestResponse response = new RestResponse();
		int statusCode = ResponseStatusCode.OK;
		String message = "添加联系成功";
		if(!CommonUtil.validateDto(response,br,contact.getClass().getName().toString())){
			statusCode = ResponseStatusCode.INTERNAL_SERVER_ERROR;
		}else{
			contactServiceImpl.add(contact);
		}
		response.setStatusCode(statusCode);
		return response;
	}
	
	
	@RequestMapping(value = "service", method = RequestMethod.GET)
	public String servicePage() {
		return "site.main.service";
	}
	
	/**
	 * 
	 * 加入我们
	 *
	 * @return
	 */
	@RequestMapping(value = "join", method = RequestMethod.GET)
	public String joinUsPage() {
		return "site.main.join";
	}
	/**
	 * 
	 * 代理
	 *
	 * @return
	 */
	@RequestMapping(value = "agency", method = RequestMethod.GET)
	public String agencyPage() {
		return "site.main.agency";
	}
	
	
	@RequestMapping(value = "agency", method = RequestMethod.POST)
	@ResponseBody
	public RestResponse addAgency(@RequestBody @Valid Agency agency,BindingResult br) throws SecurityException, ClassNotFoundException {
		RestResponse response = new RestResponse();
		int statusCode = ResponseStatusCode.OK;
		String message = "添加代理成功";
		if(!CommonUtil.validateDto(response,br,agency.getClass().getName().toString())){
			statusCode = ResponseStatusCode.INTERNAL_SERVER_ERROR;
		}else{
			agencyServiceImpl.add(agency);
		}
		response.setStatusCode(statusCode);
		return response;
	}
	
	@RequestMapping(value = "customer", method = RequestMethod.GET)
	public String customerPage() {
		return "site.main.customer";
	}
	
	
	@RequestMapping(value = "customer", method = RequestMethod.POST)
	@ResponseBody
	public RestResponse addAgency(@RequestBody @Valid Customer customer,BindingResult br) throws SecurityException, ClassNotFoundException {
		RestResponse response = new RestResponse();
		int statusCode = ResponseStatusCode.OK;
		String message = "添加客户成功";
		if(!CommonUtil.validateDto(response,br,customer.getClass().getName().toString())){
			statusCode = ResponseStatusCode.INTERNAL_SERVER_ERROR;
		}else{
			customerServiceImpl.add(customer);
		}
		response.setStatusCode(statusCode);
		return response;
	}
	
//	@RequestMapping(value = "test", method = RequestMethod.GET)
//	@ResponseBody
//	public RestResponse test(){
//		RestResponse response = new RestResponse();
//		List<City> citys = cityServiceImpl.list();
//		String[] cityNames = new String[citys.size()];
//		for(int i=0;i<citys.size();i++){
//			cityNames[i] = citys.get(i).getCity();
//		}
//		Collator cmp = Collator.getInstance(java.util.Locale.CHINA);
//		Arrays.sort(cityNames, cmp); 
//		String html = "<dl class=\"layout city-list\"><dt>A</dt>";
//		String last = "";
//		for (int j=0;j<cityNames.length;j++) {
//			if(last==""){
//				last = PinyinUtil.converterToFirstSpell(cityNames[j].substring(0,1).trim());
//			}
//			String current = PinyinUtil.converterToFirstSpell(cityNames[j].substring(0,1).trim());
//			if(!current.equals(last)){
//				last = current;
//				html += "</dl>\n<dl class=\"layout city-list\">\n<dt>"+current.toUpperCase()+"</dt>\n";
//			}
//			html+= "<dd id='"+cityServiceImpl.findCityByName(cityNames[j]).getId()+"'>"+cityNames[j]+"</dd>\n";
//		} 
//		System.out.println(html);
//		return response;
//	}
	
	@RequestMapping("/code")
	public void getCode(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {

		// 定义图像buffer
		BufferedImage buffImg = new BufferedImage(width, height,
				BufferedImage.TYPE_INT_RGB);
		// Graphics2D gd = buffImg.createGraphics();
		// Graphics2D gd = (Graphics2D) buffImg.getGraphics();
		Graphics gd = buffImg.getGraphics();
		// 创建一个随机数生成器类
		Random random = new Random();
		// 将图像填充为白色
		gd.setColor(Color.WHITE);
		gd.fillRect(0, 0, width, height);

		// 创建字体，字体的大小应该根据图片的高度来定。
		Font font = new Font("Fixedsys", Font.BOLD, fontHeight);
		// 设置字体。
		gd.setFont(font);

		// 画边框。
		//gd.setColor(Color.BLACK);
		gd.drawRect(0, 0, width - 1, height - 1);

		// 随机产生40条干扰线，使图象中的认证码不易被其它程序探测到。
		gd.setColor(Color.BLACK);
		for (int i = 0; i < 40; i++) {
			int x = random.nextInt(width);
			int y = random.nextInt(height);
			int xl = random.nextInt(12);
			int yl = random.nextInt(12);
			gd.drawLine(x, y, x + xl, y + yl);
		}

		// randomCode用于保存随机产生的验证码，以便用户登录后进行验证。
		StringBuffer randomCode = new StringBuffer();
		int red = 0, green = 0, blue = 0;

		// 随机产生codeCount数字的验证码。
		for (int i = 0; i < codeCount; i++) {
			// 得到随机产生的验证码数字。
			String code = String.valueOf(codeSequence[random.nextInt(36)]);
			// 产生随机的颜色分量来构造颜色值，这样输出的每位数字的颜色值都将不同。
			red = random.nextInt(255);
			green = random.nextInt(255);
			blue = random.nextInt(255);

			// 用随机产生的颜色将验证码绘制到图像中。
			gd.setColor(new Color(red, green, blue));
			gd.drawString(code, (i + 1) * xx, codeY);

			// 将产生的四个随机数组合在一起。
			randomCode.append(code);
		}
		// 将四位数字的验证码保存到Session中。
		HttpSession session = req.getSession();
		session.setAttribute("code", randomCode.toString());

		// 禁止图像缓存。
		resp.setHeader("Pragma", "no-cache");
		resp.setHeader("Cache-Control", "no-cache");
		resp.setDateHeader("Expires", 0);

		resp.setContentType("image/jpeg");

		// 将图像输出到Servlet输出流中。
		ServletOutputStream sos = resp.getOutputStream();
		ImageIO.write(buffImg, "jpeg", sos);
		sos.close();
	}
	
	
	
	
	
}
