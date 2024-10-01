/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Jogador implements Comparable<Jogador> {
    private int pontos;
    private String nome;

    public Jogador(int pontos, String nome) {
        this.pontos = pontos;
        this.nome = nome;
    }

    public int getPontos() {
        return pontos;
    }

    public String getNome() {
        return nome;
    }

    @Override
    public int compareTo(Jogador t) {
        return t.getPontos() - this.getPontos();
    }
}




