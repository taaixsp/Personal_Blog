package com.generation.blogpessoal.model;

public class UsuarioLogin {
	
	private Long id;
	
	private String name;
	
	private String usuario;
	
	private String password;
	
	private String image;
	
	private String token;
	
	

	public UsuarioLogin(Long id, String name, String usuario, String password, String image, String token) {
		super();
		this.id = id;
		this.name = name;
		this.usuario = usuario;
		this.password = password;
		this.image = image;
		this.token = token;
	}

	public UsuarioLogin () {}
	
	public Long getId() {
		return id;
	}
	

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}
	

}
