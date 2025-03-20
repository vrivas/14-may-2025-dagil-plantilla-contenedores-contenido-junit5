package es.vrivas.dagil;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.fail;

/**
 * Clase de test para la clase Contenedor.
 */
public class ContenedorTest {
    /**
     * Inicialización de los tests.
     */
    @BeforeAll
    public static void setUp() {
        System.out.println("Iniciando test clase Contenedor...");
    }

    // ---------------------------------------------------------------
    // Tests para el método add
    // ---------------------------------------------------------------

    /**
     * Excepción si se intenta añadir un objeto nulo.
     */
    @Test
    public void add_excepcion_si_objeto_nulo() {
        // Salta exepción si se intenta añadir un objeto nulo
        Contenedor contenedor = new Contenedor();
        Contenido objeto = null;
        try {
            contenedor.add(objeto);
            fail();
        } catch (IllegalArgumentException e) {
            System.out.println("Excepción lanzada: " + e.getMessage() + " para objeto nulo");
        }

    }

    /**
     * El método add devuelve el mismo objeto.
     */
    @Test
    public void add_devuelve_mismo_objeto() {
        // El método debe devolver el mismo objeto
        Contenedor contenedor = new Contenedor();
        Contenido objeto = new Contenido();
        objeto.setDescripcion("Descripción en add_devuelve_mismo_objeto");
        objeto.setId(1);
        assertSame(contenedor, contenedor.add(objeto));

    }

    /**
     * El método add inserta un objeto.
     */
    @Test
    public void add_inserta_objeto() {
        // El objeto se ha añadido al contenedor
        final String unaDescripcion = "Descripción en add_inserta_objeto";
        Contenedor contenedor = new Contenedor();
        Contenido objeto = new Contenido();
        objeto.setDescripcion(unaDescripcion);
        objeto.setId(1);
        Contenido objetoRecuperado = contenedor.add(objeto).getPorId(1);
        assert objetoRecuperado != null;
        assert objetoRecuperado.getDescripcion().equals(unaDescripcion);
    }

    /**
     * Excepción si se intenta añadir un objeto que ya existe.
     */
    @Test
    public void add_excepcion_si_objeto_ya_existe() {
        try {
            Contenedor contenedor = new Contenedor();
            Contenido objeto = new Contenido();
            objeto.setDescripcion("add_excepcion_si_objeto_ya_existe");
            objeto.setId(1);
            contenedor.add(objeto);
            contenedor.add(objeto);
            fail();
        } catch (IllegalArgumentException e) {
            System.out.println("Excepción lanzada: " + e.getMessage() + " para objeto ya añadido");
        }
    }

    // ---------------------------------------------------------------
    // Tests para el método getNumObjetosContenidos
    // ---------------------------------------------------------------
    /**
     * Un contenedor vacío devuelve 0 objetos contenidos.
     */
    @Test
    public void getNumObjetosContenidos_contenedor_vacio() {
        // Devuelve 0 si no hay objetos en el contenedor
        Contenedor contenedor = new Contenedor();
        assert contenedor.getNumObjetosContenidos() == 0;
    }

    /**
     * Un contenedor no vacío devuelve el número de objetos contenidos.
     */
    @Test
    public void getNumObjetosContenidos_contenedor_no_vacio() {
        Contenedor contenedor = new Contenedor();
        Contenido objeto = new Contenido();
        objeto.setDescripcion("Descripción en testGetNumObjetosContenidos");
        objeto.setId(1);
        contenedor.add(objeto);
        assert contenedor.getNumObjetosContenidos() == 1;
    }

    // ---------------------------------------------------------------
    // Tests para el método getPorPosicion
    // ---------------------------------------------------------------
    /**
     * Excepción si la posición es negativa.
     */
    @Test
    public void getPorPosicion_excepcion_posicion_negativa() {
        // Salta excepción si la posición no es válida
        // Prueba para posiciones menores que 0
        Contenedor contenedor = new Contenedor();
        try {
            contenedor.getPorPosicion(-1);
            fail();
        } catch (IllegalArgumentException e) {
            System.out.println("Excepción lanzada: " + e.getMessage() + " para posición -1");
        }

    }

    /**
     * Excepción si la posición es mayor o igual al número de elementos que hay.
     */
    @Test
    public void getPorPosicion_excepcion_posicion_superior_existentes() {
        Contenedor contenedor = new Contenedor();
        try {
            contenedor.getPorPosicion(0);
            fail();
        } catch (IllegalArgumentException e) {
            System.out.println("Excepción lanzada: " + e.getMessage() + " para posición 0");
        }
        try {
            contenedor.getPorPosicion(1);
            fail();
        } catch (IllegalArgumentException e) {
            System.out.println("Excepción lanzada: " + e.getMessage() + " para posición 1");
        }
    }

    /**
     * Prueba de valores límite para el método getPorPosicion.
     */
    @Test
    public void getPorPosicion_valores_limite() {
        Contenedor contenedor = new Contenedor();
        Contenido objeto1 = new Contenido();
        objeto1.setDescripcion("Descripción en testGetPorPosicion para objeto1");
        objeto1.setId(1);
        contenedor.add(objeto1);
        Contenido objeto2 = new Contenido();
        objeto2.setDescripcion("Descripción en testGetPorPosicion para objeto2");
        objeto2.setId(2);
        contenedor.add(objeto2);
        Contenido objetoRecuperado = contenedor.getPorPosicion(0);
        assert objetoRecuperado != null;
        assert objetoRecuperado.getDescripcion().equals("Descripción en testGetPorPosicion para objeto1");

        objetoRecuperado = contenedor.getPorPosicion(1);
        assert objetoRecuperado != null;
        assert objetoRecuperado.getDescripcion().equals("Descripción en testGetPorPosicion para objeto2");
    }

    // ---------------------------------------------------------------
    // Tests para el método getPorId
    // ---------------------------------------------------------------

    /**
     * Prueba para un contenedor vacío.
     */
    @Test
    public void getPorId_contenedor_vacio() {
        Contenedor contenedor = new Contenedor();
        Contenido objeto = contenedor.getPorId(1);
        assert objeto == null;
    }

    /**
     * Prueba para un contenedor con elementos.
     */
    @Test
    public void getPorId_contenedor_con_elementos() {
        // Devuelve el objeto si está en el contenedor
        Contenedor contenedor = new Contenedor();
        Contenido objeto = new Contenido();
        objeto.setDescripcion("Descripción en testGetPorId");
        objeto.setId(1);
        contenedor.add(objeto);
        Contenido objetoRecuperado = contenedor.getPorId(1);
        assert objetoRecuperado != null;
        assert objetoRecuperado.getDescripcion().equals("Descripción en testGetPorId");
    }

    // ---------------------------------------------------------------
    // Tests para el método toString
    // ---------------------------------------------------------------

    /**
     * toString devuelve [] si no hay objetos en el contenedor.
     */
    @Test
    public void toString_contenedor_vacio() {
        Contenedor contenedor = new Contenedor();
        assertEquals("[]", contenedor.toString());
    }

    /**
     * toString devuelve un string con los objetos en formato JSON.
     */
    @Test
    public void toString_contenedor_no_vacio() {
        Contenedor contenedor = new Contenedor();
        Contenido objeto1 = new Contenido();
        objeto1.setDescripcion("Descripción en testToString para objeto1");
        objeto1.setId(1);
        contenedor.add(objeto1);
        // Para un solo objeto
        assertEquals("[\n{id: 1, unaDescripcion: 'Descripción en testToString para objeto1'},\n]",
                contenedor.toString());
        Contenido objeto2 = new Contenido();
        objeto2.setDescripcion("Descripción en testToString para objeto2");
        objeto2.setId(2);
        contenedor.add(objeto2);
        // Para dos objetos
        String cadenaJSONEsperada = "[\n"
                + "{id: 1, unaDescripcion: 'Descripción en testToString para objeto1'},\n"
                + "{id: 2, unaDescripcion: 'Descripción en testToString para objeto2'},\n"
                + "]";
        assertEquals(cadenaJSONEsperada, contenedor.toString());

    }

    /**
     * Finalización de los tests.
     */
    @AfterAll
    public static void setDown() {
        System.out.println("Finalizando test clase Contenedor...");
    }

}
