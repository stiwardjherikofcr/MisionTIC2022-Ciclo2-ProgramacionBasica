
import co.edu.utp.misiontic2022.c2.sjcr.reto_4.view.ReportesView;
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Stiward
 */
public class App {

    public static void main(String[] args) {
        ReportesView reportesView = new ReportesView();
        Scanner scan = new Scanner(System.in);
        String menu
                = "================Menu===============\n"
                + "1- Proyectos financiados por banco\n"
                + "2- Total adeudado por proyecto superior a un limite\n"
                + "3- Lideres que mas gastan\n"
                + "4- Salir\n"
                + "Elija una opcion: \n";
        int option = 4;
        boolean out = false;
        try {
            do {
                System.out.print(menu);
                option = Integer.parseInt(scan.nextLine());
                switch (option) {
                    case 1:
                        System.out.println("Nombre del banco: ");
                        String banco = scan.nextLine();
                        reportesView.proyectosFinanciadosPorBanco(banco);
                        break;
                    case 2:
                        System.out.println("Limite inferior: ");
                        Double limiteInferior = Double.parseDouble(scan.nextLine());
                        reportesView.totalAdeudadoPorProyectosSuperioresALimite(limiteInferior);
                        break;
                    case 3:
                        reportesView.lideresQueMasGastan();
                        break;
                    default:
                        out = true;
                }
            } while (!out);
        } catch (NumberFormatException e) {
            System.out.println("Solo se permiten numeros");
            App.main(args);
        }
    }
}
