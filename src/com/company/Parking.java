package com.company;

import javax.swing.*;
import java.math.RoundingMode;
import java.text.NumberFormat;
import java.util.Objects;
import java.util.Random;
                                                //Optimizar monedas y billetes que metes para no meter los que son 0. Crear consultor buscando por (plaza o matricula) y te de el opuesto. Si esta vacia la plaza decirlo y si no hay matricula decirlo.
public class Parking {
    Random rn = new Random();
    public String plazas[] = new String[25];

    public boolean existencia = false;
    public int plazasOcup = 0, randNum, duplicidad=0;// precio, pago, cambio, pBill100, pBill20, pBill5, pMon2, pMon1, pMon05, pMon02, cBill100, cBill20, cBill5, cMon2, cMon1, cMon05, cMon02, horasEstancia;
    public String matricSalida;//plaza1 = "vacio", plaza2 = "vacio", plaza3 = "vacio", plaza4 = "vacio", plaza5 = "vacio", matricSalida;
    public double precioReal, pagoReal, cambioReal, precio, pago, cambio, pBill100, pBill20, pBill5, pMon2, pMon1, pMon05, pMon02, pMon01, cBill100, cBill20, cBill5, cMon2, cMon1, cMon05, cMon02, cMon01, horasEstancia;//horasEstancia; precio, pago, cambio, pBill100, pBill20, pBill5, pMon2, pMon1, pMon05, pMon02, cBill100, cBill20, cBill5, cMon2, cMon1, cMon05, cMon02; //Pasar todo a cents
    //NUEVAS INDICACIONES-Ahora 25 plazas. Entrada asignar a plaza aleatoria. / Salida Pedir dinero en billetes y monedas dependiendo del tipo y cambio en bill y mon optimizados a max precio/(bill o mon)

    public void setupPlazas() {
        for (int i = 0; i < 25; i++) {
            if(!Objects.equals(plazas[i],"vacio")){
                plazas[i]="vacio";
                System.out.println("La "+(i + 1)+"ª plaza ha sido vaciada correctamente");
            }
        }
        plazasOcup=0;
    }

    public void entrada() {
        if (plazasOcup < 25 && plazasOcup >= 0) {
            plazasOcup++;
            do {
                randNum = rn.nextInt(25);
            } while (!Objects.equals(plazas[randNum], "vacio"));
            plazas[randNum] = JOptionPane.showInputDialog("Introduce la matrícula del coche.\nSu choche se estacionará en la " + (randNum + 1) + "ª plaza");
            for(int i = 0; i < 25; i++){
                if(Objects.equals(plazas[randNum],plazas[i])){
                    duplicidad++;
                }
            }
            if(duplicidad<1){
                System.out.println("Se ha producido un error en el sistema al registrar la matrícula del coche");
            }else if(duplicidad>1){
                System.out.println("La matrícula del vehículo a ingresar ya ha sido previamente ingresada.\nPor tanto ya se encuentra en el parking y la acción no será ejecutada");
                plazas[randNum]="vacio";
            }
            duplicidad=0;

            /*
            if (plaza1 == "vacio") {
                plaza1 = JOptionPane.showInputDialog("Introduce la matrícula del coche. Su choche se estacionará en la primera plaza");
                System.out.println("Su coche fue exitosamente estacionado en la primera plaza");
            } else if (plaza2 == "vacio" && plaza1 != "vacio") {
                plaza2 = JOptionPane.showInputDialog("Introduce la matrícula del coche. Su choche se estacionará en la segunda plaza");
                System.out.println("Su coche fue exitosamente estacionado en la segunda plaza");
            } else if (plaza3 == "vacio" && plaza1 != "vacio" && plaza2 != "vacio") {
                plaza3 = JOptionPane.showInputDialog("Introduce la matrícula del coche. Su choche se estacionará en la tercera plaza");
                System.out.println("Su coche fue exitosamente estacionado en la tercera plaza");
            } else if (plaza4 == "vacio" && plaza1 != "vacio" && plaza2 != "vacio" && plaza3 != "vacio") {
                plaza4 = JOptionPane.showInputDialog("Introduce la matrícula del coche. Su choche se estacionará en la cuarta plaza");
                System.out.println("Su coche fue exitosamente estacionado en la cuarta plaza");
            } else if (plaza5 == "vacio" && plaza1 != "vacio" && plaza2 != "vacio" && plaza3 != "vacio" && plaza4 != "vacio") {
                plaza5 = JOptionPane.showInputDialog("Introduce la matrícula del coche. Su choche se estacionará en la quinta plaza");
                System.out.println("Su coche fue exitosamente estacionado en la quinta plaza");
            } else {
                System.out.println("Se ha producido un error en el sistema");
            }
                         */
        } else {
            System.out.println("No hay plazas libres");
        }
    }

    public void salida() {
        plazasOcup--;
        matricSalida = JOptionPane.showInputDialog("Introduce la matrícula del coche a extraer del parking");
        for (int i = 0; i < 25; i++) {
            if (Objects.equals(plazas[i], matricSalida)) {
                existencia = true;
                plazas[i] = "vacio";
                System.out.println("La " + (i + 1) + "ª plaza queda liberada");
                pago();
            }
        }
        if (!existencia) {
            System.out.println("No se ha encontrado su vehículo entre los estacionados en el parking");
        }
        existencia = false;
        /*
        if (Objects.equals(matricSalida, plaza1)) {
            plaza1 = "vacio";
            System.out.println("La primera plaza queda liberada");
            pago();
        } else if (Objects.equals(matricSalida, plaza2)) {
            plaza2 = "vacio";
            System.out.println("La segunda plaza queda liberada");
            pago();
        } else if (Objects.equals(matricSalida, plaza3)) {
            plaza3 = "vacio";
            System.out.println("La tercera plaza queda liberada");
            pago();
        } else if (Objects.equals(matricSalida, plaza4)) {
            plaza4 = "vacio";
            System.out.println("La cuarta plaza queda liberada");
            pago();
        } else if (Objects.equals(matricSalida, plaza5)) {
            plaza5 = "vacio";
            System.out.println("La quinta plaza queda liberada");
            pago();
        } else {
            System.out.println("No se ha encontrado su vehículo entre los estacionados en el parking");
        }
        */
    }

    public void pago() {
        horasEstancia = Integer.parseInt(JOptionPane.showInputDialog("Introduce el número de horas de la estancia"));
        if (horasEstancia < 3 && horasEstancia >= 0) {
            System.out.println("El precio que ha de pagar es: " + (precioReal = (precio = horasEstancia * 150)/100) + "€");
        } else {
            System.out.println("El precio que ha de pagar es: " + (precioReal = (precio = horasEstancia * 150 + 20 * (horasEstancia - 3))/100) + "€");
        }
        do {
            pBill100 = Integer.parseInt(JOptionPane.showInputDialog("Introduce la cantidad de billetes de 100€ abonada"));
            pBill20 = Integer.parseInt(JOptionPane.showInputDialog("Introduce la cantidad de billetes de 20€ abonada"));
            pBill5 = Integer.parseInt(JOptionPane.showInputDialog("Introduce la cantidad de billetes de 5€ abonada"));
            pMon2 = Integer.parseInt(JOptionPane.showInputDialog("Introduce la cantidad de monedas de 2€ abonada"));
            pMon1 = Integer.parseInt(JOptionPane.showInputDialog("Introduce la cantidad de monedas de 1€ abonada"));
            pMon05 = Integer.parseInt(JOptionPane.showInputDialog("Introduce la cantidad de monedas de 0,50€ abonada"));
            pMon02 = Integer.parseInt(JOptionPane.showInputDialog("Introduce la cantidad de monedas de 0,20€ abonada"));
            pMon01 = Integer.parseInt(JOptionPane.showInputDialog("Introduce la cantidad de monedas de 0,10€ abonada"));
            System.out.println("La cantidad total abonada es de " + (pagoReal = (pago = pBill100 * 10000 + pBill20 * 2000 + pBill5 * 500 + pMon2 * 200 + pMon1 * 100 + pMon05 * 50 + pMon02 * 20 + pMon01 * 10)/100) + "€");
            if (pago > precio) {
                NumberFormat numberFormat = NumberFormat.getInstance();
                numberFormat.setMaximumFractionDigits(0);
                numberFormat.setRoundingMode(RoundingMode.DOWN);
                cambio = pago - precio;
                cBill100 = Integer.parseInt(numberFormat.format(cambio / 10000));
                cBill20 = Integer.parseInt(numberFormat.format((cambio % 10000) / 2000));
                cBill5 = Integer.parseInt(numberFormat.format((cambio % 10000 % 2000) / 500));
                cMon2 = Integer.parseInt(numberFormat.format((cambio % 10000 % 2000 % 500) / 200));
                cMon1 = Integer.parseInt(numberFormat.format((cambio % 10000 % 2000 % 500 % 200) / 100));
                cMon05 = Integer.parseInt(numberFormat.format((cambio % 10000 % 2000 % 500 % 200 % 100) / 50));             //!!!!!Aun no funcionan los céntimos!!!!!
                cMon02 = Integer.parseInt(numberFormat.format((cambio % 10000 % 2000 % 500 % 200 % 100 % 50) / 20));
                cMon01 = Integer.parseInt(numberFormat.format((cambio % 10000 % 2000 % 500 % 200 % 100 % 50 % 20) / 10));
                System.out.println("Tome su cambio, gracias ^^: " + (cambioReal = cambio/100) + "€ en " + cBill100 + " billetes de 100€, " + cBill20 + " billetes de 20€, " + cBill5 + " billetes de 5€, " + cMon2 + " monedas de 2€, " + cMon1 + " monedas de 1€, " + cMon05 + " monedas de 50 cents, " + cMon02 + " monedas de 20 cents y "+ cMon01 + "monedas de 10 cents.");
            } else if (pago == precio) {
                System.out.println("Gracias por usar nuestro servicio de parking. Vuelva pronto ^^");
            } else {
                System.out.println("La cantidad abonada no alcanza la cuota a pagar. Reintroduzca la cantidad de dinero que pagará. Esta vez una suficiente PT!!!");
            }


            /*
            pago = Double.parseDouble(JOptionPane.showInputDialog("Introduce la cantidad que vayas a pagar"));
            if(pago>precio) {
                System.out.println("Tome su cambio, gracias ^^: " + (cambio = pago - precio) + "€");
            }else if(pago==precio){
                System.out.println("Gracias por usar nuestro servicio de parking. Vuelva pronto ^^");
            }else{
                System.out.println("La cantidad definida como a pagar es insuficiente. Reintroduzca una cantidad esta vez aceptable. PT!!!!");
            }
                         */
        } while (pago < precio);
    }

    public void aforo(){
        System.out.println("El número de vehículos estacionados actualmente en el parking es de: "+plazasOcup);
        if(plazasOcup<8){
            System.out.println("Por tanto, la cantidad de vehículos es baja");
        }else if(plazasOcup<16){
            System.out.println("Por tanto, la cantidad de vehículos es media");
        }else if(plazasOcup<25){
            System.out.println("Por tanto, la cantidad de vehículos es alta");
        }else if(plazasOcup==25){
            System.out.println("Por tanto, no hay capacidad para más ocupantes");
        }
    }
}