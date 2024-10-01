package Controller;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import Model.CarregaPerguntas;
import Model.Listener;
import Model.Pergunta;
import Model.PerguntaMatematica;
import Model.PerguntasAlternativa;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 * @author Afonso
 */
public class Jogo {

   private static int            contador = 0;
   private static List<Pergunta> perguntas;
   private static Listener       listener;

   public static void questao( boolean alternativaE ) {

      // MUDAR O CONTADOR DEPOIS
      Pergunta pergunta = perguntas.get( contador++ );

      if( pergunta instanceof PerguntasAlternativa ){
         PerguntasAlternativa perguntaAlternativa = (PerguntasAlternativa)pergunta;

         // enunciado
         System.out.println();
         System.out.println( pergunta.getEnunciado() );

         // mapeia
         Map<String, String> mapeiaAlternativas = mapeiaAlternativas( perguntaAlternativa, alternativaE );
         listener.enviaPerguntaAlternativa( pergunta.getEnunciado(), mapeiaAlternativas, pergunta );
      }
      else{
         PerguntaMatematica perguntaMatematica = (PerguntaMatematica)pergunta;

         System.out.println( "Enunciado: " + perguntaMatematica.getEnunciado() );
         listener.enviaPerguntaMatematica( perguntaMatematica.getEnunciado(), pergunta );

      }
   }


   public static Map<String, String> mapeiaAlternativas( PerguntasAlternativa pergunta, boolean alternativaE ) {
      Map<String, String> perguntas = new HashMap<>();

      if( !alternativaE ){
         List<String> alternativas = pergunta.getAlternativas().subList( 0, 4 );
         Collections.shuffle( alternativas );

         perguntas.put( "a", alternativas.get( 0 ) );
         perguntas.put( "b", alternativas.get( 1 ) );
         perguntas.put( "c", alternativas.get( 2 ) );
         perguntas.put( "d", alternativas.get( 3 ) );

         return perguntas;

      }

      List<String> alternativas = pergunta.getAlternativas();
      Collections.shuffle( alternativas );

      perguntas.put( "a", alternativas.get( 0 ) );
      perguntas.put( "b", alternativas.get( 1 ) );
      perguntas.put( "c", alternativas.get( 2 ) );
      perguntas.put( "d", alternativas.get( 3 ) );
      perguntas.put( "e", alternativas.get( 4 ) );

      return perguntas;

   }


   public static void setEtapa1() {
      Jogo.perguntas = CarregaPerguntas.getEtapa1();

   }


   public static void setEtapa2() {
      Jogo.perguntas = CarregaPerguntas.getEtapa2();
      contador = 0;
   }


   public static void setEtapa3() {
      Jogo.perguntas = CarregaPerguntas.getEtapa3();
      contador = 0;
   }


   public static void setListener( Listener l ) {
      listener = l;
   }


   public static List<Pergunta> getPerguntas() {
      return perguntas;
   }
}
