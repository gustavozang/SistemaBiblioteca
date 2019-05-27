/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import gui.TelaLogin;

/** Esta é a classe principal do projeto que inicializa a janela de Login, contendo 
 * apenas a classe main.
 */
public class Principal {
    public static void main(String[] args){
        TelaLogin telalogin = new TelaLogin();
        telalogin.setVisible(true);
    }
}
