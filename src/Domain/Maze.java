/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Domain;

public class Maze {

    int[][] matrizGenaral;
    int filas, columnas, s, e,s1,e1;
    int fil_entrada, col_entrada, filasalida, columnaSalisa, fil_entrada1, col_entrada1, filasalida1, columnaSalisa1;
    int x, y, termino;
    int f;
    int radioBotones;

    public Maze(int[][] matrizGenaral, int filas, int columnas, int s, int e, int s1, int e1, int fil_entrada, int col_entrada, int filasalida, int columnaSalisa, int fil_entrada1, int col_entrada1, int filasalida1, int columnaSalisa1, int x, int y, int termino, int f, int radioBotones) {
        this.matrizGenaral = matrizGenaral;
        this.filas = filas;
        this.columnas = columnas;
        this.s = s;
        this.e = e;
        this.s1 = s1;
        this.e1 = e1;
        this.fil_entrada = fil_entrada;
        this.col_entrada = col_entrada;
        this.filasalida = filasalida;
        this.columnaSalisa = columnaSalisa;
        this.fil_entrada1 = fil_entrada1;
        this.col_entrada1 = col_entrada1;
        this.filasalida1 = filasalida1;
        this.columnaSalisa1 = columnaSalisa1;
        this.x = x;
        this.y = y;
        this.termino = termino;
        this.f = f;
        this.radioBotones = radioBotones;
    }

  

    public Maze(int[][] matrizGenaral) {
        this.matrizGenaral = matrizGenaral;
        filas = 0;
        columnas = 0;
        s = 0;
        e = 0;
        fil_entrada = 0;
        col_entrada = 0;
        filasalida = 0;
        columnaSalisa = 0;
        x = 0;
        y = 0;
        termino = 0;
        f = 0;
        radioBotones = 0;
        s1=0;
        e1=0;
        fil_entrada1=0;
        col_entrada1=0;
        filasalida1=0;
        columnaSalisa1=0;
    }

    public int[][] getMatrizGenaral() {
        return matrizGenaral;
    }

    public void setMatrizGenaral(int[][] matrizGenaral) {
        this.matrizGenaral = matrizGenaral;
    }

    public int getFilas() {
        return filas;
    }

    public void setFilas(int filas) {
        this.filas = filas;
    }

    public int getColumnas() {
        return columnas;
    }

    public void setColumnas(int columnas) {
        this.columnas = columnas;
    }

    public int getS() {
        return s;
    }

    public void setS(int s) {
        this.s = s;
    }

    public int getE() {
        return e;
    }

    public void setE(int e) {
        this.e = e;
    }

    public int getS1() {
        return s1;
    }

    public void setS1(int s1) {
        this.s1 = s1;
    }

    public int getE1() {
        return e1;
    }

    public void setE1(int e1) {
        this.e1 = e1;
    }

    public int getFil_entrada() {
        return fil_entrada;
    }

    public void setFil_entrada(int fil_entrada) {
        this.fil_entrada = fil_entrada;
    }

    public int getCol_entrada() {
        return col_entrada;
    }

    public void setCol_entrada(int col_entrada) {
        this.col_entrada = col_entrada;
    }

    public int getFilasalida() {
        return filasalida;
    }

    public void setFilasalida(int filasalida) {
        this.filasalida = filasalida;
    }

    public int getColumnaSalisa() {
        return columnaSalisa;
    }

    public void setColumnaSalisa(int columnaSalisa) {
        this.columnaSalisa = columnaSalisa;
    }

    public int getFil_entrada1() {
        return fil_entrada1;
    }

    public void setFil_entrada1(int fil_entrada1) {
        this.fil_entrada1 = fil_entrada1;
    }

    public int getCol_entrada1() {
        return col_entrada1;
    }

    public void setCol_entrada1(int col_entrada1) {
        this.col_entrada1 = col_entrada1;
    }

    public int getFilasalida1() {
        return filasalida1;
    }

    public void setFilasalida1(int filasalida1) {
        this.filasalida1 = filasalida1;
    }

    public int getColumnaSalisa1() {
        return columnaSalisa1;
    }

    public void setColumnaSalisa1(int columnaSalisa1) {
        this.columnaSalisa1 = columnaSalisa1;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getTermino() {
        return termino;
    }

    public void setTermino(int termino) {
        this.termino = termino;
    }

    public int getF() {
        return f;
    }

    public void setF(int f) {
        this.f = f;
    }

    public int getRadioBotones() {
        return radioBotones;
    }

    public void setRadioBotones(int radioBotones) {
        this.radioBotones = radioBotones;
    }

}
