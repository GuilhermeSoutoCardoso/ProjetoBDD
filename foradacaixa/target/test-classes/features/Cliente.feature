#language: pt
#encoding: utf-8

@GoogleChrome
Funcionalidade: Cadastro de Clientes

  @login
  Cenario: Inserir cliente pessoa fisica
    Dado que eu faca login no sistema
    E acesso o menu clientes
    Quando informo os dados da pessoa
    E clico em avancar
    E informo os enderecos
    E clico em salvar
    Entao eu valido a mensagem de sucesso
    E faco o logout do sistema
