#language: pt

Funcionalidade: Simular investimento na poupanca do Sicredi
Como um Associado,
Eu gostaria de preencher o formulario de simulacao
Para ver a tabela de resultado com mes e valor.

Contexto:
Dado um associado que se encontra na tela de simulacao de investimento de poupanca

Esquema do Cenario: Validar simulacao com dados corretos e tempo aplicado em meses
Quando preenche o campo de valor a ser aplicado com "<valorAplicado>"
E preenche o campo de valor a ser poupado com "<valorPoupado>"
E preenche o campo de tempo aplicado com "<tempoAplicadoEmMeses>" meses
E clica no botao Simular 
Entao aparece a tela de resultado
E aparece o tempo em meses a ser guardado igual a "<tempoAplicadoEmMeses>"
E aparece o valor total aplicado com juros igual a "<valorTotal>"
E aparece uma tabela de resultado com mes e valor

Exemplos:
	| valorAplicado	| valorPoupado	| tempoAplicadoEmMeses	| valorTotal	|
	| 80,00					| 100,00				| 5											| 583					|
	| 20,00					| 20,00					| 15										| 326					|


Esquema do Cenario: Validar simulacao com dados corretos e tempo aplicado em anos
Quando preenche o campo de valor a ser aplicado com "<valorAplicado>"
E preenche o campo de valor a ser poupado com "<valorPoupado>"
E preenche o campo de tempo aplicado com "<tempoAplicadoEmAnos>" anos
E clica no botao Simular 
Entao aparece a tela de resultado
E aparece o tempo em meses a ser guardado igual a "<tempoAplicadoEmMeses>"
E aparece o valor total aplicado com juros igual a "<valorTotal>"
E aparece uma tabela de resultado com mes e valor

Exemplos:
	| valorAplicado	| valorPoupado	| tempoAplicadoEmAnos	| tempoAplicadoEmMeses | valorTotal	|
	| 80,00					| 100,00				| 10									| 120									 | 14.034			|
	

Esquema do Cenario: Validar valor aplicado com um numero menor do que 20
Quando preenche o campo de valor a ser aplicado com "<valorAplicado>"
E preenche o campo de valor a ser poupado com "<valorPoupado>"
E preenche o campo de tempo aplicado com "<tempoAplicadoEmMeses>" meses
E clica no botao Simular 
Entao aparece a mensagem de valor minimo aplicado de vinte reais

Exemplos:
	| valorAplicado	| valorPoupado	| tempoAplicadoEmMeses	|
	| 10,00					| 100,00				| 5											|
	
	
Esquema do Cenario: Validar valor poupado com um numero menor do que 20
Quando preenche o campo de valor a ser aplicado com "<valorAplicado>"
E preenche o campo de valor a ser poupado com "<valorPoupado>"
E preenche o campo de tempo aplicado com "<tempoAplicadoEmMeses>" meses
E clica no botao Simular 
Entao aparece a mensagem de valor minimo poupado de vinte reais

Exemplos:
	| valorAplicado	| valorPoupado	| tempoAplicadoEmMeses	|
	| 100,00				| 19,00					| 5											|

	
Cenario: Validar campos obrigatorios
Quando clica no link Limpar formulario
E clica no botao Simular 
Entao aparece a mensagem de valor minimo aplicado de vinte reais
E aparece a mensagem de valor minimo poupado de vinte reais
E aparece a mensagem de obrigatorio no campo tempo