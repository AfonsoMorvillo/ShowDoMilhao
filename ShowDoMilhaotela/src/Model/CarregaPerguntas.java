package Model;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class CarregaPerguntas {

   private static List<Pergunta> perguntas = new ArrayList<>();

   public static void carregarPerguntas( int etapa ) {

      try{

         File f = new File( "arquivos/perguntas" + etapa + ".txt" );
         Scanner sc = new Scanner( f );

         while( sc.hasNextLine() ){

            String s[] = sc.nextLine().split( ";" );

            // MAIOR == QUESTOA DE MULTIPLA ESCOLHA
            if( s.length > 2 ){
               perguntas.add( new PerguntasAlternativa( s[ 0 ], s[ 1 ], s[ 2 ], s[ 3 ], s[ 4 ], s[ 5 ] ) );
            }
            else{
               perguntas.add( new PerguntaMatematica( s[ 0 ], s[ 1 ] ) );
            }

         }
         System.out.println( " carregou ETAPA " + etapa );
         Collections.shuffle( perguntas );
         sc.close();
      }
      catch( Exception e ){
         e.printStackTrace();
      }

   }
   

   public static List<Pergunta> getEtapa1() {
      carregarPerguntas( 1 );
      return perguntas;
   }


   public static List<Pergunta> getEtapa2() {
      perguntas.clear();
      carregarPerguntas( 2 );
      return perguntas;
   }


   public static List<Pergunta> getEtapa3() {
      perguntas.clear();
      carregarPerguntas( 3 );
      return perguntas;
   }

}
