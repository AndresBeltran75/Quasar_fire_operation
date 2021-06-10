package com.mercadoLibre.quasar.operation.to;

import java.io.Serializable;
import java.util.List;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description = "Datos de la petición")
public class requestTO implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@ApiModelProperty(value = "Lista con datos de las naves")
	private List<quasarTO> satellites;

	public List<quasarTO> getSatellites() {
		return satellites;
	}

	public void setSatellites(List<quasarTO> satellites) {
		this.satellites = satellites;
	}

}
