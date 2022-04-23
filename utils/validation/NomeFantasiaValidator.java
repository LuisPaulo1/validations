import static br.mp.mprj.mca.Utils.PascalCase.toPascalCase;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerMapping;

public class NomeFantasiaValidator implements ConstraintValidator<NomeFantasiaValid, String> {
	
	@Autowired
	private HttpServletRequest request;
	
	@Autowired
	private ServicoAcolhimentoRepository repository;

	@Override
	public boolean isValid(String nomeFantasia, ConstraintValidatorContext context) {
		
		boolean value = true;		
		ServicoAcolhimento servicoAcolhimento = repository.findByNomeFantasia(toPascalCase(nomeFantasia));
		
		if(request.getMethod().equals("PUT")) {
			
			@SuppressWarnings("unchecked")
			var uriVars = (Map<String, String>) request.getAttribute(HandlerMapping.URI_TEMPLATE_VARIABLES_ATTRIBUTE);
			long servicoAcolhimentoId = Long.parseLong(uriVars.get("id"));
			
			if (servicoAcolhimento != null && servicoAcolhimentoId != servicoAcolhimento.getId()) 
				value = false;
			
		} else {
			if(servicoAcolhimento != null) 
				value = false;			
		}		
		
		return value;
	}

}
