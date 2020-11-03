
# Conversor en Vaadin

[![Build Status](https://travis-ci.com/uqbar-project/eg-conversor-vaadin.svg?branch=master)](https://travis-ci.com/uqbar-project/eg-conversor-vaadin)

![demo](./images/demo.gif)

En este ejemplo mostramos el típico ejemplo del conversor en el framework Vaadin, donde

- el usuario puede ingresar millas
- con el botón Convertir se convierte a kilómetros y se muestra en un label
- adicionalmente tenemos una grilla que muestra el historial de conversiones que fuimos haciendo

## Cómo es Vaadin

Vaadin integra componentes UI que tienen

- una parte cliente (en Javascript)
- y una contraparte server (que corre en una JDK, en nuestro caso en programada en Xtend)

![arquitectura de Vaadin](./images/architecture.svg)


## Estructura general del proyecto

Project follow the Maven's [standard directory layout structure](https://maven.apache.org/guides/introduction/introduction-to-the-standard-directory-layout.html):
- Under the `srs/main/java` are located Application sources
   - `Application.java` is a runnable Java application class and a starting point
   - `GreetService.java` is a  Spring service class
   - `MainView.java` is a default view and entry point of the application
- Under the `srs/test` are located test files
- `src/main/resources` contains configuration files and static resources
- The `frontend` directory in the root folder contains client-side dependencies and resource files
   - All CSS styles used by the application are located under the root directory `frontend/styles`    
   - Templates would be stored under the `frontend/src`

### Desarrollando del lado de Java

### Desarrollando con el Designer de Vaadin (versión Pro)

## Cómo se ejecuta la aplicación

Desde la consola podés ejecutar el comando maven:

```bash
mvn spring-boot:run
```

O bien desde Eclipse, ejecutando el main que está en la clase `Application`.

En cualquiera de los dos casos, el servidor que levanta es SpringBoot (se puede configurar un Jetty si están interesados en tener una versión más liviana).

## Testeos de integración con Selenium

Los tests de integración se implementan con [Vaadin TestBench](https://vaadin.com/testbench). Para ejecutar los tests con Google Chrome está el siguiente goal de Maven:

```bash
mvn verify -Pit,production
```

and make sure you have a valid TestBench license installed.

Profile `it` adds the following parameters to run integration tests:
```sh
-Dwebdriver.chrome.driver=path_to_driver
-Dcom.vaadin.testbench.Parameters.runLocally=chrome
```

If you would like to run a separate test make sure you have added these parameters to VM Options of JUnit run configuration

## Links relacionados

- Vaadin Basics [https://vaadin.com/docs](https://vaadin.com/docs)
- More components at [https://vaadin.com/components](https://vaadin.com/components) and [https://vaadin.com/directory](https://vaadin.com/directory)
- Download this and other examples at [https://vaadin.com/start](https://vaadin.com/start)
- Using Vaadin and Spring [https://vaadin.com/docs/v14/flow/spring/tutorial-spring-basic.html](https://vaadin.com/docs/v14/flow/spring/tutorial-spring-basic.html) article
- Join discussion and ask a question at [https://vaadin.com/forum](https://vaadin.com/forum)

