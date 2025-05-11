class ProcesamientoTweets {
    public static final int LIMITE_TWEET = 280;

    public static void main(String[] args) {
        System.out.println("**** Tweets ****\n");

        String tweet1 = "@roxxanne Me Gusta mucho la programacion y tambien me gusta programar en java #java #programacion";

        System.out.println("Tweet 1\n");
        System.out.println(tweet1 + "\n");

        int longitud1 = tweet1.length();
        System.out.println("Tweet 1 longitud: " + longitud1 + " caracteres");

        boolean cumpleLimite1 = longitud1 <= LIMITE_TWEET;
        System.out.println("¿Tweet 1 cumple con el límite?: " + cumpleLimite1 + "\n");

        int inicio1 = tweet1.indexOf('@');
        int fin1 = tweet1.indexOf(' ', inicio1);
        String usuario1 = tweet1.substring(inicio1, fin1);
        System.out.println("usuario del tweet 1: " + usuario1 + "\n");

        String tweet2 = "@unstastudent I really like programming, and I also enjoy coding in Java with some music. #java #programming #linkinpark #paparoach";

        System.out.println("Tweet 2\n");
        System.out.println(tweet2 + "\n");

        int longitud2 = tweet2.length();
        System.out.println("Tweet 2 longitud: " + longitud2 + " caracteres");

        boolean cumpleLimite2 = longitud2 <= LIMITE_TWEET;
        System.out.println("¿Tweet 2 cumple con el límite?: " + cumpleLimite2 + "\n");

        int inicio2 = tweet2.indexOf('@');
        int fin2 = tweet2.indexOf(' ', inicio2);
        String usuario2 = tweet2.substring(inicio2, fin2);
        System.out.println("usuario del tweet 2: " + usuario2 + "\n");

        System.out.println("Nuevo Tweet Construido\n");

        String[] fragmentos = {
                "Hoy es un dia ",
                "ideal para ",
                "programar en java y ",
                "mirar guias en youtube"
        };

        StringBuilder sb = new StringBuilder();

        sb.append("@Alfredozzz ");

        for (String fragmento : fragmentos) {
            sb.append(fragmento);
        }
        sb.append("#Java #UNSTA #Programacion2");

        System.out.println(sb.toString());
    }
}