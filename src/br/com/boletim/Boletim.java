package br.com.boletim;
import java.util.Scanner;

public class Boletim {
	
	private static int registros = 3;
	private static String[] alunos = new String[registros];
	private static float[] avaliacoes1 = new float[registros];
	private static float[] avaliacoes2 = new float[registros];
	private static Scanner sc = new Scanner(System.in);
	
	private static void invocarMenu() {
		int opcao;	
		do{
			System.out.println("Digite [1] para: Registrar notas de um novo aluno");
			System.out.println("Digite [2] para: Consultar boletim de um aluno");
			System.out.println("Digite [3] para: Consultar notas da turma");
			System.out.println("Digite [4] para: Sair");
			opcao = sc.nextInt();
			if(opcao == 1) {
				registrarNotas();
			}else if(opcao == 2) {
				consultarBoletim();
			}else if(opcao == 3) {
				consultarNotasTurma();
			}
			
		}while(opcao != 4);
		System.out.println("Programa finalizado com sucesso.");		
	}
	
	private static String registrarNotas() {
		System.out.println("Registrar Notas");
		if(alunos[registros-1] != null) {
			System.out.println("Há " + registros + " registros de alunos. Impossível registrar mais do que " + registros + " boletins. \n");
			return "";
		}else {
			System.out.println("Digite o nome do aluno: ");
			String aluno = sc.next();
			System.out.println("Digite a nota da Avaliação 1: ");
			float avaliacao1 = sc.nextFloat();
			System.out.println("Digite a nota da Avaliacao2: ");
			float avaliacao2 = sc.nextFloat();			
			for (int a = 0; a < registros; a++ ) {
				if(alunos[a] == null) {
					alunos[a] = aluno;
					avaliacoes1[a] = avaliacao1;
					avaliacoes2[a] = avaliacao2;
					System.out.println("Registro efetuado com sucesso. Notas registradas: " + (a+1) + "\n");
					return "";
				}
			}
			System.out.println("Erro \n");
			return "";
		}
	}
	
	private static String consultarBoletim() {
		System.out.println("Consultar Boletim");
		System.out.println("Digite o nome do aluno: ");
		String aluno = sc.next();
		float media;
		for(int a = 0; a < registros; a++) {
			if(alunos[a] != null && alunos[a].equals(aluno)) {
				media = ((avaliacoes1[a]+avaliacoes2[a])/2);
				System.out.println("Aluno: " + alunos[a]);
				System.out.println("Nota da Avaliação 1: " + avaliacoes1[a]);
				System.out.println("Nota da Avaliação 2: " + avaliacoes2[a]);
				System.out.println("Média final: " + (media));
				if(media < 4) {
					System.out.println("Reprovado\n");
					return "";
				}else if(media < 7) {
					System.out.println("Prova final\n");
					return "";
				}else if(media >= 7) {
					System.out.println("Aprovado\n");
					return "";
				}else {
					System.out.println("Erro\n");
					return "";
				}
			}
		}
		System.out.println("Aluno não encontrado.\n");
		return "";
	}
	
	private static void consultarNotasTurma() {
		System.out.println("Consultar as Notas da Turma");
		float media;
		for(int a = 0; a < registros; a++) {
			if(alunos[a] != null) {
				media = ((avaliacoes1[a]+avaliacoes2[a])/2);
				System.out.println("Aluno: " + alunos[a]);
				System.out.println("Nota da Avaliação 1: " + avaliacoes1[a]);
				System.out.println("Nota da Avaliação 2: " + avaliacoes2[a]);
				System.out.println("Média final: " + (media));
				if(media < 4) {
					System.out.println("Reprovado\n");
				}else if(media < 7) {
					System.out.println("Prova final\n");
				}else if(media >= 7) {
					System.out.println("Aprovado\n");
				}else {
					System.out.println("Erro\n");
				}
			}
		}
	}
	
	public static void main(String[] args) {
		invocarMenu();	
		sc.close();
	}
}