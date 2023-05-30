package edu.fiuba.algo3.modelo;

public class TorreBlanca extends Defensa {

    public TorreBlanca(){
        this.sistemaDeAtaque = new SistemaDeAtaque(1,3);
        this.turnosNecesarios = new TurnosNecesarios(1);
        this.coste = 10;
        Jugador jugador = Jugador.getInstancia();
        jugador.restarCreditos(this.coste());
    }
}
