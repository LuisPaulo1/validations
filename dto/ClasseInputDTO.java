import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.URL;
import org.springframework.http.MediaType;
import org.springframework.web.multipart.MultipartFile;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ClasseInputDTO {
			
	@NotNull
	private Long promotoriaId;
	
	@NotNull
	private Long varaInfanciaId;
	
	@Size(max = 30)
	@Pattern(regexp = "[0-9\\-./]*$", message = "Informe apenas números e símbolos (ponto, barra e hífen)")
	private String numeroInclusao;
		
	@NotBlank
	private String naturezaServico;
	
	@NotBlank
	private String regime;
	
	@NotBlank
	private String modalidade;		
	
	@NomeFantasiaValid
	@NotBlank
	private String nomeFantasia;
	
	private String razaoSocial;
		
	@CnpjValid
	private String cnpj;
		
	@URL
	private String site;
	
	@NotNull
	private Long estadoId;
	
	@NotNull
	private Long municipioId;
		
	private Long bairroId;
	
	@NotBlank
	private String logradouro;	
		
	private Integer numeroResidencia;
		
	@NotBlank	
	private String cep;
		
	private String complemento;
		
	private String pontoReferencia;
			
	private String telefones;
			
	private String emails;
	
	@NotBlank
	private String mantenedora;
	
	@NotNull
	private Long unidadeMpId;
	
	@FileSize(max = "2MB", message = "Tamanho máximo da imagem deve ser 2MB")
	@FileContentType(allowed = {MediaType.IMAGE_JPEG_VALUE, MediaType.IMAGE_PNG_VALUE, "image/bmp", "image/tiff", "image/jpg"})
	private MultipartFile logomarca;

}