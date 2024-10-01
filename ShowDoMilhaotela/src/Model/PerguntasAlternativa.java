package Model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Afonso
 */
public class PerguntasAlternativa extends Pergunta {

   private List<String> alternativas = new ArrayList<>();

   public PerguntasAlternativa( String enunciado, String resposta, String string1, String string2, String string3, String string4 ) {
      super( enunciado, resposta );
      this.alternativas = new ArrayList<>( Arrays.asList( resposta, string1, string2, string3, string4 ) );

   }


   @Override
   public String toString() {
      return "Pergunta{" + "enunciado=" + getEnunciado() + ", alternativas=" + alternativas + ", resposta=" + getResposta() + '}';
   }


   public List<String> getAlternativas() {
      return alternativas;
   }


   @Override
   public boolean verificaResposta( String resp ) {
      if( resp.equals( getResposta() ) ){
         return true;
      }
      return false;

   }

}
