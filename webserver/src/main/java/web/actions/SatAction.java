package web.actions;

import org.takes.facets.fork.RqRegex;
import org.takes.rs.RsWithStatus;
import sat.Device;
import sat.DeviceFactory;
import web.ApiResponse;

import java.io.IOException;

public class SatAction {

    public Device getDevice(RqRegex request) {
        return DeviceFactory.build(request.matcher().group("device"));
    }

    public RsWithStatus getDeviceError(Device device) throws IOException {

        if (device == null) {
            return ApiResponse.error(422, "O dispositivo SAT informado não é suportado.");
        }

        if (!device.isAvailable()) {
            return ApiResponse.error(422, "O seu sistema operacional e/ou arquitetura não são suportados por esse dispositivo SAT.");
        }

        return null;

    }

}
