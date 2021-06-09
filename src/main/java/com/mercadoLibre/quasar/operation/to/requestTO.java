package com.mercadoLibre.quasar.operation.to;

import java.io.Serializable;
import java.util.List;

public class requestTO implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private List<quasarTO> satellites;

	public List<quasarTO> getSatellites() {
		return satellites;
	}

	public void setSatellites(List<quasarTO> satellites) {
		this.satellites = satellites;
	}

}
