package cl.respirarysoltar.reportes;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;

import java.util.Map;

/**
 * Handler Lambda invocado (a) periódicamente por EventBridge Scheduler para
 * consolidar reportes batch, y (b) de forma reactiva por los eventos de
 * dominio publicados en EventBridge (sesion_realizada, inscripcion_confirmada,
 * pago_confirmado) para alimentar el data lake en S3 consultado vía Athena.
 *
 * No frena la operación transaccional del negocio: por eso vive fuera de
 * ECS Fargate y escala a cero entre ejecuciones (RNF de mantenibilidad/costo).
 */
public class ReporteOcupacionHandler implements RequestHandler<Map<String, Object>, String> {

    @Override
    public String handleRequest(Map<String, Object> event, Context context) {
        // TODO: 1) leer el evento de EventBridge (o el trigger del scheduler)
        //       2) escribir/actualizar el objeto correspondiente en el bucket S3 (data lake)
        //       3) opcionalmente disparar una consulta Athena para el reporte agregado
        context.getLogger().log("Procesando evento de reportes: " + event);
        return "OK";
    }
}
