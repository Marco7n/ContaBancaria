package contaBancaria;

public class Cliente {
	private String Nome;
	private String endereco;
	public Cliente(String Nome, String endereco) {
		this.Nome = Nome;
		this.endereco = endereco;
	}
	
	public String getNome() {
		return Nome;
	}

	public void setNome(String nome) {
		Nome = nome;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

}
