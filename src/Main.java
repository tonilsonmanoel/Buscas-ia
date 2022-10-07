import espacoDeEstados.*;
import estrategiasDeBusca.cega.BuscaEmLargura;
import estrategiasDeBusca.cega.BuscaEmProfundidadeLimitada;
import estrategiasDeBusca.heuristica.*;
import java.util.Iterator;
import java.util.List;
import javax.swing.JOptionPane;

public class Main {

	@SuppressWarnings("rawtypes")
	public static void main(String[] args) {
		
		char[] cfgIni1 = {'2','4','3','7','1','6','5',' ','8'};
                char[] cfgFim1 = {'1','2','3','4','5','6','7',' ','8'};
                
                char[] cfgIni2 = {'2','4','3','7','1','6','5',' ','8'};
                char[] cfgFim2 = {'1','2','3','4','5','6',' ','7','8'};
		
		Puzzle8 estadoInicial1 = new Puzzle8();
		estadoInicial1.setEstado(cfgIni1);
		estadoInicial1.setCusto(0);
		estadoInicial1.setAvaliacao( estadoInicial1.heuristica(cfgFim1) );
			
		Puzzle8 estadoFinal1 = new Puzzle8();
		estadoFinal1.setEstado(cfgFim1);
		estadoFinal1.setCusto(0);
		estadoFinal1.setAvaliacao(0);
                
                Puzzle8 estadoInicial2 = new Puzzle8();
		estadoInicial2.setEstado(cfgIni2);
		estadoInicial2.setCusto(0);
		estadoInicial2.setAvaliacao( estadoInicial2.heuristica(cfgFim2) );
			
		Puzzle8 estadoFinal2 = new Puzzle8();
		estadoFinal2.setEstado(cfgFim2);
		estadoFinal2.setCusto(0);
		estadoFinal2.setAvaliacao(0);
                // TELA
                String EscolhaBusca;
                String TipoBusca = JOptionPane.showInputDialog("Escolha qual o tipo de busca:\n 1.Busca Cega   2.Busca Heuristica");
                if (TipoBusca.equals("1")){
                    EscolhaBusca = JOptionPane.showInputDialog("Escolha qual busca cega:\n 1.BuscaEmLargura  2. BuscaEmProfundidade  3.BuscaEmProfundidadeInterativa");
                     switch (EscolhaBusca) {
                       case "1":
                               //BuscaEmLargura
              
                                BuscaEmLargura buscaLargura = new BuscaEmLargura();
                                buscaLargura.setInicio(estadoInicial1);
                                buscaLargura.setObjetivo(estadoFinal1);
                                buscaLargura.buscar();
                                for(Estado e : buscaLargura.getCaminhoSolucao()) {
                                        System.out.println(e);
                                } 
                                System.out.println("Fim da primeira execução!");

                                BuscaEmLargura buscaLargura2 = new BuscaEmLargura();
                                buscaLargura2.setInicio(estadoInicial2);
                                buscaLargura2.setObjetivo(estadoFinal2);
                                buscaLargura2.buscar();
                                for(Estado e : buscaLargura2.getCaminhoSolucao()) {
                                        System.out.println(e);
                                } 
                                System.out.println("Fim da segunda execução!");
                                //Fim BuscaEmLargura
                           break;
                       case "2":
                                  //BuscaEmProfundidadeLimitada
                                BuscaEmProfundidadeLimitada BuscaEPL1 = new BuscaEmProfundidadeLimitada();
                                BuscaEPL1.setInicio(estadoInicial1);
                                BuscaEPL1.setObjetivo(estadoFinal1);
                                BuscaEPL1.setLimite(9);
                                BuscaEPL1.buscar();
                                for(Estado e : BuscaEPL1.getCaminhoSolucao()) {
                                        System.out.println(e);
                                } 

                                System.out.println("Fim da primeira Execução");
                                BuscaEmProfundidadeLimitada BuscaEPL2 = new BuscaEmProfundidadeLimitada();
                                BuscaEPL2.setInicio(estadoInicial2);
                                BuscaEPL2.setObjetivo(estadoFinal2);
                                BuscaEPL2.setLimite(9);
                                BuscaEPL2.buscar();
                                for(Estado e : BuscaEPL2.getCaminhoSolucao()) {
                                        System.out.println(e);
                                } 
                                System.out.println("Fim da segunda Execução");
                                //Fim BuscaEmProfundidadeLimitada
                           
                           break;
                       case "3":
                                //BuscaEmProfundidadeLimitadaInterativa
                                BuscaEmProfundidadeLimitada BInterativa = new BuscaEmProfundidadeLimitada();
                                BInterativa.setInicio(estadoInicial1);
                                BInterativa.setObjetivo(estadoFinal1);

                                BInterativa.setLimite(0);
                                List<Estado<?>> caminhoSolucao = null;
                                while(caminhoSolucao == null ){
                                    try {
                                        BInterativa.buscar();
                                        caminhoSolucao = BInterativa.getCaminhoSolucao();
                                    } catch (Exception e) {

                                    }
                                      BInterativa.setLimite(BInterativa.getLimite()+ 1);
                                } 
                                System.out.println(BInterativa.getCaminhoSolucao());
                                System.out.println("Fim da primeira execução!");

                                 BuscaEmProfundidadeLimitada BInterativa2 = new BuscaEmProfundidadeLimitada();
                                BInterativa2.setInicio(estadoInicial2);
                                BInterativa2.setObjetivo(estadoFinal2);
                                BInterativa.setLimite(0);

                                List<Estado<?>> caminhoSolucao2 = null;
                                while(caminhoSolucao2 == null ){
                                    try {
                                        BInterativa2.buscar();
                                        caminhoSolucao2 = BInterativa2.getCaminhoSolucao();
                                    } catch (Exception e) {
                                    }
                                      BInterativa2.setLimite(BInterativa2.getLimite()+ 1);
                                } 
                                System.out.println(BInterativa2.getCaminhoSolucao());
                                System.out.println("Fim da segunda execução!");

                                //Fim BuscaEmProfundidadeLimitadaInterativa
                           break;
                           default:
                               System.out.println("Escolha Invalida!");
                               System.exit(0);
                   }
                    
                } else {
                     EscolhaBusca = JOptionPane.showInputDialog("Digite qual busca heuristica:\n 1.AStar 2. BestFirst");
                     switch (EscolhaBusca) {
                        case "1":
                                AStar buscaAS = new AStar();
                                buscaAS.setInicio(estadoInicial1);
                                buscaAS.setObjetivo(estadoFinal1);
                                buscaAS.buscar();
                                for(Estado e : buscaAS.getCaminhoSolucao()) {
                                        System.out.println(e);
                                } 
                                System.out.println("Fim da primeira execução!");

                                AStar buscaAS2 = new AStar();
                                buscaAS2.setInicio(estadoInicial2);
                                buscaAS2.setObjetivo(estadoFinal2);
                                buscaAS2.buscar();
                                for(Estado e : buscaAS2.getCaminhoSolucao()) {
                                        System.out.println(e);
                                }
                                System.out.println("Fim da segunda execução!");
                            break;
                        case "2":
                                BestFirst buscaBF = new  BestFirst();
                                buscaBF.setInicio(estadoInicial1);
                                buscaBF.setObjetivo(estadoFinal1);
                                buscaBF.buscar();
                                for(Estado e : buscaBF.getCaminhoSolucao()) {
                                        System.out.println(e);
                                } 
                                System.out.println("Fim da primeira execução!");
                                
                                BestFirst buscaBF2 = new  BestFirst();
                                buscaBF2.setInicio(estadoInicial2);
                                buscaBF2.setObjetivo(estadoFinal2);
                                buscaBF2.buscar();
                                for(Estado e : buscaBF2.getCaminhoSolucao()) {
                                        System.out.println(e);
                                } 
                                System.out.println("Fim da segunda execução!");
                            
                           
                            break;
                        default:
                            System.out.println("Escolha Invalida!");
                            System.exit(0);
                    }
                
                }
                //Fim Tela
        
                
        }

   

}
