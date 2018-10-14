package com.rcp.model;

import java.util.ArrayList;
import java.util.List;

public class Server extends ModelObject{
	private String hostname;
	private int port;
	private String username;
	private String password;
	private List<Folder> folders;
	private Folder junkFolder;
	
	public Server(){
		folders = new ArrayList<Folder>();
		addFolder(new Folder("Inbox"));
		addFolder(new Folder("Drafts"));
		addFolder(new Folder("Sent"));
		addFolder(new Folder("Junk"));
		addFolder(new Folder("Trash"));

	}
	
	public Folder getJunkFolder() {
		return junkFolder;
	}
	private void addFolder(Folder folder) {
		folders.add(folder);
		folder.setServer(this);
		firePropertyChange("folders", null, null);
		if (folder.getName().equals("Junk")) {
			junkFolder = folder;
		}
	}
	
	public List<Folder> getFolders() {
		return folders;
	}

	public String getHostname() {
		return hostname;
	}

	public Object getModel() {
		return Model.getInstance();
	}

	public void setHostname(String hostname) {
		firePropertyChange("hostname", this.hostname, this.hostname=hostname);
		
	}

	public String getUsername() {
		return username;
	}

	public int getPort() {
		return port;
	}
	public void setPort(int port) {
		firePropertyChange("port", this.port, this.port=port);
	}

	public void setUsername(String username) {
		firePropertyChange("username", this.username, this.username=username);
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		firePropertyChange("password", this.password, this.password = password);
	}

	public String toString() {
		return "Server( hostname=\"" + hostname + "\"" + ", username=\""
				+ username + "\"" + ", password=\"" + password + "\""
				+ ", port=" + port + ")";
	}
	
	public Object getDefaultSelection() {
		for (Folder f : folders) {
			if ("Inbox".equals(f.getName())) {
				return f;
			}
		}
		return null;
	}
}
