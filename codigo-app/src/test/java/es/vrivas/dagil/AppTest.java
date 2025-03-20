package es.vrivas.dagil;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Unit test for simple App.
 */
class AppTest {
    @BeforeAll
    public void setUp() {
        System.out.println("Iniciando test clase App...");
    }

    /**
     * Test de introducción de un conjunto de datos de prueba.
     */
    @Test
    public void testIntroducir_datos_de_prueba() {
        assertEquals(App.MAX_OBJETOS_PRUEBA, App.establecer_datos_de_prueba());
    }

    @AfterAll
    public void setDown() {
        System.out.println("Finalizando test clase App...");
    }
}
