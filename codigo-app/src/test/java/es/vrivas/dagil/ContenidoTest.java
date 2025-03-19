package es.vrivas.dagil;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class ContenidoTest {

    @BeforeAll
    public void setUp() {
        System.out.println("Iniciando test clase Contenido...");
    }

    @Test
    public void testGetId() {
        {
            // Comprueba que el id inicial es 0
            Contenido objeto = new Contenido();
            assertEquals(0, objeto.getId());
        }
        {
            // Comprueba otro id
            Contenido objeto = new Contenido();
            objeto.setId(1);
            assertEquals(1, objeto.getId());
        }
    }

    @Test
    public void testGetDescripcion() {
        {
            // Comprueba que la descripción inicial es ""
            Contenido objeto = new Contenido();
            assertEquals("", objeto.getDescripcion());
        }
        {
            // Comprueba otra descripción
            Contenido objeto = new Contenido();
            objeto.setDescripcion("Descripción");
            assertEquals("Descripción", objeto.getDescripcion());
        }
    }

    @Test
    public void testSetId() {
        {
            // Comprueba que no se puede establecer un id negativo
            Contenido objeto = new Contenido();
            try {
                objeto.setId(-1);
                fail();
            } catch (IllegalArgumentException e) {
                System.out.println("Excepción lanzada: " + e.getMessage() + " para id negativo");
            }
        }
        {
            // Comprueba que establece el id y que devuelve el propio objeto
            Contenido objeto = new Contenido();
            assertSame(objeto, objeto.setId(1));
            assertEquals(1, objeto.getId());
        }

    }

    @Test
    public void testSetDescripcion() {
        {
            // Comprueba que no se puede establecer una descripción nula
            Contenido objeto = new Contenido();
            try {
                objeto.setDescripcion(null);
                fail();
            } catch (IllegalArgumentException e) {
                System.out.println("Excepción lanzada: " + e.getMessage() + " para descripción nula");
            }
        }
        {
            // Comprueba que no se puede establecer una descripción vacía
            Contenido objeto = new Contenido();
            try {
                objeto.setDescripcion("");
                fail();
            } catch (IllegalArgumentException e) {
                System.out.println("Excepción lanzada: " + e.getMessage() + " para descripción vacía");
            }
        }
        {
            // Comprueba que la descripción inicial es ""
            Contenido objeto = new Contenido();
            assertEquals("", objeto.getDescripcion());
        }
        {
            // Comprueba que establece una descripción y que devuelve el mismo objeto
            Contenido objeto = new Contenido();
            assertSame(objeto, objeto.setDescripcion("Descripción"));
            assertEquals("Descripción", objeto.getDescripcion());
        }
    }

    @Test
    public void testToString() {
        {
            // Comprueba que devuelve un string con el objeto en formato JSON para un objeto con id 0 y descripción ""
            Contenido objeto = new Contenido();
            assertEquals("{id: 0, descripcion: ''}", objeto.toString());
        }
        {
            // Comprueba que devuelve un string con el objeto en formato JSON para un objeto con id y descripción
            Contenido objeto = new Contenido();
            objeto.setId(1);
            objeto.setDescripcion("Descripción para testToString");
            assertEquals("{id: 1, descripcion: 'Descripción para testToString'}", objeto.toString());
        }
    }

    @AfterAll
    public void setDown() {
        System.out.println("Finalizando test clase Contenido...");
    }
}
