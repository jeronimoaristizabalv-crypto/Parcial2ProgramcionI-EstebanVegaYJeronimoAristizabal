package co.edu.uniquindio.poo.app;

import javax.swing.*;

public class Main {
    public static void main(String args[]) {


        JOptionPane.showMessageDialog(null, "Bienvenido al sistema de gestion de TechRepair");

        int opcion;

        do {
            opcion = Integer.valueOf(JOptionPane.showInputDialog(null, "Seleccione una opcion: ---Menu---\n" +
                    "1. Registrar cliente." +
                    "\n2. Mostrar cliente." +
                    "\n3. Actualizar datos del cliente." +
                    "\n4. Eliminar cliente." +
                    "\n5. Registrar equipo." +
                    "\n6. Mostrar equipo." +
                    "\n7. Actualizar datos del equipo." +
                    "\n8. Eliminar equipo." +
                    "\n9. Registrar técnico." +
                    "\n10. Mostrar tecnico." +
                    "\n11. Actualizar datos del tecnico." +
                    "\n12. Eliminar tecnico." +
                    "\n13. Registrar repuesto." +
                    "\n14. Mostrar repuesto." +
                    "\n15. Actualizar datos del repuesto." +
                    "\n16. Eliminar repuesto." +
                    "\n17. Crear orden de servicio." +
                    "\n18. Mostrar orden de servicio." +
                    "\n19. Eliminar orden de servicio." +
                    "\n20. Crear servicio de diagnostico." +
                    "\n21. Crear servicio de mantenimiento preventivo." +
                    "\n22. Crear servicio de reparación correctiva." +
                    "\n23. Mostrar servicio." +
                    "\n24. Actualizar datos del servicio." +
                    "\n25. Eliminar servicio." +
                    "\n26. Agregar detalle a una orden." +
                    "\n27. Asignar técnico." +
                    "\n28. Registrar repuestos utilizados." +
                    "\n29. Calcular valor de un detalle." +
                    "\n30. Calcular valor total de la orden." +
                    "\n31. Actualizar estado de un detalle." +
                    "\n32. Finalizar una orden." +
                    "\n33. Consultar órdenes de un cliente." +
                    "\n34. Consultar trabajos de un técnico." +
                    "\n35. Consultar equipos pendientes." +
                    "\n36. Generar reporte de servicios." +
                    "\n37. Generar reporte de técnicos." +
                    "\n38. Consultar inventario crítico." +
                    "\n39. Salir."));


            switch (opcion) {
                case 1:
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 5:
                    break;
                case 6:
                    break;
                case 7:
                    break;
                case 8:
                    break;
                case 9:
                    break;
                case 10:
                    break;
                case 11:
                    break;
                case 12:
                    break;
                case 13:
                    break;
                case 14:
                    break;
                case 15:
                    break;
                case 16:
                    break;
                case 17:
                    break;
                case 18:
                    break;
                case 19:
                    break;
                case 20:
                    break;
                case 21:
                    break;
                case 22:
                    break;
                case 23:
                    break;
                case 24:
                    break;
                case 25:
                    break;
                case 26:
                    break;
                case 27:
                    break;
                case 28:
                    break;
                case 29:
                    break;
                case 30:
                    break;
                case 31:
                    break;
                case 32:
                    break;
                case 33:
                    break;
                case 34:
                    break;
                case 35:
                    break;
                case 36:
                    break;
                case 37:
                    break;
                case 38:
                    break;
                case 39:
                    JOptionPane.showMessageDialog(null, "Gracias por usar el sistema.");
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opcion invalida.");
                    break;
            }
        } while (opcion != 39);
    }
}