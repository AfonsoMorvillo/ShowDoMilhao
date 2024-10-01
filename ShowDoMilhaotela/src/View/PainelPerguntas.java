/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package View;

import Controller.Jogo;
import Model.Listener;
import Model.Pergunta;
import Model.PerguntaMatematica;
import Model.RankingJogadores;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.HeadlessException;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Map;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineEvent;
import javax.sound.sampled.LineListener;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.border.Border;

/**
 *
 * @author Afonso
 */
public class PainelPerguntas extends javax.swing.JPanel {

    /**
     * Creates new form PainelPerguntas
     */
    public int contador = 0;
    public Pergunta perguntaAtual;
    public Map<String, String> alternativasAtual;
    public boolean alternativaELigada = false;
    public int contadorPulos = 3;
    public int contadorAjudas = 3;
    public static String nomeJogador;
    public static int pontuacao = 0;
    private CronometroPanel cronometroPanel;
    private boolean contCronometro = false;

    public PainelPerguntas() {

        initComponents();

        Border bordaPersonalizada = BorderFactory.createMatteBorder(2, 5, 2, 5, Color.BLACK);
        Labelpergunta.setBorder(bordaPersonalizada);

        alternativaE.setVisible(alternativaELigada);
        jPontuacao.setText("Pontuação: "+pontuacao);

        Jogo.setListener(new Listener() {

            @Override
            public void enviaPerguntaAlternativa(String enunciado, Map<String, String> alternativas, Pergunta pergunta) {
                setEnunciado(enunciado);
                setValorBotao(alternativas);
                perguntaAtual = pergunta;
                alternativasAtual = alternativas;
                setPerguntaAlternativa();


                if (contadorPulos != 0) {
                    pular.setVisible(true);
                } else {
                    pular.setVisible(false);
                }

                if (contadorAjudas != 0) {
                    ajuda.setVisible(true);
                } else {
                    ajuda.setVisible(false);
                }

                if (contCronometro) {
                    adicionaCronometro();
                }

            }

            @Override
            public void enviaPerguntaMatematica(String enunciado, Pergunta pergunta) {
                setEnunciado(enunciado);
                perguntaAtual = pergunta;
                setPerguntaMatematica();
                pular.setVisible(false);
                ajuda.setVisible(false);
                respostaMatematica.setText("");
                if (contCronometro) {
                    adicionaCronometro();
                }

            }

        });
        Jogo.setEtapa1();
        Jogo.questao(alternativaELigada);

    }

  

    public void setEnunciado(String s) {
        String stringFormatada = "<html>" + s.replace("\n", "<br>") + "</html>";
        this.enunciado.setText(stringFormatada);
    }

    public void setValorBotao(Map<String, String> alternativas) {

        this.alternativaA.setText("A: " + alternativas.get("a"));
        this.alternativaB.setText("B: " + alternativas.get("b"));
        this.alternativaC.setText("C: " + alternativas.get("c"));
        this.alternativaD.setText("D: " + alternativas.get("d"));

        if (alternativas.containsKey("e")) {

            this.alternativaE.setText("E: " + alternativas.get("e"));
        }

        this.alternativaA.setHorizontalAlignment(SwingConstants.LEFT);
        this.alternativaB.setHorizontalAlignment(SwingConstants.LEFT);
        this.alternativaC.setHorizontalAlignment(SwingConstants.LEFT);
        this.alternativaD.setHorizontalAlignment(SwingConstants.LEFT);
        this.alternativaE.setHorizontalAlignment(SwingConstants.LEFT);
//        
//        this.alternativaA.setPreferredSize(new Dimension(buttonWidth, this.alternativaA.getHeight()));
//        this.alternativaB.setPreferredSize(new Dimension(buttonWidth, this.alternativaB.getHeight()));
//        this.alternativaC.setPreferredSize(new Dimension(buttonWidth, this.alternativaC.getHeight()));
//        this.alternativaD.setPreferredSize(new Dimension(buttonWidth, this.alternativaD.getHeight()));
    }

    public boolean verificaRespostaMatematica(String numero) {
        if (numero.equals(perguntaAtual.getResposta())) {
            return true;
        }
        return false;

    }

    public boolean verificaResposta(String resposta) {

        if (alternativasAtual.get(resposta).equals(perguntaAtual.getResposta())) {
            System.out.println("VOCE ACERTOU!!");
            return true;
        }

        System.out.println("ERROUUUUU!!");
        return false;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")


    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel3 = new javax.swing.JLabel();
        alternativaC = new javax.swing.JButton();
        alternativaB = new javax.swing.JButton();
        alternativaD = new javax.swing.JButton();
        alternativaA = new javax.swing.JButton();
        alternativaE = new javax.swing.JButton();
        confirmar = new javax.swing.JButton();
        enunciado = new javax.swing.JLabel();
        respostaMatematica = new javax.swing.JTextField();
        ajuda = new javax.swing.JButton();
        pular = new javax.swing.JButton();
        Labelpergunta = new javax.swing.JLabel();
        cronometro = new javax.swing.JPanel();
        jPontuacao = new javax.swing.JLabel();

        setBackground(new java.awt.Color(1, 1, 223));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/ShowIcon.png.png"))); // NOI18N
        add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 20, -1, -1));

        alternativaC.setBackground(new java.awt.Color(113, 4, 4));
        alternativaC.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 16)); // NOI18N
        alternativaC.setForeground(new java.awt.Color(255, 255, 255));
        alternativaC.setText("alternativaC");
        alternativaC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                alternativaCActionPerformed(evt);
            }
        });
        add(alternativaC, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 320, 550, 50));

        alternativaB.setBackground(new java.awt.Color(113, 4, 4));
        alternativaB.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 16)); // NOI18N
        alternativaB.setForeground(new java.awt.Color(255, 255, 255));
        alternativaB.setText("alternativaB");
        alternativaB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                alternativaBActionPerformed(evt);
            }
        });
        add(alternativaB, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 250, 550, 50));

        alternativaD.setBackground(new java.awt.Color(113, 4, 4));
        alternativaD.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 16)); // NOI18N
        alternativaD.setForeground(new java.awt.Color(255, 255, 255));
        alternativaD.setText("alternativaD");
        alternativaD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                alternativaDActionPerformed(evt);
            }
        });
        add(alternativaD, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 390, 550, 50));

        alternativaA.setBackground(new java.awt.Color(113, 4, 4));
        alternativaA.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 16)); // NOI18N
        alternativaA.setForeground(new java.awt.Color(255, 255, 255));
        alternativaA.setText("alternativaA");
        alternativaA.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        alternativaA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                alternativaAActionPerformed(evt);
            }
        });
        add(alternativaA, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 180, 550, 50));

        alternativaE.setBackground(new java.awt.Color(113, 4, 4));
        alternativaE.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 16)); // NOI18N
        alternativaE.setForeground(new java.awt.Color(255, 255, 255));
        alternativaE.setText("alternativaE");
        alternativaE.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                alternativaEActionPerformed(evt);
            }
        });
        add(alternativaE, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 460, 550, 50));

        confirmar.setBackground(new java.awt.Color(113, 4, 4));
        confirmar.setForeground(new java.awt.Color(255, 255, 255));
        confirmar.setText("Confirmar");
        confirmar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                confirmarActionPerformed(evt);
            }
        });
        add(confirmar, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 180, 100, 50));

        enunciado.setBackground(new java.awt.Color(255, 0, 0));
        enunciado.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 22)); // NOI18N
        enunciado.setForeground(new java.awt.Color(255, 255, 255));
        enunciado.setText("PERGUNTA");
        enunciado.setToolTipText("");
        enunciado.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        add(enunciado, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 40, 540, 80));
        add(respostaMatematica, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 180, 200, 50));

        ajuda.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 14)); // NOI18N
        ajuda.setText("AJUDA");
        ajuda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ajudaActionPerformed(evt);
            }
        });
        add(ajuda, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 552, 90, 40));

        pular.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 14)); // NOI18N
        pular.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/seta-direita.png"))); // NOI18N
        pular.setText("PULAR");
        pular.setToolTipText("");
        pular.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        pular.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pularActionPerformed(evt);
            }
        });
        add(pular, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 550, -1, 40));

        Labelpergunta.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/wepik-export-20230627121207APRc.png"))); // NOI18N
        Labelpergunta.setBorder(javax.swing.BorderFactory.createEtchedBorder(java.awt.Color.darkGray, java.awt.Color.white));
        add(Labelpergunta, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, 550, 100));

        cronometro.setBackground(new java.awt.Color(1, 1, 223));
        add(cronometro, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 480, 220, 50));

        jPontuacao.setFont(new java.awt.Font("Liberation Sans", 0, 24)); // NOI18N
        jPontuacao.setForeground(new java.awt.Color(255, 255, 255));
        jPontuacao.setText("Pontuação:");
        add(jPontuacao, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 160, 130, 40));
    }// </editor-fold>//GEN-END:initComponents

    private void alternativaAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_alternativaAActionPerformed

        acaoBotao("a");


    }//GEN-LAST:event_alternativaAActionPerformed


    private void alternativaBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_alternativaBActionPerformed

        acaoBotao("b");
    }//GEN-LAST:event_alternativaBActionPerformed

    private void alternativaCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_alternativaCActionPerformed

        acaoBotao("c");
    }//GEN-LAST:event_alternativaCActionPerformed

    private void alternativaDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_alternativaDActionPerformed

        acaoBotao("d");
    }//GEN-LAST:event_alternativaDActionPerformed

    private void alternativaEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_alternativaEActionPerformed
        // TODO add your handling code here:
        acaoBotao("e");
    }//GEN-LAST:event_alternativaEActionPerformed

    private void confirmarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_confirmarActionPerformed
        // TODO add your handling code here:
        acaoBotao(respostaMatematica.getText().trim());
    }//GEN-LAST:event_confirmarActionPerformed

    private void ajudaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ajudaActionPerformed
        ajuda();
    }//GEN-LAST:event_ajudaActionPerformed

    private void pularActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pularActionPerformed
        pular();
    }//GEN-LAST:event_pularActionPerformed

    public void acaoBotao(String valorAlternativa) throws HeadlessException {
        play("estaCertoDisso");
        int opcao = JOptionPane.showConfirmDialog(this, "Tem certeza da sua resposta?", "Confirmação", JOptionPane.YES_NO_OPTION);

        if (opcao == JOptionPane.YES_OPTION) {
            if (perguntaAtual instanceof PerguntaMatematica) {
                if (verificaRespostaMatematica(valorAlternativa)) {
                    play("certaResposta");
                    pontuacao++;
                    JOptionPane.showMessageDialog(this, "Você acertou!", "Resultado", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(this, "Você PERDEU!", "Resultado", JOptionPane.ERROR_MESSAGE);
                    RankingJogadores.escreveRanking(nomeJogador, pontuacao);
                    Menu.Menu();
                    return;
                }

            } else {
                if (verificaResposta(valorAlternativa)) {
                    play("certaResposta");
                    pontuacao++;
                    JOptionPane.showMessageDialog(this, "Você acertou!", "Resultado", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(this, "Você PERDEU!", "Resultado", JOptionPane.ERROR_MESSAGE);
                    RankingJogadores.escreveRanking(nomeJogador, pontuacao);
                    Menu.Menu();
                    return;
                }

            }
            contador++;
            jPontuacao.setText("Pontuação: "+pontuacao);

            if (contador == 4) {
                alternativaELigada = true;
                Jogo.setEtapa2();

            }
            if (contador == 8) {
                Jogo.setEtapa3();
                contCronometro = true;
            }
            if (contador == 12) {
                // ganhou o jogo
                JOptionPane.showMessageDialog(this, "Parabéns, você ganhou o jogo!");
                Menu.Menu();
                RankingJogadores.escreveRanking(nomeJogador, pontuacao);
                return;
            }
            Jogo.questao(alternativaELigada);
        } else {
            
        }
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Labelpergunta;
    private javax.swing.JButton ajuda;
    private javax.swing.JButton alternativaA;
    private javax.swing.JButton alternativaB;
    private javax.swing.JButton alternativaC;
    private javax.swing.JButton alternativaD;
    private javax.swing.JButton alternativaE;
    private javax.swing.JButton confirmar;
    private javax.swing.JPanel cronometro;
    private javax.swing.JLabel enunciado;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jPontuacao;
    private javax.swing.JButton pular;
    private javax.swing.JTextField respostaMatematica;
    // End of variables declaration//GEN-END:variables

    public void setPerguntaMatematica() {

        this.respostaMatematica.setVisible(true);
        this.confirmar.setVisible(true);
        this.alternativaA.setVisible(false);
        this.alternativaB.setVisible(false);
        this.alternativaC.setVisible(false);
        this.alternativaD.setVisible(false);
        this.alternativaE.setVisible(false);

    }

    public void setPerguntaAlternativa() {
        this.respostaMatematica.setVisible(false);
        this.confirmar.setVisible(false);
        this.alternativaA.setVisible(true);
        this.alternativaB.setVisible(true);
        this.alternativaC.setVisible(true);
        this.alternativaD.setVisible(true);
        this.alternativaE.setVisible(alternativaELigada);
    }
    
     public void play(String resposta) {
        try {
            File audioFile = new File("arquivos/" + resposta + ".wav");
            AudioInputStream audioStream = AudioSystem.getAudioInputStream(audioFile);
            Clip clip = AudioSystem.getClip();
            clip.open(audioStream);

            clip.addLineListener(new LineListener() {
                public void update(LineEvent event) {
                    if (event.getType() == LineEvent.Type.STOP) {
                        clip.close();
                        try {
                            audioStream.close();
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }
            });

            clip.start();

            // Aguardar a reprodução completa do áudio
            while (clip.isRunning()) {
                Thread.sleep(100); // Pausa breve para evitar consumo excessivo de recursos
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void ajuda() {
        contadorAjudas--;
        ArrayList<JButton> botoes = new ArrayList<>(); // Inicializa o ArrayList
        botoes.add(alternativaA);
        botoes.add(alternativaB);
        botoes.add(alternativaC);
        botoes.add(alternativaD);

        if (alternativaELigada) {
            botoes.add(alternativaE);
        }

        Collections.shuffle(botoes);
        int contador = 0;

        ajuda.setVisible(false);
        for (JButton botao : botoes) {
          

            if (!perguntaAtual.getResposta().equals(botao.getText().substring(3))) {
                contador++;
                botao.setVisible(false);
            }
            if (contador == 2) {
                return;
            }
        }

    }

    private void pular() {
        contadorPulos--;
       
        Jogo.questao(alternativaELigada);
    }

    public void setNomeJogador(String nomeJogador) {
        this.nomeJogador = nomeJogador;
    }

    public String getNomeJogador() {
        return nomeJogador;
    }

    public void adicionaCronometro() {

        if (cronometroPanel != null) {
            cronometroPanel.stop();
        }

        cronometroPanel = new CronometroPanel();
        cronometroPanel.setIt(new InterfaceTempo() {
            @Override
            public void terminaJogo() {
                terminou();
            }
        });
        cronometro.removeAll();
        cronometro.add(cronometroPanel, BorderLayout.CENTER);
        cronometro.revalidate();
        cronometro.repaint();
    }

    public void terminou() {

        JOptionPane.showMessageDialog(this, "Você PERDEU!", "Resultado", JOptionPane.ERROR_MESSAGE);
        RankingJogadores.escreveRanking(nomeJogador, pontuacao);
        Menu.Menu();
        return;

    }
}
