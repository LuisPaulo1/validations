import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.util.unit.DataSize;
import org.springframework.web.multipart.MultipartFile;

public class FileSizeValidator implements ConstraintValidator<FileSize, MultipartFile> {

	private DataSize maxSize;
	
	@Override
	public void initialize(FileSize constraintAnnotation) {
		this.maxSize = DataSize.parse(constraintAnnotation.max());
	}
	
	@Override
	public boolean isValid(MultipartFile value, ConstraintValidatorContext context) {
		
		if(value == null || value.isEmpty())
			return true;
		
		boolean result = value.getSize() <= this.maxSize.toBytes();
		if(result)
			return true;
		
		throw new BadRequestException("logomarca", "Tamanho máximo da imagem deve ser 2MB");
		
	}

}