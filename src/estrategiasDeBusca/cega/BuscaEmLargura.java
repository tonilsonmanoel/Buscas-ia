package estrategiasDeBusca.cega;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import espacoDeEstados.Estado;

/**
 * Esta classe implementa uma estrat�gia de busca cega conhecida como "Busca em
 * Largura", caracter�stica por explorar o espa�o de estados n�vel-a-n�vel sempre
 * visitando primeiro os nodos n�o-expandidos da �rvore de busca que se encontram
 * mais pr�ximos da raiz.
 * 
 * @author Leandro C. Fernandes
 *
 */
public class BuscaEmLargura extends BuscaCega {
	
	private Queue<Estado<?>> eAbertos;

	/**
	 * Construtor padr�o.
	 */
	public BuscaEmLargura() {
		this(null,null);
	}
	
	/**
	 * Cria uma nova inst�ncia de Busca em Largura e define os estados inicial
	 * e objetivo para o processo.
	 * @param estadoInicial estado inicial de busca
	 * @param estadoMeta estado que cont�m os objetivos da busca
	 */
	public BuscaEmLargura(Estado<?> estadoInicial, Estado<?> estadoMeta) {
		super(estadoInicial,estadoMeta);
		nomeDaEstrategia = "Busca em Largura";
		eAbertos = new LinkedList<Estado<?>>();
	}
	
	/**
	 * Implementa efetivamente a estrat�gia de busca, iniciando a explora��o do
	 * espa�o a partir do estado inicial e seguindo n�vel a n�vel a procura de
	 * um estado que atenda aos objetivos. Ao t�rmino, o caminho correspondente
	 * a solu��o encontra-se armazenado no atributo caminho.  
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void buscar() {
		Estado<?> eCorrente = eInicial;
		while ((eCorrente != null) && (!eCorrente.equals(eObjetivo))) {
			for (Estado<?> estado : (List<Estado<?>>) eCorrente.getSucessores())
				eAbertos.add(estado);
			eCorrente = eAbertos.poll();
		}
		// Se o la�o foi encerrado por um estado v�lido ...
		if (eCorrente != null) {
			// ent�o constru�mos o caminho da solu��o (da folha at� a raiz)
			caminho.add(eCorrente);
			while (eCorrente.getAncestral() != null) {
				eCorrente = eCorrente.getAncestral();
				caminho.add(eCorrente);
			}
			Collections.reverse(caminho);
		}
	}
	
}
