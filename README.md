# ms-reportes

Reportes de ocupación e ingresos para Respirar y Soltar. Cubre el RF derivado de analítica
(no numerado explícitamente en el levantamiento original porque es transversal a los RF-04 a RF-08).

**Dominio:** reportes/analítica. **Runtime:** AWS Lambda (no ECS), consultando Amazon Athena
sobre un data lake en S3. Consume eventos de `ms-agenda`, `ms-talleres`, `ms-pagos` y `ms-clinico`
vía EventBridge (fan-out) y no expone ninguna API síncrona al resto del sistema: se sacrifica a
consistencia eventual para no frenar la operación (ver RNF de disponibilidad en el documento de
análisis).

## Cómo compilar el paquete de despliegue

```bash
mvn clean package
# genera target/ms-reportes-0.1.0.jar listo para subir como AWS Lambda (handler:
# cl.respirarysoltar.reportes.ReporteOcupacionHandler)
```
