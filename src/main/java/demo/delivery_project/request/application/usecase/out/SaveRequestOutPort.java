package demo.delivery_project.request.application.usecase.out;

import demo.delivery_project.request.application.domain.model.Request;

public interface SaveRequestOutPort {
    Request save(Request domain);
}
