package web.actions;

import log.Log;
import org.takes.Response;
import org.takes.facets.fork.RqRegex;
import org.takes.facets.fork.TkRegex;
import org.takes.rs.RsWithStatus;
import sat.Device;
import sat.Sat;
import web.ApiResponse;

public class ConsultaSat extends SatAction implements TkRegex {
    @Override
    public Response act(RqRegex request) throws Exception {

        Device device = this.getDevice(request);
        RsWithStatus deviceError = this.getDeviceError(device);
        if (deviceError != null) {
            return deviceError;
        }

        Sat sat = new Sat(device);

        Log.logger.info("Iniciando consulta");

        String response = sat.consultar();

        Log.logger.info("Resposta: " + response);

        return ApiResponse.success(response);
    }
}
