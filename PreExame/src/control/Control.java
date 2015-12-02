package control;

public class Control {

	/**
	 * Construtor	
	 */
	public Control(){
			
		}
		
	/**
	 * Monta a tabela dos discos.
	 * @param String tamanho
	 * @param int discos
	 * @return String[][] Tabela com os discos devidamente divididos.
	 */
	public String[][] montarDiscos(String tamanho, int discos){
		tamanho += ".0";
		double bits = Double.parseDouble(tamanho)*8;
		double linhas = bits/(discos-1);		
		if (linhas - (int)linhas != 0) linhas++;
		
		String[][] tab = new String [(int)linhas][discos];
		
		int n = 1 , bit = 1;
		
		for (int i = 0; i < (int)linhas;i++){
			
			for (int j = 0; j < discos-1; j++){
				if (n <= bits){
					tab[i][j] = "b"+n;
					n++;
				}else{
					j = discos-1;
				}
			}
		}
		
		
		for (int i = 0; bit <= bits; i++){
			System.out.println(i + " " + bit);
			tab[i][discos-1] = CalcDiscoPariedade(bit, bits);
			bit += 32;
		}
		
		MostraTab(tab, (int)linhas, discos);
		return tab;
	}
	
	/**
	 * Metodo que serve apenas para mostrar o conteúdo da tabela (usado para os testes)
	 * @param tab
	 * @param linhas
	 * @param discos
	 */
	private void MostraTab(String[][] tab, int linhas, int discos){
		String mostra = "";
		for(int i = 0; i < linhas; i++){
			for (int j = 0; j < discos; j++ ){
				mostra += tab[i][j] + "|";
			}
			mostra += "\n";
		}
		System.out.println(mostra);
	}
	
	/**
	 * Calcula os bits do disco de pariedade.
	 * @param b
	 * @param bits
	 * @return String do disco de pariedade.
	 */
	private String CalcDiscoPariedade(int b, double bits){
		String pariedade = new String("parity :");
		
		pariedade += b;	
		if (b + 32 <= bits){
			pariedade += " - " + (b + 32);
		}else{
			pariedade += " - " + (int)bits;
		}
		return pariedade;
	}
	
	
	/**
	 * Prepara o vetor de String com os títulos das colunas
	 * @param nDiscos
	 * @return Vetor de String com o nome dos discos.
	 */
	public String[] StringDiscos(int nDiscos){
		String[] discos = new String[nDiscos];
		
		for (int i = 0; i < nDiscos-1; i++){
			discos[i] = "Disk" + (i+1);
		}
		discos[nDiscos-1] = "parity Disk";
		
		for (int i = 0 ; i < nDiscos ; i++)
			System.out.print(discos[i]);
			System.out.println("");
		
		return discos;			
	}
}
