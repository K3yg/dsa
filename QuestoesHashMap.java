import MapaDispersao.MapaDispersao;

public class QuestoesHashMap {
  public static void main(String[] args) {
    class Aluno {
      private int matricula;
      private String nome;
      private String dataNascimento;

      public Aluno(int matricula, String nome, String dataNascimento) {
        this.matricula = matricula;
        this.nome = nome;
        this.dataNascimento = dataNascimento;
      }

      public int getMatricula() {
        return matricula;
      }

      // public String getNome() {
      //   return nome;
      // }

      // public String getDataNascimento() {
      //   return dataNascimento;
      // }

      @Override
      public String toString() {
        return "Aluno{" +
                "matricula=" + matricula +
                ", nome='" + nome + '\'' +
                ", dataNascimento='" + dataNascimento + '\'' +
                '}';
      }
    }

    System.out.println("=== PLANO DE TESTES PL01 - VALIDAÇÃO DO MAPA DE DISPERSÃO ===\n");
    
    MapaDispersao<Aluno> mapa = new MapaDispersao<>(53);
    System.out.println("Mapa criado com capacidade de 53 listas encadeadas\n");

    // CASO DE TESTE 1: Validar inserção e busca de um dado novo
    System.out.println("--- CASO DE TESTE 1: Inserção e busca de um dado novo ---");
    Aluno obj1 = new Aluno(12000, "Jean", "01/01/2000");
    System.out.println("Criando objeto obj1: " + obj1);
    System.out.println("Hash da chave 12000: " + (12000 % 53));
    
    mapa.inserir(obj1.getMatricula(), obj1);
    System.out.println("Objeto inserido no mapa com chave 12000");
    
    Aluno encontrado = mapa.buscar(12000);
    System.out.println("Buscando aluno com chave 12000...");
    System.out.println("Resultado da busca: " + encontrado);
    System.out.println("Verificando identidade de referência: " + (encontrado == obj1));
    
    assert mapa.buscar(12000) == obj1;
    System.out.println("✓ CASO 1: Objeto inserido e localizado com sucesso!\n");

    // CASO DE TESTE 2: Validar inserção de múltiplos objetos
    System.out.println("--- CASO DE TESTE 2: Inserção de múltiplos objetos ---");
    Aluno a2 = new Aluno(14000, "Pedro", "20/01/1999");
    Aluno a3 = new Aluno(12500, "Marta", "18/02/2001");
    Aluno a4 = new Aluno(13000, "Lucas", "25/11/1998");
    
    System.out.println("Inserindo múltiplos alunos:");
    System.out.println("  - " + a2 + " (Hash: " + (14000 % 53) + ")");
    System.out.println("  - " + a3 + " (Hash: " + (12500 % 53) + ")");
    System.out.println("  - " + a4 + " (Hash: " + (13000 % 53) + ")");
    
    mapa.inserir(a2.getMatricula(), a2);
    mapa.inserir(a3.getMatricula(), a3);
    mapa.inserir(a4.getMatricula(), a4);
    
    System.out.println("Buscando todos os alunos:");
    System.out.println("  Matrícula 12000: " + mapa.buscar(12000));
    System.out.println("  Matrícula 14000: " + mapa.buscar(14000));
    System.out.println("  Matrícula 12500: " + mapa.buscar(12500));
    System.out.println("  Matrícula 13000: " + mapa.buscar(13000));
    
    assert mapa.buscar(14000) == a2;
    assert mapa.buscar(12500) == a3;
    assert mapa.buscar(13000) == a4;
    System.out.println("✓ CASO 2: Múltiplos objetos inseridos e localizados com sucesso!\n");

    // CASO DE TESTE 3: Validar inserção e busca com colisões
    System.out.println("--- CASO DE TESTE 3: Inserção e busca com colisões ---");
    System.out.println("Criando mapa para teste de colisões...");
    MapaDispersao<Aluno> mapaColisao = new MapaDispersao<>(53);
    
    Aluno c1 = new Aluno(12000, "Jean", "01/01/2000");
    Aluno c2 = new Aluno(14000, "Pedro", "20/01/1999");
    Aluno c3 = new Aluno(14226, "Marta", "18/02/2001");
    Aluno c4 = new Aluno(17180, "Lucas", "25/11/1998");
    
    System.out.println("Inserindo alunos (com colisões esperadas):");
    System.out.println("  - " + c1 + " (Hash: " + (12000 % 53) + ")");
    System.out.println("  - " + c2 + " (Hash: " + (14000 % 53) + ")");
    System.out.println("  - " + c3 + " (Hash: " + (14226 % 53) + ") - COLIDE com 12000");
    System.out.println("  - " + c4 + " (Hash: " + (17180 % 53) + ") - COLIDE com 14000");
    
    mapaColisao.inserir(c1.getMatricula(), c1);
    mapaColisao.inserir(c2.getMatricula(), c2);
    mapaColisao.inserir(c3.getMatricula(), c3);
    mapaColisao.inserir(c4.getMatricula(), c4);
    
    System.out.println("Buscando todos os alunos (incluindo os que colidiram):");
    System.out.println("  Matrícula 12000: " + mapaColisao.buscar(12000));
    System.out.println("  Matrícula 14000: " + mapaColisao.buscar(14000));
    System.out.println("  Matrícula 14226: " + mapaColisao.buscar(14226));
    System.out.println("  Matrícula 17180: " + mapaColisao.buscar(17180));
    
    assert mapaColisao.buscar(12000) == c1;
    assert mapaColisao.buscar(14000) == c2;
    assert mapaColisao.buscar(14226) == c3;
    assert mapaColisao.buscar(17180) == c4;
    System.out.println("✓ CASO 3: Colisões tratadas corretamente!\n");

    System.out.println("🎉 TODOS OS CASOS DE TESTE DO PLANO PL01 PASSARAM COM SUCESSO!");
    System.out.println("Fator de carga final: " + mapa.calcularFatorCarga());
  }
} 