package demo.delivery_project.region.application.usecase.out;

import demo.delivery_project.region.application.domain.model.Region;

public interface SaveRegionOutPort {
    Region save(Region domain);
}
