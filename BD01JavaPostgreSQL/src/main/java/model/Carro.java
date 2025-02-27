package model;

public class Carro {
    private int codigo;
    private String marca;
    private String modelo;
    private int ano;
    private char combustivel; // 'G' para Gasolina, 'A' para Álcool, 'D' para Diesel, 'E' para Elétrico, etc.

    public Carro() {
        this.codigo = -1;
        this.marca = "";
        this.modelo = "";
        this.ano = 0;
        this.combustivel = '*';
    }

    public Carro(int codigo, String marca, String modelo, int ano, char combustivel) {
        this.codigo = codigo;
        this.marca = marca;
        this.modelo = modelo;
        this.ano = ano;
        this.combustivel = combustivel;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public char getCombustivel() {
        return combustivel;
    }

    public void setCombustivel(char combustivel) {
        this.combustivel = combustivel;
    }

    @Override
    public String toString() {
        return "Carro [codigo=" + codigo + ", marca=" + marca + ", modelo=" + modelo + ", ano=" + ano + ", combustivel=" + combustivel + "]";
    }
}