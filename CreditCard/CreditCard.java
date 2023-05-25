
public class CreditCard{

    CreditCard (String propietario, String numero, String tipo, int cvv, String fechaCaducidad, float balance){
        // Validar propietario
        if (propietario == null || propietario.isEmpty()) {
            throw new IllegalArgumentException("El propietario de la tarjeta no puede ser nulo o vacío.");
        }

        for (int i = 0; i < propietario.length(); i++) {
            if (Character.isDigit(propietario.charAt(i))) {
                throw new IllegalArgumentException("El propietario de la tarjeta no puede contener números.");
            }
        }

        if (!propietario.matches("[a-zA-Z\\s]+")) {
            throw new IllegalArgumentException("El propietario de la tarjeta no puede contener caracteres especiales.");
        }

        if (propietario.length() < 10 || propietario.length() > 60) {
            throw new IllegalArgumentException("El propietario de la tarjeta debe tener entre 10 y 60 caracteres.");
        }


        // Validar número de tarjeta
        if (numero == null || numero.isEmpty()) {
            throw new IllegalArgumentException("El número de tarjeta no puede ser nulo o vacío.");
        }

        for (int i = 0; i < numero.length(); i++) {
            if (Character.isLetter(numero.charAt(i))) {
                throw new IllegalArgumentException("El número de tarjeta no puede contener letras.");
            }
        }

        if (numero.length() != 16) {
            throw new IllegalArgumentException("El número de tarjeta debe tener 16 dígitos.");
        }

        if (numero.charAt(0) == '0') {
            throw new IllegalArgumentException("El número de tarjeta no puede empezar por 0.");
        }

        //Validar numero con el algoritmo de Luhn
        int suma = 0;
        boolean alternar = false;
        for (int i = numero.length() - 1; i >= 0; i--) {
            int n = Integer.parseInt(numero.substring(i, i + 1));
            if (alternar) {
                n *= 2;
                if (n > 9) {
                    n = (n % 10) + 1;
                }
            }
            suma += n;
            alternar = !alternar;
        }
        


        // Validar tipo de tarjeta
        if (tipo == null || tipo.isEmpty()) {
            throw new IllegalArgumentException("El tipo de tarjeta no puede ser nulo o vacío.");
        }

        if (!tipo.equals("Visa") && !tipo.equals("MasterCard") && !tipo.equals("American Express") && !tipo.equals("Discover")) {
            throw new IllegalArgumentException("El tipo de tarjeta debe ser Visa, MasterCard, American Express o Discover.");
        }


        // Validar CVV
        if (cvv <= 0 || cvv > 999) {
            throw new IllegalArgumentException("El CVV debe ser un número positivo y de 3 cifras.");
        }

        // Validar fecha de caducidad
        if (fechaCaducidad == null || fechaCaducidad.isEmpty()) {
            throw new IllegalArgumentException("La fecha de caducidad no puede ser nula o vacía.");
        }

        if (fechaCaducidad.length() != 5) {
            throw new IllegalArgumentException("La fecha de caducidad debe tener 5 caracteres.");
        }

        if (fechaCaducidad.charAt(2) != '/') {
            throw new IllegalArgumentException("La fecha de caducidad debe tener el formato MM/AA.");
        }

        //Para comprobar que la fecha de caducidad es válida, se comprueba que el mes esté entre 1 y 12 y el año entre 23 y 99
        int mes = Integer.parseInt(fechaCaducidad.substring(0, 2));
        int anio = Integer.parseInt(fechaCaducidad.substring(3, 5));
        
        if (mes < 1 || mes > 12) {
            throw new IllegalArgumentException("El mes de caducidad debe estar entre 1 y 12.");
        }

        if (anio < 23 || anio > 99) {
            throw new IllegalArgumentException("El año de caducidad debe estar entre 23 y 99.");
        }

        // Validar balance
        if (balance < 0) {
            throw new IllegalArgumentException("El balance de la tarjeta no puede ser negativo.");
        }

        this.propietario = propietario;
        this.numero = numero;
        this.tipo = tipo;
        this.cvv = cvv;
        this.fechaCaducidad = fechaCaducidad;
        this.balance = balance;
    }

    public String getPropietario()    { return propietario; }

    public String getNumero()         { return numero; }

    public String getTipo()           { return tipo; }

    public int getCvv()               { return cvv; }

    public String getFechaCaducidad() { return fechaCaducidad;}

    public float getBalance()         { return balance; }

    //funciones necesarias para que la clase funcione correctamente no setters
    public void retirar(float cantidad) {
        if (cantidad < 0) {
            throw new IllegalArgumentException("La cantidad a retirar no puede ser negativa.");
        }

        if (cantidad > balance) {
            throw new IllegalArgumentException("La cantidad a retirar no puede ser mayor que el balance de la tarjeta.");
        }

        balance -= cantidad;
    }

    public void ingresar(float cantidad) {
        if (cantidad < 0) {
            throw new IllegalArgumentException("La cantidad a ingresar no puede ser negativa.");
        }

        balance += cantidad;
    }

    public void pagar(float cantidad) {
        if (cantidad < 0) {
            throw new IllegalArgumentException("La cantidad a pagar no puede ser negativa.");
        }

        if (cantidad > balance) {
            throw new IllegalArgumentException("La cantidad a pagar no puede ser mayor que el balance de la tarjeta.");
        }

        balance -= cantidad;
    }

    private String propietario;
    private String numero;
    private String tipo;
    private int cvv;
    private String fechaCaducidad;
    private float balance; 
}
