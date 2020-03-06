package steps;

import pages.SimuladorResultadoPage;
import pages.SimuladorValoresDeEntradaPage;
import driver.DriverFactory;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.tools.ant.util.FileUtils;
import org.junit.Assert;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import io.cucumber.java.After;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;

public class ValidarSimuladorPoupancaSteps {
	private SimuladorValoresDeEntradaPage simulador = new SimuladorValoresDeEntradaPage();;
	private SimuladorResultadoPage resultado = new SimuladorResultadoPage();
	
	@Dado("^um associado que se encontra na tela de simulacao de investimento de poupanca$")	
	public void um_associado_que_se_encontra_na_tela_de_simulacao_de_investimento_de_poupanca()							
	{		
	    System.out.println("Dado um associado que se encontra na tela de simulacao de investimento de poupanca");		
	    if(resultado.isPaginaResultado()) {
	    	resultado.clicarBotaoRefazerSimulacao();
	    }	    
	    Assert.assertTrue("ASSERT FAILED - Pagina de simulacao nao exibida", simulador.isPaginaValoresDeEntrada());
	}		

	@Quando("preenche o campo de valor a ser aplicado com {string}")
	public void preenche_o_campo_de_valor_a_ser_aplicado_com(String valorAplicado) {
		System.out.println("Quando preenche o campo de valor a ser aplicado com "+valorAplicado);
		simulador.preencherValorAplicado(valorAplicado);
	}
	
	@Quando("preenche o campo de valor a ser poupado com {string}")
	public void preenche_o_campo_de_valor_a_ser_poupado_com(String valorPoupado) {
		System.out.println("Quando preenche o campo de valor a ser poupado com "+valorPoupado);
		simulador.preencherValorPoupado(valorPoupado);
	}
	
	@Quando("preenche o campo de tempo aplicado com {string} meses")
	public void preenche_o_campo_de_tempo_aplicado_com_meses(String tempoAplicadoEmMeses) {
		System.out.println("Quando preenche o campo de tempo aplicado com "+tempoAplicadoEmMeses+ " meses");
		simulador.preencherTempoAplicado(tempoAplicadoEmMeses);
		simulador.selecionarMes();
	}
	
	@Quando("preenche o campo de tempo aplicado com {string} anos")
	public void preenche_o_campo_de_tempo_aplicado_com_anos(String tempoAplicadoEmAnos) {
	    // Write code here that turns the phrase above into concrete actions
		System.out.println("Quando preenche o campo de tempo aplicado com "+tempoAplicadoEmAnos+ " anos");
		simulador.preencherTempoAplicado(tempoAplicadoEmAnos);
		simulador.selecionarAno();
	}
	
	@Quando("clica no botao Simular")
	public void clica_no_botao_Simular() {
		System.out.println("Quando clica no botao Simular");	
		simulador.clicarBotaoSimular();
	}
	
	@Quando("clica no link Limpar formulario")
	public void clica_no_bot_o_Simular() {
		System.out.println("Quando clica no link Limpar formulario");	
		simulador.clicarLinkLimparFormulario();
	}
	
	@Entao("aparece a tela de resultado")
	public void aparece_a_tela_de_resultado() {
		System.out.println("Entao aparece a tela de resultado");
		Assert.assertTrue("ASSERT FAILED - Pagina de resultado nao exibida", resultado.isPaginaResultado());
	}
	
	@Entao("aparece o tempo em meses a ser guardado igual a {string}")
	public void aparece_o_tempo_em_meses_a_ser_guardado_igual_a(String tempoAplicadoEmMeses) {
		System.out.println("Entao aparece o tempo em meses a ser guardado igual a "+tempoAplicadoEmMeses);
		System.out.println("Resultado: "+resultado.capturarMesesAplicados());
		Assert.assertEquals("ASSERT FAILED - Tempo em meses diferente do esperado", tempoAplicadoEmMeses+" meses", resultado.capturarMesesAplicados());
	}
	
	@Entao("aparece o valor total aplicado com juros igual a {string}")
	public void aparece_o_valor_total_aplicado_com_juros_igual_a(String valorTotal) {
		System.out.println("Entao aparece o valor total aplicado com juros igual a "+valorTotal);
		System.out.println("Resultado: "+resultado.capturarValorTotal());
		Assert.assertEquals("ASSERT FAILED - Valor total diferente do esperado", "R$ "+valorTotal, resultado.capturarValorTotal());
	}
	
	@Entao("aparece uma tabela de resultado com mes e valor")
	public void aparece_uma_tabela_de_resultado_com_mes_e_valor() {
		System.out.println("Entao aparece uma tabela de resultado com mes e valor");
		Assert.assertTrue("ASSERT FAILED - Tabela mes e valor nao disponivel", resultado.isTabelaMesValor());
	}
	
	@Entao("aparece a mensagem de valor minimo aplicado de vinte reais")
	public void aparece_a_mensagem_de_valor_minimo_aplicado_de_vinte_reais() {
		System.out.println("Entao aparece a mensagem de valor minimo aplicado de vinte reais");
		Assert.assertTrue("ASSERT FAILED - Nao esta aparecendo mensagem para valor minimo aplicado de 20 reais", simulador.isMensagemValorAplicadoMinimo());
	}

	@Entao("aparece a mensagem de valor minimo poupado de vinte reais")
	public void aparece_a_mensagem_de_valor_minimo_poupado_de_vinte_reais() {
		Assert.assertTrue("ASSERT FAILED - Nao esta aparecendo mensagem para valor minimo poupado de 20 reais", simulador.isMensagemValorPoupadoMinimo());
	}

	@Entao("aparece a mensagem de obrigatorio no campo tempo")
	public void aparece_a_mensagem_de_obrigatorio_no_campo_tempo() {
		System.out.println("Entao aparece a mensagem de obrigatorio no campo tempo");
		Assert.assertTrue("ASSERT FAILED - Nao esta aparecendo mensagem de obrigatoriedade do campo tempo", simulador.isMensagemTempoObrigatorio());
	}
	
	@After
	public void saveScreenshot(){	    
		System.out.println("Salvando screenshot...");	
		String date = new SimpleDateFormat("yyMMddHHmmss").format(new Date());		
		try { 
			TakesScreenshot screenshot = (TakesScreenshot)DriverFactory.getDriver();
			File srcFile = screenshot.getScreenshotAs(OutputType.FILE);
			File tgtFile = new File(System.getProperty("user.dir")+"\\src\\test\\resources\\images\\simuladorPoupanca_screenshot_" + date + ".png");

			FileUtils.getFileUtils().copyFile(srcFile, tgtFile); 
		} catch(Exception e) { 
			System.out.println(e);
		}		 				
	}
	
}
