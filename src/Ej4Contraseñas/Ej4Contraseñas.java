import java.util.Scanner;

class ValidacionPassword {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        nuevaContrasena contrasena = new nuevaContrasena();
        boolean continuar = true;

        while (continuar) {
            System.out.print("\nIngrese la contraseña: ");
            String password = input.next();

            if (contrasena.esContrasenaSegura(password)) {
                System.out.println("¡Contraseña segura! ¿Desea generar una nueva contraseña de todos modos? [S/N]");
                String respuesta = input.next().toUpperCase();

                if (!respuesta.equals("S")) {
                    System.out.println("Continuando con su contraseña actual.");
                    continuar = false;
                    continue;
                }
            }

            System.out.println("Generando nueva contraseña segura...");

            System.out.print("Ingrese su Nombre: ");
            String nombre = input.next();

            System.out.print("Ingrese una Palabra Clave: ");
            String apellido = input.next();

            System.out.print("Ingrese su Año de Nacimiento: ");
            String fechaNacimiento = input.next();

            String generada = contrasena.generarContrasenaSegura(nombre, apellido, fechaNacimiento);
            System.out.println("Su nueva contraseña segura es: " + generada);

            System.out.print("\n¿Desea generar otra contraseña? [S/N]: ");
            String opcion = input.next().toUpperCase();
            continuar = opcion.equals("S");
        }

        System.out.println("\nPrograma terminado. ¡Hasta luego!");
        input.close();
    }
}

class nuevaContrasena {
    public boolean esContrasenaSegura(String password) {
        boolean longitud = password.length() >= 8;
        boolean tieneDigito = password.matches(".*\\d.*");
        boolean tieneEspecial = password.matches(".*[!@#$%^&*].*");
        return longitud && tieneDigito && tieneEspecial;
    }

    public String generarContrasenaSegura(String nombre, String apellido, String fechaNacimiento) {
        String especiales = "!@#$%^&*";
        String numeros = "0123456789";

        StringBuffer passwordSeg = new StringBuffer();
        passwordSeg.append(Character.toUpperCase(nombre.charAt(0)));
        passwordSeg.append(apellido.length() > 2 ? apellido.substring(0, 3) : apellido);
        passwordSeg.append(fechaNacimiento.substring(fechaNacimiento.length() - 2));

        passwordSeg.append(especiales.charAt((int)(Math.random() * especiales.length())));

        passwordSeg.append(numeros.charAt((int)(Math.random() * numeros.length())));

        return passwordSeg.toString();
    }
}