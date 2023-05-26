## Primer Ejercicio
Este ejercicio consiste en una implementación de un sistema relacionado con la búsqueda del Santo Grial. A continuación, se describen los archivos y clases principales del proyecto:

- `Holy.java`: La interfaz `Holy` define un contrato para cualquier objeto que pueda considerarse sagrado. Contiene un único método `isHoly()` que devuelve un valor booleano que indica si el objeto es sagrado.

- `HolyGrail.java`: La clase `HolyGrail` implementa la interfaz `Holy` y representa el objeto del Santo Grial. En este caso, se establece que el objeto del Santo Grial es sagrado al devolver siempre `true` en el método `isHoly()`.

- `HolyGrailQuest.java`: La clase `HolyGrailQuest` implementa la interfaz `Quest<Holy>` y representa la búsqueda del Santo Grial. En el método `embark()`, se crea una instancia de `HolyGrail` y se devuelve como resultado de la búsqueda.

- `Knight.java`: La interfaz `Knight` define un contrato para un caballero que puede embarcarse en una búsqueda. Contiene el método `embarkOnQuest()` que devuelve un objeto de tipo `Holy`.

- `KnightOfTheRoundTable.java`: La clase `KnightOfTheRoundTable` implementa la interfaz `Knight` y representa un caballero de la Mesa Redonda. Tiene un nombre y una búsqueda asignada. Al invocar el método `embarkOnQuest()`, el caballero intenta embarcarse en la búsqueda y devuelve el objeto sagrado obtenido.

- `LamesaredondaApplication.java`: El archivo `LamesaredondaApplication.java` contiene el punto de entrada del programa. Crea una instancia de `KnightOfTheRoundTable` llamada `knight` y le asigna una búsqueda del Santo Grial. Luego, se invoca `knight.embarkOnQuest()` dos veces y se verifica si el objeto sagrado obtenido es el Santo Grial o no, imprimiendo un mensaje en consecuencia.

- `Quest.java`: La interfaz `Quest<T>` define un contrato para una búsqueda genérica que devuelve un objeto de tipo `Holy`. Contiene el método `embark()` que representa el inicio de la búsqueda y puede lanzar una excepción de tipo `QuestFailedException`.

- `QuestFailedException.java` : La clase `QuestFailedException` es una excepción personalizada que se lanza cuando una búsqueda falla.


## Segundo Ejercicio

Este proyecto muestra un ejemplo de configuración y uso de componentes en Spring Framework. El objetivo principal es simular una búsqueda del Santo Grial mediante la interacción de diferentes clases.

### Estructura del proyecto

El proyecto está estructurado en varios archivos Java que se encuentran en el paquete `dss.ejercicio2.SegundaSolucion`. A continuación se describen los archivos principales:

- `AppConfig.java`: Este archivo contiene la configuración de los componentes de Spring utilizando anotaciones. Se definen los beans (`Knight`, `Quest`, `HolyGrailQuest`, `Holy`) y se establecen sus dependencias.

- `Holy.java`: Interfaz que define un método `isHoly()` para determinar si un objeto es sagrado.

- `HolyGrail.java`: Clase que implementa la interfaz `Holy` y define el método `isHoly()`, el cual siempre retorna `true`. Representa el objeto del Santo Grial.

- `HolyGrailQuest.java`: Clase que implementa la interfaz `Quest` y define el método `embark()`. Esta clase es responsable de la búsqueda del Santo Grial. Tiene una dependencia en el objeto `Holy` (el Santo Grial) que se inyecta mediante la anotación `@Autowired`.

- `Knight.java`: Interfaz que define el método `embarkOnQuest()` para que un caballero pueda embarcarse en una búsqueda.

- `KnightOfTheRoundTable.java`: Clase que implementa la interfaz `Knight`. Representa un caballero de la Mesa Redonda. Tiene una dependencia en el objeto `Quest` que se inyecta a través del constructor. Cuando se invoca el método `embarkOnQuest()`, se ejecuta la búsqueda del Santo Grial.

- `Quest.java`: Interfaz parametrizada que define el método `embark()` para realizar una búsqueda. El tipo de tesoro buscado se especifica como parámetro genérico.

- `QuestFailedException.java`: Clase que representa una excepción personalizada para indicar que una búsqueda ha fallado.

- `HolyApplication.java`: Clase principal del proyecto que inicia la aplicación de Spring. Se crea el contexto de la aplicación utilizando la configuración definida en `AppConfig`. Luego, se obtiene una instancia de `Knight` del contexto y se invoca el método `embarkOnQuest()` para iniciar la búsqueda del Santo Grial. Dependiendo del resultado de la búsqueda, se imprime un mensaje indicando si se encontró el Santo Grial o no.

