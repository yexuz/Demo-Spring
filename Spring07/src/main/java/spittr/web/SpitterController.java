package spittr.web;

import java.io.File;
import java.io.IOException;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import spittr.Spitter;
import spittr.data.SpitterRepository;

@Controller
@RequestMapping("/spitter")
public class SpitterController {

	// 处理来自/spitter/register的get请求
	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public String showRegistrationForm(Model model) {
		model.addAttribute(new Spitter());
		return "registerForm";
	}

	private SpitterRepository spitterRepository;

	public SpitterController() {
	}

	// 注入SpitterRepository
	@Autowired
	public SpitterController(SpitterRepository spitterRepository) {
		this.spitterRepository = spitterRepository;
	}

	// ps: 很重要一点需要注意，Errors参数要紧跟在带有@Valid注解的参数后面
	/*值得一提的是，如果在编写控制器方法的时候，通过Part参数的形式接受文件上传，那么就
	没有必要配置MultipartResolver了。只有使用MultipartFile的时候，我们才需要
	MultipartResolver。*/
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String processRegistration(@RequestPart("profilePicture") MultipartFile profilePicture,
			@Valid Spitter spitter, Errors errors, RedirectAttributes model) throws IllegalStateException, IOException {
//		profilePicture.transferTo(new File("/data/spittr/" + profilePicture.getOriginalFilename()));
		if (errors.hasErrors()) {
			return "registerForm";
		}
		// 保存Spitter
		spitterRepository.save(spitter);
		model.addAttribute("username", spitter.getUsername());
		model.addAttribute("aa", "20");
		model.addFlashAttribute("spitter", spitter); //配合RedirectAttributes
		return "redirect:/spittles/{username}";
	}

//	private void saveImage(MultipartFile image) throws ImageUploadException {
//		try {
//			AWSCredentials awsCredentials = new AWSCredentials(s3AccessKey, s2SecretKey);
//			// 配置S3服务
//			S3Service s3 = new RestS3Service(awsCredentials);
//			// 创建S3 bucket对象
//			S3Bucket bucket = s3.getBucket("spittrImages");
//			S3Object imageObject = new S3Object(image.getOriginalFilename());
//			// 设置图像数据
//			imageObject.setDataInputStream(image.getInputStream());
//			imageObject.setContentLength(image.getSize());
//			imageObject.setContentType(image.getContentType());
//			AccessControlList acl = new AccessControlList();
//			// 设置权限
//			acl.setOwner(bucket.getOwner());
//			acl.grantPermission(GroupGrantee.ALL_USERS, Permission.PERMISSION_READ);
//			imageObject.setAcl(acl);
//			// 保存图片
//			s3.putObject(bucket, imageObject);
//		} catch (Exception e) {
//			throw new ImageUploadException("Unable to save image", e);
//		}
//	}
}