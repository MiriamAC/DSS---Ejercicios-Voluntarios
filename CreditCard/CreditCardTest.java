import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class CreditCardTest{

    private CreditCard creditCard;
    
    @Before
    public void setUp() {
        // Configuración inicial antes de cada prueba
        creditCard = new CreditCard("Raoden Sarene", "1234567890123456", "Visa", 123, "01/25", 1000.0f);
    }
    
    @Test
    public void testValidCreditCard() {
        // Prueba válida, se espera que no se lance ninguna excepción
        new CreditCard("Raoden Sarene", "1234567890123456", "Visa", 123, "01/25", 1000.0f);
    }
    
    // Pruebas para el constructor
    
    @Test(expected = IllegalArgumentException.class)
    public void testInvalidPropietarioNull() {
        new CreditCard(null, "1234567890123456", "Visa", 123, "01/25", 1000.0f);
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void testInvalidPropietarioEmpty() {
        new CreditCard("", "1234567890123456", "Visa", 123, "01/25", 1000.0f);
    }
    
    
    @Test(expected = IllegalArgumentException.class)
    public void testInvalidNumeroNull() {
        new CreditCard("Raoden Sarene", null, "Visa", 123, "01/25", 1000.0f);
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void testInvalidNumeroEmpty() {
        new CreditCard("Raoden Sarene", "", "Visa", 123, "01/25", 1000.0f);
    }
    
    
    @Test(expected = IllegalArgumentException.class)
    public void testInvalidTipoNull() {
        new CreditCard("Raoden Sarene", "1234567890123456", null, 123, "01/25", 1000.0f);
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void testInvalidTipoEmpty() {
        new CreditCard("Raoden Sarene", "1234567890123456", "", 123, "01/25", 1000.0f);
    }
    
    
    @Test(expected = IllegalArgumentException.class)
    public void testInvalidCvvNegative() {
        new CreditCard("Raoden Sarene", "1234567890123456", "Visa", -123, "01/25", 1000.0f);
    }
    
    
    @Test(expected = IllegalArgumentException.class)
    public void testInvalidFechaCaducidadNull() {
        new CreditCard("Raoden Sarene", "1234567890123456", "Visa", 123, null, 1000.0f);
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void testInvalidFechaCaducidadEmpty() {
        new CreditCard("Raoden Sarene", "1234567890123456", "Visa", 123, "", 1000.0f);
    }
    
    
    @Test(expected = IllegalArgumentException.class)
    public void testInvalidBalanceNegative() {
        new CreditCard("Raoden Sarene", "1234567890123456", "Visa", 123, "01/25", -1000.0f);
    }
    


    //test de los getters
    @Test
    public void testPropietario(){
        CreditCard c = new CreditCard("Raoden Sarene", "1234567890123456", "Visa", 123, "01/25", 1000.0f);
        assertEquals("Raoden Sarene", c.getPropietario());
    }
    @Test
    public void testNumero(){
        CreditCard c = new CreditCard("Raoden Sarene", "1234567890123456", "Visa", 123, "01/25", 1000.0f);
        assertEquals("1234567890123456", c.getNumero());
    }
    @Test
    public void testTipo(){
        CreditCard c = new CreditCard("Raoden Sarene", "1234567890123456", "Visa", 123, "01/25", 1000.0f);
        assertEquals("Visa", c.getTipo());
    }
    @Test
    public void testCvv(){
        CreditCard c = new CreditCard("Raoden Sarene", "1234567890123456", "Visa", 123, "01/25", 1000.0f);
        assertEquals(123, c.getCvv());
    }

    @Test
    public void testFechaCaducidad(){
        CreditCard c = new CreditCard("Raoden Sarene", "1234567890123456", "Visa", 123, "01/25", 1000.0f);
        assertEquals("01/25", c.getFechaCaducidad());
    }
    @Test
    public void testBalance(){
        CreditCard c = new CreditCard("Raoden Sarene", "1234567890123456", "Visa", 123, "01/25", 1000.0f);
        
        assertEquals(1000.0f, c.getBalance(), 0);
        //cambiar asserEquals por una funcion que no sea deprecated


    }


    @Test
    public void testRetirar(){
        CreditCard c = new CreditCard("Raoden Sarene", "1234567890123456", "Visa", 123, "01/25", 1000.0f);
        c.retirar(100);
        assertEquals(900.0f, c.getBalance(), 0);
    }
    @Test
    public void testIngresar(){
        CreditCard c = new CreditCard("Raoden Sarene", "1234567890123456", "Visa", 123, "01/25", 1000.0f);
        c.ingresar(100);
        assertEquals(1100.0f, c.getBalance(), 0);
    }
    @Test
    public void testPagar(){
        CreditCard c = new CreditCard("Raoden Sarene", "1234567890123456", "Visa", 123, "01/25", 1000.0f);
        c.pagar(100);
        assertEquals(900.0f, c.getBalance(), 0);
    }
    


}

