/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package View;

import Model.Jogador;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

public class RankingPanel extends JPanel {
   private static final String FILE_PATH = "arquivos/ranking.txt";
   private JTable              table;

   public RankingPanel() {
      setPreferredSize( new Dimension( 1000, 650 ) );
      setLayout( new BorderLayout() );

      // Criar tabela
      DefaultTableModel model = new DefaultTableModel();
      model.addColumn( "Nome do Jogador" );
      model.addColumn( "Pontuação" );
      table = new JTable( model );
      JScrollPane scrollPane = new JScrollPane( table );
      add( scrollPane, BorderLayout.CENTER );

      // Carregar dados da tabela
      carregarDadosTabela();

      // Criar botão Voltar
      JButton btnVoltar = new JButton( "Voltar" );
      btnVoltar.addActionListener( new ActionListener() {
         public void actionPerformed( ActionEvent e ) {
            Menu.Menu();
         }
      } );

      // Adicionar botão ao painel
      JPanel buttonPanel = new JPanel();
      buttonPanel.add( btnVoltar );
      add( buttonPanel, BorderLayout.SOUTH );
   }


  private void carregarDadosTabela() {
   java.util.List<Jogador> listaJogadores = new ArrayList<>();
   DefaultTableModel model = (DefaultTableModel) table.getModel();
   model.setRowCount(0);

   try (BufferedReader br = new BufferedReader(new FileReader(FILE_PATH))) {
      String line;
      while ((line = br.readLine()) != null) {
         String[] data = line.split(";");
         Jogador jogador = new Jogador(Integer.parseInt(data[0]), data[1]); // Considerando que o primeiro campo é o número de pontos e o segundo é o nome do jogador
         listaJogadores.add(jogador);
      }

      // Ordena a lista de jogadores usando o jogad orComparator
      Collections.sort(listaJogadores);

      // Escreve os dados na tabela
      for (Jogador jogador : listaJogadores) {
         model.addRow(new Object[] { jogador.getPontos(), jogador.getNome() });
      }
   } catch (IOException e) {
      System.out.println("Ocorreu um erro ao ler o arquivo CSV: " + e.getMessage());
   }
}


}
