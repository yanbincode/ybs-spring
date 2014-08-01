package web.upload;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.io.FileUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.multipart.support.DefaultMultipartHttpServletRequest;

/**
 * 接受上传的文件，及存放<br>
 * 1、最原始的参考java项目下的文件传输<br>
 * 2、利用spring MultipartFile自动封装对象进行数据流读写<br>
 * 3、利用DefaultMultipartHttpServletRequest 来获取MultipartFile对象进行读写<br>
 * 4、利用apache包下的工具方法，简化文件读写的代码<br>
 * 5、利用MultipartFile的子类CommonsMultipartFile来简化文件读写代码
 * 
 * @author yanbin
 * 
 */
@Controller
@RequestMapping("/upload.do")
public class UploadController {

	/**
	 * 跳转到上传页面
	 * 
	 * @return
	 */
	@RequestMapping(params = "method=upload", method = RequestMethod.GET)
	public String upload() {
		return "upload/upload";
	}

	/**
	 * 上传单个文件。
	 * 
	 * @param multipartFile
	 * @param request
	 * @return
	 */
	@RequestMapping(params = "method=upload", method = RequestMethod.POST)
	public String upload(@RequestParam("file") MultipartFile multipartFile, HttpServletRequest request) {

		// 获取文件需要存放的路径
		String path = request.getSession().getServletContext().getRealPath("/temp_file/");

		// 判断文件是否为空
		if (!multipartFile.isEmpty()) {
			InputStream is = null;
			FileOutputStream fos = null;
			try {
				// 获取流
				is = multipartFile.getInputStream();
				// 根据路径 新建一个file 对象
				File targetFile = new File(path + multipartFile.getOriginalFilename());
				// 将输入流中的内容通过输出流写入file 对象
				fos = new FileOutputStream(targetFile);
				byte[] bytes = new byte[1024];
				int len = 0;
				while ((len = is.read(bytes)) != -1) {
					fos.write(bytes, 0, len);
				}
			} catch (IOException e) {
				e.printStackTrace();
			} finally {
				// 关闭流
				try {
					fos.flush();
					fos.close();
					is.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return "ok";
	}

	/**
	 * 跳转到批量上传页面
	 * 
	 * @return
	 */
	@RequestMapping(params = "method=batchUploads", method = RequestMethod.GET)
	public String batchUploads() {
		return "upload/batchUploads";
	}

	/**
	 * 批量上传，其实就是单个文件的处理的循环
	 * 
	 * @param multipartFiles
	 * @param request
	 * @return
	 */
	@RequestMapping(params = "method=batchUploads", method = RequestMethod.POST)
	public String batchUploads(@RequestParam("file") MultipartFile[] multipartFiles, HttpServletRequest request) {

		// 获取文件需要存放的路径
		String path = request.getSession().getServletContext().getRealPath("/temp_file/");

		// 将流声明，关闭放在循环外面
		InputStream is = null;
		FileOutputStream fos = null;
		try {
			// 循环处理
			for (MultipartFile multipartFile : multipartFiles) {
				// 不为空
				if (!multipartFile.isEmpty()) {
					// 获取流
					is = multipartFile.getInputStream();
					// 根据路径 新建一个file 对象
					File targetFile = new File(path + multipartFile.getOriginalFilename());
					// 将输入流中的内容通过输出流写入file 对象
					fos = new FileOutputStream(targetFile);
					byte[] bytes = new byte[1024];
					int len = 0;
					while ((len = is.read(bytes)) != -1) {
						fos.write(bytes, 0, len);
					}
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			// 关闭流
			try {
				fos.flush();
				fos.close();
				is.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return "ok";
	}

	/**
	 * multipartFile 对象的一些常用属性方法。
	 * 
	 * @param multipartFile
	 * @throws IOException
	 */
	@SuppressWarnings("unused")
	private void multipartMethod(MultipartFile multipartFile) throws IOException {
		// 获取上传的文件的上传页面上的名字
		String fieldName = multipartFile.getName();
		// 获取上传的文件原名。包含后缀名
		String fileName = multipartFile.getOriginalFilename();
		// 获取文件的大小
		Long fileSize = multipartFile.getSize();
		// 获取输入流
		InputStream is = multipartFile.getInputStream();
	}

	/**
	 * 根据DefaultMultipartHttpServletRequest 来获取附件。本质其实是一样的。
	 * 注意：这里面，批量的时候，表单上面的相同name 属性会认为一个附件。多个附件必须name不同
	 * 
	 * @param request
	 * @return
	 */
	@SuppressWarnings("unused")
	private List<MultipartFile> getAttachment(HttpServletRequest request) {
		List<MultipartFile> fileLists = new ArrayList<MultipartFile>();

		// 将request 强转为子类
		if (request instanceof DefaultMultipartHttpServletRequest) {
			DefaultMultipartHttpServletRequest multipartRequest = (DefaultMultipartHttpServletRequest) request;
			// 利用DefaultMultipartHttpServletRequest获取上传的附件map
			Map<String, MultipartFile> files = multipartRequest.getFileMap();
			// 遍历map ，赋值给list
			for (Map.Entry<String, MultipartFile> file : files.entrySet()) {
				if (file.getValue().getSize() > 0) {
					fileLists.add(file.getValue());
				}
			}
		}
		return fileLists;
	}

	/**
	 * 利用apache io包中的FileUtils类，可以封装文件读写。调用copyInputStreamToFile方法直接写入文件
	 * 
	 * @param multipartFile
	 * @param request
	 * @return
	 */
	@RequestMapping(params = "method=utilsUpload", method = RequestMethod.POST)
	public String utilsUpload(@RequestParam("file") MultipartFile multipartFile, HttpServletRequest request) {
		String path = request.getSession().getServletContext().getRealPath("/temp_file/");
		if (!multipartFile.isEmpty()) {
			try {
				// 简化流和文件的读写
				FileUtils.copyInputStreamToFile(multipartFile.getInputStream(),
						new File(path, multipartFile.getOriginalFilename()));
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return "ok";
	}

	/**
	 * 利用CommonsMultipartFile 获取FileItem 的写入方法
	 * 
	 * @param multipartFile
	 * @param request
	 * @return
	 */
	@RequestMapping(params = "method=fileItemUpload", method = RequestMethod.POST)
	public String fileItemUpload(@RequestParam("file") CommonsMultipartFile multipartFile, HttpServletRequest request) {
		String path = request.getSession().getServletContext().getRealPath("/temp_file/");
		if (!multipartFile.isEmpty()) {
			File targetFile = new File(path + multipartFile.getOriginalFilename());
			try {
				FileItem fileItem = multipartFile.getFileItem();
				fileItem.write(targetFile);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return "ok";
	}

}
