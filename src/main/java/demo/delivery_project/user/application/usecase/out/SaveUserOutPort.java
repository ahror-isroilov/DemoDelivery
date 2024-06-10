package demo.delivery_project.user.application.usecase.out;

import demo.delivery_project.user.application.domain.model.User;

public interface SaveUserOutPort {
    /**
     * Userni saqlash uchun endpoint
     *
     * @param domain
     * @return
     */
    User save(User domain);
}
