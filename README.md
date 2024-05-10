# TDF Plaftorm

Plafatorma de sistema


## Modulos

Este sistema en principio estara compuesto de los siguientes modulos:

- USERS
- CARDS
- MERCHANTS
- TRANSACTIONS

Donde cada modulo podria ser representado por una estructura tipo ``tabla``


## Explicación estructura

En la vida real los sistemas, pueden a veces, ser implementados en ``microservicios`` y para
que esto pueda escalar en esta forma, veo que lo mejor es estructurar el proyecto por ``dominio``.

Esto facilitaria poder reemplazar un ``modulo`` por un ``microservicio`` sin tener que 
estar modificando clases compartidas.


## Persistencia

Para este ejemplo vamos a utilizar ``postgres`` como base de datos.


## Development

Para poder interactuar con la funcionalidad de este proyecto se deja un script
que levanta una base de datos ``postgres`` utilizando docker.

