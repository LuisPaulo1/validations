import java.util.Arrays;
import java.util.List;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.web.multipart.MultipartFile;

public class FileContentTypeValidator implements ConstraintValidator<FileContentType, MultipartFile> {

	private List<String> allowedContentTypes;
	
	@Override
	public void initialize(FileContentType constraintAnnotation) {
		this.allowedContentTypes = Arrays.asList(constraintAnnotation.allowed()); 
	}
	
	@Override
	public boolean isValid(MultipartFile multipartFile, ConstraintValidatorContext context) {
				
		if(multipartFile == null || multipartFile.isEmpty()) 
			return true;
		
		boolean result = this.allowedContentTypes.contains(multipartFile.getContentType());
		if(result)
			return true;
				
		throw new BadRequestException("logomarca", "O tipo da imagem não é suportado");
	}

}