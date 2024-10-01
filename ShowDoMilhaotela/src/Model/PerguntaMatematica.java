package Model;

public class PerguntaMatematica extends Pergunta {

   public PerguntaMatematica( String enunciado, String resposta ) {
      super( enunciado, resposta );
   }


   @Override
   public boolean verificaResposta( String resp ) {
      if( resp.equals( getResposta() ) ){
         return true;
      }
      return false;

   }

}
