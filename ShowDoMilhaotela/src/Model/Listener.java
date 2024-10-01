/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Model;

import java.util.Map;

/**
 * @author Afonso
 */
public interface Listener {

   public void enviaPerguntaAlternativa( String enunciado, Map<String, String> alternativas, Pergunta pergunta );


   public void enviaPerguntaMatematica( String enunciado, Pergunta pergunta );

}
