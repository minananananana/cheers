package kr.co.service;
import org.springframework.web.multipart.MultipartFile;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.io.File;
import java.nio.file.attribute.FileStoreAttributeView;
import kr.co.service.FileService;

public class FileServiceImpl implements FileService{
	public String saveFile(MultipartFile file) {//�����̹��� �޼ҵ带 ������ش�
		
		SimpleDateFormat simpl = new SimpleDateFormat("yyyyMMddHHmmss-");
		
		Calendar calendar = Calendar.getInstance();
		
		String sysFileName = simpl.format(calendar.getTime()) + file.getOriginalFilename();
		
		File saveFile = new File(IMAGE_REPO+"/"+sysFileName);
		
		try {
			file.transferTo(saveFile);//�ش� ��ġ�� ���� ����
		}catch (Exception e) {
			e.printStackTrace();
		}
		return sysFileName;
	}
}
