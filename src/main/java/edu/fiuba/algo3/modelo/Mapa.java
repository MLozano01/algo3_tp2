package edu.fiuba.algo3.modelo;

import java.util.ArrayList;
import java.util.Iterator;

public class Mapa {
     final private static Mapa instancia = new Mapa();
    final private ArrayList<Camino> caminos;
    final private ArrayList<Enemigo> enemigos;

    private Mapa() {
        this.caminos = new ArrayList<>();
        this.enemigos = new ArrayList<>();
    }

    public static Mapa getInstancia() {
        return instancia;
    }

    public void ubicarCamino(Camino camino) {
        this.caminos.add(camino);
    }

    public void ubicarEnemigo(Enemigo enemigo) {
        this.enemigos.add(enemigo);
    }


    public Enemigo getObjetivo(Parcela parcela) {
        Iterator<Enemigo> it = enemigos.iterator();
        Enemigo enemigoCercano = it.next();
        int distanciaMinima = enemigoCercano.distancia(parcela);
        int distanciaElemento;
        Enemigo enemigo;
        while(it.hasNext()){
            enemigo = it.next();
            distanciaElemento = enemigo.distancia(parcela);

            if (distanciaMinima > distanciaElemento) {
                distanciaMinima = distanciaElemento;
                enemigoCercano = enemigo;
            }
        }
        return enemigoCercano;
    }

    public void reiniciar() {
        enemigos.clear();
        caminos.clear();
    }

    public void moverEnemigos() {
        Enemigo enemigo;

        for (int i = enemigos.size()-1; i >= 0; i--) {
            enemigo = enemigos.get(i);
            enemigo.mover();
        }
    }

    public boolean gano() {
        Jugador jugador = Jugador.getInstancia();
        return (enemigos.size() == 0 && !(jugador.estaMuerto()));
    }

    public boolean perdio(){
        Jugador jugador = Jugador.getInstancia();
        return (jugador.estaMuerto());
    }


    public void removerEnemigo(Enemigo enemigo) {
        this.enemigos.remove(enemigo);
    }
}