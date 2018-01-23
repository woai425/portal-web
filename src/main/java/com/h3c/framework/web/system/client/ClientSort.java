package com.h3c.framework.web.system.client;

import java.util.Comparator;

import com.h3c.framework.common.dto.ClientDTO;

public class ClientSort implements Comparator<ClientDTO> {

	
	public int compare(ClientDTO prev, ClientDTO now) {
		return (int) (now.getLogindatetime().getTime()-prev.getLogindatetime().getTime());
	}

}
