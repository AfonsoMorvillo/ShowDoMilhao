/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

/**
 * @author aluno
 */
public class RankingJogadores {
   private static final String FILE_PATH = "arquivos/ranking.txt";

   public static void escreveRanking( String nomeJogador, int pontuacao ) {
      try( BufferedWriter writer = new BufferedWriter( new FileWriter( FILE_PATH, true ) )){
         String linha = nomeJogador + ";" + pontuacao;
         writer.write( linha );
         writer.newLine();
      }
      catch( IOException e ){
         e.printStackTrace();
      }
   }

}
