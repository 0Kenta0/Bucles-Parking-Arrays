package com.company;

import javax.swing.*;
import java.awt.*;

public class Main {

    public static void main(String[] args) {
        //WHILE-  Pasar 10 num y registrar si son +, - o 0 y devolver cantidad de los mismos
        /*
        While obj=new While();

        obj.bucle();
        int posNum= obj.getPosNum(), negNum= obj.getNegNum(), ceroNum= obj.getCeroNum();
        System.out.println("La cantidad de números positivos es "+posNum);
        System.out.println("La cantidad de número negativos es "+negNum);
        System.out.println("La cantidad de ceros es "+ceroNum);
         */
        //WHILE- Pedir por teclado tantos num como alguien quiera pero si da un 0 dejas de pedir. Reflejar por pantalla la tabla de multiplicar del 0-10 de cada num que te den.
        /*
        While obj=new While();

        int num;

        num = Integer.parseInt(JOptionPane.showInputDialog("Introduce un número"));

        while(num!=0){
            obj.bucle(num);
            num = Integer.parseInt(JOptionPane.showInputDialog("Introduce un número"));
        }

         */

        //WHILE- Pedir por teclado sueldo trabajadores y analizar cuantos salario>1000 hasta que den 0 (acaba el bucle) sacar porcentaje sueldo debajo de mil.
        /*
        While obj=new While();

        int sueldo;
        double porcent;

        sueldo= Integer.parseInt(JOptionPane.showInputDialog("Introduce el sueldo del trabajador"));

        while(sueldo!=0){
            obj.condicion(sueldo);
            sueldo= Integer.parseInt(JOptionPane.showInputDialog("Introduce el sueldo del trabajador"));
        }
        porcent = 100*(obj.contSub / obj.contTot);
        System.out.println(porcent+" %");
         */
        //Do WHILE- Ejemplo
        /*
        While obj=new While();

        int num;

        num = Integer.parseInt(JOptionPane.showInputDialog("Introduce un número"));

        while(num!=0){
            obj.bucle(num);
            num = Integer.parseInt(JOptionPane.showInputDialog("Introduce un número"));
        }
                 */
        //Do-WHILE- Al ejecutar num aleatorio (0-50) y pides por teclado un num y si num<random "Es menor", si num>random "...". !0 intentos si no lo consigue termina.
        /*
        While bucle=new While();

        bucle.bucle();
                 */
        //FreeStyle- Hacer un garage\Principio 5 plazas y le pasas la matricula de 1 coche dos métodos (Aparcar y marchar) al pasar matricula decir que la plaza ha sido asignada a la matricula y si no quedan plazas "No quedan plazas". Salir- introducir por teclado num horas estancia--Precio <3horas --> 1,5€/hora. >3horas -->1,5€/hora+0,2€extra/hora.Registrar dinero que me dan y dar cambio y decir cuanto.
        Parking obj = new Parking();

        int peticion=-1;
        obj.setupPlazas();

        while(peticion!=0) {
            peticion = Integer.parseInt(JOptionPane.showInputDialog("Que quieres hacer en el parking?\n1->Entrar\n2->Salir\n3-->Aforo\n4-->Reseteo del parking\n0->Acabar programa"));
            switch (peticion) {
                case 1:
                    obj.entrada();
                    break;
                case 2:
                    obj.salida();
                    break;
                case 3:
                    obj.aforo();
                    break;
                case 4:
                    obj.setupPlazas();
                    break;
                case 0:
                    System.out.println("Bye, bye");
                    break;
                default:
                    System.out.println("Esa acción no está registrada.");
            }
        }
    }
}
