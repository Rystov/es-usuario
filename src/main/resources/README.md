# CommonLogging

## Detalles de la libreria

La libreria hace uso de la siguientes variables de entorno que de no existir deberan ser creadas en dicho entorno:

- **BASE_PATH_LOGS**: Ruta donde se alojaran los archivos de logs
- **COMPUTERNAME**: Variable de entorno propia de windows que almancea el nombre del equipo


Dentro de cada API que implemente esta libreria se deberan definir los siquientes properties dentro del archico **applications.properties** de cada API:

- **spring.application.name**: Nombre del api. Ejemplo:

	spring.application.name=ClienteES
	
- **custom.dominioNegocio**: Nombre del dominio de negocio al que pertenece el API. Ejemplo:

	custom.dominioNegocio=Clientes	

Los dominios de negocio opcionales son los siguinetes:

- Clientes
- Cuentas
- Inversion
- Empresas
	

NOTA: La ruta base predeterminada donde se alojaran los logs generados por esta libreria es **/home/OBA**.

## COMPOSICION DE LA ESTRUTURA DE CARPERTA DE LOGS

La estructura de carpetas esta definida de la siguinete manera:

-[RUTA PREDETERMINADA DE LOGS]/Logs/[DOMINIO DE NEGOCIO]/