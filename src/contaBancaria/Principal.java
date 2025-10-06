package contaBancaria;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

public class Principal {

	private ContaBancaria buscarConta(List<ContaBancaria> contas, String numero) {
		for (ContaBancaria c : contas) {
			if (c.getNumero().equals(numero)) {
				return c;
			}
		}
		return null;
	}
	

	private ContaEspecial buscarContaE(List<ContaEspecial> contas, String numero) {
		for (ContaEspecial c_E : contas) {
			if (c_E.getNumero().equals(numero)) {
				return c_E;
			}
		}
		return null;
	}

	public Principal() {
		List<ContaBancaria> contas = new ArrayList<>();
		List<ContaEspecial> contasE = new ArrayList<>();
		Cliente cliente = null;
		ContaBancaria cb = new ContaBancaria();
		ContaEspecial conta_E = new ContaEspecial();

		int opcao = 0;
		do {
			opcao = Integer.parseInt(JOptionPane.showInputDialog("1 - Cadastrar Cliente \n"
					+ "2 - Criar Conta Bancária \n" + "3 - Criar Conta Bancária Especial\n" + "4 - Sacar \n"
					+ "5 - Depositar \n" + "6 - Transferir \n" + "7 - Buscar Contas\n" + "0 - Sair"));
			switch (opcao) {
			case 1:
				String nome = JOptionPane.showInputDialog("Informe seu nome: ");
				String endereco = JOptionPane.showInputDialog("Informe seu endereço: ");
				cliente = new Cliente(nome, endereco);

				JOptionPane.showMessageDialog(null,
						"Cliente cadastrado!\nNome: " + cliente.getNome() + "\nEndereço: " + cliente.getEndereco());

				break;
			case 2:
				String numero = JOptionPane.showInputDialog("Digite o número da conta: ");
				double saldo = 3000;
				cb = new ContaBancaria(numero, saldo, cliente);
				contas.add(cb);
				JOptionPane.showMessageDialog(null, "Conta criada!\nNúmero: " + numero + "\nTitular: "
						+ cliente.getNome() + "\nSaldo inicial: " + cb.getSaldo());
				break;
				
			case 3:
				String numeroE = JOptionPane.showInputDialog("Informe o número da sua conta: ");
				double saldoE = 3000;
				double Limite = 800;
				conta_E = new ContaEspecial(numeroE, saldoE, cliente, Limite);
				contasE.add(conta_E);
				JOptionPane.showMessageDialog(null, "Conta criada!\nNúmero: " + numeroE + "\nTitular: "
						+ cliente.getNome() + "\nLimite inicial: " + conta_E.getLimite());
				break;
			case 4:
				String conta_saque = JOptionPane.showInputDialog("Informe a conta para saque");

				cb = buscarConta(contas, conta_saque);
				conta_E = buscarContaE(contasE, conta_saque);
				if (conta_E != null) {

					String entrada = JOptionPane.showInputDialog("Informe o valor para saque");
					double valor = Double.parseDouble(entrada);

					conta_E.sacar(valor);

					JOptionPane.showMessageDialog(null, "Limite Atual: " + conta_E.getLimite());
				} else {
					JOptionPane.showMessageDialog(null, "Conta não encontrada!");
				}
				
				if (cb != null) {

					String entrada = JOptionPane.showInputDialog("Informe o valor para saque");
					double valor = Double.parseDouble(entrada);

					cb.sacar(valor);

					JOptionPane.showMessageDialog(null, "Saldo Atual: " + cb.getSaldo());
				} else {
					JOptionPane.showMessageDialog(null, "Conta não encontrada!");
				}
				break;
			case 5:
				String conta_dep = JOptionPane.showInputDialog("Informe a conta para depósito");
				cb = buscarConta(contas, conta_dep);
				if (cb != null) {

					String entrada = JOptionPane.showInputDialog("Informe o valor para depósito");
					double valor = Double.parseDouble(entrada);

					cb.depositar(valor);

					JOptionPane.showMessageDialog(null, "Saldo Atual: " + cb.getSaldo());
				} else {
					JOptionPane.showMessageDialog(null, "Conta não encontrada!");
				}
				break;
			case 6:
				String transf = JOptionPane.showInputDialog("Informe a conta para transferência");
				String vlr = JOptionPane.showInputDialog("Informe o valor da transferência");
				double valor_tranf = Double.parseDouble(vlr);
				ContaBancaria contaDestino = buscarConta(contas, transf);

				if (contaDestino != null) {
					try {
						cb.transferir(valor_tranf, contaDestino);
						JOptionPane.showMessageDialog(null, "Transferência realizada com sucesso!");
					} catch (IllegalArgumentException e) {
						JOptionPane.showMessageDialog(null, e.getMessage());
					}
				} else {
					JOptionPane.showMessageDialog(null, "Conta destino não encontrada!");
				}
				break;

			case 7:
				
				StringBuilder sbE = new StringBuilder("Contas Cadastradas:\n");

				for (ContaEspecial c : contasE) {
					sbE.append(c.toString()).append("\n");
				}

				JOptionPane.showMessageDialog(null, sbE.toString());
				
				StringBuilder sb = new StringBuilder("Contas Cadastradas:\n");

				for (ContaBancaria c : contas) {
					sb.append(c.toString()).append("\n");
				}

				JOptionPane.showMessageDialog(null, sb.toString());
				break;

			}
		} while (opcao != 0);
	}

	public static void main(String[] args) {
		new Principal();
	}
}
