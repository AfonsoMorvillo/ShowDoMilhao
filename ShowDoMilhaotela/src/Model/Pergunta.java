package Model;

public abstract class Pergunta {
   private String enunciado;
   private String resposta;

   public Pergunta( String enunciado, String resposta ) {
      this.enunciado = enunciado;
      this.resposta = resposta;
   }


   public String getEnunciado() {
      return enunciado;
   }


   public String getResposta() {
      return resposta;
   }


   public abstract boolean verificaResposta( String resp );
}
