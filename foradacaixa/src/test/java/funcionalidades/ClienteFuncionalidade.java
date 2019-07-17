package funcionalidades;

import pages.ClientePage;
import pages.EnderecoPage;
import readers.Config;

public class ClienteFuncionalidade extends ClientePage {
	
	ClientePage clientePage = new ClientePage();
	EnderecoPage enderecoPage = new EnderecoPage();

	public void informarDadosPessoa() {
		
		if(Config.getProperty("cliente.tipo_pessoa").equals("fisica"))
			clientePage.setFisica();
		
		if(Config.getProperty("cliente.tipo_pessoa").equals("juridica"))
			clientePage.setJuridica();
		
		clientePage.setCpfCnpj(Config.getProperty("cliente.cpf_cnpj"));
		clientePage.setNomeRazaoSocial(Config.getProperty("cliente.nome_razao_social"));
		clientePage.setEmail(Config.getProperty("cliente.email"));
		clientePage.setDataNasc(Config.getProperty("cliente.data_nasc"));
		clientePage.setSexo(Config.getProperty("cliente.sexo"));
		clientePage.setEstadoCivil(Config.getProperty("cliente.estado_civil"));
	}

	public void clicarAvancar() {
		
		clientePage.setAvancar();
	}

	public void informarEnderecos() {
		
		enderecoPage.setCepPrincipal(Config.getProperty("endereco.principal.cep"));
		enderecoPage.setEnderecoPrincipal(Config.getProperty("endereco.principal.endereco"));
		enderecoPage.setNumeroPrincipal(Config.getProperty("endereco.principal.numero"));
		enderecoPage.setComplementoPrincipal(Config.getProperty("endereco.principal.complemento"));
		enderecoPage.setCidadePrincipal(Config.getProperty("endereco.principal.cidade"));
		enderecoPage.setEstadoPrincipal(Config.getProperty("endereco.principal.estado"));
		enderecoPage.setTelefonePrincipal(Config.getProperty("endereco.principal.telefone"));
		enderecoPage.setCelularPrincipal(Config.getProperty("endereco.principal.celular"));		
		enderecoPage.setCepCobranca(Config.getProperty("endereco.cobranca.cep"));
		enderecoPage.setEnderecoCobranca(Config.getProperty("endereco.cobranca.endereco"));
		enderecoPage.setNumeroCobranca(Config.getProperty("endereco.cobranca.numero"));
		enderecoPage.setComplementoCobranca(Config.getProperty("endereco.cobranca.complemento"));
		enderecoPage.setCidadeCobranca(Config.getProperty("endereco.cobranca.cidade"));
		enderecoPage.setEstadoCobranca(Config.getProperty("endereco.cobranca.estado"));
		enderecoPage.setTelefoneCobranca(Config.getProperty("endereco.cobranca.telefone"));
		enderecoPage.setCelularCobranca(Config.getProperty("endereco.cobranca.celular"));
	}

	public void clicarSalvar() {
		
		enderecoPage.setSalvar();
	}

	public boolean validarMsg() {
		
		boolean flag = true;
		
		try {
			enderecoPage.getMsgSucesso();
			System.out.println("\nMsg: Cliente cadastrado com sucesso - PASSOU!\n");
			flag = true;
			
		} catch(Exception e) {
			
			System.out.println("\nMsg: Cliente cadastrado com sucesso - FALHOU!\n");
			flag = false;
			e.printStackTrace();
		}
		return flag;
	}

}
