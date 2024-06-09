import br.com.dio.desafio.dominio.Alunos;
import br.com.dio.desafio.dominio.Bootcamp;
import br.com.dio.desafio.dominio.Dev;
import br.com.dio.desafio.dominio.Progresso;
import br.com.dio.desafio.conteudos.Bootcamps;

public class Main {

    public static void main(String[] args) {
        Bootcamp bootcamp = Bootcamps.bootcamp();

        Dev devVicente = Alunos.criarDevVicente();
        Dev devChavatte = Alunos.criarDevChavatte();

        System.out.println(bootcamp);

        Progresso.exibirProgressoDev(devVicente);
        Progresso.exibirProgressoDev(devChavatte);
    }
}
