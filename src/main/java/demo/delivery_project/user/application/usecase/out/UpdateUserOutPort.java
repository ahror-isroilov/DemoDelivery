package demo.delivery_project.user.application.usecase.out;

import demo.delivery_project.region.application.usecase.in.response.RegionResponse;
import demo.delivery_project.user.application.domain.model.User;
import demo.delivery_project.user.application.usecase.in.request.SetCarrierRegionsRequest;

import java.util.List;

public interface UpdateUserOutPort {
    User update(User domain);

    List<RegionResponse> setCarrierRegions(SetCarrierRegionsRequest request);
}
