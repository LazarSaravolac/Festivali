package jwd.wafepa.support;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import jwd.wafepa.model.Glas;
import jwd.wafepa.web.dto.GlasDTO;

@Component
public class KupovinaToKupovinaDTO  implements Converter<Glas,GlasDTO>{

	@Override
	public GlasDTO convert(Glas arg0) {
		GlasDTO dto=new GlasDTO();
		dto.setId(arg0.getId());
		dto.setBroj(arg0.getBroj());
		return dto;
	}

}
