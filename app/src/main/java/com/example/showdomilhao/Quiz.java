package com.example.showdomilhao;

import static com.example.showdomilhao.Dados.*;


import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;


import java.util.ArrayList;
import java.util.Random;


public class Quiz extends AppCompatActivity {
    private TextView  bemVindo ,pergunta, numerodaPergunta;
    private RadioGroup rgRespostas;
    private RadioButton rbResposta1, rbResposta2, rbResposta3, rbResposta4;
    private Button proxima_Pergunta, cartas;

    // Estado
    private boolean cartaSelecionou;
    private int pontuacao = 0, questoes = 1;
    private int respostaSelecionada = -1; // 0..3
    private int perguntaAtual = 0;
    private int numeroPerguntas = 10;
    private int cartasRecebidas;

    private String [] Perguntas = {
            "Quem foi Carlo Acutis e por que é conhecido na Igreja Católica?", //1
            "Qual é o título dado a Carlo Acutis pela Igreja?",//2
            "Qual era a grande devoção de Carlo Acutis?",//3
            "Em que ano Carlo Acutis faleceu?",//4
            "Qual é a famosa frase de Carlo Acutis sobre a Eucaristia?",//5
            "Onde o corpo de Carlo Acutis está sepultado?",//6
            "Qual foi a principal missão de Carlo na internet?",//7
            "Com quantos anos Carlo Acutis faleceu?",//8
            "Quem canoniza ou beatifica um fiel na Igreja Católica?",//9
            "Qual é o sacramento central da vida cristã segundo Carlo Acutis?",//10
            "Qual é o nome do livro que contém os ensinamentos da Igreja Católica?",//11
            "O que significa a palavra 'Eucaristia'?",//12
            "Quem é considerado o primeiro Papa da Igreja Católica?",//13
            "Quantos mandamentos existem na Lei de Deus?",//14
            "Quem é a mãe de Jesus Cristo?",//15
            "O que é a Santíssima Trindade?",//16
            "Qual oração Jesus nos ensinou?",//17
            "Qual é o primeiro mandamento?",//18
            "Qual é o significado do Rosário?",//19
            "Em qual cidade nasceu Carlo Acutis?",//20
            "Qual virtude Carlo Acutis mais viveu no cotidiano?",//21
            "Qual foi o apelido dado a Carlo Acutis?",//22
            "Em que ano Carlo Acutis foi beatificado?",//23
            "Qual Papa beatificou Carlo Acutis?",//24
            "O que significa ser beato?",//25
            "Qual é o símbolo principal da fé cristã?",//26
            "Qual é o nome do sacramento do perdão?",//27
            "Quem instituiu a Eucaristia?",//28
            "Qual é o dia santo da ressurreição de Cristo?",//29
            "Quantos evangelhos existem na Bíblia?",//30
            "Qual foi o milagre mais importante de Jesus?",//31
            "Quem é o sucessor de Pedro na Igreja?",//32
            "Qual documento orienta a doutrina católica?",//33
            "Qual é a profissão de fé do cristão?",//34
            "O que significa a palavra 'Católica'?",//35
            "Qual é o livro da Bíblia que fala sobre a criação?",//36
            "Quem foi o primeiro mártir cristão?",//37
            "O que é a Confirmação na Igreja Católica?",//38
            "Qual é a importância da Missa para os católicos?",//39
            "Carlo Acutis dizia que a Eucaristia é a sua...?",//40
            "Qual foi a doença que levou Carlo Acutis à morte?",//41
            "Em que data é celebrado o dia litúrgico de Carlo Acutis?",//42
            "Quem é o atual Papa?",//43
            "Qual é o significado de 'Amém'?",//44
            "Quem foi escolhido por Deus para receber os Dez Mandamentos?",//45
            "Qual foi o primeiro milagre de Jesus?",//46
            "O que significa 'Evangelho'?",//47
            "Quem escreveu a maioria das cartas do Novo Testamento?",//48
            "Qual é a oração dedicada a Maria, mãe de Jesus?",//49
            "O que Carlo Acutis chamou de 'a estrada para o céu'?",//50
            "Qual é a principal característica da vida de um santo?"//51
    };


    private String[][] Respostas = {
            {"Um jogador de futebol","Um jovem apaixonado pela Eucaristia","Um sacerdote","Um Papa"},//1
            {"Venerável","Beato","Padre","Mártir"},//2
            {"Rosário","Internet","Eucaristia","Viagens"},//3
            {"2004","2006","2008","2010"},//4
            {"A Eucaristia é a minha autoestrada para o Céu","Jesus é meu melhor amigo","Maria é minha mãe","Rezar salva a alma"},//5
            {"Roma","Assis","Milão","Vaticano"},//6
            {"Criar jogos","Evangelizar online","Fazer vídeos","Estudar programação"},//7
            {"12 anos","15 anos","17 anos","18 anos"},//8
            {"O Papa","O Bispo","O Cardeal","O Arcebispo"},//9
            {"Batismo","Crisma","Eucaristia","Unção dos Enfermos"},//10
            {"Bíblia","Catecismo da Igreja Católica","Missal Romano","Código de Direito Canônico"},//11
            {"Reunião","Memória","Ação de Graças","Adoração"},//12
            {"São Paulo","São Pedro","São João","Santo Agostinho"},//13
            {"5","7","10","12"},//14
            {"Santa Ana","Maria","Isabel","Marta"},//15
            {"Pai, Filho e Espírito Santo","Jesus, Maria e José","Fé, Esperança e Caridade","Anjos e Santos"},//16
            {"Ave Maria","Glória","Pai-Nosso","Credo"},//17
            {"Não matarás","Amar a Deus sobre todas as coisas","Honrar pai e mãe","Guardar domingos"},//18
            {"Um símbolo da cruz","Meditação dos mistérios da vida de Cristo","Um salmo","Um hino"},//19
            {"Assis","Roma","Milão","Nápoles"},//20
            {"Caridade","Alegria","Humildade","Obediência"},//21
            {"Geek de Deus","Influenciador Católico","Ciberapóstolo","Apóstolo da Eucaristia"},//22
            {"2018","2019","2020","2021"},//23
            {"Papa Francisco","Papa Bento XVI","Papa João Paulo II","Papa Paulo VI"},//24
            {"Título para quem é considerado santo localmente","Título de quem morreu em martírio","Título dado antes da canonização","Nome dos Papas"},//25
            {"A Bíblia","O Crucifixo","O Rosário","O Evangelho"},//26
            {"Confirmação","Batismo","Reconciliação","Ordem"},//27
            {"São Paulo","Jesus Cristo","Pedro","João"},//28
            {"Natal","Quaresma","Páscoa","Pentecostes"},//29
            {"2","3","4","5"},//30
            {"Multiplicação dos pães","Transformar água em vinho","Ressurreição","Cura de leprosos"},//31
            {"Cardeal","Bispo","Papa","Diácono"},//32
            {"Catecismo da Igreja Católica","Encíclica","Bíblia","Evangelho"},//33
            {"Ave-Maria","Credo","Glória","Pai-Nosso"},//34
            {"Universal","Santidade","Deus","Sagrado"},//35
            {"Gênesis","Êxodo","Levítico","Salmos"},//36
            {"Paulo","Pedro","Estevão","Tiago"},//37
            {"Casamento","Crisma","Eucaristia","Ordem"},//38
            {"Lembrar de Maria","Encontrar amigos","Presença real de Cristo","Unir a comunidade"},//39
            {"Mãe","Namorada","Autoestrada","Porta"},//40
            {"Leucemia","Gripe","Acidente","Covid"},//41
            {"5 de maio","10 de outubro","15 de agosto","25 de dezembro"},//42
            {"Papa João Paulo II","Papa Bento XVI","Papa Leão XIV","Papa Francisco"},//43
            {"Assim seja","Aleluia","Glória","Hosana"},//44
            {"Moisés","Abraão","Jacó","Davi"},//45
            {"Andar sobre as águas","Multiplicação dos pães","Transformar água em vinho","Cura do cego"},//46
            {"Mensagem","Boa notícia","História","Oração"},//47
            {"São Lucas","São Paulo","São Pedro","São Tiago"},//48
            {"Glória","Pai-Nosso","Ave-Maria","Credo"},//49
            {"Rosário","Eucaristia","Jejum","Confissão"},//50
            {"Riqueza","Caridade","Fé","Obediência"}//51
    };


    private int [] respostaCerta = {
            1, // Carlo Acutis ,1
            1, // Beato , 2
            2, // Eucaristia ,3
            1, // 2006 ,4
            0, // A Eucaristia é a minha autoestrada para o Céu ,5
            1, // Assis , 6
            1, // Evangelizar online ,7
            2, // 15 anos ,8
            0, // Papa , 9
            2, // Eucaristia , 10
            1, // Catecismo , 11
            2, // Ação de Graças , 12
            1, // São Pedro ,13
            2, // 10 mandamentos ,14
            1, // Maria ,15
            0, // Trindade ,6
            2, // Pai-Nosso ,17
            1, // Amar a Deus ,18
            1, // Mistérios da vida de Cristo ,19
            2, // Milão ,20
            2, // Humildade ,21
            2, // Ciberapóstolo ,22
            2, // 2020 ,23
            0, // Papa Francisco,24
            2, // Título antes da canonização ,25
            1, // Crucifixo ,26
            2, // Reconciliação ,27
            1, // Jesus Cristo ,28
            2, // Páscoa ,29
            2, // 4 evangelhos ,30
            2, // Ressurreição ,31
            2, // Papa ,32
            0, // Catecismo ,33
            1, // Credo ,34
            0, // Universal ,35
            0, // Gênesis ,36
            2, // Estevão ,37
            1, // Crisma ,38
            2, // Eucaristia ,39
            2, // Autoestrada ,40
            0, // Leucemia ,41
            1, // 10 de outubro ,42
            2, // Papa Leão XIV ,43
            0, // Assim seja ,44
            0, // Moisés ,45
            2, // Transformar água em vinho ,46
            1, // Boa notícia ,47
            1, // São Paulo ,48
            2, // Ave-Maria ,49
            1, // Eucaristia ,50
            2  // Fé ,51
    };

    private final ArrayList<Integer> indicesDisponiveis = new ArrayList<>();

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Esconde a ActionBar (opcional)
        if (getSupportActionBar() != null) getSupportActionBar().hide();

        setContentView(R.layout.activity_quiz);

        // Bind
        bemVindo          = findViewById(R.id.tvTitulo);
        pergunta          = findViewById(R.id.IdtvPergunta);
        numerodaPergunta  = findViewById(R.id.tvNumeroPergunta);
        rgRespostas       = findViewById(R.id.rgRespostas);
        rbResposta1       = findViewById(R.id.rbResposta1);
        rbResposta2       = findViewById(R.id.rbResposta2);
        rbResposta3       = findViewById(R.id.rbResposta3);
        rbResposta4       = findViewById(R.id.rbResposta4);
        proxima_Pergunta  = findViewById(R.id.btnProxima);
        cartas            = findViewById(R.id.btnCartas);

        // Popular índices disponíveis (embaralhar perguntas sem repetir)
        for (int i = 0; i < Perguntas.length; i++) indicesDisponiveis.add(i);

        // Listener de seleção (pega índice 0..3)
        rgRespostas.setOnCheckedChangeListener((group, checkedId) -> {
            if (checkedId == R.id.rbResposta1) respostaSelecionada = 0;
            else if (checkedId == R.id.rbResposta2) respostaSelecionada = 1;
            else if (checkedId == R.id.rbResposta3) respostaSelecionada = 2;
            else if (checkedId == R.id.rbResposta4) respostaSelecionada = 3;
        });

        carregarPergunta();

        // Próxima pergunta
        proxima_Pergunta.setOnClickListener(v -> {
            int checkedId = rgRespostas.getCheckedRadioButtonId();
            if (checkedId == -1) {
                Toast.makeText(this, "Selecione uma alternativa!", Toast.LENGTH_SHORT).show();
                return;
            }

            // Descobre o índice 0..3 a partir do RadioButton marcado
            View marcado = findViewById(checkedId);
            int indiceSelecionado = rgRespostas.indexOfChild(marcado);

            // Usa esse índice para validar
            if (indiceSelecionado == respostaCerta[perguntaAtual]) {
                pontuacao++;
            }

            numeroPerguntas--;

            if (numeroPerguntas > 0) {
                carregarPergunta();
                if (numeroPerguntas == 1) proxima_Pergunta.setText("Finalizar");
            } else {
                SharedPreferences preferences = getSharedPreferences(ARQUIVO_USUARIO, 0);
                preferences.edit().putInt(PONTUACAO, pontuacao).apply();
                startActivity(new Intent(getApplicationContext(), Resultado.class));
                finish();
            }
        });


        // Cartas (eliminar alternativas erradas)
        cartas.setOnClickListener(v -> {
            Intent intent = new Intent(getApplicationContext(), Cartas.class);
            startActivityForResult(intent, 1);
            cartaSelecionou = true;
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == 1 && resultCode == RESULT_OK && data != null) {
            cartasRecebidas = data.getIntExtra("Carta", -1);
            cartas.setClickable(false);
            cartas.setAlpha(0.5f);

            if (cartasRecebidas > 0) {
                int correta = respostaCerta[perguntaAtual];

                boolean[] desativadas = new boolean[4];
                desativadas[correta] = true; // não desativa a correta

                Random random = new Random();
                int eliminadas = 0;

                while (eliminadas < cartasRecebidas) {
                    int i = random.nextInt(4);
                    if (!desativadas[i]) {
                        RadioButton alvo = getRadioByIndex(i);

                        // Se a alternativa a eliminar está marcada, desmarque tudo
                        if (alvo.isChecked()) {
                            rgRespostas.clearCheck();       // 🔑 limpa seleção
                            // respostaSelecionada = -1;    // (se mantiver a variável)
                        }

                        alvo.setEnabled(false);
                        alvo.setAlpha(0.5f);
                        desativadas[i] = true;
                        eliminadas++;
                    }
                }

            }
        }
    }

    private RadioButton getRadioByIndex(int idx) {
        switch (idx) {
            case 0: return rbResposta1;
            case 1: return rbResposta2;
            case 2: return rbResposta3;
            case 3: return rbResposta4;
        }
        return rbResposta1;
    }

    // Carrega próxima pergunta aleatória, sem repetir
    private void carregarPergunta() {
        // Reset visual/estado SEMPRE que entrar em nova pergunta
        habilitarTodas(true);
        setAlphaTodas(1f);
        rgRespostas.clearCheck();        // 🔑 nada marcado
        // respostaSelecionada = -1;     // (apenas se você mantiver essa variável)

        numerodaPergunta.setText(
                "Pergunta " + (Perguntas.length - indicesDisponiveis.size() + 1) + " de 10"
        );

        if (indicesDisponiveis.size() == 0) return;

        Random random = new Random();
        int posicao = random.nextInt(indicesDisponiveis.size());
        perguntaAtual = indicesDisponiveis.get(posicao);
        indicesDisponiveis.remove(posicao);

        pergunta.setText(Perguntas[perguntaAtual]);
        rbResposta1.setText(Respostas[perguntaAtual][0]);
        rbResposta2.setText(Respostas[perguntaAtual][1]);
        rbResposta3.setText(Respostas[perguntaAtual][2]);
        rbResposta4.setText(Respostas[perguntaAtual][3]);

        cartas.setClickable(true);
        cartas.setAlpha(1f);
    }


    private void habilitarTodas(boolean enabled) {
        rbResposta1.setEnabled(enabled);
        rbResposta2.setEnabled(enabled);
        rbResposta3.setEnabled(enabled);
        rbResposta4.setEnabled(enabled);
    }

    private void setAlphaTodas(float a) {
        rbResposta1.setAlpha(a);
        rbResposta2.setAlpha(a);
        rbResposta3.setAlpha(a);
        rbResposta4.setAlpha(a);
    }

    // Verifica acerto e atualiza pontuação
    private void acertoErro() {
        if (respostaSelecionada == respostaCerta[perguntaAtual]) {
            pontuacao++;
            bemVindo.setText(bemVindo.getText().toString()); // mantém sua lógica original
        }
    }
}