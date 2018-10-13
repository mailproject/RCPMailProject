package com.rcp.model;

import java.util.ArrayList;
import java.util.List;



public class Model extends ModelObject{
	private static Model model;
	private List<Server> servers = new ArrayList<Server>();

	public Model() {
		Server server = new Server();
//		server.setHostname("My Mail Server");
//		server.setPort(23);
//		server.setUsername("test");
//		addServer(server);
	}
	public Object getDefaultSelection() {
		return servers.size() > 0 ? servers.get(0).getDefaultSelection() : null;
	}

	public static Model getInstance() {
		if (model == null) {
			model = new Model();
		}
		return model;
	}

}
