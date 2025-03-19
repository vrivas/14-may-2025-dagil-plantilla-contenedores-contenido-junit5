package es.vrivas.dagil;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Unit test for simple App.
 */
class AppTest {
    /**
     * Test de introducción de un conjunto de datos de prueba
     */
    @Test
    public void testIntroducir_datos_de_prueba() {
        assertEquals(6, App.establecer_datos_de_prueba());
    }
}
